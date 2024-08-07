package labs.lab5
import chisel3._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import org.scalatest._
class ex1test extends FreeSpec with ChiselScalatestTester {
  "Ex1" in {
    test(new ex1(4)){
        x=>
        x.io.alu_oper.poke("b0010".U)
        x.io.arg_x.poke(2.U)
        x.io.arg_y.poke(2.U)
        x.clock.step(10)
        x.io.alu_out.expect(4.U)

    }
  }
}