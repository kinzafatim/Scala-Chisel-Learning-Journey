package labs.lab2
import chisel3._ 

class mmux extends Bundle{
    val A=Input(UInt(32.W))
    val B= Input(UInt(32.W))
    val S= Input(Bool())
    val Out=Output(UInt())
}
class ex1 extends Module{
    val io= IO(new mmux)
    io.Out:= io.A & io.S | io.B & (!io.S)
}