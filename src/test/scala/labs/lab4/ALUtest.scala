// package labs.lab4
// import chisel3._
// import chisel3.util._
// import org.scalatest._
// import chiseltest._
// import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotation
// import scala.util.Random
// import ALUOPCODE._

// class TestALU extends FreeSpec with ChiselScalatestTester {
//   "ALU Test" in {
//     test(new ex1).withAnnotations(Seq(VerilatorBackendAnnotation)) { 
//         c =>
//       // ALU operations
//       val array_op = Array(ALU_ADD, ALU_SUB, ALU_AND, ALU_OR, ALU_XOR, ALU_SLT,
//         ALU_SLL, ALU_SLTU, ALU_SRL, ALU_SRA, ALU_COPY_A, ALU_COPY_B,ALU_MUL, ALU_DIV, ALU_MOD, ALU_MAX,ALU_MIN  ALU_XXX)

//       for (i <- 0 until 100) {
//         val Rs_1 = Random.nextLong() & 0xFFFFFFFFL
//         val Rs_2 = Random.nextLong() & 0xFFFFFFFFL
//         val opr = Random.nextInt(12)
//         val aluop = array_op(opr)
//         val result = aluop match {
//           case ALU_ADD => Rs_1 + Rs_2
//           case ALU_SUB => Rs_1 - Rs_2
//           case ALU_AND => Rs_1 & Rs_2
//           case ALU_OR => Rs_1 | Rs_2
//           case ALU_XOR => Rs_1 ^ Rs_2
//           case ALU_SLT => (Rs_1 < Rs_2).asInstanceOf[Int]
//           case ALU_SLL => Rs_1 << (Rs_2 & 0x1F)
//           case ALU_SLTU => (Rs_1 < Rs_2).asInstanceOf[Int]
//           case ALU_SRL => Rs_1 >> (Rs_2 & 0x1F)
//           case ALU_SRA => (Rs_1.toInt >> (Rs_2 & 0x1F)).toLong
//           case ALU_COPY_A => Rs_1
//           case ALU_COPY_B => Rs_2
//           case _ => 0
//         }

//         val result1 = (BigInt(result) & BigInt("FFFFFFFF", 16)).asUInt()

//         c.io.in_A.poke(Rs_1.U)
//         c.io.in_B.poke(Rs_2.U)
//         c.io.alu_Op.poke(aluop)
//         c.clock.step(1)
//         c.io.out.expect(result1)
//       }
//       c.clock.step(2)
//     }
//   }
// }
