package model;

public enum ExperienciaProfessor {

    FRONTEND,
    BACKEND,
    FULLSTACK;

    public static ExperienciaProfessor obterPeloCodigo(int codigo) {
        ExperienciaProfessor[] experiencia = ExperienciaProfessor.values();
        return experiencia[codigo-1];
    }


}
