package ru.ifmo.random.shapes.examples

import ru.ifmo.random.shapes.api.*
import ru.ifmo.random.shapes.views.CompositeView
import ru.ifmo.random.shapes.views.PngView
import ru.ifmo.random.shapes.views.ProfilingView
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class Example(
    private val shape: ExampleRandomShape,
    private val shapeName: String
) : ShapeView by CompositeView(
    ProfilingView(
        PngView(shape) { "${shapeName}_${currentDate()}.png" }
    )
//    ProfilingView(
//        SwingView(
//            shape,
//            shapeName,
//            width,
//            height
//        )
//    )
) {
    companion object {
        private val formatter = DateTimeFormatter.ofPattern("YYYYddmm_HHmmss")

        private fun currentDate() = ZonedDateTime.now().format(formatter)
    }
}
