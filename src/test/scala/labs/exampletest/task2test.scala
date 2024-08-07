package labs
import chisel3._
import chiseltest._
import org.scalatest._
class task2test extends FreeSpec with ChiselScalatestTester{
    "up down counter" in {
        test(new task2(7)){
        x=>
        x.io.data_in.poke(1.U)
        x.io.reload.poke(1.B)
        x.clock.step(15)
        }
    }
}