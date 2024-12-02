package org.example;

// Classe abstrata que representa um usuário do sistema
public abstract class Usuario {
    // Atributo que armazena o nome do usuário
    private String nome;

    // Atributo que armazena o email do usuário
    private String email;

    // Atributo que armazena a senha do usuário
    private String senha;

    // Construtor da classe Usuario
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Método abstrato que deve ser implementado pelas subclasses para realizar o login
    public abstract void login();

    // Método abstrato que deve ser implementado pelas subclasses para realizar o logout
    public abstract void logout();

    // Método abstrato que deve ser implementado pelas subclasses para atualizar o perfil do usuário
    public abstract void atualizarPerfil();

    // Método que retorna o nome do usuário
    public String getNome() {
        return nome;
    }

    // Método que retorna o email do usuário
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método que retorna uma representação em String do objeto Usuario
    @Override
    public String toString() {
        return "Nome: " + nome + ";" + "Email: " + email + ";" + "Senha: " + senha;
    }
}
