import cli.Display;
import model.*;
import repository.*;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import exception.OpcaoInvalidaException;

public class Aplicacao {

    private Display display = new Display();
    private ProfessorRepository professorRepository = new ProfessorRepository();
    private AlunoRepository alunoRepository = new AlunoRepository();
    private PedagogoRepository pedagogoRepository = new PedagogoRepository();


    public void iniciar() {
        Operacao operacao = null;
        display.exibirApresentacao();
        display.voltarParaMenu ();
        while (operacao != Operacao.SAIR) {
            display.exibirMenu();
            try {
                operacao = display.obterOperacao();
                processar(operacao);
            } catch (OpcaoInvalidaException e) {
                display.exibirMensagem("A opção informada é inválida!");
            } catch (InputMismatchException e) {
                display.exibirMensagem("O valor digitado não é válido.");
            } catch (DateTimeParseException e){
                display.exibirMensagem("A data informada não é válida.");
            } catch (ArrayIndexOutOfBoundsException e){
                display.exibirMensagem("A opção informada não é válida.");
            }
        }
    }

    private void processar(Operacao operacao) throws OpcaoInvalidaException {
        switch (operacao) {
            case CADASTRAR_ALUNO:
                Aluno aluno = (Aluno) display.cadastrar(operacao);
                alunoRepository.inserir(aluno);
                System.out.println("O aluno foi cadastrado com sucesso sob o código "+aluno.getCodigo());
                display.voltarParaMenu();
                break;
            case CADASTRAR_PROFESSOR:
                Professor professor = (Professor) display.cadastrar(operacao);
                professorRepository.inserir(professor);
                System.out.println("O professor foi cadastrado com sucesso sob o código "+professor.getCodigo());
                display.voltarParaMenu();
                break;
            case CADASTRAR_PEDAGOGO:
                Pedagogo pedagogo = (Pedagogo) display.cadastrar(operacao);
                pedagogoRepository.inserir(pedagogo);
                System.out.println("O pedagogo foi cadastrado com sucesso sob o código "+pedagogo.getCodigo());
                display.voltarParaMenu();
                break;
            case ATUALIZAR_ALUNO:
                System.out.println("Relação dos alunos");
                System.out.printf("%-17s%-40s%-11s   %-23s\n","Código","Nome", "CPF", "Função");
                alunoRepository.imprimirAlunos();
                Long codigoAlunoParaAtualizar = display.pedirCodigoAluno();
                SituacaoMatriculaAluno situacaoAluno = display.atualizarSituacaoAluno();
                alunoRepository.atualizarSituacaoAluno(codigoAlunoParaAtualizar, situacaoAluno);
                display.voltarParaMenu();
                break;
            case ATENDIMENTO_PEDAGOGICO:
                System.out.println("Relação de códigos dos pedagogos:");
                pedagogoRepository.imprimirCodigosPedagogos();
                Long codigoPedagogo = display.solicitarCodigoPedagogo();
                Boolean ehPedagogo = pedagogoRepository.atualizarAtendimentoPedagogico(codigoPedagogo);
                if (ehPedagogo) {
                    System.out.println("Relação de códigos dos alunos");
                    alunoRepository.imprimirCodigosAlunos();
                    Long codigoAluno = display.solicitarCodigoAluno();
                    alunoRepository.atualizarAtendimentoPedagogico(codigoAluno);
                    alunoRepository.atualizarSituacaoAluno(codigoAluno, SituacaoMatriculaAluno.valueOf("ATENDIMENTO_PEDAGOGICO"));
                }
                display.voltarParaMenu();
                break;
            case RELATORIO_PESSOA:
                display.exibirOpcoesRelatorioPessoas();
                int codigoOpcao = display.obterCategoriaPessoa();
                display.exibirCabecalhoListagemPessoa();
                if (codigoOpcao == 1 | codigoOpcao == 4) {
                    alunoRepository.imprimirAlunos();
                }
                if (codigoOpcao == 2 | codigoOpcao == 4) {
                    professorRepository.imprimirProfessores();
                }
                if (codigoOpcao == 3 | codigoOpcao == 4) {
                    pedagogoRepository.imprimirPedagogos();
                }
                display.voltarParaMenu();
                break;
            case RELATORIO_ALUNO:
                display.exibirOpcoesRelatorioAlunos();
                alunoRepository.imprimirRelatorio(display.obterSituacaoMatricula());
                display.voltarParaMenu();
                break;
            case RELATORIO_PROFESSOR:
                display.exibirOpcoesRelatorioProfessor();
                professorRepository.imprimirRelatorio(display.obterExperienciaProfessor());
                display.voltarParaMenu();
                break;
            case ATENDIMENTO_PEDAGOGICO_ALUNO:
                alunoRepository.imprimirRelatorioAtendimentos();
                display.voltarParaMenu();
                break;
            case ATENDIMENTO_PEDAGOGICO_PEDAGOGO:
                pedagogoRepository.imprimirRelatorioAtendimentos();
                display.voltarParaMenu();
                break;
            }
        }
    }



