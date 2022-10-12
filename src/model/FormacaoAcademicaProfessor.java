package model;

public enum FormacaoAcademicaProfessor {

    GRADUACAO_INCOMPLETA,
    GRADUACAO_COMPLETA,
    MESTRADO,
    DOUTORADO;

    public static FormacaoAcademicaProfessor obterPeloCodigo(int codigo) {
        FormacaoAcademicaProfessor[] formacao = FormacaoAcademicaProfessor.values();
        return formacao[codigo-1];
    }

}
