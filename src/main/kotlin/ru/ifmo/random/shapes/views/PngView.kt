package ru.ifmo.random.shapes.views

import ru.ifmo.random.shapes.api.RandomShape
import ru.ifmo.random.shapes.api.ShapeView
import java.awt.image.RenderedImage
import java.io.File
import javax.imageio.ImageIO

/**
 * A view of random shape that renders shape representation to PNG file.
 *
 * @property shape preferably normalized random shape
 *
 * @author Dmitry Komarov
 */
class PngView(
    private val shape: RandomShape<RenderedImage>,
    private val fileName: () -> String
) : ShapeView {

    override fun show() {
        ImageIO.write(shape.render(), "PNG", File(fileName()))
    }
}
