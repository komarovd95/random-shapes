package ru.ifmo.random.shapes.examples.lambertian

import ru.ifmo.random.shapes.api.SampledRandomShape
import ru.ifmo.random.shapes.api.TransformedRandomShape
import ru.ifmo.random.shapes.examples.Example
import ru.ifmo.random.shapes.examples.ExampleRandomShape

fun main(args: Array<String>) {
    val samplesCount = args[0].toInt()

    Example(
        ExampleRandomShape(
            TransformedRandomShape(
                RandomLambertianSphere(),
                130.0,
                100.0,
                50.0,
                400.0
            ),
            samplesCount
        ),
        "lambertian-$samplesCount"
    ).show()
}
