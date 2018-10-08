package ru.ifmo.random.shapes.examples.square

import ru.ifmo.random.shapes.api.Point
import ru.ifmo.random.shapes.api.RandomShape
import java.util.*

class RandomSquare : RandomShape<Point> {

    override fun render() = Point(random.nextDouble(), random.nextDouble(), 1.0)

    companion object {
        private val random = Random()
    }
}
