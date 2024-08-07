package labs
import chisel3.util._
import chisel3._
import java.io.File
class task2(n:Int) extends Module{
    val io=IO(new Bundle{
        val data_in=Input(UInt(n.W))
        val reload= Input(Bool())
        val out= Output(Bool())
    })
    val up_down_con= RegInit(0.B) // when 0 increment, 1
    val counter= RegInit(0.U(n.W))
    val max_count= RegInit(6.U(n.W))
    when(up_down_con===1.U){
        counter:=counter-1.U
        printf("%x\n", counter)
        io.out:=1.B
        when(counter===0.U){
            counter:=0.U
        }
    }.otherwise{
        counter:=counter+1.U
        printf("%x\n", counter)
        io.out:=0.B
        when(counter===max_count){
            up_down_con:=1.U
        }

    }

}