package labs.lab6
import chisel3._
import chiseltest._
import org.scalatest._
class ex1test extends FreeSpec with ChiselScalatestTester{
    "ex1 shift register" in {
        test(new ex1){
        x=>
        x.io.in.poke("b0001".U)
        x.clock.step()
        x.io.out.expect("b0011".U)
        }
    } 
}