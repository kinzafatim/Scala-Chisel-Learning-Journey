package labs
import chisel3._
import chiseltest._
import org.scalatest._
class lab1ex1test extends FreeSpec with ChiselScalatestTester{
    "counter1" in {
        test(new counter1(2.S)){
        x=>
        
        x.clock.step(5)
        }
    }
}