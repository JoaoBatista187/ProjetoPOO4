package org.example;

// Classe Aluno que estende a classe Usuario
public class Aluno extends Usuario {
    // Atributo que representa a turma do aluno
    private String turma;

    // Construtor da classe Aluno
    public Aluno(String nome, String email, String senha, String turma) {
        // Chama o construtor da classe pai (Usuario)
        super(nome, email, senha);
        // Inicializa o atributo turma
        this.turma = turma;
    }

    // Método que realiza o login do aluno
    @Override
    public void login() {
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
        System.out.println("Perfil do aluno " + getNome() + " atualizado");
    }

    // Método que simula o ato de estudar
    public void estudar() {
        System.out.println("Aluno " + getNome() + " está estudando");
    }

    // Método que simula o envio de um projeto
    public void enviarProjeto() {
        System.out.println("Aluno " + getNome() + " enviou um projeto");
    }

    // Método que retorna uma representação em String do objeto Aluno
    @Override
    public String toString() {
        // Chama o método toString da classe pai e adiciona a turma
        return super.toString() + ";" + "Turma: " + turma;
    }
}
