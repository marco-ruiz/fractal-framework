/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bop.fractals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.bop.fractals.progress.ThresholdProgressUpdater;

/**
 * @author Marco Ruiz
 * @since Feb 21, 2017
 */
public class GeometricPatternFractalGenerator<SHAPE_T extends Shape<SHAPE_T>> extends GeometricFractalGenerator<SHAPE_T> {

	private SHAPE_T base;
	protected List<SHAPE_T> patterns;
	protected int recursions;
	protected boolean lastRecurOnly;

	private ThresholdProgressUpdater syncProgressUpdater;
	private Map<Integer, List<SHAPE_T>> shapesByRecursionLevel = new HashMap<>();

	public GeometricPatternFractalGenerator(List<SHAPE_T> pattern, int numRecur) {
		this(pattern, numRecur, false, null);
	}

	public GeometricPatternFractalGenerator(List<SHAPE_T> pattern, int numRecur, boolean lastRecurOnly, Consumer<Float> progressListener) {
		patterns = new ArrayList<SHAPE_T>(pattern);
		base = patterns.remove(0);
		init(numRecur, lastRecurOnly, progressListener);
	}

	public GeometricPatternFractalGenerator(SHAPE_T base, List<SHAPE_T> patterns, int numRecur, boolean lastRecurOnly, Consumer<Float> progressListener) {
		setBase(base);
		setPatterns(patterns);
		init(numRecur, lastRecurOnly, progressListener);
	}

	private void init(int numRecur, boolean lastRecurOnly, Consumer<Float> progressListener) {
		setRecursions(numRecur);
		setLastRecurOnly(lastRecurOnly);
		setProgressListener(progressListener);

		this.patterns.stream().forEach(patternUnit -> patternUnit.computeConstants(base));
	}

	public SHAPE_T getBase() {
		return base;
	}

	public void setBase(SHAPE_T base) {
		this.base = base;
	}

	public List<SHAPE_T> getPatterns() {
		return patterns;
	}

	public void setPatterns(List<SHAPE_T> patterns) {
		this.patterns = patterns;
	}

	public void addPattern(SHAPE_T pattern) {
		this.patterns.add(pattern);
	}

	public void setRecursions(int numRecur) {
		this.recursions = numRecur;
	}

	public void setLastRecurOnly(boolean lastRecurOnly) {
		this.lastRecurOnly = lastRecurOnly;
	}

	public void setProgressListener(Consumer<Float> progressListener) {
		this.syncProgressUpdater = new ThresholdProgressUpdater(progressListener, calculateNumGeometriesToCompute(), 2);
		setProgressUpdater(this.syncProgressUpdater);
	}

	protected long calculateNumGeometriesToCompute() {
		int numPatterns = patterns.size();
		long factor = (numPatterns == 1) ? 1 : (long)(Math.pow(numPatterns, recursions) - 1) / (numPatterns - 1);
		return (numPatterns * factor) - numPatterns;
	}

	public List<SHAPE_T> getFractal() {
		return (lastRecurOnly) ? getFractal(recursions - 1) : super.getFractal();
	}

	public List<SHAPE_T> getFractal(int recursionLevel) {
		return shapesByRecursionLevel.get(recursionLevel);
	}

	protected void buildFractalShapes() {
		shapesByRecursionLevel.computeIfAbsent(0, ArrayList::new).addAll(patterns);
		patterns.stream().forEach(shape -> addFractalShape(shape));

		IntStream.range(1, recursions).forEach(this::computeRecursionLevel);
	}

	private void computeRecursionLevel(int recursionLevel) {
		List<SHAPE_T> prevRecShapes = shapesByRecursionLevel.get(recursionLevel - 1);
		List<SHAPE_T> currRecShapes =
				patterns.stream()
					.map(pattern -> computeEquivalencesOf(prevRecShapes, pattern))
					.flatMap(List::stream)
					.collect(Collectors.toList());
		shapesByRecursionLevel.put(recursionLevel, currRecShapes);
	}

	private List<SHAPE_T> computeEquivalencesOf(List<SHAPE_T> prevRecShapes, SHAPE_T pattern) {
		return prevRecShapes.stream()
			.filter(relBase -> !interrupted)
			.map(relBase -> relBase.computeGeometryEquivalentTo(pattern))
			.peek(shape -> syncProgressUpdater.incrementGenerated())
			.peek(shape -> addFractalShape(shape))
			.collect(Collectors.toList());
	}
}

