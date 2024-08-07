package labs.lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class ex3test extends FreeSpec with ChiselScalatestTester {
  "lab6 Ex3 " in {
    test(new ex3){a =>
        a.io.reload.poke(1.B)
        a.io.din.poke("b0001".U)
        a.io.doneIn.poke(1.B)
        a.clock.step(100)
        a.io.out.expect(0.B)
    } 
  }
}