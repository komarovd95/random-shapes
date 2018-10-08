package ru.ifmo.random.shapes.examples.circle

import ru.ifmo.random.shapes.api.Point
import ru.ifmo.random.shapes.api.RandomShape
import java.util.*
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class RandomCircle : RandomShape<Point> {

    override fun render(): Point {
        val theta = 2.0 * PI * random.nextDouble()
        val r = sqrt(random.nextDouble())
        return Point(r * cos(theta), r * sin(theta), 1.0)
    }

    companion object {
        private val random = Random()
    }
}
