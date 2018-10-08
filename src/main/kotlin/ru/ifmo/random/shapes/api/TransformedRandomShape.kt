package ru.ifmo.random.shapes.api

class TransformedRandomShape(
    private val originShape: RandomShape<Point>,
    private val xOffset: Double = 0.0,
    private val yOffset: Double = 0.0,
    private val xScale: Double = 1.0,
    private val yScale: Double = 1.0
) : RandomShape<Point> {

    override fun render(): Point {
        val point = originShape.render()
        return Point(
            point.x * xScale + xOffset,
            point.y * yScale + yOffset,
            point.energy
        )
    }
}
