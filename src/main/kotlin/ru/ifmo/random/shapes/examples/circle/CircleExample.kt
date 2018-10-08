package ru.ifmo.random.shapes.examples.circle

import ru.ifmo.random.shapes.api.TransformedRandomShape
import ru.ifmo.random.shapes.examples.Example
import ru.ifmo.random.shapes.examples.ExampleRandomShape

fun main(args: Array<String>) {
    val samplesCount = args[0].toInt()

    Example(
        ExampleRandomShape(
            TransformedRandomShape(
                RandomCircle(),
                300.0,
                300.0,
                150.0,
                150.0
            ),
            samplesCount
        ),
        "circle-$samplesCount"
    ).show()
}
