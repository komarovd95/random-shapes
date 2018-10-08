package ru.ifmo.random.shapes.api

class SampledRandomShape<out R>(
    private val originShape: RandomShape<R>,
    private val samplesCount: Int
) : RandomShape<Iterable<R>> {

    override fun render() = object : Iterable<R> {
        override fun iterator() = object : Iterator<R> {

            private var sampleCount: Int = 0

            override fun next(): R {
                sampleCount++
                return originShape.render()
            }

            override fun hasNext() = sampleCount < samplesCount
        }
    }
}
