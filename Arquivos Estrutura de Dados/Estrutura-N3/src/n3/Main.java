package n3;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArvoreBinaria<Integer> tree = new ArvoreBinaria<>();
            AdicionarNumerosFrame addFrame = new AdicionarNumerosFrame(tree);
            addFrame.setVisible(true);
        });
    }
}
