package labs.lab8

import chisel3._
import chisel3.util._

class task1 extends Module {
    val io = IO(new Bundle {
        val requestor = Vec(4, Flipped(Decoupled(UInt(32.W)))) //consumer 
        val Readaddr = Input(UInt(5.W))
        val Writeaddr = Input(UInt(5.W))
        val memory_out = Vec(4, Output(UInt(32.W)))
    })

    val memory = SyncReadMem(1024, Vec(4, UInt(32.W)))

    val register0 = Reg(UInt(32.W))
    val register1 = Reg(UInt(32.W))
    val register2 = Reg(UInt(32.W))
    val register3 = Reg(UInt(32.W))

    val r0 = Queue(io.requestor(0))
    val r1 = Queue(io.requestor(1))
    val r2 = Queue(io.requestor(2))
    val r3 = Queue(io.requestor(3))
    val arb = Module(new Arbiter(UInt(), 4))
    arb.io.in(0) <> r0
    arb.io.in(1) <> r1
    arb.io.in(2) <> r2
    arb.io.in(3) <> r3
    arb.io.out.ready := 1.U

    when(io.requestor(0).valid) {
        register0 := arb.io.out.bits
        memory.write(io.Writeaddr, VecInit(Seq(register0, 0.U, 0.U, 0.U)))
    }.elsewhen(io.requestor(1).valid) {
        register1 := arb.io.out.bits
        memory.write(io.Writeaddr, VecInit(Seq(0.U, register1, 0.U, 0.U)))
    }.elsewhen(io.requestor(2).valid) {
        register2 := arb.io.out.bits
        memory.write(io.Writeaddr, VecInit(Seq(0.U, 0.U, register2, 0.U)))
    }.otherwise {
        register3 := arb.io.out.bits
        memory.write(io.Writeaddr, VecInit(Seq(0.U, 0.U, 0.U, register3)))
    }

    io.memory_out := memory.read(io.Readaddr)
}
