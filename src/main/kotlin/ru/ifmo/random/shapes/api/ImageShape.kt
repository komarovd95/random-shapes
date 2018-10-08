package ru.ifmo.random.shapes.api

import java.awt.Color
import java.awt.image.BufferedImage

class ImageShape(
    private val originShape: RandomShape<List<Point>>,
    private val width: Int,
    private val height: Int
) : RandomShape<BufferedImage> {

    override fun render(): BufferedImage {
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        for (x in 0 until width) {
            for (y in 0 until height) {
                image.setRGB(x, y, Color.BLACK.rgb)
            }
        }
        originShape.render().forEach {
            image.setRGB(it.x.toInt(), it.y.toInt(), toRgb(it.energy))
        }
        return image
    }

    private fun toRgb(energy: Double): Int {
        val green = (energy * 0xFF).toInt()
        return Color(0, green, 0).rgb
    }
}