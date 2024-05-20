package labs.lab6
import chisel3._
import chiseltest._
import org.scalatest._
class ex2test extends FreeSpec with ChiselScalatestTester{
    "ex2 " in {
        test(new ex2(5)){
        x=>
        x.clock.step(100)
        x.io.out.expect("b0100".U)
        }
    }
}