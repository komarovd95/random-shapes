package ru.ifmo.random.shapes.examples.sphere

import ru.ifmo.random.shapes.api.SampledRandomShape
import ru.ifmo.random.shapes.api.TransformedRandomShape
import ru.ifmo.random.shapes.examples.Example
import ru.ifmo.random.shapes.examples.ExampleRandomShape

fun main(args: Array<String>) {
    val samplesCount = args[0].toInt()

    Example(
        ExampleRandomShape(
            TransformedRandomShape(
                RandomSphere(),
                130.0,
                120.0,
                50.0,
                100.0
            ),
            samplesCount
        ),
        "sphere-$samplesCount"
    ).show()
}
