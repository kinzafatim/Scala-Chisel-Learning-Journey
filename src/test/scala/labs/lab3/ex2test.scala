package labs.lab3
import chisel3._
import chiseltest._
import org.scalatest._
class ex2test extends FreeSpec with ChiselScalatestTester{
    "ALU SWITCH" in{
        test(new ex2){
            x=>
            x.io.in_A.poke(5.U)
            x.io.in_B.poke(3.U)
            x.io.alu_Op.poke("b0000".U)
            x.clock.step(4)
            x.io.out.expect(8.U)
            x.io.sum.expect(8.U)
        }
    }
}