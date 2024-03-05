package labs
import chisel3._
import chiseltest._
import org.scalatest._
class ex2test extends FreeSpec with ChiselScalatestTester{
    "counteree" in {
        test(new ex2){
        x=>
        x.clock.step(10)
        }
    }
}