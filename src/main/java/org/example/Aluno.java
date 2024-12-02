package org.example;
// Classe Aluno que estende a classe Usuario
public class Aluno extends Usuario {
    // Atributo que representa a turma do aluno
    private String turma;

    // Construtor da classe Aluno
    public Aluno(String nome, String email, String senha, String turma) {
        // Chama o construtor da classe pai (Usuario)
        super(nome, email, senha);
        // Valida o parâmetro turma
        if (turma == null || turma.isEmpty()) {
            throw new IllegalArgumentException("Turma não pode ser nula ou vazia");
        }
        // Inicializa o atributo turma
        this.turma = turma;
    }

    // Método de login do aluno

    @Override
    public void login() {
        if (getSenha() == null || getSenha().isEmpty()) {
            throw new IllegalStateException("Não é possível fazer login: senha não pode ser nula ou vazia");
        }
        System.out.println("Aluno " + getNome() + " logado");
    }

    // Método que realiza o logout do aluno
    @Override
    public void logout() {
        System.out.println("Aluno " + getNome() + " deslogado");
    }

    // Método que atualiza o perfil do aluno
    @Override
    public void atualizarPerfil() {
        if (getEmail() == null || getEmail().isEmpty()) {
            throw new IllegalStateException("Não é possível atualizar o perfil: email não pode ser nulo ou vazio");
        }
        System.out.println("Perfil do aluno " + getNome() + " atualizado");
    }

    public void estudar() {
        System.out.println("Aluno " + getNome() + " está estudando");
    }

    public void enviarProjeto() {
        System.out.println("Aluno " + getNome() + " enviou um projeto");
    }

    public String getTurma() {
        return turma;
    }

    @Override
    public String toString() {
        return super.toString() + "; Turma: " + turma;
    }
}