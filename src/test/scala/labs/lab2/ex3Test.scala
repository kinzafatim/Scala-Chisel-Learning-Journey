package labs.lab2
import chisel3._
import chiseltest._
import org.scalatest._
class ex3Test extends FreeSpec with ChiselScalatestTester{
    "Mux-one-hot" in{
        test(new Ex3){
        x=>
        // x.io.in0.poke(1.U) 
        // x.io.in1.poke(0.U)
        // x.io.in2.poke(0.U)
        // x.io.in3.poke(0.U)
        // x.io.sel.poke(3.U)
        x.clock.step(10)
        x.io.out0.expect(1.U)
        x.io.out1.expect(0.U)
        // x.io.out2.expect(0.U)
        }
    }
}