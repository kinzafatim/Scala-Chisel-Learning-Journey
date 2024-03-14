package labs
import chisel3._
import chiseltest._
import org.scalatest._
class ex3Test extends FreeSpec with ChiselScalatestTester{
    "Mux-one-hot" in{
        test(new Ex3){
        x=>
        x.io.in0.poke(1.U)
        x.io.in1.poke(2.U)
        x.io.in2.poke(3.U)
        x.io.in3.poke(4.U)
        x.io.sel.poke(2.U)
        x.clock.step(1)
        x.io.out1.expect(0.U)
        x.io.out2.expect(1.U)
        }
    }

}