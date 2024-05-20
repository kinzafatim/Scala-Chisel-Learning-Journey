package labs.lab6
import chisel3._
import chisel3.util._
class task3 ( val len : Int =1) extends Module {
val io = IO(new Bundle{
    val out = Vec(len , Output(Bool()))
    val load_in = Vec(len , Input(Bool()))
    val in = Input(Bool())
    val load = Input(Bool())
})
val reg1 = RegInit(0.B)
val reg2 = RegInit(0.B)
val reg3 = RegInit(0.B)
val mux1=Mux(io.load,io.in, io.load_in(0))
reg1 := mux1

val mux2=Mux(io.load,reg1, io.load_in(1))
reg2 := mux2

val mux3=Mux(io.load,reg2, io.load_in(2))
reg3:=mux3
 io.out(0):=reg1
 io.out(1):=reg2
 io.out(2):=reg3

}