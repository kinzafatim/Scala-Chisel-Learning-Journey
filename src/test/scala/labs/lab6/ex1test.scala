package labs.lab6
import chisel3._
import chiseltest._
import org.scalatest._
class ex1test extends FreeSpec with ChiselScalatestTester{
    "ex1 shift register" in {
        test(new ex1){
        x=>
        x.io.in.poke("b0001".U)
        x.io.loadParallel.poke(0.B) //1 for parallel load, 0 for normal
        x.io.parallelData.poke("b0001".U)
        x.io.in.poke("b0001".U)
        x.clock.step()
        x.io.out.expect("b0011".U)
        }//It shifts the current state state to the left by one bit (state << 1.U)
    } 
}