fun main() {
    Car.changeOil()
    Car.changeTires()

    println(checkTypes<Boolean>())
    println(checkTypes<Int>())
    println(checkTypes<String>())

    val tv = TV()
    println(tv.volume)
    tv.volumeUp()
    println(tv.volume)
    tv.volumeUp(5)
    println(tv.volume)
    tv.volumeUp(multiplier = 5)
    println(tv.volume)

    val smartInt = SmartInt(5)
    println(smartInt isGreaterThan 4)
    println(smartInt isLessThan 6)

    println(double(2))
    println(nextNumber(3, ::double))
    println(nextNumberWithLogging().invoke(3, ::double))

    val logic = fun(input: Int): Int = if (input > 2) 2 else input
    println(nextNumber(5, logic))
    println(nextNumber(5) { input -> input + 4 })
}

object Car {
    fun changeOil() {
        println("changeOil")
    }

    fun changeTires() {
        println("changeTires")
    }
}

inline fun <reified T> checkTypes(): Boolean {
    return when(T::class) {
        Boolean::class -> true
        Int::class -> false
        else -> false
    }
}

class TV {
    var volume = 0

    fun volumeUp(amount: Int = 1, multiplier: Int = 1) {
        volume += amount * multiplier
    }
}

class SmartInt(private val target: Int) {
    infix fun isGreaterThan(other: Int): Boolean {
        return target > other
    }

    infix fun isLessThan(other: Int): Boolean {
        return target < other
    }
}

fun double(input: Int) = input * 2

inline fun nextNumber(input: Int, customLogic: (Int) -> Int): Int {
    // custom logic
    return customLogic(input)
}

fun nextNumberWithLogging(): (Int, (Int) -> Int) -> Int {
    println("about to call nextNumber")
    return ::nextNumber
}
