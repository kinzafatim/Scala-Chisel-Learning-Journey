package labs
import chisel3._ 
class shiftreg(val init :Int = 1) extends Module {
    val io = IO(new Bundle{
        val in = Input(Bool())
        val out = Output(UInt(4.W))
        })
        val state = RegInit(init.U(4.W)) // register initialization
        val nextState = ((state << 1.U) | io.in)
        state := nextState
        io.out := state
}