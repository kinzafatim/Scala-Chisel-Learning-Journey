package labs.lab8
import chisel3._
import chiseltest._
import org.scalatest._
class task1test extends FreeSpec with ChiselScalatestTester{
    "lab8 task1 " in {
        test(new task1){
            x=>
            x.io.requestor(0).valid.poke(true.B) //valid signal is set by the producer
            x.io.requestor(0).bits.poke(8.U) // Assuming you want to write the value 8
    
            x.io.requestor(1).valid.poke(false.B)
            x.io.requestor(1).bits.poke(0.U)
    
            x.io.requestor(2).valid.poke(false.B)
            x.io.requestor(2).bits.poke(0.U)
    
            x.io.requestor(3).valid.poke(false.B)
            x.io.requestor(3).bits.poke(0.U)
            x.io.Readaddr.poke(12.U)

            x.io.Writeaddr.poke(1.U)

            x.clock.step(100)
        }
    }
}