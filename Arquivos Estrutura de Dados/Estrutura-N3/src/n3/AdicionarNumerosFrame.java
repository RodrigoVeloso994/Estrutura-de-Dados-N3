package n3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarNumerosFrame extends JFrame {
    private ArvoreBinaria<Integer> arvore;

    public AdicionarNumerosFrame(ArvoreBinaria<Integer> arvore) {
        this.arvore = arvore;
        setTitle("Adicionar Números");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Parte superior com campo de entrada
        JPanel painelInput = new JPanel();
        painelInput.setLayout(new FlowLayout());
        JTextField campoEntrada = new JTextField(10);
        JButton botaoAdicionar = new JButton("Adicionar");
        painelInput.add(campoEntrada);
        painelInput.add(botaoAdicionar);

        // Parte inferior com botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2, 2));
        JButton botaoListar = new JButton("Listar Números");
        JButton botaoBuscar = new JButton("Buscar Número");
        JButton botaoSair = new JButton("Sair");

        // Configurar cores para preto e branco
        botaoAdicionar.setForeground(Color.BLACK);
        botaoListar.setForeground(Color.BLACK);
        botaoBuscar.setForeground(Color.BLACK);
        botaoSair.setForeground(Color.BLACK);
        botaoAdicionar.setBackground(Color.WHITE);
        botaoListar.setBackground(Color.WHITE);
        botaoBuscar.setBackground(Color.WHITE);
        botaoSair.setBackground(Color.WHITE);

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(campoEntrada.getText());
                    arvore.inserir(numero);
                    campoEntrada.setText("");
                    JOptionPane.showMessageDialog(AdicionarNumerosFrame.this, "Número " + numero + " adicionado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AdicionarNumerosFrame.this, "Por favor, insira um número válido.");
                }
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarNumerosFrame listarFrame = new ListarNumerosFrame(arvore);
                listarFrame.setVisible(true);
                setVisible(false);
            }
        });

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Informe o número a ser buscado:");
                try {
                    int numero = Integer.parseInt(input);

                    boolean encontrado = arvore.buscar(numero);

                    if (encontrado) {
                        JOptionPane.showMessageDialog(AdicionarNumerosFrame.this, "Número encontrado!");
                    } else {
                        JOptionPane.showMessageDialog(AdicionarNumerosFrame.this, "Número não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AdicionarNumerosFrame.this, "Por favor, insira um número válido.");
                }
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdicionarNumerosFrame.this, "Volte sempre!");
                // Encerrar o aplicativo
                System.exit(0);
            }
        });

        painelBotoes.add(botaoListar);
        painelBotoes.add(botaoBuscar);
        painelBotoes.add(botaoSair);

        painelPrincipal.add(painelInput, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        add(painelPrincipal);
    }
}
