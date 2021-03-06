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

import java.util.function.Consumer;

/**
 * @author Marco Ruiz
 * @since Feb 21, 2017
 */
public interface PatternEditor {

	public void startBaseDefinition();
	public void clear();
	public void showPattern();
	public void showFractal();
	public void computeFractal(int numIter, boolean onlyLastIter, Consumer<Float> progressUpdater);
}
