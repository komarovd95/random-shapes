package ru.ifmo.random.shapes.views

import ru.ifmo.random.shapes.api.RandomShape
import ru.ifmo.random.shapes.api.ShapeView
import java.awt.Graphics
import java.awt.Image
import java.awt.image.BufferedImage
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

/**
 * A view of random shape that renders shape representation to Swing UI.
 *
 * @property shape preferably normalized random shape
 * @property shapeName the name of rendered shape, used in file name
 * @property width width of rendering image
 * @property height height of rendering image
 * @property baseColor base color of rendering image. Green by default
 *
 * @author Dmitry Komarov
 */
class SwingView(
    private val shape: RandomShape<BufferedImage>,
    private val title: String,
    private val width: Int,
    private val height: Int
) : ShapeView {

    override fun show() {
        val image = shape.render()
        SwingUtilities.invokeLater {
            val frame = JFrame(title)
            frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            frame.setSize(width, height)

            frame.add(object : JPanel() {
                override fun paintComponent(g: Graphics) {
                    super.paintComponent(g)
                    g.drawImage(image, 0, 0, null)
                }
            })

            frame.isVisible = true
        }
    }
}
