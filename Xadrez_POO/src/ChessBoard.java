import Pecas.*;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame {
    private Peca[][] pecas = new Peca[8][8];
    private JButton[][] squares = new JButton[8][8]; // Matriz para armazenar os quadrados

    public ChessBoard() {
        setTitle("Tabuleiro de Xadrez");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel boardPanel = new JPanel(new GridLayout(8, 8));

        boolean white = false;

        for (int row = 0; row < 8; row++) {
            white = !white;
            for (int col = 0; col < 8; col++) {
                JButton square = new JButton();
                if (white) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.DARK_GRAY);
                }
                final int r = row;
                final int c = col;
                square.addActionListener(e -> {
                    if(pecas[r][c] != null){
                        pecas[r][c].move();
                    }
                });
                boardPanel.add(square);
                squares[row][col] = square; // Armazena na matriz
                white = !white;
            }
        }
        inicializarPecas();
        atualizarIcones();
        add(boardPanel);
    }
    private void inicializarPecas() {
        ImageIcon torrePreta = loadScaledIcon("src/Images/Black_Rook.png", 100, 100);
        ImageIcon cavaloPreto = loadScaledIcon("src/Images/Black_Knight.png", 100, 100);
        ImageIcon bispoPreto = loadScaledIcon("src/Images/Black_Bishop.png", 100, 100);
        ImageIcon rainhaPreta = loadScaledIcon("src/Images/Black_Queen.png", 100, 100);
        ImageIcon reiPreto = loadScaledIcon("src/Images/Black_King.png", 100, 100);
        ImageIcon peaoPreto = loadScaledIcon("src/Images/Black_Pawn.png", 100, 100);

        ImageIcon torreBranca = loadScaledIcon("src/Images/White_Rook.png", 100, 100);
        ImageIcon cavaloBranco = loadScaledIcon("src/Images/White_Knight.png", 100, 100);
        ImageIcon bispoBranco = loadScaledIcon("src/Images/White_Bishop.png", 100, 100);
        ImageIcon rainhaBranca = loadScaledIcon("src/Images/White_Queen.png", 100, 100);
        ImageIcon reiBranco = loadScaledIcon("src/Images/White_King.png", 100, 100);
        ImageIcon peaoBranco = loadScaledIcon("src/Images/White_Pawn.png", 100, 100);

        pecas[0][0] = new TorrePreto(0, 0, torrePreta);
        pecas[0][1] = new CavaloPreto(0, 1, cavaloPreto);
        pecas[0][2] = new BispoPreto(0, 2, bispoPreto);
        pecas[0][3] = new RainhaPreto(0, 3, rainhaPreta);
        pecas[0][4] = new ReiPreto(0, 4, reiPreto);
        pecas[0][5] = new BispoPreto(0, 5, bispoPreto);
        pecas[0][6] = new CavaloPreto(0, 6, cavaloPreto);
        pecas[0][7] = new TorrePreto(0, 7, torrePreta);
        for (int col = 0; col < 8; col++) {
            pecas[1][col] = new PeaoPreto(1, col, peaoPreto);
        }
        pecas[7][0] = new TorreBranco(7, 0, torreBranca);
        pecas[7][1] = new CavaloBranco(7, 1, cavaloBranco);
        pecas[7][2] = new BispoBranco(7, 2, bispoBranco);
        pecas[7][3] = new RainhaBranco(7, 3, rainhaBranca);
        pecas[7][4] = new ReiBranco(7, 4, reiBranco);
        pecas[7][5] = new BispoBranco(7, 5, bispoBranco);
        pecas[7][6] = new CavaloBranco(7, 6, cavaloBranco);
        pecas[7][7] = new TorreBranco(7, 7, torreBranca);
        for (int col = 0; col < 8; col++) {
            pecas[6][col] = new PeaoBranco(6, col, peaoBranco);
        }
    }
    private void atualizarIcones() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (pecas[row][col] != null) {
                    squares[row][col].setIcon(pecas[row][col].getImagem());
                } else {
                    squares[row][col].setIcon(null); // limpa ícone se necessário
                }
            }
        }
    }

        // Método para acessar um quadrado
    public JButton getSquare(int row, int col) {
        return squares[row][col];
    }
    public static ImageIcon loadScaledIcon(String path, int width, int height) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}