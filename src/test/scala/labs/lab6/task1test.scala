package labs.lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
class task1test extends FreeSpec with ChiselScalatestTester {
  "lab6 task1 " in {
    test(new task1(13)){
        x=>
        x.clock.step(100)
        x.io.out.expect("b0010".U)
        }
  }
}