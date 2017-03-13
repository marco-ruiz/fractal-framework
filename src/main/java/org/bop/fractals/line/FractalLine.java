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

package org.bop.fractals.line;

import org.bop.fractals.Shape;

/**
 * @author Marco Ruiz
 * @since Feb 21, 2017
 */
public class FractalLine implements Shape<FractalLine> {

	public final float Ax;
	public final float Ay;
	public final float Bx;
	public final float By;

	public final Object color;

	// Only pattern lines need PatternConstants. By default they are null.
	private PatternConstants kA = null;
	private PatternConstants kB = null;

	public FractalLine(float Ax, float Ay, float Bx, float By) {
		this(Ax, Ay, Bx, By, null);
	}

	public FractalLine(float Ax, float Ay, float Bx, float By, Object color) {
		this.Ax = Ax;
		this.Ay = Ay;
		this.Bx = Bx;
		this.By = By;
		this.color = color;
	}

	public void computeConstants(FractalLine baseLine) {
		kA = computeConstantsForPoint(baseLine, Ax, Ay);
		kB = computeConstantsForPoint(baseLine, Bx, By);
	}

	private PatternConstants computeConstantsForPoint(FractalLine base, float x, float y) {
		float dx, dy, dax, day;
		float D;
		float crossDiff, straightSum;

		dx = base.Bx - base.Ax;
		dy = base.By - base.Ay;

		dax = x - base.Ax;
		day = y - base.Ay;

		crossDiff = dx * day - dy * dax;
		straightSum = dx * dax + dy * day;

		D = dx * dx + dy * dy;  // Only 0 if base.A == base.B !!!

		return new PatternConstants(straightSum/D, crossDiff/D);
	}

	public FractalLine computeGeometryEquivalentTo(FractalLine patternLine) {
		PatternConstants constantsA = patternLine.kA;
		PatternConstants constantsB = patternLine.kB;

		float xDiff = Bx - Ax;
		float yDiff = By - Ay;

		float compAx = Ax + constantsA.x * xDiff - constantsA.y * yDiff;
		float compAy = Ay + constantsA.x * yDiff + constantsA.y * xDiff;
		float compBx = Ax + constantsB.x * xDiff - constantsB.y * yDiff;
		float compBy = Ay + constantsB.x * yDiff + constantsB.y * xDiff;

		return new FractalLine(compAx, compAy, compBx, compBy, patternLine.color);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(Ax);
		result = prime * result + Float.floatToIntBits(Ay);
		result = prime * result + Float.floatToIntBits(Bx);
		result = prime * result + Float.floatToIntBits(By);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FractalLine other = (FractalLine) obj;
		if (Float.floatToIntBits(Ax) != Float.floatToIntBits(other.Ax))
			return false;
		if (Float.floatToIntBits(Ay) != Float.floatToIntBits(other.Ay))
			return false;
		if (Float.floatToIntBits(Bx) != Float.floatToIntBits(other.Bx))
			return false;
		if (Float.floatToIntBits(By) != Float.floatToIntBits(other.By))
			return false;
		return true;
	}
}

class PatternConstants {
	public final float x, y;

	public PatternConstants(float x, float y) {
		this.x = x;
		this.y = y;
	}
}


