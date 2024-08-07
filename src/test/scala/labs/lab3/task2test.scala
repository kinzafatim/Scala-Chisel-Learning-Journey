package labs.lab3
import chisel3._
import chiseltest._
import org.scalatest._
class task2test extends FreeSpec with ChiselScalatestTester{
    "Immediate Generator" in{
        test(new task2){
            x=>
            x.io.instr.poke("h00418113".U)
            x.io.opcode.poke("b0010011".U) // I-type
            x.clock.step(4)

            x.io.out_ins.expect("h4".U)
        }
    }
}