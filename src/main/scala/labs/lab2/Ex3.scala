package labs
import chisel3._
import chisel3.util._
class Ex3 extends Module {
    val io = IO(new Bundle {

    val in0 = Input(UInt(1.W))
    val in1 = Input(UInt(1.W))
    val in2 = Input(UInt(1.W))
    val in3 = Input(UInt(1.W))
    val sel = Input(UInt(2.W))
    val out1 = Output(UInt(1.W))
    val out2 = Output(UInt(1.W))
})
io.out1 := Mux1H(io.sel, Seq(io.in0, io.in1))
io.out2 := Mux1H(io.sel, Seq(io.in2, io.in3))
}