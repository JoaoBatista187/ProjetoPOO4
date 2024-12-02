import org.example.Conteudo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

// Classe de teste para a classe Conteudo
public class ConteudoTest {
    // Atributo que representa um conteúdo a ser testado
    private Conteudo conteudo;

    // Método que é executado antes de cada teste, inicializando um objeto Conteudo
    @BeforeEach
    public void setUp() {
        conteudo = new Conteudo("Título de Teste", "Descrição de Teste", new Date());
    }

    // Testa o método getTitulo
    @Test
    public void testGetTitulo() {
        assertEquals("Título de Teste", conteudo.getTitulo()); // Verifica se o título retornado é o esperado
    }

    // Testa o método setTitulo
    @Test
    public void testSetTitulo() {
        conteudo.setTitulo("Novo Título"); // Atualiza o título
        assertEquals("Novo Título", conteudo.getTitulo()); // Verifica se o título foi atualizado corretamente
    }

    // Testa o método getDescricao
    @Test
    public void testGetDescricao() {
        assertEquals("Descrição de Teste", conteudo.getDescricao()); // Verifica se a descrição retornada é a esperada
    }

    // Testa o método setDescricao
    @Test
    public void testSetDescricao() {
        conteudo.setDescricao("Nova Descrição"); // Atualiza a descrição
        assertEquals("Nova Descrição", conteudo.getDescricao()); // Verifica se a descrição foi atualizada corretamente
    }

    // Testa o método getDataPublicacao
    @Test
    public void testGetDataPublicacao() {
        assertNotNull(conteudo.getDataPublicacao()); // Verifica se a data de publicação não é nula
    }

    // Testa o método setDataPublicacao
    @Test
    public void testSetDataPublicacao() {
        Date novaData = new Date(System.currentTimeMillis() + 86400000); // Um dia no futuro
        conteudo.setDataPublicacao(novaData); // Atualiza a data de publicação
        assertEquals(novaData, conteudo.getDataPublicacao()); // Verifica se a data foi atualizada corretamente
    }

    // Testa o método visualizarConteudo
    @Test
    public void testVisualizarConteudo() {
        // Este teste não pode ser verificado diretamente, mas você pode verificar se não lança exceções
        assertDoesNotThrow(() -> conteudo.visualizarConteudo()); // Verifica se o método não lança exceções
    }

    // Testa o método toString
    @Test
    public void testToString() {
        String expected = "Conteudo{titulo='Título de Teste', descricao='Descrição de Teste', dataPublicacao=" + conteudo.getDataPublicacao() + "}";
        assertTrue(conteudo.toString().contains("Título de Teste")); // Verifica se a representação em String contém o título
        assertTrue(conteudo.toString().contains("Descrição de Teste")); // Verifica se a representação em String contém a descrição
    }
}