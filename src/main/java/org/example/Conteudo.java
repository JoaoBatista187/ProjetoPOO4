package org.example;

import java.util.Date;

// Classe que representa um conteúdo com título, descrição e data de publicação
public class Conteudo {
    // Atributo que armazena o título do conteúdo
    private String titulo;

    // Atributo que armazena a descrição do conteúdo
    private String descricao;

    // Atributo que armazena a data de publicação do conteúdo
    private Date dataPublicacao;

    // Construtor da classe Conteudo
    public Conteudo(String titulo, String descricao, Date dataPublicacao) {
        // Inicializa os atributos com os valores fornecidos
        setTitulo(titulo); // Usar o método set para validação
        setDescricao(descricao); // Usar o método set para validação
        setDataPublicacao(dataPublicacao); // Usar o método set para validação
    }

    // Método que exibe as informações do conteúdo
    public void visualizarConteudo() {
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Publicação: " + dataPublicacao); // Exibe a data sem formatação
    }

    // Método que retorna o título do conteúdo
    public String getTitulo() {
        return titulo;
    }

    // Método que define um novo título para o conteúdo
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
        }
        this.titulo = titulo;
    }

    // Método que retorna a descrição do conteúdo
    public String getDescricao() {
        return descricao;
    }

    // Método que define uma nova descrição para o conteúdo
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia.");
        }
        this.descricao = descricao;
    }

    // Método que retorna a data de publicação do conteúdo
    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    // Método que define uma nova data de publicação para o conteúdo
    public void setDataPublicacao(Date dataPublicacao) {
        if (dataPublicacao == null) {
            throw new IllegalArgumentException("Data de publicação não pode ser nula.");
        }
        this.dataPublicacao = dataPublicacao;
    }

    // Método que retorna uma representação em String do objeto Conteudo
    @Override
    public String toString() {
        return "Conteudo{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataPublicacao=" + dataPublicacao + // Exibe a data sem formatação
                '}';
    }
}