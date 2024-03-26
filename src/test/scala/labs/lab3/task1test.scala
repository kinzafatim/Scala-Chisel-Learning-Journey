package labs.lab3
import chisel3._
import chiseltest._
import org.scalatest._
class task1test extends FreeSpec with ChiselScalatestTester{
    "Branch" in{
        test(new task1){
            x=>
            x.io.fnct3.poke(0.U)
          //  x.io.branch.poke(1.B)
            x.io.arg_x.poke(2.U)
            x.io.arg_y.poke(5.U)
            x.clock.step(4)
            x.io.br_taken.expect(0.B)
        }
    }
}