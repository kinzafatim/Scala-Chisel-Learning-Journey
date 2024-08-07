package labs.lab3
import chisel3._
import chiseltest._
import org.scalatest._
class ex1test extends FreeSpec with ChiselScalatestTester {
  "ex1" in {
    test(new ex1) { x =>
      x.io.in.poke("b1000".U)
      x.clock.step(1) // Step the clock
      x.io.out.expect("b11".U)
    }
  }
}
