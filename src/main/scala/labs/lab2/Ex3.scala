package labs.lab2
import chisel3 . _
import chisel3 . util . _
class Ex3 extends Module {
    val io = IO(new Bundle {
        val out0 = Output(UInt(1.W))
        val out1 = Output(UInt(1.W))
  })
  val in0 = 0.U
  val in1 = 1.U
  val in2 = 0.U
  val in3 = 0.U
  // Create one-hot encoded selector
  val sel = Cat(in3, in2, in1, in0)
  io.out0 := Mux1H(sel, Seq(in0, in1))
  io.out1 := Mux1H(sel, Seq(in2, in3))
}
