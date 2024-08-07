package labs.lab5
import chisel3._
import chisel3.util._

class datapacket[ T <: Data ]( gen : T ) extends Bundle{
    val address_field= UInt(10.W) //address field is UInt type of ten bits width
    val data_field= Input(gen) // Only the data field is type parameterized
}

class Router[ T <: Data ]( genn : T ) extends Module{
    val io=IO(new Bundle{
        val in= Input(new datapacket(genn))
        val out= Output(new datapacket(genn))
    })
    io.out := io.in
}