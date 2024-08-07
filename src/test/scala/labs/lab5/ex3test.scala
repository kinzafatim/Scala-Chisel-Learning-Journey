package labs.lab5
import chisel3._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import org.scalatest._
class ex3test extends FreeSpec with ChiselScalatestTester {
  "ex3" in {
    test(new Operator(2,UInt(16.W))( _ & _ )){
        x=>
        x.io.in(0).poke(1.U)
        x.io.in(1).poke(0.U)
        x.clock.step(10)

        x.io.out(0).expect(0.U)
        x.io.out(1).expect(0.U)
    }
  }
}