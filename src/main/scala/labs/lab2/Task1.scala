package labs.lab2
import chisel3._
import chisel3.util._
class LM_IO_Interface extends Bundle{
    val s0= Input(Bool())
    val s1= Input(Bool())
    val s2= Input(Bool())
    val out=Output(UInt(32.W))
}
class Task1 extends Module{
    val io= IO(new LM_IO_Interface)
    val sel= Cat(io.s2, io.s1,io.s0)
    io.out:= MuxLookup(sel, false.B, Array(
        (0.U) -> 0.U,
        (1.U) -> 8.U,
        (2.U) -> 16.U,
        (3.U) -> 24.U,
        (4.U) -> 32.U,
        (5.U) -> 32.U,
        (6.U) -> 32.U,
        (7.U) -> 32.U
    ))
}