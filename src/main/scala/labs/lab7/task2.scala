package labs.lab7
import chisel3._
import chisel3.util._
//import chisel3.iotesters.{ChiselFlatSpec, Driver , PeekPokeTester}
import chisel3.experimental.ChiselEnum
import chisel3.experimental.{withClock , withReset , withClockAndReset}
import chisel3.experimental.BundleLiterals._

object Manchester_Encoding {
    object State extends ChiselEnum {
        val Idle, Sync, Decode = Value
        }
}
class Manchester_Encoding extends Module {
    import Manchester_Encoding.State
    import Manchester_Encoding.State._
    val io = IO(new Bundle {
        val in = Input(UInt(1.W))
        val start = Input(Bool())
        val out = Output(UInt(8.W))
        val flag = Output(UInt(1.W))
        })
        val state = RegInit(Idle)
        val outReg = RegInit(0.U(8.W))// output register to hold last 8 bits of decoded data
         //temporary register to help with decoding process
        val tempReg = RegInit(0.U(1.W))
        val bitCounter = RegInit(0.U(3.W)) //count to 7 (3 bits)
        //Define a flag register
        val flagReg = RegInit(0.U(1.W))
        
        io.out := outReg
        io.flag := flagReg
        switch(state) {
            is(Idle) {
                when(io.start) {
                    state := Sync}
            }
            is(Sync) {
                when(io.in === 1.U) {
                    state := Decode
                    }
            }
            is(Decode) {
                // Decode the Manchester encoded stream
                when(io.in =/= tempReg) { // Detect transition if in is not equal to temreg
                    tempReg := io.in
                    when(io.in === 1.U) {
                        // Transition from low to high -> '1'
                            outReg := Cat(outReg(6, 0), 1.U)
                            }.otherwise {
                                // Transition from high to low -> '0'
                                outReg := Cat(outReg(6, 0), 0.U)
                                }
                    bitCounter := bitCounter + 1.U
                    when(bitCounter === 7.U) {
                        state := Idle
                        flagReg := 1.U // Set flag to indicate 8 bits received
                        }
      }
}
}
}