package model;

public enum EstadoProfessor {

    ATIVO,
    INATIVO;

    public static EstadoProfessor obterPeloCodigo(int codigo) {
        EstadoProfessor[] situacaoProfessor = EstadoProfessor.values();
        return situacaoProfessor[codigo-1];
    }

}
