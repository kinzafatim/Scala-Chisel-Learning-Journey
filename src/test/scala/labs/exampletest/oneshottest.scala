package labs
import chisel3._
import chiseltest._
import org.scalatest._
class oneshottest extends FreeSpec with ChiselScalatestTester{
    "one shot timer" in {
        test(new oneshot){
        x=>
        x.io.reload.poke(0.B)
        x.io.din.poke(9.U)
        x.clock.step(10)
        x.io.out.expect(0.U)
        }
    }
}