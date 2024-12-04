package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SistemaPrincipal {

    // Listas para armazenar usuários e grupos em memória
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static final ArrayList<Grupo> grupos = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializando dados fictícios
        inicializarUsuarios();
        // Exibe a janela de login
        mostrarTelaLogin();
    }

    private static void inicializarUsuarios() {
        usuarios.add(new Usuario("Aluno", "aluno@gmail.com", "1234"));
        usuarios.add(new Usuario("Professor", "professor@gmail.com", "1234"));
    }

    private static void mostrarTelaLogin() {
        JFrame loginFrame = new JFrame("Login - Sistema de Grupos");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(800, 500);
        loginFrame.setLayout(new GridLayout(4, 2, 10, 10));
        loginFrame.setLocationRelativeTo(null);

        // Campos de entrada de login
        JLabel lblTipoUsuario = new JLabel("Tipo de Usuário:");
        String[] tipos = {"Aluno", "Professor"};
        JComboBox<String> cmbTipoUsuario = new JComboBox<>(tipos);

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        JLabel lblStatus = new JLabel("", SwingConstants.CENTER);

        // Adicionando os componentes ao frame
        loginFrame.add(lblTipoUsuario);
        loginFrame.add(cmbTipoUsuario);
        loginFrame.add(lblEmail);
        loginFrame.add(txtEmail);
        loginFrame.add(lblSenha);
        loginFrame.add(txtSenha);
        loginFrame.add(btnLogin);
        loginFrame.add(lblStatus);

        // Evento do botão de login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoUsuario = (String) cmbTipoUsuario.getSelectedItem();
                String email = txtEmail.getText();
                String senha = new String(txtSenha.getPassword());

                if (autenticarUsuario(tipoUsuario, email, senha)) {
                    JOptionPane.showMessageDialog(loginFrame, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    loginFrame.dispose(); // Fecha a janela de login
                    mostrarTelaGrupos(); // Abre a janela de grupos
                } else {
                    lblStatus.setText("Credenciais inválidas!");
                    lblStatus.setForeground(Color.RED);
                }
            }
        });

        // Exibir a janela
        loginFrame.setVisible(true);
    }

    private static boolean autenticarUsuario(String tipoUsuario, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.tipo.equals(tipoUsuario) && usuario.email.equals(email) && usuario.senha.equals(senha)) {
                return true;
            }
        }
        return false;
    }

    private static void mostrarTelaGrupos() {
        JFrame gruposFrame = new JFrame("Grupos de Estudo - Ementa do Curso");
        gruposFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gruposFrame.setSize(800, 500);
        gruposFrame.setLayout(new BorderLayout());
        gruposFrame.setLocationRelativeTo(null);

        // Painel superior para criar grupos
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblDisciplina = new JLabel("Disciplina:");
        String[] disciplinas = {
                "Programação Orientada a Objetos",
                "Autoria Web",
                "Engenharia de Software",
                "Extenção",
                "Finanças"
        };
        JComboBox<String> cmbDisciplinas = new JComboBox<>(disciplinas);

        JLabel lblNomeGrupo = new JLabel("Nome do Grupo:");
        JTextField txtNomeGrupo = new JTextField();

        JButton btnCriarGrupo = new JButton("Criar Grupo");

        // Adicionando componentes ao painel superior
        panelTop.add(lblDisciplina);
        panelTop.add(cmbDisciplinas);
        panelTop.add(lblNomeGrupo);
        panelTop.add(txtNomeGrupo);
        panelTop.add(new JLabel()); // Espaço vazio
        panelTop.add(btnCriarGrupo);

        // Painel central para exibir grupos criados
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        JLabel lblGrupos = new JLabel("Grupos Criados:");
        JList<Grupo> listGrupos = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listGrupos);

        panelCenter.add(lblGrupos, BorderLayout.NORTH);
        panelCenter.add(scrollPane, BorderLayout.CENTER);

        // Adicionando painéis ao frame
        gruposFrame.add(panelTop, BorderLayout.NORTH);
        gruposFrame.add(panelCenter, BorderLayout.CENTER);

        // Atualizar lista de grupos na interface
        atualizarListaGrupos(listGrupos);

        // Evento para criar grupo
        btnCriarGrupo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String disciplina = (String) cmbDisciplinas.getSelectedItem();
                String nomeGrupo = txtNomeGrupo.getText().trim();

                if (nomeGrupo.isEmpty()) {
                    JOptionPane.showMessageDialog(gruposFrame, "O nome do grupo não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                grupos.add(new Grupo(disciplina, nomeGrupo));
                atualizarListaGrupos(listGrupos); // Atualiza a lista
                txtNomeGrupo.setText(""); // Limpa o campo
                JOptionPane.showMessageDialog(gruposFrame, "Grupo criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Evento para interagir com grupo selecionado
        listGrupos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Grupo grupoSelecionado = listGrupos.getSelectedValue();
                if (grupoSelecionado != null) {
                    mostrarTelaInteracaoGrupo(grupoSelecionado);
                }
            }
        });

        // Exibir a janela de grupos
        gruposFrame.setVisible(true);
    }

    private static void atualizarListaGrupos(JList<Grupo> listGrupos) {
        DefaultListModel<Grupo> model = new DefaultListModel<>();
        for (Grupo grupo : grupos) {
            model.addElement(grupo);
        }
        listGrupos.setModel(model);
    }

    private static void mostrarTelaInteracaoGrupo(Grupo grupo) {
        JFrame grupoFrame = new JFrame("Interação no Grupo - " + grupo.nomeGrupo);
        grupoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        grupoFrame.setSize(800, 500);
        grupoFrame.setLayout(new BorderLayout());
        grupoFrame.setLocationRelativeTo(null);

        // Exibição de mensagens
        JTextArea txtAreaMensagens = new JTextArea();
        txtAreaMensagens.setEditable(false);
        JScrollPane scrollMensagens = new JScrollPane(txtAreaMensagens);

        // Campo para enviar mensagens
        JPanel panelEnviar = new JPanel();
        panelEnviar.setLayout(new BorderLayout());
        JTextField txtMensagem = new JTextField();
        JButton btnEnviar = new JButton("Enviar");

        panelEnviar.add(txtMensagem, BorderLayout.CENTER);
        panelEnviar.add(btnEnviar, BorderLayout.EAST);

        // Adicionando componentes à janela
        grupoFrame.add(scrollMensagens, BorderLayout.CENTER);
        grupoFrame.add(panelEnviar, BorderLayout.SOUTH);

        // Atualiza mensagens na interface
        atualizarMensagensGrupo(grupo, txtAreaMensagens);

        // Evento para enviar mensagem
        btnEnviar.addActionListener(e -> {
            String mensagem = txtMensagem.getText().trim();
            if (!mensagem.isEmpty()) {
                grupo.mensagens.add(mensagem);
                atualizarMensagensGrupo(grupo, txtAreaMensagens);
                txtMensagem.setText(""); // Limpa o campo
            }
        });

        grupoFrame.setVisible(true);
    }

    private static void atualizarMensagensGrupo(Grupo grupo, JTextArea txtAreaMensagens) {
        StringBuilder mensagens = new StringBuilder();
        for (String mensagem : grupo.mensagens) {
            mensagens.append(mensagem).append("\n");
        }
        txtAreaMensagens.setText(mensagens.toString());
    }

    // Classe auxiliar para usuários
    static class Usuario {
        String tipo;
        String email;
        String senha;

        Usuario(String tipo, String email, String senha) {
            this.tipo = tipo;
            this.email = email;
            this.senha = senha;
        }
    }

    // Classe auxiliar para grupos
    static class Grupo {
        String disciplina;
        String nomeGrupo;
        ArrayList<String> mensagens = new ArrayList<>();

        Grupo(String disciplina, String nomeGrupo) {
            this.disciplina = disciplina;
            this.nomeGrupo = nomeGrupo;
        }

        @Override
        public String toString() {
            return disciplina + " - " + nomeGrupo;
        }
    }
}