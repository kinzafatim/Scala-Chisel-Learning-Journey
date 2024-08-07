package labs.lab4
import labs.lab4.ALUOPCODE._
import chisel3._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import org.scalatest._

import scala.util.Random

class ex1test extends FreeSpec with ChiselScalatestTester {

  "ALU Test" in {
    test(new ex1).withAnnotations(Seq(VerilatorBackendAnnotation)) { 
        c =>
        val array_op = Array(ALUOPCODE.ALU_MUL,ALUOPCODE.ALU_ADD, ALUOPCODE.ALU_SUB, ALUOPCODE.ALU_AND, ALUOPCODE.ALU_OR, ALUOPCODE.ALU_XOR, ALUOPCODE.ALU_SLT, ALUOPCODE.ALU_SLL, ALUOPCODE.ALU_SLTU, ALUOPCODE.ALU_SRL, ALUOPCODE.ALU_SRA, ALUOPCODE.ALU_COPY_A, ALUOPCODE.ALU_COPY_B, ALUOPCODE.ALU_XXX)
        
        for (i <- 0 until 100) {
        val src_a = Random.nextLong() & 0xFFFFFFFFL
        val src_b = Random.nextLong() & 0xFFFFFFFFL
        //val opr = Random.nextInt(12)
        val aluop = array_op(0)

        // ALU functional implementation using Scala match
        val result = aluop match {
          case ALUOPCODE.ALU_ADD   => src_a + src_b
          case ALUOPCODE.ALU_SUB   => src_a - src_b
          case ALUOPCODE.ALU_AND   => src_a & src_b
          case ALUOPCODE.ALU_OR    => src_a | src_b
          case ALUOPCODE.ALU_XOR   => src_a ^ src_b
          case ALUOPCODE.ALU_SLT   => (src_a.toInt < src_b.toInt).asInstanceOf[Int]
          case ALUOPCODE.ALU_SLL   => src_a << (src_b & 0x1F)
          case ALUOPCODE.ALU_SLTU  => (src_a < src_b).asInstanceOf[Int]
          case ALUOPCODE.ALU_SRL   => src_a >> (src_b & 0x1F)
          case ALUOPCODE.ALU_SRA   => (src_a.toInt >> (src_b.toInt & 0x1F)).toInt
          case ALUOPCODE.ALU_COPY_A => src_a
          case ALUOPCODE.ALU_COPY_B => src_b
          case _         => 0
        }

        val result1: BigInt = if (result < 0)
          (BigInt(0xFFFFFFFFL) + result + 1) & 0xFFFFFFFFL
        else result & 0xFFFFFFFFL

        c.io.in_A.poke(src_a.U)
        c.io.in_B.poke(src_b.U)
        c.io.alu_Op.poke(aluop)
        c.clock.step(1)
        c.io.out.expect(0.U)
        //c.io.sum.expect(0.U)
      }
      c.clock.step(10)
    }
  }
}
