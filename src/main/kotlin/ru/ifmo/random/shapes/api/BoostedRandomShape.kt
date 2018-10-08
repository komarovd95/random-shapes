package ru.ifmo.random.shapes.api

import kotlin.math.min

class BoostedRandomShape(
    private val originShape: RandomShape<List<Point>>,
    private val boostingLevel: Double
) : RandomShape<List<Point>> {

    override fun render() = originShape.render().map {
        Point(it.x, it.y, min(it.energy, boostingLevel))
    }
}
