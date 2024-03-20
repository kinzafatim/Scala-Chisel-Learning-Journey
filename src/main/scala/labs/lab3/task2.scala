package labs.lab3
import chisel3._
import chisel3.util._
class IO_ImmdValGen extends Bundle {
    val instr = Input(UInt(32.W))
    //val opcode= Input(UInt(7.W))
    val out_ins = Output(UInt(32.W))
}
class task2 extends Module {
    val io = IO ( new IO_ImmdValGen)
    val wiree = Wire(UInt(32.W))
    wiree:= Cat(Fill(20, io.instr(31)), io.instr(31, 20))
    io.out_ins := wiree
    // immd_se:=O.u
    // switch(io.instr){
    //     is("b0010011"){ // I
    //         immd_se:= Cat(Fill(20, io.instr(31)), io.instr(31, 20))
            
    //     }
    //     // is("b0100011"){ //S
    //     //     immd_se:= Cat(Fill(20,io.instr(31)),io.instr(31,25),io.instr(11,8))
            

        // }
        // is("b1100011"){ // B
        //     immd_se:= Cat(Fill()io.instr())

        // }
        // is("b"){ // 0010111 (for LUI), 0110111 (for AUIPC)
        //     immd_se:= Cat(Fill()io.instr(31,12))
            
        // }
        // is("b1101111"){ // J
        //     immd_se:= Cat(Fill())
            
        // }
}