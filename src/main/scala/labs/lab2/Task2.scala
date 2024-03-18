package labs.lab2
import chisel3._
import chisel3.util._
class Task2 extends Module{
    val io= IO(new Bundle{
        val in = Vec(4,Input(Bool()))
        val sel = Vec(2,Input(Bool()))
        val shifttype = Input(Bool())
        val out = Vec(4,Output(Bool()))
})
val select= Cat(io.sel(1), io.sel(0))
io.out(0) :=MuxLookup(select, false.B,Array(
    (0.U) -> io.in(0),
    (1.U) -> io.in(1),
    (2.U) -> io.in(2),
    (3.U) -> io.in(3)
))
io.out(1) :=MuxLookup(select, false.B,Array(
    (0.U) -> io.in(1),
    (1.U) -> io.in(2),
    (2.U) -> io.in(3), 
    (3.U) -> MuxLookup(io.shifttype, false.B,Array(
        (0.U) -> 0.U,
        (1.U) -> io.in(0)
    ))
))
io.out(2) :=MuxLookup(select, false.B,Array(
    (0.U) -> io.in(2),
    (1.U) -> io.in(3), 
    (2.U) -> MuxLookup(io.shifttype, false.B,Array(
        (0.U) -> 0.U,
        (1.U) -> io.in(0)
    )), 
    (3.U) -> MuxLookup(io.shifttype, false.B,Array(
        (0.U) -> 0.U,
        (1.U) -> io.in(1)
    ))

))
io.out(3) :=MuxLookup(select, false.B,Array(
    (0.U) -> io.in(3), 
    (1.U) -> MuxLookup(io.shifttype, false.B,Array(
        (0.U) -> 0.U,
        (1.U) -> io.in(0)
    )),
    (2.U) -> MuxLookup(io.shifttype, false.B,Array(
        (0.U) -> 0.U,
        (1.U) -> io.in(1)
    )),
    (3.U) -> MuxLookup(io.shifttype, false.B,Array(
        (0.U) -> 0.U,
        (1.U) -> io.in(2)
    ))
))
}