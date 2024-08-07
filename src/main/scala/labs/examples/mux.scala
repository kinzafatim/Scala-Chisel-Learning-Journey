package labs
import chisel3._ 

class mux_io extends Bundle{
    val A=Input(Bool())
    val B= Input(Bool())
    val S= Input(Bool())
    val Out=Output(Bool())
}
class mux extends Module{
    val io= IO(new mux_io)
    io.Out:= io.A & io.S | io.B &(!io.S)

}