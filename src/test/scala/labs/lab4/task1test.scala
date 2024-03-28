package labs.lab4
import labs.lab4.branch._
import chisel3.Bool
import chisel3._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import org.scalatest._
import scala.util.Random

class task1test extends FreeSpec with ChiselScalatestTester {
  "Branch Control Test" in {
    test(new task1).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
    val array_op = Array(branch.beq,branch.bne,branch.blt,branch.bge, branch.bltu,branch.bgeu)
        for (i <- 0 until 100) {
        val src_a = Random.nextLong() & 0xFFFFFFFFL
        val src_b = Random.nextLong() & 0xFFFFFFFFL
        //val opr = Random.nextInt(12)
        val aluop = array_op(0)
        val result = aluop match {
          case branch.beq   => src_a === src_b
          case branch.bne  => src_a != src_b
          case branch.blt   => src_a < src_b
          case branch.bge   => src_a >= src_b
          case branch.bltu  => src_a < src_b
          case branch.bgeu   => src_a >= src_b
          case _         => 0
        }
        c.io.fnct3.poke(aluop)
        c.io.arg_x.poke(src_a.U)
        c.io.arg_y.poke(src_b.U)
        c.clock.step(1)
        c.io.br_taken.expect(0.B)
      }
      c.clock.step(10)
    }
  }
}