package ru.ifmo.random.shapes.examples.triangle

import ru.ifmo.random.shapes.api.Point
import ru.ifmo.random.shapes.api.RandomShape
import java.util.*

class RandomTriangle(
    private val vector1: Pair<Double, Double>,
    private val vector2: Pair<Double, Double>
) : RandomShape<Point> {

    override fun render(): Point {
        while (true) {
            val x = random.nextDouble()
            val y = random.nextDouble()

            if ((x + y) <= 1.0) {
                return Point(
                    vector1.first * x + vector1.second * y,
                    vector2.first * x + vector2.second * y,
                    1.0
                )
            }
        }
    }

    companion object {
        private val random = Random()
    }
}
