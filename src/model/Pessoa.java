package model;

import java.time.LocalDate;

public abstract class Pessoa {

    private String nome;
    private Long CPF;
    private Long telefone;
    private Long codigo;
    private LocalDate dataNascimento;

    public Pessoa(String nome, Long CPF, Long telefone, Long codigo, LocalDate dataNascimento) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.codigo = codigo;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", telefone='" + telefone + '\'' +
                ", codigo='" + codigo + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public Long getCPF() {
        return CPF;
    }

    public Long getTelefone() {
        return telefone;
    }

    public Long getCodigo() { return codigo; }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

}
