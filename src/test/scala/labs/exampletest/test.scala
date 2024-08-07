package labs
import chisel3._
import chiseltest._
import org.scalatest._
class test1 extends FreeSpec with ChiselScalatestTester{
    "and gate" in{
        test(new andgate()){
            a =>
            a.io.a.poke(1.U)
            a.io.b.poke(1.U)
            a.clock.step(1)
            a.io.c.expect(1.U)

        }
    }
}