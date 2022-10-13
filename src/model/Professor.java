package model;

import java.time.LocalDate;

public class Professor extends Pessoa{

    private ExperienciaProfessor experienciaProfessor;
    private EstadoProfessor estadoProfessor;
    private FormacaoAcademicaProfessor formacaoAcademicaProfessor;

    public Professor(String nome, Long CPF, Long telefone, Long código, LocalDate dataNascimento,
                     FormacaoAcademicaProfessor formacaoAcademicaProfessor,
                     EstadoProfessor estadoProfessor,
                     ExperienciaProfessor experienciaProfessor) {
        super(nome, CPF, telefone, código, dataNascimento);
        this.experienciaProfessor = experienciaProfessor;
        this.estadoProfessor = estadoProfessor;
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
                ", Situação= '" + this.estadoProfessor + '\'' +
                ", Experiência= '" + this.experienciaProfessor + '\'' +
                '}';
    }

    public ExperienciaProfessor getExperienciaProfessor() {
        return experienciaProfessor;
    }

    public EstadoProfessor getEstadoProfessor() {
        return estadoProfessor;
    }

    public FormacaoAcademicaProfessor getFormacaoAcademicaProfessor() {
        return formacaoAcademicaProfessor;
    }
}
