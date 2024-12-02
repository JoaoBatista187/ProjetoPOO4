package org.example;

import java.util.Date;

// Classe Projeto que estende a classe Conteudo
public class Projeto extends Conteudo {
    // Atributo que armazena a data de entrega do projeto
    private Date dataEntrega;

    // Atributo que armazena o feedback do professor sobre o projeto
    private String feedbackProf;

    // Construtor da classe Projeto
    public Projeto(String titulo, String descricao, Date dataPublicacao, Date dataEntrega) {
        // Chama o construtor da classe pai (Conteudo)
        super(titulo, descricao, dataPublicacao);
        // Inicializa o atributo dataEntrega
        this.dataEntrega = dataEntrega;
    }

    // Método que simula o envio do projeto
    public void enviarProjeto() {
        System.out.println("Projeto '" + getTitulo() + "' enviado com sucesso!");
    }

    // Método que retorna a data de entrega do projeto
    public Date getDataEntrega() {
        return dataEntrega;
    }

    // Método que define uma nova data de entrega para o projeto
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    // Método que retorna o feedback do professor
    public String getFeedbackProf() {
        return feedbackProf;
    }

    // Método que define um novo feedback do professor para o projeto
    public void setFeedbackProf(String feedbackProf) {
        this.feedbackProf = feedbackProf;
    }

    // Método que exibe as informações do projeto, incluindo as informações da classe pai
    @Override
    public void visualizarConteudo() {
        // Chama o método visualizarConteudo da classe pai
        super.visualizarConteudo();
        // Exibe a data de entrega do projeto
        System.out.println("Data de Entrega: " + dataEntrega);
        // Exibe o feedback do professor, se disponível
        if (feedbackProf != null) {
            System.out.println("Feedback do Professor: " + feedbackProf);
        }
    }
}
