package ru.ifmo.random.shapes.api

/**
 * A 2D-point with energy.
 *
 * @property x X-axis coordinate
 * @property y Y-axis coordinate
 * @property energy an energy of given point
 *
 * @author Dmitry Komarov
 */
data class Point(val x: Double, val y: Double, val energy: Double)
