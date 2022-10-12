package repository;

import model.Aluno;
import model.Comparator;
import model.Operacao;
import model.SituacaoMatriculaAluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlunoRepository  {
    private List<Aluno> alunos = new ArrayList<>();

    public void inserir(Aluno aluno) {
        this.alunos.add(aluno);
    }

//    public List<Aluno> consultar() {
//        return alunos;
//    }


    public void imprimirRelatorio(SituacaoMatriculaAluno situacaoMatricula){
        System.out.printf("%-17s%-40s%-28s%-24s\n","CÓDIGO DO ALUNO","NOME DO ALUNO",
                "NOTA DO PROCESSO SELETIVO","ATENDIMENTOS PEDAGÓGICOS");
        System.out.printf("%-17s%-40s%-28s%-24s\n","---------------","--------------------------------------",
                "--------------------------","------------------------");
        for (Aluno aluno:alunos) {
            if (situacaoMatricula == null){
                System.out.printf("%-17s%-40s%-28s%-24d\n",aluno.getCodigo(),aluno.getNome(),
                        aluno.getNota(),aluno.getQtdadeAtendimentosPedagagicos());
            }
            else if (aluno.getSituacaoMatricula()==situacaoMatricula) {
                System.out.printf("%-17s%-40s%-28s%-24d\n",aluno.getCodigo(),aluno.getNome(),
                        aluno.getNota(),aluno.getQtdadeAtendimentosPedagagicos());
            }
        }
    }

//    public int quantidadeAlunos(){
//        int qtdadeAlunos = alunos.size()+1;
//        return qtdadeAlunos;
//    }

    public void imprimirAlunos(){
        for (Aluno aluno: alunos) {
            System.out.printf("%-17s%-40s%-28s%-10s\n",aluno.getCodigo(),aluno.getNome(),
                    aluno.getCPF(), "aluno");
        }
    }

    public void atualizarAtendimentoPedagogico(Long codigoAluno) {
        for (Aluno aluno:alunos){
            if (aluno.getCodigo()==codigoAluno){
                int atendimento = aluno.getQtdadeAtendimentosPedagagicos();
                aluno.setQtdadeAtendimentosPedagagicos(atendimento+1);
            }
        }
    }

    public void atualizarSituacaoAluno(Long codigoAluno, SituacaoMatriculaAluno situacaoMatricula) {
        for (Aluno aluno:alunos){
            if (aluno.getCodigo()==codigoAluno){
                aluno.setSituacaoMatricula(situacaoMatricula);
            }
        }
    }

    public void imprimirAlunosQtidadeAtendimentos() {
        List<Aluno> alunosPorQtidadeAtendimento = new ArrayList<>(alunos);
        Collections.sort(alunosPorQtidadeAtendimento);
        for(Aluno aluno: alunosPorQtidadeAtendimento){
            System.out.println(aluno);
        }
    }

    public void imprimirRelatorioAtendimentos(){
        System.out.printf("%-17s%-40s%-24s\n","CÓDIGO DO ALUNO","NOME DO ALUNO",
                "ATENDIMENTOS PEDAGÓGICOS");
        System.out.printf("%-17s%-40s%-24s\n","---------------","--------------------------------------"
                ,"------------------------");
        List<Aluno> alunosPorQtidadeAtendimento = new ArrayList<>(alunos);
        Collections.sort(alunosPorQtidadeAtendimento);
        for (Aluno aluno:alunosPorQtidadeAtendimento) {
            System.out.printf("%-17s%-40s%-24d\n",aluno.getCodigo(),aluno.getNome(),
                        aluno.getQtdadeAtendimentosPedagagicos());
        }
    }
//
//    @Override
//    public int compare(int atendimentosPedagogicos1, int atendimentosPedagogicos2) {
////        return 0;
//    }
}
