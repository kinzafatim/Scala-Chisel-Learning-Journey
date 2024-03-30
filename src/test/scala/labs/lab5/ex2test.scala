package labs.lab5
import chisel3._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import org.scalatest._
class ex2test extends FreeSpec with ChiselScalatestTester {
  "Ex2" in {
    test(new ex2(UInt(4.W))){
      x=>
      x.io.in1.poke(1.U)
      x.io.in2.poke(0.U)
      x.io.sel.poke(1.B)
      x.clock.step(10)
      x.io.out.expect(0.U)
    }
  }
}
