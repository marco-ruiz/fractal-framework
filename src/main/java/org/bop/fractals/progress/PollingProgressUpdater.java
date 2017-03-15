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

package org.bop.fractals.progress;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Marco Ruiz
 * @since Feb 21, 2017
 */
public class PollingProgressUpdater extends BaseProgressUpdater {

	private static ExecutorService progressUpdaterService = Executors.newFixedThreadPool(1);

	protected Supplier<Float> progressSupplier;
	private boolean interrupted;

	public PollingProgressUpdater(Supplier<Float> progressSupplier, Consumer<Float> progressListener) {
		super(progressListener);
		this.progressSupplier = progressSupplier;
	}

	public void start() {
		progressUpdaterService.submit(() -> run());
	}

	public void stop() {
		interrupted = true;
	}

	public void run() {
		if (progressListener == null) return;
		interrupted = false;
		while (true) {
			updateProgress(progressSupplier.get());
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {}
			if (interrupted) return;
		}
	}
}

