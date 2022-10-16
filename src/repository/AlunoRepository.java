package repository;

import cli.Display;
import model.Aluno;
import model.SituacaoMatriculaAluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlunoRepository  {
    private List<Aluno> alunos = new ArrayList<>();
    private Display display = new Display();

    public void inserir(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void imprimirRelatorio(SituacaoMatriculaAluno situacaoMatricula){
        display.exibirCabecalhoRelatorioAluno();
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



    public void imprimirAlunos(){
        for (Aluno aluno: alunos) {
            System.out.printf("%-17s%-40s%011d   %-23s\n",aluno.getCodigo(),aluno.getNome(),
                    aluno.getCPF(), "aluno");
        }
    }

    public void imprimirCodigosAlunos(){
        for (Aluno aluno: alunos) {
            System.out.printf("%-17s%-40s\n",aluno.getCodigo(),aluno.getNome());
        }
    }

    public void atualizarAtendimentoPedagogico(Long codigoAluno) {
        Boolean ehAluno = false;
        for (Aluno aluno:alunos){
            if (aluno.getCodigo()==codigoAluno){
                ehAluno = true;
                int atendimento = aluno.getQtdadeAtendimentosPedagagicos();
                aluno.setQtdadeAtendimentosPedagagicos(atendimento+1);
                System.out.println("Nome do Aluno: "+aluno.getNome());
                System.out.println("O cadastro do atendimento pedagógico foi realizado com sucesso!");
            }
        }
        if (!ehAluno) {
            System.out.println("O atendimento não foi cadastrado porque não existe um aluno cadastrado com esse código.");
        }
    }


    public void atualizarSituacaoAluno(Long codigoAluno, SituacaoMatriculaAluno situacaoMatricula) {
        Boolean ehAluno = false;
        for (Aluno aluno:alunos){
            if (aluno.getCodigo()==codigoAluno){
                ehAluno = true;
                aluno.setSituacaoMatricula(situacaoMatricula);
                System.out.println("A situação do aluno "+aluno.getNome()+" foi alterada para "+aluno.getSituacaoMatricula());
            }
        }
        if (!ehAluno) {
            System.out.println("Não existe um aluno cadastrado com esse código.");
        }
    }

    public void imprimirRelatorioAtendimentos(){
        display.exibirCabecalhoAtendimentoAluno();
        List<Aluno> alunosPorQtidadeAtendimento = new ArrayList<>(alunos);
        Collections.sort(alunosPorQtidadeAtendimento);
        for (Aluno aluno:alunosPorQtidadeAtendimento) {
            System.out.printf("%-17s%-40s%-24d\n",aluno.getCodigo(),aluno.getNome(),
                        aluno.getQtdadeAtendimentosPedagagicos());
        }
    }
}
