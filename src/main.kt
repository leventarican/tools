import kotlin.test.assertTrue

fun main() {
    sigmoidFunction()
}

fun sigmoidFunction() {
//    val x = listOf<Double>(3.0, -4.0, 0.1, 100.0, -42.0)
//    val s = mutableListOf<Double>()
//    x.forEach { x ->
//        println(x)
//        s.add(mathtools.sigmoid(x))
//    }
    val x = 3.0
    val s = mathtools.sigmoid(x)

    println("[sigmoid function] input: $x; output: $s")

    // unit test
    assertTrue {
        s == 1
    }
}