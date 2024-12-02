package org.example;

import java.util.ArrayList;
import java.util.List;

// Classe que representa um grupo de alunos e professores
public class Grupo {
    // Atributo que armazena o nome do grupo
    private String nomeGrupo;

    // Lista que armazena as mensagens enviadas no grupo
    private List<String> mensagens = new ArrayList<>();

    // Lista que armazena os alunos do grupo
    private List<Aluno> alunos = new ArrayList<>();

    // Lista que armazena os professores do grupo
    private List<Professor> professores = new ArrayList<>();

    // Construtor da classe Grupo
    public Grupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    // Método que adiciona um aluno ao grupo
    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado ao grupo " + nomeGrupo);
        } else {
            System.out.println("Aluno " + aluno.getNome() + " já está no grupo " + nomeGrupo);
        }
    }

    // Método que remove um aluno do grupo
    public void removerAluno(Aluno aluno) {
        if (alunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " removido do grupo " + nomeGrupo);
        } else {
            System.out.println("Aluno " + aluno.getNome() + " não encontrado no grupo " + nomeGrupo);
        }
    }

    // Método que adiciona um professor ao grupo
    public void adicionarProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            professores.add(professor);
            System.out.println("Professor " + professor.getNome() + " adicionado ao grupo " + nomeGrupo);
        } else {
            System.out.println("Professor " + professor.getNome() + " já está no grupo " + nomeGrupo);
        }
    }

    // Método que remove um professor do grupo
    public void removerProfessor(Professor professor) {
        if (professores.remove(professor)) {
            System.out.println("Professor " + professor.getNome() + " removido do grupo " + nomeGrupo);
        } else {
            System.out.println("Professor " + professor.getNome() + " não encontrado no grupo " + nomeGrupo);
        }
    }

    // Método que adiciona uma mensagem ao grupo
    public void adicionarMensagem(String mensagem) {
        try {
            if (mensagem == null || mensagem.isEmpty()) {
                throw new IllegalArgumentException("Mensagem não pode ser vazia ou nula.");
            }
            mensagens.add(mensagem);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar mensagem: " + e.getMessage());
        }
    }

    // Método que remove uma mensagem do grupo
    public void removerMensagem(String mensagem) {
        try {
            if (!mensagens.contains(mensagem)) {
                throw new IllegalArgumentException("Mensagem não encontrada no grupo.");
            }
            mensagens.remove(mensagem);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao remover mensagem: " + e.getMessage());
        }
    }

    // Método que lista todas as mensagens do grupo
    public void listarMensagens() {
        System.out.println("Mensagens do grupo " + nomeGrupo + ":");
        for (String msg : mensagens) {
            System.out.println("- " + msg);
        }
    }

    // Método que retorna o nome do grupo
    public String getNomeGrupo() {
        return nomeGrupo;
    }

    // Método que define um novo nome para o grupo
    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    // Método que retorna a lista de mensagens do grupo
    public List<String> getMensagens() {
        return mensagens;
    }

    // Método que retorna a lista de alunos do grupo
    public List<Aluno> getAlunos() {
        return alunos;
    }

    // Método que retorna a lista de professores do grupo
    public List<Professor> getProfessores() {
        return professores;
    }

    // Método que retorna uma representação em String do objeto Grupo
    @Override
    public String toString() {
        return "Grupo: " + nomeGrupo + "\n" +
                "Alunos: " + alunos.size() + "\n" +
                "Professores: " + professores.size() + "\n" +
                "Mensagens: " + mensagens.size();
    }
}
