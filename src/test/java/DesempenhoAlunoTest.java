import org.example.DesempenhoAluno;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DesempenhoAlunoTest {
    private DesempenhoAluno desempenho;

    @BeforeEach
    public void setUp() {
        desempenho = new DesempenhoAluno(12345);
    }

    @Test
    public void testGetMatriculaAluno() {
        assertEquals(12345, desempenho.getMatriculaAluno());
    }

    @Test
    public void testAtualizarProgresso() {
        desempenho.atualizarProgresso("POO", 80.0);
        assertEquals(80.0, desempenho.getProgresso("POO"), 0.01);
    }

    @Test
    public void testRegistrarNota() {
        desempenho.registrarNota("POO", 9.0);
        assertEquals(9.0, desempenho.getNota("POO"), 0.01);
    }

    @Test
    public void testGetNotaNaoRegistrada() {
        assertEquals(-1.0, desempenho.getNota("POO"), 0.01); // Nota não registrada
    }

    @Test
    public void testAtualizarProgressoInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            desempenho.atualizarProgresso("POO", 150.0); // Deve lançar exceção
        });
        assertEquals("Progresso deve estar entre 0 e 100.", exception.getMessage());
    }

    @Test
    public void testRegistrarNotaInvalida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            desempenho.registrarNota("POO", 11.0); // Deve lançar exceção
        });
        assertEquals("Nota deve estar entre 0 e 10.", exception.getMessage());
    }
}