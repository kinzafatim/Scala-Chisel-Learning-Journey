package labs.lab3
import chisel3._
import chiseltest._
import org.scalatest._
class task1test extends FreeSpec with ChiselScalatestTester{
    "Immediate Generator" in{
        test(new task2){
            x=>
            x.io.instr.poke("b0010011".U) 
           // x.io.opcode.poke(5.U) 

            x.clock.step(4)

            x.io.immd_se.expect("b00000000000000000000_1111111111".B)
        }
    }
}