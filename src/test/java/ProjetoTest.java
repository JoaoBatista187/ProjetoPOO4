import org.example.Projeto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

// Classe de teste para a classe Projeto
public class ProjetoTest {
    // Atributo que representa um projeto a ser testado
    private Projeto projeto;
    private Date dataPublicacao; // Data de publicação do projeto
    private Date dataEntrega; // Data de entrega do projeto

    // Método que é executado antes de cada teste, inicializando um objeto Projeto
    @BeforeEach
    public void setUp() {
        dataPublicacao = new Date(); // Inicializa a data de publicação como a data atual
        dataEntrega = new Date(dataPublicacao.getTime() + 86400000); // Define a data de entrega como 1 dia depois
        projeto = new Projeto("Projeto de Teste", "Descrição do projeto", dataPublicacao, dataEntrega); // Cria um novo projeto
    }

    // Testa o método enviarProjeto
    @Test
    public void testEnviarProjeto() {
        // O método enviarProjeto apenas imprime uma mensagem, então não há retorno para verificar.
        assertDoesNotThrow(() -> projeto.enviarProjeto()); // Verifica se o método não lança exceções
    }

    // Testa o método getDataEntrega
    @Test
    public void testGetDataEntrega() {
        assertEquals(dataEntrega, projeto.getDataEntrega()); // Verifica se a data de entrega retornada é a esperada
    }

    // Testa o método setDataEntrega
    @Test
    public void testSetDataEntrega() {
        Date novaDataEntrega = new Date(dataPublicacao.getTime() + 172800000); // Define uma nova data de entrega (2 dias depois)
        projeto.setDataEntrega(novaDataEntrega); // Atualiza a data de entrega
        assertEquals(novaDataEntrega, projeto.getDataEntrega()); // Verifica se a nova data de entrega foi atualizada corretamente
    }

    // Testa o método getFeedbackProf
    @Test
    public void testGetFeedbackProf() {
        assertNull(projeto.getFeedbackProf()); // Verifica se o feedback do professor é nulo inicialmente
    }

    // Testa o método setFeedbackProf
    @Test
    public void testSetFeedbackProf() {
        String feedback = "Bom trabalho!"; // Define um feedback de exemplo
        projeto.setFeedbackProf(feedback); // Atualiza o feedback do professor
        assertEquals(feedback, projeto.getFeedbackProf()); // Verifica se o feedback foi atualizado corretamente
    }

    // Testa o método visualizarConteudo
    @Test
    public void testVisualizarConteudo() {
        // O método visualizarConteudo imprime informações, então não há retorno para verificar.
        assertDoesNotThrow(() -> projeto.visualizarConteudo()); // Verifica se o método não lança exceções
    }
}