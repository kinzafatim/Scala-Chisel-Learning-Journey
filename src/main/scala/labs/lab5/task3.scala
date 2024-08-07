package labs.lab5
import chisel3._
import chisel3.util. _
class task3[T <: Data](gen: T) extends Module {
  val io = IO(new Bundle {
    val sel = Input(Bool())
    val inA = Input(gen)
    val inB = Input(gen)
    val out = Output(gen)
  })
  val inAU = io.inA.asUInt
  val inBU = io.inB.asUInt
  val outU = Mux(io.sel, inBU, inAU)
  io.out := outU.asTypeOf(gen) //Typecasting output back to original type

}
