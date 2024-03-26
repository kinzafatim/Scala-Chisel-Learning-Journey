// package labs
// import chisel3._
// import chisel3.util._
// trait Config {
//   // word length configuration parameter
//   val WLEN = 32
//   val XLEN = 32
//   // ALU operation control signal width
//   val ALUOP_SIG_LEN = 4
// }

// object ALUOP {
//   // ALU Operations, may expand / modify in future
//   val ALU_ADD   = 0.U(4.W)
//   val ALU_SUB   = 1.U(4.W)
//   val ALU_AND   = 2.U(4.W)
//   val ALU_OR    = 3.U(4.W)
//   val ALU_XOR   = 4.U(4.W)
//   val ALU_SLT   = 5.U(4.W)
//   val ALU_SLL   = 6.U(4.W)
//   val ALU_SLTU  = 7.U(4.W)
//   val ALU_SRL   = 8.U(4.W)
//   val ALU_SRA   = 9.U(4.W)
//   val ALU_COPY_A = 10.U(4.W)
//   val ALU_COPY_B = 11.U(4.W)
//   val ALU_XXX    = 15.U(4.W)
// }

// import ALUOP._

// class ALUIO extends Bundle with Config {
//   val A = Input(UInt(32.W))
//   val B = Input(UInt(32.W))
//   val alu_Op = Input(UInt(4.W))
//   val out = Output(UInt(32.W))
//   val sum = Output(UInt(32.W))
// }

// class ALU extends Module with Config {
//   val io = IO(new ALUIO)

//   // Calculation of sum based on alu_Op
//   val sum = io.A + Mux(io.alu_Op(0), -io.B, io.B) // if alu_Op is 0, then sum = A+B, otherwise sum = A-io.B

//   // Comparing MSBs of A and B
//   val cmp = Mux(io.A(XLEN - 1) === io.B(XLEN - 1), sum(XLEN - 1), 
//               Mux(io.alu_Op(1), io.B(XLEN - 1), io.A(XLEN - 1)))
// val shamt = io.B(4, 0).asUInt
// val shin = Mux(io.alu_Op(0), Reverse(io.B), io.B) // Select B or its inverse based on alu_Op(0)
// val shiftr = shin >> shamt
// val shiftl = shin << shamt

// val out = Mux(
//   io.alu_Op === ALU_ADD || io.alu_Op === ALU_SUB, sum,
//   Mux(io.alu_Op === ALU_SLT || io.alu_Op === ALU_SLTU, cmp,
//     Mux(io.alu_Op === ALU_SRA || io.alu_Op === ALU_SRL, shiftr,
//       Mux(io.alu_Op === ALU_SLL, shiftl,
//         Mux(io.alu_Op === ALU_AND, io.A & io.B,
//           Mux(io.alu_Op === ALU_OR, io.A | io.B,
//             Mux(io.alu_Op === ALU_XOR, io.A ^ io.B,
//               Mux(io.alu_Op === ALU_COPY_A, io.A,
//                 Mux(io.alu_Op === ALU_COPY_B, io.B, 0.U)))))))))

// io.out := out
// io.sum := sum
// }