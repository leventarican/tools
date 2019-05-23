import java.awt.image.BufferedImage
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    args?.run {
        val arg = this[0]
        val inputFile = File(arg)
        val absolutePath = inputFile.toPath().toAbsolutePath()
        val bytes = Files.readAllBytes(absolutePath)
        println("path: $absolutePath; size: ${bytes.size / 1024}KB")

        val image = ImageIO.read(inputFile)
        val outFile = Paths.get(absolutePath.parent.toString(), "${inputFile.nameWithoutExtension}-resized.${inputFile.extension}").toFile()
        val scaled = scale(image, image.width/2, image.height/2)
        ImageIO.write(scaled, "png", outFile);
    }
}

/**
 * thanks to: https://stackoverflow.com/questions/16497853/scale-a-bufferedimage-the-fastest-and-easiest-way
 */
fun scale(src: BufferedImage, w: Int, h: Int): BufferedImage {
    val img = BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
    var x: Int = 0
    var y: Int
    val ww = src.width
    val hh = src.height
    while (x < w) {
        y = 0
        while (y < h) {
            val col = src.getRGB(x * ww / w, y * hh / h)
            img.setRGB(x, y, col)
            y++
        }
        x++
    }
    return img
}