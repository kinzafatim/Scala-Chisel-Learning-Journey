package labs.lab5
import chisel3._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import org.scalatest._
class task2test extends FreeSpec with ChiselScalatestTester {
  "Task2" in {
    test(new Router(UInt(4.W))){
        x=>
        x.io.in.data_field.poke(2.U)

        x.clock.step(10)
        x.io.out.data_field.expect(2.U)

    }
  }
}