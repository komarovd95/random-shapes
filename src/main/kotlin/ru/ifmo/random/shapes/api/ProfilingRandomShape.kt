package ru.ifmo.random.shapes.api

import java.util.*

class ProfilingRandomShape<out R>(
    private val originShape: RandomShape<R>,
    private val profilingStamp: String
) : RandomShape<R> {

    override fun render(): R {
        val profileStart = System.currentTimeMillis()
        val renderResult = originShape.render()
        val profileEnd = System.currentTimeMillis()
        reportProfile(profileEnd - profileStart)
        return renderResult
    }

    private fun reportProfile(elapsedTime: Long) {
        if (profileStack.isEmpty()) {
            println("$profilingStamp: ${elapsedTime}ms")
        } else {
            println("$profilingStamp: ${elapsedTime - profileStack.peek()}ms")
        }
        profileStack.push(elapsedTime)
    }

    companion object {
        val profileStack = Stack<Long>()
    }
}
