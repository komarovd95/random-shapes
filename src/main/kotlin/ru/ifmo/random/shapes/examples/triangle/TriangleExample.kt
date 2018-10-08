package ru.ifmo.random.shapes.examples.triangle

import ru.ifmo.random.shapes.api.SampledRandomShape
import ru.ifmo.random.shapes.api.TransformedRandomShape
import ru.ifmo.random.shapes.examples.Example
import ru.ifmo.random.shapes.examples.ExampleRandomShape

fun main(args: Array<String>) {
    val samplesCount = args[0].toInt()

    Example(
        ExampleRandomShape(
            TransformedRandomShape(
                RandomTriangle(0.8 to 1.0, 1.0 to 0.7),
                150.0,
                150.0,
                300.0,
                300.0
            ),
            samplesCount
        ),
        "triangle-$samplesCount"
    ).show()
}
