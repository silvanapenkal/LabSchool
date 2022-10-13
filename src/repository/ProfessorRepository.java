package repository;

import model.ExperienciaProfessor;
import model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {

    private List<Professor> professores = new ArrayList<>();

    public void inserir(Professor professor) {
        this.professores.add(professor);
    }

    public void imprimirRelatorio(ExperienciaProfessor experienciaProfessor){
        System.out.printf("%-22s%-40s%-21s%-14s%-10s\n","CÓDIGO DO PROFESSOR","NOME DO PROFESSOR",
                "FORMAÇÃO ACADÊMICA","EXPERIÊNCIA","ESTADO");
        System.out.printf("%-22s%-40s%-21s%-14s%-10s\n","-------------------","--------------------------------------",
                "------------------","-----------","------");
        for (Professor professor: professores) {
            if (experienciaProfessor == null){
                System.out.printf("%-22s%-40s%-21s%-14s%-10s\n",professor.getCodigo(),professor.getNome(),
                        professor.getFormacaoAcademicaProfessor(),
                        professor.getExperienciaProfessor(),professor.getEstadoProfessor());
            } else if (professor.getExperienciaProfessor()==experienciaProfessor) {
                System.out.printf("%-22s%-40s%-21s%-14s%-10s\n",professor.getCodigo(),professor.getNome(),
                        professor.getFormacaoAcademicaProfessor(),
                        professor.getExperienciaProfessor(),professor.getEstadoProfessor());
            }
        }
    }

    public void imprimirProfessores(){
        for (Professor professor: professores) {
                System.out.printf("%-17s%-40s%-28s%-10s\n",professor.getCodigo(),professor.getNome(),
                        professor.getCPF(), "professor");
        }
    }

}
