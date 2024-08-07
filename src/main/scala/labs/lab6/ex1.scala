package labs.lab6
import chisel3._ 
class ex1(val init :Int = 1) extends Module {
    val io = IO(new Bundle{
        val in = Input(UInt(4.W))
        val parallel=Input(Bool())
        val out = Output(UInt(4.W))
        })
        val state = RegInit ( init . U (4. W ) )
        val nextState = ((state << 1.U) | io.in)

        when(io.parallel){
            state:= io.in
        }
        .otherwise{
            state:= nextState
        }
        io.out := state
}