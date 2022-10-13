package cli;

import exception.OpcaoInvalidaException;
import model.*;

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

    public void exibirMenuExperienciaProfessor(){
        System.out.println();
        System.out.println("Informe a Experiência do Professor: ");
        System.out.println("1 - Frontend");
        System.out.println("2 - Backend");
        System.out.println("3 - Fullstack");
    }

    public void exibirMenuSituacaoProfessor() {
        System.out.println();
        System.out.println("Informe a Situação do Professor: ");
        System.out.println("1 - Ativo");
        System.out.println("2 - Inativo");
    }

    public void exibirMenuFormacaoProfessor() {
        System.out.println("Informe a Formação Acadêmica do professor: ");
        System.out.println("1 - Superior Incompleto");
        System.out.println("2 - Superior Completo");
        System.out.println("3 - Mestrado");
        System.out.println("4 - Doutorado");
    }

    public void exibirMenuSituacaoMatricula() {
        System.out.println("Informe a Situação da Matrícula: ");
        System.out.println("1- Ativo");
        System.out.println("2- Irregular");
        System.out.println("3- Atendimento pedagógico");
        System.out.println("4- Inativo");
    }

    public void exibirCabecalhoListagemPessoa(){
        System.out.println();
        System.out.println("Listagem de Pessoas");
        System.out.println("-------------------");
        System.out.printf("%-17s%-40s%-28s%-10s\n","Código","Nome",
                "CPF", "Função");
    }

    public void exibirOpcoesRelatorioPessoas() {
        System.out.println("Quais caegorias de pessoas você deseja consultar?");
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

    public Pessoa cadastrar (Operacao operacao) {
        Scanner scanner = new Scanner(System.in);
        String nome = "";
        System.out.println();
        while (nome==""){
            System.out.print("Informe o nome: ");
            nome = scanner.nextLine();
        }
        System.out.println();
        System.out.print("Informe o CPF (digite apenas os números): ");
        Long CPF = scanner.nextLong();
        System.out.println();
        System.out.print("Informe o Telefone (digite apenas os números): ");
        Long telefone = scanner.nextLong();
        System.out.println();
        System.out.print("Data de Nascimento(formato = dd/MM/yyyy): ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(input, formatador);
        System.out.println();
        Pessoa pessoa;
        Long codigo = (long) GeradorDeCodigo.getProximaMatricula();
        if (operacao == Operacao.CADASTRAR_ALUNO) {
            int qtdadeAtendimentoPedagogico = 0;
            exibirMenuSituacaoMatricula();
            int situacao = scan.nextInt();
            SituacaoMatriculaAluno situacaoMatricula = SituacaoMatriculaAluno.obterPeloCodigo(situacao);
            System.out.println();
            System.out.print("Informe a Nota do Processo Seletivo: ");
            Double nota = scan.nextDouble();
            System.out.println();
            pessoa = new Aluno(nome, CPF, telefone, codigo, dataNascimento,
                    situacaoMatricula, nota, qtdadeAtendimentoPedagogico);
        } else if (operacao == operacao.CADASTRAR_PROFESSOR) {
            exibirMenuFormacaoProfessor();
            int formacao = scan.nextInt();
            FormacaoAcademicaProfessor formacaoAcademicaProfessor = FormacaoAcademicaProfessor.obterPeloCodigo(formacao);
            exibirMenuSituacaoProfessor();
            int situacao = scan.nextInt();
            SituacaoProfessor situacaoProfessor = SituacaoProfessor.obterPeloCodigo(situacao);
            exibirMenuExperienciaProfessor ();
            int experiencia = scan.nextInt();
            ExperienciaProfessor experienciaProfessor = ExperienciaProfessor.obterPeloCodigo(experiencia);
            System.out.println();
            pessoa = new Professor(nome, CPF, telefone, codigo, dataNascimento, formacaoAcademicaProfessor,
                    situacaoProfessor, experienciaProfessor);
        } else {
            int qtdadeAtendimentoPedagogico = 0;
            pessoa = new Pedagogo(nome, CPF, telefone, codigo, dataNascimento, qtdadeAtendimentoPedagogico);
        }
        return pessoa;
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
        voltarParaMenu();
    }
}