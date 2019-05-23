object mathtools {
    internal fun sigmoid(x: Double) : Int = (1.0 / 1.0+Math.pow(Math.E, -1*x)).toInt()
}