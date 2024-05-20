package labs.lab6
import chisel3._
import chisel3.util._
class task2(val max: Int = 8) extends Module {
    val io = IO(new Bundle {
        val out = Output(UInt(log2Ceil(max).W))
  })
  val counter = RegInit(0.U(log2Ceil(max).W))
  val msb = counter(log2Ceil(max) - 1)
  when(msb === 1.U) {
    counter := 0.U
  } .otherwise {
    counter := counter + 1.U
  }
  io.out := counter
}



