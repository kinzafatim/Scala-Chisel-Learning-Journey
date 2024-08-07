package labs.lab2
import chisel3._
import chiseltest._
import org.scalatest._
class Task1test extends FreeSpec with ChiselScalatestTester{
    "task1" in {
        test(new Task1){
            x=>
            x.io.s0.poke(1.B)
            x.io.s1.poke(1.B)
            x.io.s2.poke(1.B)
            x.clock.step(4)
            x.io.out.expect(32.U)
        }
    }
}