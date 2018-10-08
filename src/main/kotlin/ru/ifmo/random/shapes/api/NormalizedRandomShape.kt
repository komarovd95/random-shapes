package ru.ifmo.random.shapes.api

/**
 * A random shape which contains points with energy in range [0..1].
 *
 * @property originShape backing shape
 *
 * @author Dmitry Komarov
 */
class NormalizedRandomShape(private val originShape: RandomShape<List<Point>>) : RandomShape<List<Point>> {

    override fun render(): List<Point> {
        val points = originShape.render()
        return if (points.isEmpty()) {
            points
        } else {
            val maxEnergy = points.maxBy { it.energy }!!.energy
            points.map {
                Point(it.x, it.y, it.energy / maxEnergy)
            }
        }
    }
}
