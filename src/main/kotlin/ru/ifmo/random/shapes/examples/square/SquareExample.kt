package ru.ifmo.random.shapes.examples.square

import ru.ifmo.random.shapes.api.SampledRandomShape
import ru.ifmo.random.shapes.api.TransformedRandomShape
import ru.ifmo.random.shapes.examples.Example
import ru.ifmo.random.shapes.examples.ExampleRandomShape

fun main(args: Array<String>) {
    val samplesCount = args[0].toInt()

    Example(
        ExampleRandomShape(
            TransformedRandomShape(
                RandomSquare(),
                150.0,
                150.0,
                300.0,
                300.0
            ),
            samplesCount
        ),
        "square-$samplesCount"
    ).show()
}
