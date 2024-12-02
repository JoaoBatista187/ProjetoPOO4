import org.example.DesempenhoAluno;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Classe de teste para a classe DesempenhoAluno
public class DesempenhoAlunoTest {
    // Atributo que representa o desempenho de um aluno a ser testado
    private DesempenhoAluno desempenho;

    // Método que é executado antes de cada teste, inicializando um objeto DesempenhoAluno
    @BeforeEach
    public void setUp() {
        desempenho = new DesempenhoAluno(12345); // Inicializa o desempenho com uma matrícula de exemplo
    }

    // Testa o método getMatriculaAluno
    @Test
    public void testGetMatriculaAluno() {
        assertEquals(12345, desempenho.getMatriculaAluno()); // Verifica se a matrícula retornada é a esperada
    }

    // Testa o método atualizarProgresso
    @Test
    public void testAtualizarProgresso() {
        desempenho.atualizarProgresso("POO", 80.0); // Atualiza o progresso na disciplina POO
        assertEquals(80.0, desempenho.getProgresso("POO"), 0.01); // Verifica se o progresso foi atualizado corretamente
    }

    // Testa o método registrarNota
    @Test
    public void testRegistrarNota() {
        desempenho.registrarNota("POO", 9.0); // Registra uma nota na disciplina POO
        assertEquals(9.0, desempenho.getNota("POO"), 0.01); // Verifica se a nota foi registrada corretamente
    }

    // Testa o método getNota para uma nota não registrada
    @Test
    public void testGetNotaNaoRegistrada() {
        assertEquals(-1.0, desempenho.getNota("POO"), 0.01); // Verifica se a nota não registrada retorna -1.0
    }

    // Testa o método atualizarProgresso com um valor inválido
    @Test
    public void testAtualizarProgressoInvalido() {
        // Verifica se uma IllegalArgumentException é lançada ao passar um progresso inválido
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            desempenho.atualizarProgresso("POO", 150.0); // Deve lançar exceção
        });
        assertEquals("Progresso deve estar entre 0 e 100.", exception.getMessage()); // Verifica a mensagem da exceção
    }

    // Testa o método registrarNota com uma nota inválida
    @Test
    public void testRegistrarNotaInvalida() {
        // Verifica se uma IllegalArgumentException é lançada ao passar uma nota inválida
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            desempenho.registrarNota("POO", 11.0); // Deve lançar exceção
        });
        assertEquals("Nota deve estar entre 0 e 10.", exception.getMessage()); // Verifica a mensagem da exceção
    }
}