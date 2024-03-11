package labs
import chisel3._ 

class mux_2to1_IO extends Bundle{
    val A=Input(Bool())
    val B= Input(Bool())
    val S= Input(Bool())
    val Out=Output(Bool())
}
class muxx extends Module{
    val io= IO(new mux_2to1_IO)
    io.Out:= Mux(io.S, io.A, io.B)
}