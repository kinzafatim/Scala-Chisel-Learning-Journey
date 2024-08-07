package labs.lab8
import chisel3._
import chisel3.util._
class ex2 extends Module {
  val width: Int = 8
  val io = IO(new Bundle {
    val enable = Input(Bool())
    val write = Input(Bool())
    val addr = Input(UInt(10.W))
    val mask = Input(Vec(4, Bool()))
    val dataIn = Input(Vec(4, UInt(width.W)))
    val dataOut = Output(Vec(4, UInt(width.W)))
  })
  val bank0 = SyncReadMem(512, Vec(4, UInt(width.W))) // Create two 16-byte memory banks
  val bank1 = SyncReadMem(512, Vec(4, UInt(width.W)))

  // Forwarding logic based on lsb of address
  val bankSelect = io.addr(0) // which bank to use (0 for bank0, 1 for bank1).
  val bankAddr = io.addr >> 1 // Shift address right by 1 to remove LSB
  // Read operation with forwarding
  val readDataBank0 = bank0.read(bankAddr, io.enable && !bankSelect)
  val readDataBank1 = bank1.read(bankAddr, io.enable && bankSelect)

  val defaultDataOut = VecInit(Seq.fill(4)(0.U(width.W)))   // Default output to zero

  // Mux to select the read data based on bankSelect
  io.dataOut := Mux(io.enable, Mux(bankSelect, readDataBank1, readDataBank0), defaultDataOut)

  // Write operation with mask
  when (io.write) {
    when (bankSelect) {
      bank1.write(bankAddr, io.dataIn, io.mask)
    } otherwise {
      bank0.write(bankAddr, io.dataIn, io.mask)
    }
  }
}

// Memory Banking is a technique used in memory 
// design to divide the memory into multiple banks that can be accessed independently