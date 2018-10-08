package ru.ifmo.random.shapes.examples.lambertian

import ru.ifmo.random.shapes.api.Point
import ru.ifmo.random.shapes.api.RandomShape
import java.util.*
import kotlin.math.*

class RandomLambertianSphere : RandomShape<Point> {

    override fun render(): Point {
        val phi = 2.0 * PI * random.nextDouble()
        val theta = acos(1.0 - random.nextDouble())

        val x = sin(theta) * cos(phi)
        val y = sin(theta) * sin(phi)
        val z = cos(theta) + 1.0

        val norm = sqrt(x.pow(2) + y.pow(2) + z.pow(2))

        val th = acos(z / norm)
        val ph = atan2(y / norm, x / norm) + PI

        return Point(ph, th, min(max(1.0 / sin(th) / cos(th), 0.0), 1.0))
    }

    companion object {
        private val random = Random()
    }
}
