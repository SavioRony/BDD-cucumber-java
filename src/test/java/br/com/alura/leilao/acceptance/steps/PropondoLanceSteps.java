package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropondoLanceSteps {
    private List<Lance> lances;
    private Leilao leilao;

    @Before
    public void setup(){
        lances = new ArrayList<>();
        leilao = new Leilao("Tablet XPTO");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("Fulano");
        Lance lance = new Lance(usuario, BigDecimal.TEN);
        lances.add(lance);
    }

    @Quando("propoe ao leilao")
    public void quando_propoe_o_lance() {
        lances.forEach(lance -> leilao.propoe(lance));
    }

    @Entao("o lance e aceito")
    public void entao_o_lance_e_aceito() {
        assertEquals(1, leilao.getLances().size());
        assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario(Double valor, String nomeUsuario) {
        Usuario usuario = new Usuario(nomeUsuario);
        Lance lance = new Lance(usuario, new BigDecimal(valor));
        lances.add(lance);
    }

    @Quando("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        lances.forEach(lance -> leilao.propoe(lance));
    }
    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        assertEquals(lances.size(), leilao.getLances().size());
        assertEquals(lances.get(0).getValor(), leilao.getLances().get(0).getValor());
        assertEquals(lances.get(1).getValor(), leilao.getLances().get(1).getValor());
    }
}
