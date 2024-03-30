// package labs.lab5
// import chisel3._
// import chisel3.util._

// class datapacket[ T <: Data ]( gen : T ) extends Bundle{
//     val address_field= UInt(10.W) //address field is UInt type of ten bits width
//     val data_field= Input(gen) // Only the data field is type parameterized
// }

// class Router[ T <: Data ]( gen : T ) extends Module{
//     val io=IO(new datapacket{
//         val in=
//         val out=
//     })
// }