package labs.lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class task4test extends FreeSpec with ChiselScalatestTester {
  "lab6 task4 " in {
    test(new task4(10)){
        x=>
        x.io.up_down.poke(1.B)
        x.clock.step(100)
        x.io.out.expect(4.U)
        }
  }
}