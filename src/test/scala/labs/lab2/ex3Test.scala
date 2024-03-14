package labs
import chisel3._
import chiseltest._
import org.scalatest._
class ex3Test extends FreeSpec with ChiselScalatestTester{
    "Mux-one-hot" in{
        test(new Ex3){
        x=>
        x.io.in0.poke(10.U)
        x.io.in1.poke(20.U)
        x.io.in2.poke(30.U)
        x.io.in3.poke(40.U)
        x.io.sel.poke(3.U)
        x.clock.step(1)
        x.io.out.expect(30.U)
        }
    }

}