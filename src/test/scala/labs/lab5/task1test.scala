package labs.lab5
import chisel3._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import org.scalatest._
class task1test extends FreeSpec with ChiselScalatestTester {
  "Task1 Adder" in {
    test(new task1(4)){
        x=>
        x.io.in0.poke(1.U)
        x.io.in1.poke(0.U)

        x.clock.step(10)
        x.io.sum.expect(1.U)

    }
  }
}