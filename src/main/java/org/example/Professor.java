package org.example;

// Classe Professor que estende a classe Usuario
public class Professor extends Usuario {
    // Atributo que representa o departamento do professor
    private String departamento;

    // Construtor da classe Professor
    public Professor(String nome, String email, String senha, String departamento) {
        // Chama o construtor da classe pai (Usuario)
        super(nome, email, senha);
        // Inicializa o atributo departamento
        this.departamento = departamento;
    }

    // Método que realiza o login do professor
    @Override
    public void login() {
        System.out.println("Professor " + getNome() + " logado");
    }

    // Método que realiza o logout do professor
    @Override
    public void logout() {
        System.out.println("Professor " + getNome() + " deslogado");
    }

    // Método que atualiza o perfil do professor
    @Override
    public void atualizarPerfil() {
        System.out.println("Perfil do professor " + getNome() + " atualizado");
    }

    // Método que simula a publicação de conteúdo pelo professor
    public void publicarConteudo() {
        System.out.println("Professor " + getNome() + " publicou conteúdo");
    }

    // Método que simula a avaliação de um exercício pelo professor
    public void avaliarExercicio() {
        System.out.println("Professor " + getNome() + " avaliou um exercício");
    }

    // Método que simula a avaliação de um projeto pelo professor
    public void avaliarProjeto() {
        System.out.println("Professor " + getNome() + " avaliou um projeto");
    }

    // Método que simula a publicação de feedback pelo professor
    public void publicarFeedback() {
        System.out.println("Professor " + getNome() + " publicou feedback");
    }

    // Método que retorna uma representação em String do objeto Professor
    @Override
    public String toString() {
        // Chama o método toString da classe pai e adiciona o departamento
        return super.toString() + ";" + "Departamento: " + departamento;
    }
}
