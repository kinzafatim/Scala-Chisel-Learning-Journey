package labs.lab8
import chisel3._
import chiseltest._
import org.scalatest._
class ex1test extends FreeSpec with ChiselScalatestTester{
    "lab8 ex1 " in {
        test(new ex1){
            x=>
            x.io.enable.poke(1.B)
            x.io.write.poke(1.B)
            x.io.addr.poke(10.U)
            x.io.mask(0).poke(0.B)
            x.io.mask(1).poke(0.B)
            x.io.mask(2).poke(0.B)
            x.io.mask(3).poke(0.B)
            x.io.dataIn(0).poke(8.U)
            x.io.dataIn(1).poke(8.U)
            x.io.dataIn(2).poke(8.U)
            x.io.dataIn(3).poke(8.U)
            x.clock.step(100)
            x.io.dataOut(0).expect(3.U)
            x.io.dataOut(1).expect(3.U)
            x.io.dataOut(2).expect(3.U)
            x.io.dataOut(3).expect(3.U)
            }
    }
}