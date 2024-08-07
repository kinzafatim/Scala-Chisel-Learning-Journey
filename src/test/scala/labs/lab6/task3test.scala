package labs.lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class task3test extends FreeSpec with ChiselScalatestTester {
  "lab6 task3 " in {
    test(new task3(3)){
        x=>
        x.io.load_in(0).poke(1.B)
        x.io.load_in(1).poke(1.B)
        x.io.load_in(2).poke(1.B)
        x.io.in.poke(0.B)
        x.io.load.poke(0.B)
        x.clock.step(100)
        x.io.out(0).expect(1.B)
        x.io.out(1).expect(1.B)
        x.io.out(2).expect(1.B)
        }
  }
}