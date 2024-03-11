package labs
import chisel3._
import chiseltest._
import org.scalatest._
class ex3test extends FreeSpec with ChiselScalatestTester{
    "counter2" in {
        test(new ex3(5, 9)){
        x=>
        x.clock.step(10)
        }
    }
}