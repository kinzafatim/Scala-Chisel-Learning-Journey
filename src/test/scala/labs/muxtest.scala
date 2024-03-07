package labs
import chisel3._
import chiseltest._
import org.scalatest._
class muxtest extends FreeSpec with ChiselScalatestTester{
    "mux" in {
        test(new mux){
        x=>
        x.io.A.poke(0.B)
        x.io.B.poke(1.B)
        x.io.S.poke(1.B)
        x.clock.step(10)
        x.io.Out.expect(0.B)
        }
    }
}