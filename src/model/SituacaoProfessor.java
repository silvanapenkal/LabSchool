package model;

public enum SituacaoProfessor {

    ATIVO,
    INATIVO;

    public static SituacaoProfessor obterPeloCodigo(int codigo) {
        SituacaoProfessor[] situacaoProfessor = SituacaoProfessor.values();
        return situacaoProfessor[codigo-1];
    }

}
