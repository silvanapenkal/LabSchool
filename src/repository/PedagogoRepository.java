package repository;

import cli.Display;
import model.Pedagogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedagogoRepository {

    private List<Pedagogo> pedagogos = new ArrayList<>();
    private Display display = new Display();

    public void inserir(Pedagogo pedagogo) {
        this.pedagogos.add(pedagogo);
    }

    public void imprimirPedagogos() {
        for (Pedagogo pedagogo : pedagogos) {
            System.out.printf("%-17s%-40s%011d   %-23s\n", pedagogo.getCodigo(), pedagogo.getNome(),
                    pedagogo.getCPF(),"pedagogo");
        }
    }

    public void imprimirCodigosPedagogos() {
        for (Pedagogo pedagogo : pedagogos) {
            System.out.printf("%-17s%-40s\n", pedagogo.getCodigo(), pedagogo.getNome());
        }
    }

    public Boolean atualizarAtendimentoPedagogico(Long codigoPedagogo) {
        Boolean ehPedagogo = false;
        for (Pedagogo pedagogo : pedagogos) {
            if (pedagogo.getCodigo() == codigoPedagogo) {
                int atendimento = pedagogo.getQtdadeAtendimentosPedagagicos();
                pedagogo.setQtdadeAtendimentosPedagagicos(atendimento + 1);
                ehPedagogo = true;
                System.out.println("Nome do Pedagogo: " + pedagogo.getNome());
            }
        }
        if (!ehPedagogo) {
            System.out.println("O atendimento não foi cadastrado porque não existe um pedagogo cadastrado com esse código.");
        }
        return ehPedagogo;
    }

    public void imprimirRelatorioAtendimentos() {
        display.exibirCabecalhoAtendimentoPedagogo();
        List<Pedagogo> pedagogosPorQtidadeAtendimento = new ArrayList<>(pedagogos);
        Collections.sort(pedagogosPorQtidadeAtendimento);
        for (Pedagogo pedagogo:pedagogosPorQtidadeAtendimento) {
            System.out.printf("%-17s%-40s%-24d\n",pedagogo.getCodigo(),pedagogo.getNome(),
                    pedagogo.getQtdadeAtendimentosPedagagicos());
        }
    }
}
