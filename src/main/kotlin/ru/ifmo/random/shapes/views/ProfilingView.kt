package ru.ifmo.random.shapes.views

import ru.ifmo.random.shapes.api.ProfilingRandomShape
import ru.ifmo.random.shapes.api.ShapeView

class ProfilingView(private val originView: ShapeView) : ShapeView {

    override fun show() {
        val start = System.currentTimeMillis()
        originView.show()
        val end = System.currentTimeMillis()
        println("Profiling [${originView::class.simpleName}]: ${end - start}ms (${ProfilingRandomShape.profileStack.peek()}ms)")
    }
}
