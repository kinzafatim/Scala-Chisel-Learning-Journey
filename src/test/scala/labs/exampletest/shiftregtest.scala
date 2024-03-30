package labs
import chisel3._
import chiseltest._
import org.scalatest._
class shiftregtest extends FreeSpec with ChiselScalatestTester{
    "shift register" in {
        test(new shiftreg){
        x=>
        x.io.in.poke(1.B)
        x.clock.step(10)
        x.io.out.expect(15.U)
        }
    }
}