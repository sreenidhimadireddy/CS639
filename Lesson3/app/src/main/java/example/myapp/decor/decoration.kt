package example.myapp.decor


data class Decoration2(val rocks: String, val wood: String, val diver: String){
}

fun makeDecorations() {
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)


    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

class Choice {
    companion object {
        var name: String = "lyric"
        fun showDescription(name:String) = println("My favorite $name")
    }
}
val equipment = "fish net" to "catching fish"
val numbers = Triple(6, 9, 42)
val equipment2 = ("fish net" to "catching fish") to "equipment"
val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras", "zebra fish" to "danio rerio" )

const val rocks = 3
fun complexFunctionCall(): Int = 42
val value1 = complexFunctionCall()

object Constants {
    const val CONSTANT2 = "object constant"
}
val foo = Constants.CONSTANT2
class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}

fun main() {
    println(Choice.name)
    Choice.showDescription("pick")
    Choice.showDescription("selection")
    println("${equipment.first} used for ${equipment.second}")
    println(numbers.toString())
    println(numbers.toList())
    println("${equipment2.first} is ${equipment2.second}\n")
    println("${equipment2.first.second}")
    val (tool, use) = equipment
    println("$tool is used for $use")
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")
    val list = listOf(1, 5, 3, 4)
    println(list.sum())
    val list2 = listOf("a", "bbb", "cc")
    for (s in list2.listIterator()) {
        println("$s ")
    }
    println(scientific.get("guppy"))
    println(scientific.get("zebra fish"))
    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))
    println(scientific.getOrElse("swordtail") { "sorry, I don't know" })


    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // what will it print?
    println(aquariumPlant.isGreen)


    run {
        val plant: AquariumPlant? = null
        plant.pull()
    }
}


fun String.hasSpaces() = indexOf(" ") != -1
open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

