package model;

import java.time.LocalDate;

public class Pedagogo extends Pessoa implements Comparable<Pedagogo> {

    private int qtdadeAtendimentosPedagagicos;

    public Pedagogo(String nome, Long CPF, Long telefone, Long código, LocalDate dataNascimento, int qtdadeAtendimentosPedagagicos) {
        super(nome, CPF, telefone, código, dataNascimento);
        this.qtdadeAtendimentosPedagagicos = qtdadeAtendimentosPedagagicos;
    }

    public int compareTo(Pedagogo o) {
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
        return "Pedagoga{" +
                "nome='" + getNome() + '\'' +
                ", CPF='" + getCPF() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                ", dataNascimento='" + getDataNascimento() + '\'' +
                ", quantidade de atendimentos'" + getQtdadeAtendimentosPedagagicos() +
                '}';
    }

    public int getQtdadeAtendimentosPedagagicos() {
        return qtdadeAtendimentosPedagagicos;
    }

    public void setQtdadeAtendimentosPedagagicos(int qtdadeAtendimentosPedagagicos) {
        this.qtdadeAtendimentosPedagagicos = qtdadeAtendimentosPedagagicos;
    }
}
