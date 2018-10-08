package ru.ifmo.random.shapes.api

import kotlin.math.floor

class ClusteredRandomShape(private val originShape: RandomShape<Iterable<Point>>) : RandomShape<List<Point>> {

    override fun render(): List<Point> {
        val points = originShape.render()

        val energyMap = HashMap<Pair<Int, Int>, Double>()
        points.forEach {
            energyMap.compute(floor(it.x).toInt() to floor(it.y).toInt()) { _, v -> if (v == null) it.energy else v + it.energy  }
        }

        return energyMap.entries.map { (key, value) -> Point(key.first.toDouble(), key.second.toDouble(), value) }
    }
}
