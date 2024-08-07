package labs.lab2
import chisel3._
import chiseltest._
import org.scalatest._
class ex1test extends FreeSpec with ChiselScalatestTester{
    "ex1" in {
        test(new ex1){
        x=>
        x.io.A.poke(0.B)
        x.io.B.poke(1.B)
        x.io.S.poke(1.B)
        x.clock.step(10)
        x.io.Out.expect(0.B)
        }
    }
}