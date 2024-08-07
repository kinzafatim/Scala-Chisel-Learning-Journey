package labs
import chisel3._
import chisel3.util._

class ex2 extends Module {
  val io = IO(new Bundle {
    //val result = Output(UInt(1.W))
  })
  val countReg = RegInit(0.U(4.W)) // count register 

  val MSB = countReg(3) // msb from count 3rd bit
 // io.result := MSB 
  when(countReg(3) === 1.U)  // if msb is = to 1 reset counter
  {
    countReg := 0.U //reset
  }.otherwise {
    countReg := countReg + 1.U
    printf("%x\n", countReg)
  }
}
