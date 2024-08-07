package labs.lab2
import chisel3._
import chiseltest._
import org.scalatest._
class Task2Test extends FreeSpec with ChiselScalatestTester{
    "Barrel shifter" in {
        test (new Task2){
            x=>
            x.io.in(0).poke(1.B)
            x.io.in(1).poke(1.B)
            x.io.in(2).poke(1.B)
            x.io.in(3).poke(0.B)
            x.io.sel(0).poke(1.B)
            x.io.sel(1).poke(1.B)
            x.io.shifttype.poke(1.B)
            x.clock.step(4)
            x.io.out(0).expect(0.B)
            x.io.out(1).expect(1.B)
            x.io.out(2).expect(1.B)
            x.io.out(3).expect(1.B)
    }
    }
}