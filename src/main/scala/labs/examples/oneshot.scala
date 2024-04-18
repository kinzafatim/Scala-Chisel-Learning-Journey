package labs
import chisel3._
class oneshotbundle extends Bundle {
  val reload = Input(Bool())
  val din = Input(UInt(8.W))
  val out = Output(UInt(8.W))
}
class oneshot extends Module {
  val io = IO(new oneshotbundle)
  val timer_count = RegInit(0.U(8.W))
  val done = timer_count === 0.U
  val next = WireInit(0.U)

  when(io.reload) {
    next := io.din
  }.elsewhen(!done) { 
    next := timer_count - 1.U
  }

  timer_count := next
  io.out := timer_count
}
