package Application.tests

import Application.model.ListaDeCandidatos
import Application.model.PessoaFisicaRepository
import org.junit.Test

import static org.junit.Assert.*


class TestListaDeCandidatos {
    @Test
    void testCriarCandidato() {
        ListaDeCandidatos listaCandidatos = new ListaDeCandidatos([])
        PessoaFisicaRepository pessoa = new PessoaFisicaRepository("a", "b", "c", 15, "e", "f", "g", ["Python": "Avançado"])
        PessoaFisicaRepository novaPessoa = listaCandidatos.criarCandidato(pessoa)
        assertSame(novaPessoa, pessoa)
    }

    @Test
    void testGetCandidato() {
        PessoaFisicaRepository pessoa = new PessoaFisicaRepository("a", "b", "c", 15, "e", "f", "g", ["Python": "Avançado"])
        ListaDeCandidatos listaCandidatos = new ListaDeCandidatos([pessoa])
        assertSame(listaCandidatos.getCandidato("a"), pessoa)
    }
}
