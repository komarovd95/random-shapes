package ru.ifmo.random.shapes.api

/**
 * A random shape.
 *
 * @author Dmitry Komarov
 */
interface RandomShape<out R> {

    /**
     * Returns a rendered representation of given shape.
     *
     * @return rendered representation
     */
    fun render(): R
}
