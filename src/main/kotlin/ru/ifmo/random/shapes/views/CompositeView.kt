package ru.ifmo.random.shapes.views

import ru.ifmo.random.shapes.api.ShapeView

/**
 * A composite view.
 *
 * @property views the views that will be rendered
 *
 * @author Dmitry Komarov
 */
class CompositeView(private vararg val views: ShapeView) : ShapeView {

    override fun show() {
        views.forEach {
            it.show()
        }
    }
}
