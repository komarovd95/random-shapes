package ru.ifmo.random.shapes.examples.cosine

import ru.ifmo.random.shapes.api.Point
import ru.ifmo.random.shapes.api.RandomShape
import java.util.*
import kotlin.math.PI
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sin

class RandomCosineSphere : RandomShape<Point> {

    private val integrals: List<Double>

    init {
        val localIntegrals = mutableListOf(0.0)
        val gammas = 0.0.range(PI / 2.0, PI / 180.0).toList()

        for (i in 0 until (gammas.size - 1)) {
            val result = sin2x.integrate(gammas[i], gammas[i + 1]) / 2.0
            localIntegrals += if (result < 0.0) {
                (localIntegrals[i] - result)
            } else {
                (localIntegrals[i] + result)
            }
        }

        integrals = localIntegrals.toList()
    }

    override fun render(): Point {
        while (true) {
            val b = randomAngle()
            val a = max(0.0, b - PI / 180.0)

            val f = max(sin2x(a), sin2x(b))

            val theta = a + (b - a) * random.nextDouble()
            val w = random.nextDouble() * f
            if (w <= sin2x(theta)) {
                val phi = 2.0 * PI * random.nextDouble()
                return Point(phi, theta, min(max(0.5 / sin2x(theta), 0.0), 1.0))
            }
        }
    }

    private fun randomAngle(): Double {
        val z = random.nextDouble() * integrals.last()
        var i = 0
        while (z > integrals[i]) {
            i++
        }
        return i * PI / 180.0
    }

    private fun ((Double) -> Double).integrate(from: Double, to: Double): Double {
        val h = (to - from) / 2.0
        return (this(from) + this(from + h)) * h
    }

    private fun Double.range(to: Double, step: Double): Iterable<Double> {
        return Iterable {
            object : Iterator<Double> {

                private var current = this@range

                override fun hasNext() = current < to

                override fun next(): Double {
                    val next = current
                    current += step
                    return next
                }
            }
        }
    }

    companion object {
        private val random = Random()

        private val sin2x = { x: Double -> sin(2.0 * x) }
    }
}
