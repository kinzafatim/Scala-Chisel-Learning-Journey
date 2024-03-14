package labs
import chisel3._
import chiseltest._
import org.scalatest._
class ptest extends FreeSpec with ChiselScalatestTester{
    "priority" in {
        test(new prioritymux){
        x=>
        x.io.in.poke(4.U)
        x.io.S0.poke(1.B)
        x.io.S1.poke(1.B)
        x.io.S2.poke(1.B)
        x.clock.step(10)
        x.io.Out.expect(0.B)
        }
    }
}