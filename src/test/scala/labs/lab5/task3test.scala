package labs.lab5
import chisel3._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import org.scalatest._
class task3test extends FreeSpec with ChiselScalatestTester {
  "Task3" in {
    test(new task3(UInt(4.W))){
        x=>
        x.io.sel.poke(1.B)
        x.io.inA.poke(0.U)
        x.io.inB.poke(6.U)
        x.clock.step(10)

        x.io.out.expect(6.U)
    }
  }
}