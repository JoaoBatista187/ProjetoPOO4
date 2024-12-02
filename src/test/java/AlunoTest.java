import org.example.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Classe de teste para a classe Aluno
public class AlunoTest {
    // Atributo que representa um aluno a ser testado
    private Aluno aluno;

    // Método que é executado antes de cada teste, inicializando um objeto Aluno
    @BeforeEach
    public void setUp() {
        aluno = new Aluno("João", "joao@example.com", "senha123", "Turma A");
    }

    // Testa o método login com uma senha válida
    @Test
    public void testLoginComSenhaValida() {
        try {
            aluno.login(); // Tenta realizar o login
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage()); // Falha se uma exceção for lançada
        }
    }

    // Testa o método atualizarPerfil com um email válido
    @Test
    public void testAtualizarPerfilComEmailValido() {
        try {
            aluno.atualizarPerfil(); // Tenta atualizar o perfil
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage()); // Falha se uma exceção for lançada
        }
    }

    // Testa o construtor da classe Aluno com uma turma válida
    @Test
    public void testConstrutorComTurmaValida() {
        try {
            new Aluno("Maria", "maria@example.com", "senha456", "Turma B"); // Tenta criar um novo aluno
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage()); // Falha se uma exceção for lançada
        }
    }

    // Testa o construtor da classe Aluno com uma turma nula
    @Test
    public void testConstrutorComTurmaNula() {
        // Verifica se uma IllegalArgumentException é lançada ao passar uma turma nula
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno("Maria", "maria@example.com", "senha456", null));
        assertEquals("Turma não pode ser nula ou vazia", exception.getMessage()); // Verifica a mensagem da exceção
    }

    // Testa o construtor da classe Aluno com uma turma vazia
    @Test
    public void testConstrutorComTurmaVazia() {
        // Verifica se uma IllegalArgumentException é lançada ao passar uma turma vazia
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno("Maria", "maria@example.com", "senha456", ""));
        assertEquals("Turma não pode ser nula ou vazia", exception.getMessage()); // Verifica a mensagem da exceção
    }
}