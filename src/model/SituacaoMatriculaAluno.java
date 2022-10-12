package model;

public enum SituacaoMatriculaAluno {

    ATIVO,
    IRREGULAR,
    ATENDIMENTO_PEDAGOGICO,
    INATIVO;

    public static SituacaoMatriculaAluno obterPeloCodigo(int codigo) {
        SituacaoMatriculaAluno[] situacaoMatriculaAluno = SituacaoMatriculaAluno.values();
        return situacaoMatriculaAluno [codigo-1];
    }

}
