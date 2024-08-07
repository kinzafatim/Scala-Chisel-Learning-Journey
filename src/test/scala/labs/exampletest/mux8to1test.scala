package labs
import chisel3._
import chiseltest._
import org.scalatest._
class mux8to1test extends FreeSpec with ChiselScalatestTester{
    "8to1 mux" in {
        test(new mux8to1){
        x=>
        x.io.in.poke(8.U)
        x.io.S0.poke(1.B)
        x.io.S1.poke(1.B)
        x.io.S2.poke(1.B)
        x.clock.step(10)
        x.io.Out.expect(0.B)
        }
    }
}