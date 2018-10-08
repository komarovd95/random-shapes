package ru.ifmo.random.shapes.examples.sphere

import ru.ifmo.random.shapes.api.Point
import ru.ifmo.random.shapes.api.RandomShape
import java.util.*
import kotlin.math.*

class RandomSphere : RandomShape<Point> {

    override fun render(): Point {
        val phi = 2.0 * PI * random.nextDouble()
        val theta = acos(2.0 * random.nextDouble() - 1.0)
        return Point(phi, theta, min(max(1.0 / sin(theta), 0.0), 1.0))
    }

    companion object {
        private val random = Random()
    }
}
