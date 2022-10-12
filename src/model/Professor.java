package model;

import java.time.LocalDate;

public class Professor extends Pessoa{

    private ExperienciaProfessor experienciaProfessor;
    private SituacaoProfessor situacaoProfessor;
    private FormacaoAcademicaProfessor formacaoAcademicaProfessor;

    public Professor(String nome, Long CPF, Long telefone, Long código, LocalDate dataNascimento,
                     FormacaoAcademicaProfessor formacaoAcademicaProfessor,
                     SituacaoProfessor situacaoProfessor,
                     ExperienciaProfessor experienciaProfessor) {
        super(nome, CPF, telefone, código, dataNascimento);
        this.experienciaProfessor = experienciaProfessor;
        this.situacaoProfessor = situacaoProfessor;
        this.formacaoAcademicaProfessor = formacaoAcademicaProfessor;
    }

    @Override
    public String toString() {
        return "Professor {" +
                "nome='" + getNome() + '\'' +
                ", CPF='" + getCPF() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                ", dataNascimento='" + getDataNascimento() + '\'' +
                ", Formação acadêmica= '" + this.formacaoAcademicaProfessor + '\'' +
                ", Situação= '" + situacaoProfessor + '\'' +
                ", Experiência= '" + experienciaProfessor + '\'' +
                '}';
    }

    public ExperienciaProfessor getExperienciaProfessor() {
        return experienciaProfessor;
    }

    public SituacaoProfessor getSituacaoProfessor() {
        return situacaoProfessor;
    }

    public FormacaoAcademicaProfessor getFormacaoAcademicaProfessor() {
        return formacaoAcademicaProfessor;
    }
}
