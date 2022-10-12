package model;

import java.time.LocalDate;

public class Aluno extends Pessoa implements Comparable<Aluno>{

    SituacaoMatriculaAluno situacaoMatricula;
    private double nota;
    private int qtdadeAtendimentosPedagagicos;

    public Aluno(String nome, Long CPF, Long telefone, Long código, LocalDate dataNascimento,
                 SituacaoMatriculaAluno situacaoMatricula, double nota, int qtdadeAtendimentosPedagagicos) {
        super(nome, CPF, telefone, código, dataNascimento);
        this.situacaoMatricula = situacaoMatricula;
        this.nota = nota;
        this.qtdadeAtendimentosPedagagicos = qtdadeAtendimentosPedagagicos;
    }



    @Override
    public int compareTo(Aluno o) {
        if (this.qtdadeAtendimentosPedagagicos > o.qtdadeAtendimentosPedagagicos) {

            // if current object is greater,then return 1
            return -1;
        }
        else if (this.qtdadeAtendimentosPedagagicos < o.qtdadeAtendimentosPedagagicos) {

            // if current object is greater,then return -1
            return 1;
        }
        else {

            // if current object is equal to o,then return 0
            return 0;
        }
    }

    @Override
    public String toString() {
        return  "Aluno {" +
                "nome='" + getNome() + '\'' +
                ", CPF='" + getCPF() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                ", dataNascimento='" + getDataNascimento() + '\'' +
                ", Situação da matrícula= '"+this.situacaoMatricula+ '\'' +
                ", Nota do processo seletivo= '"+this.nota+ '\'' +
                ", Quantidade Atendimentos Pedagógicos= '"+this.qtdadeAtendimentosPedagagicos+ '\''+
                '}';
    }

    public SituacaoMatriculaAluno getSituacaoMatricula() {
        return situacaoMatricula;
    }

    public void setSituacaoMatricula(SituacaoMatriculaAluno situacaoMatricula) {
        this.situacaoMatricula = situacaoMatricula;
    }

    public double getNota() {
        return nota;
    }

    public int getQtdadeAtendimentosPedagagicos() {
        return qtdadeAtendimentosPedagagicos;
    }

    public void setQtdadeAtendimentosPedagagicos(int qtdadeAtendimentosPedagagicos) {
        this.qtdadeAtendimentosPedagagicos = qtdadeAtendimentosPedagagicos;
    }
}
