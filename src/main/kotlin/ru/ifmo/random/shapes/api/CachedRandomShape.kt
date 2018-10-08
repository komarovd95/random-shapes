package ru.ifmo.random.shapes.api

/**
 * A random shape with lazy-evaluated cached result of render.
 *
 * @property originShape backing shape
 *
 * @author Dmitry Komarov
 */
class CachedRandomShape<out R>(private val originShape: RandomShape<R>) : RandomShape<R> {

    private val renderResult by lazy { originShape.render() }

    override fun render() = renderResult
}
