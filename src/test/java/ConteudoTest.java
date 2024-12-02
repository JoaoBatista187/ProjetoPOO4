import org.example.Conteudo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ConteudoTest {
    private Conteudo conteudo;

    @BeforeEach
    public void setUp() {
        conteudo = new Conteudo("Título de Teste", "Descrição de Teste", new Date());
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Título de Teste", conteudo.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        conteudo.setTitulo("Novo Título");
        assertEquals("Novo Título", conteudo.getTitulo());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Descrição de Teste", conteudo.getDescricao());
    }

    @Test
    public void testSetDescricao() {
        conteudo.setDescricao("Nova Descrição");
        assertEquals("Nova Descrição", conteudo.getDescricao());
    }

    @Test
    public void testGetDataPublicacao() {
        assertNotNull(conteudo.getDataPublicacao()); // Verifica se a data não é nula
    }

    @Test
    public void testSetDataPublicacao() {
        Date novaData = new Date(System.currentTimeMillis() + 86400000); // Um dia no futuro
        conteudo.setDataPublicacao(novaData);
        assertEquals(novaData, conteudo.getDataPublicacao());
    }

    @Test
    public void testVisualizarConteudo() {
        // Este teste não pode ser verificado diretamente, mas você pode verificar se não lança exceções
        assertDoesNotThrow(() -> conteudo.visualizarConteudo());
    }

    @Test
    public void testToString() {
        String expected = "Conteudo{titulo='Título de Teste', descricao='Descrição de Teste', dataPublicacao=" + conteudo.getDataPublicacao() + "}";
        assertTrue(conteudo.toString().contains("Título de Teste"));
        assertTrue(conteudo.toString().contains("Descrição de Teste"));
    }
}