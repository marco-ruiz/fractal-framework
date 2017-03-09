# Fractal Generator Library

This project consists of:
- An API to request the generation of a `fractal descriptor` given a `fractal pattern` and the number of `recursions`.
- A main framework (which expects concrete transformations implementations) to compute fractals from an specific `fractal pattern` implementation.
- A SPI to implement `fractal pattern`s of any kind and a particular one to implement geometric kind of `fractal pattern`s
- A specific `fractal pattern` implementation consisting of shape transformations for the simplest of all shapes: lines!
- A sub-framework to update progress of an abstract task (i.e. fractal generator) using abstract workers.
- Two implementations of the update progress workers: polling (asynchronous) and threshold reached (synchronous).

## Usage Examples

The following client applications have been developed using this library:

- [Android App](https://github.com/marco-ruiz/fractal-android)
- [Java Swing App](https://github.com/marco-ruiz/fractal-swing)
- [JavaFX App](https://github.com/marco-ruiz/fractal-javafx)


## Usage & Design

The generator framework requires concrete implementations of the shapes is going to be using with their respective transformation logic:

```java

	public interface GeometricPattern<SHAPE_TYPE> {
		public void computeConstants(SHAPE_TYPE base);
		public SHAPE_TYPE computeGeometryEquivalentTo(SHAPE_TYPE relativeBase);
	}

```


Having this interface implemented, the framework will generate the fractal using the following logic:
- The first shape of a `fractal pattern` is a **base**, and the rest of the shapes are relative transformations to be applied to said **base**.
- The generator recursively applies the same transformations to each of the other shapes.
- Cut off arguments are available to catalyze the process. The level of depth of the recursion can be control with the
number of recursions argument and if we want only the last level of recursion, the boolean argument **onlyLastIteration** need to be set as true.

``` java

	// Generator constructor
	public GeometricPatternFractalGenerator(
		List<SHAPE_TYPE> pattern,	// fractal pattern
		int numRecursions,			// recursion depth
		boolean lastIterOnly,		// only gather shapes computed @ last recursion level
		Consumer<Float> listener	// progress listener
	){  ...  }

```

- This class exposes two API methods to execute the generation (in memory) of the corresponding `fractal descriptor`:

``` java

	public void generateFractal()		// asynchronous generation
	public void generateFractalSync()	// synchronous generation

```

- After the generator finished generating the `fractal descriptor` (return from the synchronous call or receiving a
**finished generation** event from the asynchronous call - described later here), the `fractal descriptor` can be
accessed through the `getFractal()` method:

```java

    List<SHAPE_TYPE> shapesGenerated = fractalGenerator.getFractal();
    shapesGenerated.stream().forEach(shape -> draw(shape));

```


- *Asynchronous generation*
  - In this case, the invocation of `generateFractal()` must be pair up with a reaction from the progress listener registered,
  with the following overall logic:

```java

	Consumer<Float> progressListener = this::listenProgress;

	...

	public void listenProgress(float percentProgress)  {
		if (progress == IProgressUpdater.FINISHED_PROGRESS) {
			// The fractal generator has finished computing the fractal
		} else {
			// Update progress status if desired
		}
	}

```


