package cli;

import exception.OpcaoInvalidaException;
import model.*;
import repository.AlunoRepository;
import repository.PedagogoRepository;
import repository.ProfessorRepository;
import util.GeradorDeCodigo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Display {

    private GeradorDeCodigo geradorDeCodigo = new GeradorDeCodigo();

    public void exibirApresentacao(){
        System.out.println("******************************************************************************************");
        System.out.println("                     ,,                               ,,                           ,,  ");
        System.out.println("`7MMF'              *MM             .M\"\"\"bgd        `7MM                         `7MM  ");
        System.out.println("  MM                 MM            ,MI    \"Y          MM                           MM  ");
        System.out.println("  MM         ,6\"Yb.  MM,dMMb.      `MMb.      ,p6\"bo  MMpMMMb.  ,pW\"Wq.   ,pW\"Wq.  MM  ");
        System.out.println("  MM        8)   MM  MM    `Mb       `YMMNq. 6M'  OO  MM    MM 6W'   `Wb 6W'   `Wb MM  ");
        System.out.println("  MM      ,  ,pm9MM  MM     M8     .     `MM 8M       MM    MM 8M     M8 8M     M8 MM  ");
        System.out.println("  MM     ,M 8M   MM  MM.   ,M9     Mb     dM YM.    , MM    MM YA.   ,A9 YA.   ,A9 MM  ");
        System.out.println(".JMMmmmmMMM `Moo9^Yo.P^YbmdP'      P\"Ybmmd\"   YMbmd'.JMML  JMML.`Ybmd9'   `Ybmd9'.JMML.");
        System.out.println("******************************************************************************************");
        System.out.println();
        //Georgia 11 by Richard Sabey <cryptic_fan@hotmail.com> 9.2003
        //obtida no site https://patorjk.com/software/taag/
        System.out.println("Seja bem-vindo ao melhor sistema de gestão escolar do DEVinHouse!");
        System.out.println("Desenvolvido por Silvana Penkal Santos");
    }


    public void exibirMenu() {
        System.out.println();
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println(" 1 - Cadastrar - Aluno");
        System.out.println(" 2 - Cadastrar - Professor");
        System.out.println(" 3 - Cadastrar - Pedagogo");
        System.out.println(" 4 - Atualizar Situação do Aluno");
        System.out.println(" 5 - Realizar Atendimento Pedagogico");
        System.out.println(" 6 - Imprimir Relatório - Listagem de Pessoas");
        System.out.println(" 7 - Imprimir Relatório - Listagem de Alunos");
        System.out.println(" 8 - Imprimir Relatório - Listagem de Professores");
        System.out.println(" 9 - Imprimir Relatório - Atendimentos Pedagógicos por Aluno");
        System.out.println("10 - Imprimir Relatório - Atendimentos Pedagógicos por Pedagogo");
        System.out.println("11 - Sair");
        System.out.println();
    }

    public Pessoa cadastrar (Operacao operacao) {
        Scanner scan = new Scanner(System.in);
        String nome = solicitarNome();
        Long CPF = solicitarCPF();
        Long telefone = solicitarTelefone();
        LocalDate dataNascimento = solicitarDataNascimento();
        Pessoa pessoa;
        Long codigo = (long) GeradorDeCodigo.getProximaMatricula();
        if (operacao == Operacao.CADASTRAR_ALUNO) {
            SituacaoMatriculaAluno situacaoMatricula = solicitarSituacaoAluno();
            Double nota = solicitarNotaProcessoSeletivo();
            int qtdadeAtendimentoPedagogico = 0;
            pessoa = new Aluno(nome, CPF, telefone, codigo, dataNascimento,
                    situacaoMatricula, nota, qtdadeAtendimentoPedagogico);
        } else if (operacao == operacao.CADASTRAR_PROFESSOR) {
            FormacaoAcademicaProfessor formacaoAcademicaProfessor = solicitarFormacaoProfessor();
            EstadoProfessor situacaoProfessor = solicitarEstadoProfessor();
            ExperienciaProfessor experienciaProfessor = solicitarExperienciaProfessor();
            pessoa = new Professor(nome, CPF, telefone, codigo, dataNascimento, formacaoAcademicaProfessor,
                    situacaoProfessor, experienciaProfessor);
        } else {
            int qtdadeAtendimentoPedagogico = 0;
            pessoa = new Pedagogo(nome, CPF, telefone, codigo, dataNascimento, qtdadeAtendimentoPedagogico);
        }
        return pessoa;
    }

    public void exibirOpcoesRelatorioPessoas() {
        System.out.println("Quais categorias de pessoas você deseja consultar?");
        System.out.println("1 - Alunos");
        System.out.println("2 - Professores");
        System.out.println("3 - Pedagogos");
        System.out.println("4 - Todos");
    }

    public void exibirOpcoesRelatorioAlunos(){
        System.out.println("Quais alunos você deseja consultar?");
        System.out.println("1 - Ativo");
        System.out.println("2 - Irregular");
        System.out.println("3 - Atendimento pedagógico");
        System.out.println("4 - Inativo");
        System.out.println("5 - Todos");
    }


    public void exibirOpcoesRelatorioProfessor(){
        System.out.println("Quais professores você deseja consultar?");
        System.out.println("1 - Frontend");
        System.out.println("2 - Backend");
        System.out.println("3 - Fullstack");
        System.out.println("4 - Todos");
    }

    public Long solicitarCodigoAluno(){
        System.out.println("Digite o código do aluno a ser atendido:");
        Scanner scanner = new Scanner(System.in);
        Long codigoAluno = scanner.nextLong();
        return codigoAluno;
    }

    public Long solicitarCodigoPedagogo(){
        System.out.println("Digite o código do pedagogo que realizará o atendimento:");
        Scanner scanner = new Scanner(System.in);
        Long codigoPedagogo = scanner.nextLong();
        return codigoPedagogo;
    }

    public Operacao obterOperacao() throws OpcaoInvalidaException {
        System.out.print("Digite a opção desejada: ");
        Scanner scanner = new Scanner(System.in);
        int codigoOpcao = scanner.nextInt();
        if (codigoOpcao < 0 || codigoOpcao > Operacao.values().length) {
            throw new OpcaoInvalidaException();
        }
        Operacao operacao = Operacao.obterPeloCodigo(codigoOpcao);
        return operacao;
    }

    public SituacaoMatriculaAluno obterSituacaoMatricula() throws OpcaoInvalidaException {
        System.out.print("Digite a opção desejada: ");
        Scanner scanner = new Scanner(System.in);
        int codigoOpcao = scanner.nextInt();
        if (codigoOpcao <= 0 || codigoOpcao > SituacaoMatriculaAluno.values().length+1) {
            throw new OpcaoInvalidaException();
        }
        SituacaoMatriculaAluno situacaoMatricula = null;
        if (codigoOpcao > 0 & codigoOpcao <= SituacaoMatriculaAluno.values().length){
            situacaoMatricula = SituacaoMatriculaAluno.obterPeloCodigo(codigoOpcao);
        }
        return situacaoMatricula;
    }

    public ExperienciaProfessor obterExperienciaProfessor() throws OpcaoInvalidaException {
        System.out.print("Digite a opção desejada: ");
        Scanner scanner = new Scanner(System.in);
        int codigoOpcao = scanner.nextInt();
        if (codigoOpcao <= 0 || codigoOpcao > ExperienciaProfessor.values().length+1) {
            throw new OpcaoInvalidaException();
        }
        ExperienciaProfessor experienciaProfessor = null;
        if (codigoOpcao>0 & codigoOpcao <= ExperienciaProfessor.values().length){
            experienciaProfessor = ExperienciaProfessor.obterPeloCodigo(codigoOpcao);
        }
        return experienciaProfessor;
    }

    public int obterCategoriaPessoa() throws OpcaoInvalidaException {
        System.out.print("Digite a opção desejada: ");
        Scanner scanner = new Scanner(System.in);
        int codigoOpcao = scanner.nextInt();
        if (codigoOpcao < 1 || codigoOpcao > 4) {
            throw new OpcaoInvalidaException();
        }
        return codigoOpcao;
    }

    public Long pedirCodigoAluno (){
        System.out.println("Digite o código do aluno:");
        Scanner scanner = new Scanner(System.in);
        Long codigoAluno = scanner.nextLong();
        return codigoAluno;
    }

    public void voltarParaMenu (){
        System.out.println();
        System.out.println("Digite ENTER para exibir o Menu Principal.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public SituacaoMatriculaAluno atualizarSituacaoAluno (){
        exibirMenuSituacaoMatricula();
        Scanner scanner = new Scanner(System.in);
        int situacao = scanner.nextInt();
        SituacaoMatriculaAluno situacaoMatricula = SituacaoMatriculaAluno.obterPeloCodigo(situacao);
        return situacaoMatricula;
    }

    public void exibirCabecalhoAtendimentoAluno(){
        System.out.printf("%-17s%-40s%-24s\n","CÓDIGO DO ALUNO","NOME DO ALUNO",
                "ATENDIMENTOS PEDAGÓGICOS");
        System.out.printf("%-17s%-40s%-24s\n","---------------","--------------------------------------"
                ,"------------------------");
    }

    public void exibirCabecalhoAtendimentoPedagogo(){
        System.out.printf("%-17s%-40s%-24s\n","CÓDIGO DO PEDAGOGO","NOME DO PEDAGOGO",
                "ATENDIMENTOS PEDAGÓGICOS");
        System.out.printf("%-17s%-40s%-24s\n","---------------","--------------------------------------"
                ,"------------------------");
    }

    public void exibirCabecalhoRelatorioAluno (){
        System.out.printf("%-17s%-40s%-28s%-24s\n","CÓDIGO DO ALUNO","NOME DO ALUNO",
                "NOTA DO PROCESSO SELETIVO","ATENDIMENTOS PEDAGÓGICOS");
        System.out.printf("%-17s%-40s%-28s%-24s\n","---------------","--------------------------------------",
                "--------------------------","------------------------");
    }

    public void exibirCabecalhoListagemPessoa(){
        System.out.println();
        System.out.println("Listagem de Pessoas");
        System.out.println("-------------------");
        System.out.printf("%-17s%-40s%-11s   %-23s\n","Código","Nome", "CPF", "Função");
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
        voltarParaMenu();
    }

    private ExperienciaProfessor solicitarExperienciaProfessor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Informe a Experiência do Professor: ");
        System.out.println("1 - Frontend");
        System.out.println("2 - Backend");
        System.out.println("3 - Fullstack");
        int experiencia = scanner.nextInt();
        ExperienciaProfessor experienciaProfessor = ExperienciaProfessor.obterPeloCodigo(experiencia);
        System.out.println();
        return experienciaProfessor;
    }

   private EstadoProfessor solicitarEstadoProfessor() {
        System.out.println();
        System.out.println("Informe a Situação do Professor: ");
        System.out.println("1 - Ativo");
        System.out.println("2 - Inativo");
       Scanner scanner = new Scanner(System.in);
       int situacao = scanner.nextInt();
       EstadoProfessor estadoProfessor = EstadoProfessor.obterPeloCodigo(situacao);
       return estadoProfessor;
    }

    private FormacaoAcademicaProfessor solicitarFormacaoProfessor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a Formação Acadêmica do professor: ");
        System.out.println("1 - Superior Incompleto");
        System.out.println("2 - Superior Completo");
        System.out.println("3 - Mestrado");
        System.out.println("4 - Doutorado");
        int formacao = scanner.nextInt();
        FormacaoAcademicaProfessor formacaoAcademicaProfessor = FormacaoAcademicaProfessor.obterPeloCodigo(formacao);
        return  formacaoAcademicaProfessor;
    }

    private void exibirMenuSituacaoMatricula() {
        System.out.println("Informe a Situação da Matrícula: ");
        System.out.println("1- Ativo");
        System.out.println("2- Irregular");
        System.out.println("3- Atendimento pedagógico");
        System.out.println("4- Inativo");
    }

    private Long solicitarCPF(){
        Scanner scanner = new Scanner(System.in);
        Boolean validadeCPF = false;
        Long CPF = 00000000000l;
        System.out.println();
        while (!validadeCPF) {
            System.out.print("Informe o CPF: ");
            String entradaCPF = scanner.nextLine();
            int caracteresCPF = entradaCPF.length();
            if (caracteresCPF == 11) {
                try {
                    CPF = Long.parseLong(entradaCPF);
                    validadeCPF = true;
                } catch (Exception e) {
                    System.out.println("CPF inválido");
                }
            } else {
                System.out.println("CPF inválido");
            }
        }
        return CPF;
    }

    private Long solicitarTelefone(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        Boolean validadeTelefone = false;
        Long telefone =0000l;
        while (!validadeTelefone) {
            System.out.print("Informe o Telefone (digite apenas os números com o prefixo: ");
            System.out.println("Exemplo: se seu número é (47) 99000-9999, digite 47990009999");
            String entradaTelefone = scanner.nextLine();
            int caracteresTelefone = entradaTelefone.length();
            if (caracteresTelefone == 11) {
                try {
                    telefone = Long.parseLong(entradaTelefone);
                    validadeTelefone = true;
                } catch (Exception e) {
                    System.out.println("Telefone inválido");
                }
            } else {
                System.out.println("Telefone inválido");
            }
        }
        return telefone;
    }

    private String solicitarNome (){
        Scanner scanner = new Scanner(System.in);
        String nome = "";
        System.out.println();
        while (nome==""){
            System.out.print("Informe o nome: ");
            nome = scanner.nextLine();
        }
        return nome;
    }

    private LocalDate solicitarDataNascimento(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Data de Nascimento(formato = dd/MM/yyyy): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(input, formatador);
        System.out.println();
        return dataNascimento;
    }

    private SituacaoMatriculaAluno solicitarSituacaoAluno(){
        Scanner scanner = new Scanner(System.in);
        exibirMenuSituacaoMatricula();
        int situacao = scanner.nextInt();
        SituacaoMatriculaAluno situacaoMatricula = SituacaoMatriculaAluno.obterPeloCodigo(situacao);
        System.out.println();
        return situacaoMatricula;
    }

    private Double solicitarNotaProcessoSeletivo(){
        Scanner scanner = new Scanner(System.in);
        Double nota=11d; // Como não aceita null coloquei um valor acima de 10 para entrar no while
        while (nota<0 || nota>10){
            System.out.print("Informe a Nota do Processo Seletivo: ");
            nota = scanner.nextDouble();
        }
        System.out.println();
        return nota;
    }

}