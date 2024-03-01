package labs
import chisel3._ 
class counter1(counterBits: SInt) extends Module{
    val io=IO(new Bundle{
        val result= Output(SInt(16.W))
    })
    val max=(1.S << counterBits.asUInt)- 1.S
    val count= RegInit(0.S(16.W))
    when(count===max){
        count:=0.S
    }.otherwise{
        count:= count+1.S
        printf("%x\n", io.result)
    }
    io.result:=count
}