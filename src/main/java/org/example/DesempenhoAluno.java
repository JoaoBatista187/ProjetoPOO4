package org.example;

import java.util.HashMap;
import java.util.Map;

// Classe que representa o desempenho de um aluno em diferentes conteúdos
public class DesempenhoAluno {
    // Atributo que armazena a matrícula do aluno
    private int matriculaAluno;

    // Mapa que armazena o progresso do aluno em cada conteúdo (chave: nome do conteúdo, valor: progresso em %)
    private Map<String, Double> progressoConteudos;

    // Mapa que armazena as notas do aluno em cada conteúdo (chave: nome do conteúdo, valor: nota)
    private Map<String, Double> notasConteudos;

    // Construtor da classe DesempenhoAluno
    public DesempenhoAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
        this.progressoConteudos = new HashMap<>();
        this.notasConteudos = new HashMap<>();
    }

    // Método que retorna a matrícula do aluno
    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    // Método que define uma nova matrícula para o aluno
    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    // Método que atualiza o progresso do aluno em um conteúdo específico
    public void atualizarProgresso(String conteudo, double progresso) {
        try {
            // Verifica se o progresso está dentro do intervalo permitido
            if (progresso < 0 || progresso > 100) {
                throw new IllegalArgumentException("Progresso deve estar entre 0 e 100.");
            }
            progressoConteudos.put(conteudo, progresso);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar progresso: " + e.getMessage());
        }
    }

    // Método que retorna o progresso do aluno em um conteúdo específico
    public double getProgresso(String conteudo) {
        return progressoConteudos.getOrDefault(conteudo, 0.0);
    }

    // Método que registra a nota do aluno em um conteúdo específico
    public void registrarNota(String conteudo, double nota) {
        try {
            // Verifica se a nota está dentro do intervalo permitido
            if (nota < 0 || nota > 10) {
                throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
            }
            notasConteudos.put(conteudo, nota);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao registrar nota: " + e.getMessage());
        }
    }

    // Método que retorna a nota do aluno em um conteúdo específico
    public double getNota(String conteudo) {
        return notasConteudos.getOrDefault(conteudo, -1.0); // Retorna -1 se não houver nota
    }

    // Método que gera um resumo do desempenho do aluno
    public String gerarResumoDesempenho() {
        StringBuilder resumo = new StringBuilder();
        resumo.append("Matrícula: ").append(matriculaAluno).append("\n");
        resumo.append("Desempenho nos Conteúdos:\n");

        // Itera sobre os conteúdos para compor o resumo
        for (String conteudo : progressoConteudos.keySet()) {
            double progresso = progressoConteudos.get(conteudo);
            double nota = notasConteudos.getOrDefault(conteudo, -1.0);
            resumo.append("- ").append(conteudo)
                    .append(": Progresso = ").append(progresso).append("%");
            if (nota >= 0) {
                resumo.append(", Nota = ").append(nota);
            } else {
                resumo.append(", Nota = Não registrada");
            }
            resumo.append("\n");
        }
        return resumo.toString();
    }

    // Método que avalia o desempenho do aluno com base nas notas registradas
    public Desempenho avaliarDesempenho() {
        double somaNotas = 0.0;
        int totalConteudos = notasConteudos.size();

        // Se não houver conteúdos, considera o desempenho como MEDIO
        if (totalConteudos == 0) {
            return Desempenho.MEDIO;
        }

        // Calcula a soma das notas
        for (double nota : notasConteudos.values()) {
            somaNotas += nota;
        }

        // Calcula a média das notas
        double mediaNotas = somaNotas / totalConteudos;

        // Avalia o desempenho com base na média das notas
        if (mediaNotas >= 9) {
            return Desempenho.EXCELENTE;
        } else if (mediaNotas >= 7) {
            return Desempenho.OTIMO;
        } else if (mediaNotas >= 5) {
            return Desempenho.BOM;
        } else if (mediaNotas >= 3) {
            return Desempenho.MEDIO;
        } else {
            return Desempenho.RUIM;
        }
    }
}
