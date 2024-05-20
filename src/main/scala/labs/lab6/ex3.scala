package labs.lab6
import chisel3._ 
import chisel3.util._

class ex3 extends Module {
  val io = IO(new Bundle {
    val reload = Input(Bool())
    val din = Input(UInt(4.W))
    val out = Output(Bool())
    val doneIn = Input(Bool())
  })
  val timer_count = RegInit(0.U(8.W))
  val done = timer_count === 0.U // wire is true (1) when timer_count = 0
  val next = WireInit(0.U)

  when(io.reload) {
    next := io.din // load the data from input
  }.elsewhen(!io.doneIn) {
    next := timer_count - 1.U // decrement the timer
  }

  timer_count := next  // update the timer
  io.out := done // Output indicating timer is done
}
