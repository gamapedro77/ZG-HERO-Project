package Application.tests

import Application.model.ListaDeCandidatos
import Application.model.PessoaFisica
import org.junit.Test

import static org.junit.Assert.*


class TestListaDeCandidatos {
    @Test
    void testCriarCandidato() {
        ListaDeCandidatos listaCandidatos = new ListaDeCandidatos([])
        PessoaFisica pessoa = new PessoaFisica("a", "b", "c", 15, "e", "f", "g", ["Python": "Avançado"])
        PessoaFisica novaPessoa = listaCandidatos.criarCandidato(pessoa)
        assertSame(novaPessoa, pessoa)
    }

    @Test
    void testGetCandidato() {
        PessoaFisica pessoa = new PessoaFisica("a", "b", "c", 15, "e", "f", "g", ["Python": "Avançado"])
        ListaDeCandidatos listaCandidatos = new ListaDeCandidatos([pessoa])
        assertSame(listaCandidatos.getCandidato("a"), pessoa)
    }
}
