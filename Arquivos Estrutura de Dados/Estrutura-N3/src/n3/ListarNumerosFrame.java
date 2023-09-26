package n3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarNumerosFrame extends JFrame {
    private ArvoreBinaria<Integer> arvore;

    public ListarNumerosFrame(ArvoreBinaria<Integer> arvore) {
        this.arvore = arvore;
        setTitle("Listar Números");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<Integer> modelo = new DefaultListModel<>();
        JList<Integer> lista = new JList<>(modelo);

        JButton botaoVoltar = new JButton("Voltar");

        JButton botaoOrdemCrescente = new JButton("Em Ordem");
        JButton botaoPreOrdem = new JButton("Pré-ordem");
        JButton botaoPosOrdem = new JButton("Pós-ordem");

        // Configurar cores para preto e branco
        botaoVoltar.setForeground(Color.BLACK);
        botaoOrdemCrescente.setForeground(Color.BLACK);
        botaoPreOrdem.setForeground(Color.BLACK);
        botaoPosOrdem.setForeground(Color.BLACK);
        botaoVoltar.setBackground(Color.WHITE);
        botaoOrdemCrescente.setBackground(Color.WHITE);
        botaoPreOrdem.setBackground(Color.WHITE);
        botaoPosOrdem.setBackground(Color.WHITE);

        arvore.listarEmOrdem(modelo);

        botaoOrdemCrescente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.clear();
                arvore.listarEmOrdem(modelo);
            }
        });

        botaoPreOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.clear();
                arvore.listarPreOrdem(modelo);
            }
        });

        botaoPosOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.clear();
                arvore.listarPosOrdem(modelo);
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarNumerosFrame adicionarFrame = new AdicionarNumerosFrame(arvore);
                adicionarFrame.setVisible(true);
                setVisible(false);
            }
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 4));
        painelBotoes.add(botaoOrdemCrescente);
        painelBotoes.add(botaoPreOrdem);
        painelBotoes.add(botaoPosOrdem);
        painelBotoes.add(botaoVoltar);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(painelBotoes, BorderLayout.NORTH);
        painelPrincipal.add(new JScrollPane(lista), BorderLayout.CENTER);

        add(painelPrincipal);
    }
}
