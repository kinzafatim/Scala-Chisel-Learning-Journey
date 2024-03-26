package labs.lab3
import chisel3._
import chisel3.util._
class ex1 extends Module {
    val io = IO(new Bundle{
        val in = Input(UInt(4.W))
        val out = Output(UInt(2.W))
  })
  io.out := 0.U // Default output
  switch(io.in) {
    is("b0001".U) { // 1
      io.out := "b00".U
    }
    is("b0010".U) { // 2
      io.out := "b01".U
    }
    is("b0100".U) { // 3
      io.out := "b10".U
    }
    is("b1000".U) { // 4
      io.out := "b11".U
    }
  }
}