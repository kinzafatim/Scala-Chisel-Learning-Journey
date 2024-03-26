package labs.lab3
import chisel3._
import chisel3.util._
class LM_IO_Interface_decoder_with_valid extends Bundle {
    val in = Input(UInt(2.W))
    val out = Valid(Output(UInt(4.W)))
}
class task3 extends Module {
    val io = IO(new LM_IO_Interface_decoder_with_valid)
    when (io.in === "b00".U) { //input=0
        io.out := "b0001".U
    } .elsewhen(io.in === "b01".U) { //input=1
        io.out := "b0010".U
    } .elsewhen(io.in === "b10".U) { // input=2
        io.out := "b0100".U
    } .otherwise {
        io.out := "b1000".U //input=3
        }
}