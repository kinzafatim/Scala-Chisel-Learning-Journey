package labs.lab2
import chisel3._
import chiseltest._
import org.scalatest._
class ex2Test extends FreeSpec with ChiselScalatestTester{
    "muxlookup" in {
        test(new Ex2){
            x=>
            x.io.in0.poke(0.B)
            x.io.in1.poke(0.B)
        x.io.in2.poke(0.B)
        x.io.in3.poke(0.B)
        x.io.in4.poke(0.B)
        x.io.in5.poke(0.B)
        x.io.in6.poke(0.B)
        x.io.in7.poke(1.B)
        x.io.s0.poke(1.B)
        x.io.s1.poke(1.B)
        x.io.s2.poke(1.B)
        x.clock.step(10)
        x.io.out.expect(1.B)
        }
    }
}