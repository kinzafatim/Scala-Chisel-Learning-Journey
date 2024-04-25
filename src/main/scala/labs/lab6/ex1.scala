package labs.lab6
import chisel3._ 
class ex1(val init :Int = 1) extends Module {
    val io = IO(new Bundle{
        val in = Input(UInt(4.W))
        val out = Output(UInt(4.W))
        val loadParallel = Input(Bool()) // 1 for parallel load, 0 for normal
        val parallelData = Input(UInt(4.W)) // Data to be loaded in parallel
        })
        val state = RegInit(init.U(4.W)) // register initialization
        val nextState = Mux(io.loadParallel, io.parallelData,((state << 1.U) | io.in))
        state := nextState
        io.out := state
}