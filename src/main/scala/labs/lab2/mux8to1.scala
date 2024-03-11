package labs
import chisel3._ 

class inputt extends Bundle{
    val in= Input(UInt(8.W))
    val S0= Input(Bool())
    val S1= Input(Bool())
    val S2= Input(Bool())
    val Out=Output(Bool())
}
class mux8to1 extends Module{
    val io= IO(new inputt)
    val mux4to1_a = Mux(io.S1,Mux(io.S0,io.in(3),io.in(2)), Mux(io.S0,io.in(1),io.in(0)))
    val mux4to1_b = Mux(io.S1,Mux(io.S0,io.in(7) ,io.in(6)), Mux(io.S0,io.in(5), io.in(4)))
    
    val mux2to1=Mux(io.S2,mux4to1_b,mux4to1_a)
    io.Out:=mux2to1
    }