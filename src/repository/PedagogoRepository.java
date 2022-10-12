package repository;

import model.Aluno;
import model.Pedagogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedagogoRepository {

    private List<Pedagogo> pedagogos = new ArrayList<>();

    public void inserir(Pedagogo pedagogo) {
        this.pedagogos.add(pedagogo);
    }

    public List<Pedagogo> consultar() {
        return pedagogos;
    }

    public void imprimirPedagogos() {
        for (Pedagogo pedagogo : pedagogos) {
            System.out.printf("%-17s%-40s%-28s-%10s\n", pedagogo.getCodigo(), pedagogo.getNome(),
                    pedagogo.getCPF(),"pedagogo");
        }
    }

    public void atualizarAtendimentoPedagogico(Long codigoAluno) {
        for (Pedagogo pedagogo : pedagogos) {
            if (pedagogo.getCodigo() == codigoAluno) {
                int atendimento = pedagogo.getQtdadeAtendimentosPedagagicos();
                pedagogo.setQtdadeAtendimentosPedagagicos(atendimento + 1);
            }
        }
    }

    public void imprimirRelatorioAtendimentos() {
        Collections.sort(pedagogos);
        System.out.printf("%-17s%-40s%-24s\n","CÓDIGO DO PEDAGOGO","NOME DO PEDAGOGO",
                "ATENDIMENTOS PEDAGÓGICOS");
        System.out.printf("%-17s%-40s%-24s\n","---------------","--------------------------------------"
                ,"------------------------");
        for (Pedagogo pedagogo:pedagogos) {
            System.out.printf("%-17s%-40s%-24d\n",pedagogo.getCodigo(),pedagogo.getNome(),
                    pedagogo.getQtdadeAtendimentosPedagagicos());

        }
    }
}