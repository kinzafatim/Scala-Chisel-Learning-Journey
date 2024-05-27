package labs.lab7
import chisel3._
import chisel3.util._

class task1 extends Module {
  val io = IO(new Bundle {
    val f1 = Input(Bool())
    val f2 = Input(Bool())
    val r1 = Input(Bool())
    val r2 = Input(Bool())
    val out = Output(UInt(8.W))
  })
  val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: Nil = Enum(6)
  val state = RegInit(s0)

  // Default output
  io.out := 0.U

  switch(state) {
    is(s0) {
      io.out := 0.U
      when(io.f1) {
        state := s1
      }.elsewhen(io.f2) {
        state := s5
      }
    }
    is(s1) {
      io.out := 0.U
      when(io.f1) {
        state := s2
      }.elsewhen(io.r1) {
        state := s0
      }
    }
    is(s2) {
      io.out := 3.U
      when(io.f1) {
        state := s2
      }.elsewhen(io.r1) {
        state := s1
      }
    }
    is(s3) {
      io.out := 0.U
      when(io.f1) {
        state := s2
      }.elsewhen(io.f2) {
        state := s4
      }
    }
    is(s4) {
      io.out := 7.U
      when(io.f2) {
        state := s4
      }.elsewhen(io.r2) {
        state := s5
      }
    }
    is(s5) {
      io.out := 0.U
      when(io.f2) {
        state := s4
      }.elsewhen(io.r2) {
        state := s0
      }
    }
  }
}