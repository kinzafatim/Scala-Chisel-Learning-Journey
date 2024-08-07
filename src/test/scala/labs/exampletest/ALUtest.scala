// package labs
// import chisel3._
// import chiseltest._
// import org.scalatest._
// class ALUtest extends FreeSpec with ChiselScalatestTester {
//   "ALU" in {
//     test(new ALU) { x =>
//       // Send inputs to the ALU
//       x.io.A.poke(5.U)
//       x.io.B.poke(3.U)
//       x.io.alu_Op.poke(ALUOP.ALU_ADD)
//       // Wait for the output to settle
//       x.clock.step()
//       // Check the output
//       x.io.out.expect(8.U)
//       x.io.sum.expect(8.U)
//     }
//   }
// }
