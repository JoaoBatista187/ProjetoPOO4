package org.example;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

// Classe responsável por operações de leitura e escrita em arquivos
public class Arquivo {

    // Método para salvar uma lista de alunos em um arquivo
    public static void salvarAlunos(List<Aluno> alunos, String caminhoArquivo) {
        // Tenta abrir um BufferedWriter para escrever no arquivo especificado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            // Itera sobre a lista de alunos
            for (Aluno aluno : alunos) {
                // Escreve a representação em string do aluno no arquivo
                writer.write(aluno.toString());
                writer.newLine(); // Adiciona uma nova linha após cada aluno
            }
            System.out.println("Alunos salvos com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            // Captura e trata exceções de entrada/saída
            System.out.println("Erro ao salvar alunos no arquivo: " + caminhoArquivo);
            e.printStackTrace(); // Imprime a stack trace do erro
        }
    }

    // Método para salvar uma lista de professores em um arquivo
    public static void salvarProfessores(List<Professor> professores, String caminhoArquivo) {
        // Tenta abrir um BufferedWriter para escrever no arquivo especificado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            // Itera sobre a lista de professores
            for (Professor professor : professores) {
                // Escreve a representação em string do professor no arquivo
                writer.write(professor.toString());
                writer.newLine(); // Adiciona uma nova linha após cada professor
            }
            System.out.println("Professores salvos com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            // Captura e trata exceções de entrada/saída
            System.out.println("Erro ao salvar professores no arquivo: " + caminhoArquivo);
            e.printStackTrace(); // Imprime a stack trace do erro
        }
    }

    // Método para exibir o conteúdo de um arquivo no console
    public static void exibirArquivo(String caminhoArquivo) {
        // Tenta abrir um BufferedReader para ler o arquivo especificado
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            // Lê o arquivo linha por linha
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha); // Imprime cada linha no console
            }
        } catch (IOException e) {
            // Captura e trata exceções de entrada/saída
            e.printStackTrace(); // Imprime a stack trace do erro
        }
    }
}
