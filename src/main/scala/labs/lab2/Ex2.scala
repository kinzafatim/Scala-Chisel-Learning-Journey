package labs.lab2
import chisel3._
import chisel3.util._
class Ex2 extends Module {
val io = IO(new Bundle {
val in0 = Input(Bool())
val in1 = Input(Bool())
val in2 = Input(Bool())
val in3 = Input(Bool())
val in4 = Input(Bool())
val in5 = Input(Bool())
val in6 = Input(Bool())
val in7 = Input(Bool())
val s0 = Input(Bool())
val s1 = Input(Bool())
val s2 = Input(Bool())
val out = Output(Bool())
})

val mux0=MuxLookup(io.s1, false.B,Array(
(0.U) -> MuxLookup(io.s0, false.B, Array(
    (0.U)-> io.in0,
    (1.U) -> io.in1
)),
(1.U) -> MuxLookup(io.s0, false.B, Array(
    (0.U) -> io.in2,
    (1.U) -> io.in3
))
))
val mux1=MuxLookup(io.s1, false.B,Array(
    (0.U) -> MuxLookup(io.s0,false.B, Array(
        (0.U) -> io.in4,
        (1.U) -> io.in5
    )),
    (1.U) -> MuxLookup(io.s0,false.B, Array(
        (0.U) -> io.in6,
        (1.U) -> io.in7

    ) )

))
io.out:=MuxLookup(io.s2,false.B,Array( 
    (0.U) -> mux0,
    (1.U) -> mux1
    ))


}