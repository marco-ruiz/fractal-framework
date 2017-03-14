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

	public final double Ax;
	public final double Ay;
	public final double Bx;
	public final double By;

	public final Object color;

	// Only pattern lines need PatternConstants. By default they are null.
	private PatternConstants kA = null;
	private PatternConstants kB = null;

	public FractalLine(double Ax, double Ay, double Bx, double By) {
		this(Ax, Ay, Bx, By, null);
	}

	public FractalLine(double Ax, double Ay, double Bx, double By, Object color) {
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

	private PatternConstants computeConstantsForPoint(FractalLine base, double x, double y) {
		double dx, dy, dax, day;
		double D;
		double crossDiff, straightSum;

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

		double xDiff = Bx - Ax;
		double yDiff = By - Ay;

		double compAx = Ax + constantsA.x * xDiff - constantsA.y * yDiff;
		double compAy = Ay + constantsA.x * yDiff + constantsA.y * xDiff;
		double compBx = Ax + constantsB.x * xDiff - constantsB.y * yDiff;
		double compBy = Ay + constantsB.x * yDiff + constantsB.y * xDiff;

		return new FractalLine(compAx, compAy, compBx, compBy, patternLine.color);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Ax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(Ay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(Bx);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(By);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		if (Double.doubleToLongBits(Ax) != Double.doubleToLongBits(other.Ax))
			return false;
		if (Double.doubleToLongBits(Ay) != Double.doubleToLongBits(other.Ay))
			return false;
		if (Double.doubleToLongBits(Bx) != Double.doubleToLongBits(other.Bx))
			return false;
		if (Double.doubleToLongBits(By) != Double.doubleToLongBits(other.By))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
}

class PatternConstants {
	public final double x, y;

	public PatternConstants(double x, double y) {
		this.x = x;
		this.y = y;
	}
}


