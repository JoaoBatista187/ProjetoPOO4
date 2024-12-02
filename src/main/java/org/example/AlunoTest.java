package org.example;

import org.example.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {
    private Aluno aluno;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno("João", "joao@example.com", "senha123", "Turma A");
    }

    @Test
    public void testLoginComSenhaValida() {
        try {
            aluno.login();
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }

    @Test
    public void testAtualizarPerfilComEmailValido() {
        try {
            aluno.atualizarPerfil();
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }

    @Test
    public void testConstrutorComTurmaValida() {
        try {
            new Aluno("Maria", "maria@example.com", "senha456", "Turma B");
        } catch (Exception e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }

    @Test
    public void testConstrutorComTurmaNula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno("Maria", "maria@example.com", "senha456", null));
        assertEquals("Turma não pode ser nula ou vazia", exception.getMessage());
    }

    @Test
    public void testConstrutorComTurmaVazia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Aluno("Maria", "maria@example.com", "senha456", ""));
        assertEquals("Turma não pode ser nula ou vazia", exception.getMessage());
    }

}

