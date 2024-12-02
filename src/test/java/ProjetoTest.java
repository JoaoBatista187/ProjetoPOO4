import org.example.Projeto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ProjetoTest {
    private Projeto projeto;
    private Date dataPublicacao;
    private Date dataEntrega;

    @BeforeEach
    public void setUp() {
        dataPublicacao = new Date(); // Data atual
        dataEntrega = new Date(dataPublicacao.getTime() + 86400000); // 1 dia depois
        projeto = new Projeto("Projeto de Teste", "Descrição do projeto", dataPublicacao, dataEntrega);
    }

    @Test
    public void testEnviarProjeto() {
        // O método enviarProjeto apenas imprime uma mensagem, então não há retorno para verificar.
        assertDoesNotThrow(() -> projeto.enviarProjeto());
    }

    @Test
    public void testGetDataEntrega() {
        assertEquals(dataEntrega, projeto.getDataEntrega());
    }

    @Test
    public void testSetDataEntrega() {
        Date novaDataEntrega = new Date(dataPublicacao.getTime() + 172800000); // 2 dias depois
        projeto.setDataEntrega(novaDataEntrega);
        assertEquals(novaDataEntrega, projeto.getDataEntrega());
    }

    @Test
    public void testGetFeedbackProf() {
        assertNull(projeto.getFeedbackProf()); // Inicialmente deve ser nulo
    }

    @Test
    public void testSetFeedbackProf() {
        String feedback = "Bom trabalho!";
        projeto.setFeedbackProf(feedback);
        assertEquals(feedback, projeto.getFeedbackProf());
    }

    @Test
    public void testVisualizarConteudo() {
        // O método visualizarConteudo imprime informações, então não há retorno para verificar.
        assertDoesNotThrow(() -> projeto.visualizarConteudo());
    }
}