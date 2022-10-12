package model;

public enum Operacao {

    CADASTRAR_ALUNO,
    CADASTRAR_PROFESSOR,
    CADASTRAR_PEDAGOGO,
    ATUALIZAR_ALUNO,
    ATENDIMENTO_PEDAGOGICO,
    RELATORIO_PESSOA,
    RELATORIO_ALUNO,
    RELATORIO_PROFESSOR,
    ATENDIMENTO_PEDAGOGICO_ALUNO,
    ATENDIMENTO_PEDAGOGICO_PEDAGOGO,
    SAIR;

    public static Operacao obterPeloCodigo(int codigo) {
        Operacao[] operacoes = Operacao.values();
        return operacoes[codigo-1];
    }
}
