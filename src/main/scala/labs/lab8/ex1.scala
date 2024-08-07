package labs.lab8
import chisel3 . _
class ex1 extends Module {
    val width : Int = 8
    val io = IO(new Bundle {
        val enable = Input(Bool()) // enable reading from the memory.
        val write = Input(Bool()) //control whether to write to the memory 
        val addr = Input(UInt(10.W)) //  A 10-bit address input to specify the memory location.
        val mask = Input(Vec(4, Bool())) // controlling whether the corresponding byte in the data should be written
        val dataIn = Input(Vec(4, UInt(width.W)))
        val dataOut = Output(Vec(4, UInt(width.W)))
        })
        val mem = SyncReadMem(1024, Vec(4, UInt(width.W)))
        when(io.enable) {
            io.dataOut := mem.read(io.addr)
            }
        when(io.write) {
            val currentData = mem.read(io.addr, io.write)
            val newData = Wire(Vec(4, UInt(width.W)))
            for (i <- 0 until 4) {
                newData(i) := Mux(io.mask(i), io.dataIn(i), currentData(i))
                }
    // Write back the masked data
            mem.write(io.addr, newData)
            }
}