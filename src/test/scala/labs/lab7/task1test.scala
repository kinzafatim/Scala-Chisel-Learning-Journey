package labs.lab7
import chisel3._
import chiseltest._
import org.scalatest._
class task1test extends FreeSpec with ChiselScalatestTester{
    "lab7 task1 " in {
        test(new task1){
        x=>
        x.io.f1.poke(1.B)
        x.io.f2.poke(1.B)
        x.io.r1.poke(0.B)
        x.io.r2.poke(0.B)
        x.clock.step(100)
        x.io.out.expect(3.U)
        }
    }
}