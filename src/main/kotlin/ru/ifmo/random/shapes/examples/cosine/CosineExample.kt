package ru.ifmo.random.shapes.examples.cosine

import ru.ifmo.random.shapes.api.TransformedRandomShape
import ru.ifmo.random.shapes.examples.Example
import ru.ifmo.random.shapes.examples.ExampleRandomShape

fun main(args: Array<String>) {
    val samplesCount = args[0].toInt()

    Example(
        ExampleRandomShape(
            TransformedRandomShape(
                RandomCosineSphere(),
                130.0,
                100.0,
                50.0,
                200.0
            ),
            samplesCount
        ),
        "cosine-$samplesCount"
    ).show()
}
