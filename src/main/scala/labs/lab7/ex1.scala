// package labs.lab7
// import chisel3._
// import chisel3.util._
// import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}
// class ex1 extends Module {
//     val io = IO ( new Bundle {
//         val input1 = Flipped(Decoupled(UInt(8.W)))
//         val input2 = Flipped(Decoupled(UInt(8.W)))
//         val out = Decoupled(UInt(8.W))
// })
// val queue1 = Queue( io.input1 , 8)
// val queue2 = Queue( io.input2 , 8)
// val arb_priority = Module(new Arbiter(UInt(8.W),2))

// arb_priority.io.in(0)<> producer0.io.out
// arb_priority.io.in(1)<> producer1.io.out
// //bulk connect <> 
// io.out <> arb_priority.io.out
// }