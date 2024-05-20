package labs.lab6
import chisel3._
import chiseltest._
import org.scalatest._
class ex1test extends FreeSpec with ChiselScalatestTester{
    "ex1 shift register" in {
        test(new ex1){
        x=>
        x.io.in.poke("b1010".U)
        x.io.parallel.poke(1.B)
        x.clock.step(100)
        x.io.out.expect("b1010".U)
        }//It shifts the current state state to the left by one bit (state << 1.U)
    } 
}