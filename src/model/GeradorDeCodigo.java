package model;

public class GeradorDeCodigo {

        private static int ID = 1;

        public static int getProximaMatricula() {
            return ID++;
        }

//    public Long gerarCodigo(Operacao operacao, int ano){
//        String codigo=null;
//        String qtdadeAlunos =String.format ("%06d", quantidadeAlunos());
//        if (operacao == Operacao.CADASTRAR_ALUNO){
//            codigo = "ALU"+String.valueOf(ano)+qtdadeAlunos;
//            System.out.println(codigo);
//        }
//        return Long.valueOf(codigo) ;
//    }

}
