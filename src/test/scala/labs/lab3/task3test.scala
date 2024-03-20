package labs.lab3
import chisel3._
import chiseltest._
import org.scalatest._
class task3test extends FreeSpec with ChiselScalatestTester{
    "Valid Interface" in{
        test(new task3){
            x=>
            x.io.instr.poke("b0010011".U) 
           // x.io.opcode.poke(5.U) 
            x.clock.step(4)

            x.io.out_ins.expect("b00000000000000000000_1111111111".U)
        }
    }
}