package labs
import chisel3._ 

class pmux extends Bundle{
    val in= Input(UInt(4.W))
    val S0= Input(Bool())
    val S1= Input(Bool())
    val S2= Input(Bool())
    val Out=Output(Bool())
}
class prioritymux extends Module{
     val io= IO(new pmux)
    io.Out:= Mux(io.S2, io.in(3),Mux(io.S1, io.in(2), Mux(io.S0, io.in(1),io.in(0))))
}