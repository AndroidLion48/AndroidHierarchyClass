package com.example.androidhierarchyclass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun main() {
        val squareCabin = SquareCabin(6, 50.0)
        val roundHut = RoundHut(3, 10.0)
        val roundTower = RoundTower(4, 15.5)

        with(squareCabin) {
            println("\nSquare Cabin\n============")
            println("Capacity: $capacity")
            println("Material: $buildingMaterial")
            println("Has room? ${hasRoom()}")
            println("Floor area: %.2f".format(floorArea()))
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Has room? ${hasRoom()}")
            getRoom()

        }

        with(roundHut) {
            println("\nRound Hut\n=========")
            println("Material: $buildingMaterial")
            println("Capacity: $capacity")
            println("Has room? ${hasRoom()}")
            println("Floor area: %.2f".format(floorArea()))
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Carpet Length: ${calculateMaxCarpetLength()}")

        }

        with(roundTower) {
            println("\nRound Tower\n==========")
            println("Material: $buildingMaterial")
            println("Capacity: $capacity")
            println("Has room? ${hasRoom()}")
            println("Floors: $floors")
            println("Floor area: %.2f".format(floorArea()))
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Carpet Length: ${calculateMaxCarpetLength()}")
        }
    }

    abstract class Dwelling(private var residents: Int) {

        abstract val buildingMaterial: String
        abstract val capacity: Int

        fun getRoom() {
            if (capacity > residents) {
                residents++
                println("You have a room!")
            } else {
                println("Sorry, at capacity and no rooms left.")
            }
        }

        fun hasRoom(): Boolean {
            return residents < capacity
        }

        abstract fun floorArea(): Double
    }

    class SquareCabin(residents: Int, private val length: Double) : Dwelling(residents) {

        override val buildingMaterial = "Wood"
        override val capacity = 6

        override fun floorArea(): Double {
            return length * length
        }
    }

    open class RoundHut(residents: Int, private val radius: Double) : Dwelling(residents) {

        override val buildingMaterial = "Straw"
        override val capacity = 4

        fun calculateMaxCarpetLength(): Double {
            return sqrt(2.0) * radius
        }

        override fun floorArea(): Double {
            return PI * radius * radius
        }
    }

    class RoundTower(
        residents: Int, radius: Double,
        val floors: Int = 2
    ) : RoundHut(residents, radius) {

        override val buildingMaterial = "Stone"
        override val capacity = 4 * floors

        override fun floorArea(): Double {
            return super.floorArea() * floors
        }
    }
}
