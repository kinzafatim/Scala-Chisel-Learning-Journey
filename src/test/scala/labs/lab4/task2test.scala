// package labs.lab4
// import chisel3._
// import chisel3.util._
// import chiseltest._
// import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotation
// import org.scalatest._
// import scala.util.Random

// class task2test extends FreeSpec with ChiselScalatestTester {

//   "Immediate Value Generator Test" in {
//     test(new task2).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
//       val array_opcodes = Array(
//         "b0010011".U, "b0100011".U, "b1100011".U,
//         "b0110111".U, "b0010111".U, "b1101111".U, "b1100111".U
//       )
      
//       for (i <- 0 until 100) {
//         // Random instruction and opcode
//         val instr = Random.nextLong() & 0xFFFFFFFFL
//         //val opcode = array_opcodes(Random.nextInt(array_opcodes.length))
//         val opcode=array_opcodes(1)

//         val output = opcode match {
//           case "b0010011".U => Cat(Fill(20, instr(31)), instr(31, 20)) // I-type
//           case "b0100011".U => Cat(Fill(20, instr(31)), instr(31), instr(30, 25), instr(11, 7)) // S-type
//           case "b1100011".U => Cat(Fill(18, instr(31)), instr(31), instr(7), instr(30, 25), instr(11, 8)) // B-type
//           case "b0110111".U => Cat(Fill(12, 0.U), instr(31, 12)) // LUI
//           case "b0010111".U => Cat(Fill(12, 0.U), instr(31, 12)) // AUIPC
//           case "b1101111".U => Cat(Fill(11, instr(31)), instr(31), instr(19, 12), instr(20), instr(30, 21)) // JAL
//           case "b1100111".U => Cat(Fill(11, instr(31)), instr(31, 20)) // JALR
//          // case _         => 0
//         }
//         c.io.instr.poke(instr.U)
//         c.io.opcode.poke(opcode)
//         c.clock.step(1)
//         c.io.out_ins.expect(output)
//       }
//       c.clock.step(10)
//     }
//   }
// }
