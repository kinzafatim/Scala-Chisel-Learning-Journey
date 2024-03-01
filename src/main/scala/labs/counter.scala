package labs
import chisel3._ 
class counter(counterBits: UInt) extends Module{
    val io=IO(new Bundle{
        val result= Output(UInt(16.W))
    })
    val max=(1.U << counterBits)- 1.U
    val count= RegInit(0.U(16.W))
    when(count===max){
        count:=0.U
    }.otherwise{
        count:= count+1.U
        printf("%x\n", io.result)
    }
    io.result:=count
}