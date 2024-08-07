package labs
import chisel3._
import chiseltest._
import org.scalatest._
class countertest extends FreeSpec with ChiselScalatestTester{
    "counter" in {
        test(new counter(2.U)){
        x=>
        //x.io.counterBits.poke(1.U)
        x.clock.step(5)
        }
    }
}