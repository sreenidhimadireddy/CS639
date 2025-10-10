package com.example.lesson2
import kotlin.random.Random


private val DECORATIONS = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
private var dirtyLevel: Int = 20

// Single entry point
fun main() {
    println("Hello!")

    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = temperature > 50
    println(isHot)
    val message = "The water temperature is ${if (temperature > 50) "too warm" else "OK"}."
    println(message)

    swim()
    swim("slow")
    swim(speed = "turtle-like")

    feedTheFish()

    showDecorationsEagerLazy()
    showFlattenDemo()

    // --- Lambdas / HOF demo ---
    lambdaWaterDemo()
}


fun randomDay(): String =
    listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday").random()

fun fishFood(day: String): String = when (day) {
    "Monday"    -> "flakes"
    "Wednesday" -> "redworms"
    "Thursday"  -> "granules"
    "Friday"    -> "mosquitoes"
    "Sunday"    -> "plankton"
    else        -> "nothing"
}

fun swim(speed: String = "fast") = println("swimming $speed")

fun feedTheFish() {
    val day  = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int)        = dirty > 30
fun isSunday(day: String)      = day == "Sunday"

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean =
    isTooHot(temperature) || isDirty(dirty) || isSunday(day)


fun showDecorationsEagerLazy() {
    println("\n--- Decorations demo ---")
    println("All: $DECORATIONS")

    val eager = DECORATIONS.filter { it.startsWith('p') }
    println("eager: $eager")

    val filteredSeq = DECORATIONS.asSequence().filter { it.startsWith('p') }
    println("filtered (lazy): $filteredSeq")
    val newList = filteredSeq.toList()
    println("new list: $newList")

    val lazyMap = DECORATIONS.asSequence().map {
        println("access: $it")
        it
    }
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = DECORATIONS.asSequence()
        .filter { it.startsWith('p') }
        .map {
            println("access: $it")
            it
        }
    println("filtered (lazy map): ${lazyMap2.toList()}")
}

fun showFlattenDemo() {
    println("\n--- Flatten demo ---")
    val sports  = listOf("basketball", "fishing", "running")
    val players = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val cities  = listOf("Los Angeles", "Chicago", "Jamaica")
    val nested  = listOf(sports, players, cities)
    println("Flat: ${nested.flatten()}")
}


private val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

private fun updateDirty(dirty: Int, operation: (Int) -> Int): Int = operation(dirty)

private fun increaseDirty(start: Int) = start + 1

private fun lambdaWaterDemo() {
    println("\n--- Lambda / HOF demo ---")
    println("initial dirtyLevel: $dirtyLevel")

    println("waterFilter(dirtyLevel): ${waterFilter(dirtyLevel)}")
    println("updateDirty(30, waterFilter): ${updateDirty(30, waterFilter)}")
    println("updateDirty(15, ::increaseDirty): ${updateDirty(15, ::increaseDirty)}")

    // trailing-lambda syntax; avoid shadowing the outer dirtyLevel
    dirtyLevel = updateDirty(dirtyLevel) { d -> d + 23 }
    println("dirtyLevel after update: $dirtyLevel")
}

