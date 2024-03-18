package labs.lab3
import chisel3._ 
class encoderIO extends Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(2.W))
}
class ex1 extends Module {
    val io = IO(new encoderIO)
    io.out := 0. U
    switch(io.in){
        is ("b0001".U){ // 1
            io.out := 0.U // b00
        }
        is ("b0010".U){ // 2
            io.out := 1.U // b01
        }
        is ("b0100".U){ // 3
            io.out := 2.U // b10
        }
        is ("b1000".U){ // 4
            io.out := 3.U // b11
            
        }
    }

}