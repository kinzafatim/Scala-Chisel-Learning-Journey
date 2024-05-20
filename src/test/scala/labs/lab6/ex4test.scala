// package labs.lab6
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._
// class ex4test extends FreeSpec with ChiselScalatestTester {
//   "lab6 Ex4 " in {
//     test(new ex4){
//         a =>
//         a.io.valid.poke(.B)
//         a.io.ready.poke(.B)
//         a.io.in.poke("b0001".U)
//         a.clock.step(100)
//         a.io.out.expect("b0001".U)
//     } 
//   }
// }