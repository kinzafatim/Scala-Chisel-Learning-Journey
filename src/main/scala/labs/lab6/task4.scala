package labs.lab6
import chisel3._
import chisel3.util._
class task4(val max : Int = 10) extends Module {
    val io = IO ( new Bundle {
        val out = Output(UInt(log2Ceil(max).W))
        val up_down = Input(Bool())
})
val up_down_counter = RegInit(0.U(log2Ceil(max).W))
when(io.up_down===1.B){ //counter will count upward
   up_down_counter := up_down_counter + 1.U 
}
.otherwise{  //count down otherwise
    up_down_counter := up_down_counter - 1.U 
}
io.out:= up_down_counter
}