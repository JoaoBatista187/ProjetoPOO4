package org.example;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

// Classe principal que inicia a aplicação
public class Main {
    public static void main(String[] args) {
        // Criação de alunos
        Aluno aluno1 = new Aluno("Eduardo", "edu@gmail.com", "1234", "B");
        Aluno aluno2 = new Aluno("João", "jão@gmail.com", "12334", "B");

        // Lista de alunos
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);

        // Salva os alunos em um arquivo e exibe o conteúdo
        Arquivo.salvarAlunos(alunos, "ArquivodeAlunos");
        Arquivo.exibirArquivo("ArquivodeAlunos");

        // Criação de professores
        Professor professor1 = new Professor("Ana Costa", "ana@gmail.com", "34362436", "Matemática");
        Professor professor2 = new Professor("Carlos Pereira", "carlos@gmail.com", "35343263", "História");

        // Lista de professores
        List<Professor> professores = new ArrayList<>();
        professores.add(professor1);
        professores.add(professor2);

        // Salva os professores em um arquivo e exibe o conteúdo
        Arquivo.salvarProfessores(professores, "ArquivodeProfessores");
        Arquivo.exibirArquivo("ArquivodeProfessores");

        // Simulação de login e atividades dos alunos
        aluno1.login();
        aluno2.login();

        aluno1.estudar();
        aluno1.enviarProjeto();
        aluno2.estudar();
        aluno2.enviarProjeto();

        aluno1.atualizarPerfil();
        aluno2.atualizarPerfil();

        // Simulação de login e atividades dos professores
        professor1.login();
        professor2.login();

        professor1.publicarConteudo();
        professor1.avaliarExercicio();
        professor2.publicarConteudo();
        professor2.avaliarExercicio();

        // Criação de conteúdo e projeto
        Conteudo conteudoMatematica = new Conteudo("Introdução à Matemática", "Conceitos básicos de Matemática.", new Date());
        Projeto projetoHistoria = new Projeto("Projeto de História", "Pesquisa sobre a Revolução Francesa.", new Date(), new Date());

        // Visualização do conteúdo e projeto
        conteudoMatematica.visualizarConteudo();
        projetoHistoria.visualizarConteudo();

        // Envio do projeto
        projetoHistoria.enviarProjeto();

        // Criação e registro de desempenho do aluno
        DesempenhoAluno desempenhoAluno1 = new DesempenhoAluno(12345);
        desempenhoAluno1.registrarNota("Matemática", 8.0);
        desempenhoAluno1.registrarNota("História", 9.5);
        desempenhoAluno1.atualizarProgresso("Matemática", 75.0);
        desempenhoAluno1.atualizarProgresso("História", 80.0);

        // Geração de resumo de desempenho
        System.out.println(desempenhoAluno1.gerarResumoDesempenho());

        // Avaliação do desempenho do aluno
        Desempenho desempenho1 = desempenhoAluno1.avaliarDesempenho();
        System.out.println("Desempenho do aluno 1: " + desempenho1);

        // Criação de grupo de estudo
        Grupo grupoEstudo = new Grupo("Grupo de Estudo de História");
        grupoEstudo.adicionarAluno(aluno1);
        grupoEstudo.adicionarAluno(aluno2);
        grupoEstudo.adicionarProfessor(professor1);
        grupoEstudo.adicionarProfessor(professor2);

        // Adição de mensagens ao grupo de estudo
        grupoEstudo.adicionarMensagem("Reunião do grupo na sexta-feira às 18h.");
        grupoEstudo.adicionarMensagem("Lembrete: prazo do projeto de História é na próxima semana.");

        // Listagem de mensagens do grupo
        grupoEstudo.listarMensagens();

        // Logout dos alunos e professores
        aluno1.logout();
        aluno2.logout();
        professor1.logout();
        professor2.logout();

    }
}


