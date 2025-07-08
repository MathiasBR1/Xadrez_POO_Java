package Tabuleiro;

import Pecas.*;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ChessBoard extends JFrame {
    private Peca[][] pecas = new Peca[8][8];
    private JButton[][] squares = new JButton[8][8]; // Matriz para armazenar os quadrados
    private boolean ismoving = false;
    private Peca lastmoved;
    private Peca currentmove = null;

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
                    if (!ismoving) {
                        if (pecas[r][c] != null) {
                            if (!pecas[r][c].getColor().equals(lastmoved.getColor())) {
                                pecas[r][c].move(this);
                                this.currentmove = pecas[r][c];
                            }
                        }
                    } else {
                        getcurrentmove().cancelarmovimentos(this);
                    }
                });
                boardPanel.add(square);
                squares[row][col] = square; // Armazena na matriz
                white = !white;
            }
        }
        inicializarPecas();
        atualizarIcones();
        this.lastmoved = pecas[0][4];
        add(boardPanel);
    }

    private void inicializarPecas() { //metodo loadScaledIcon n busca em src mas sim no out/production ... logo so colocar o nome da imagem
        ImageIcon torrePreta = loadScaledIcon("Black_Rook.png", 100, 100);
        ImageIcon cavaloPreto = loadScaledIcon("Black_Knight.png", 100, 100);
        ImageIcon bispoPreto = loadScaledIcon("Black_Bishop.png", 100, 100);
        ImageIcon rainhaPreta = loadScaledIcon("Black_Queen.png", 100, 100);
        ImageIcon reiPreto = loadScaledIcon("Black_King.png", 100, 100);
        ImageIcon peaoPreto = loadScaledIcon("Black_Pawn.png", 100, 100);

        ImageIcon torreBranca = loadScaledIcon("White_Rook.png", 100, 100);
        ImageIcon cavaloBranco = loadScaledIcon("White_Knight.png", 100, 100);
        ImageIcon bispoBranco = loadScaledIcon("White_Bishop.png", 100, 100);
        ImageIcon rainhaBranca = loadScaledIcon("White_Queen.png", 100, 100);
        ImageIcon reiBranco = loadScaledIcon("White_King.png", 100, 100);
        ImageIcon peaoBranco = loadScaledIcon("White_Pawn.png", 100, 100);

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

    public void atualizarIcones() {
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

    public void changemoving(Peca peca) {
        this.currentmove = peca;
    }

    public Peca getcurrentmove() {
        return currentmove;
    }

    public void changelastmoved(Peca lastmoved) {
        this.lastmoved = lastmoved;
    }

    public Peca getLastmoved() {
        return this.lastmoved;
    }

    // Método para acessar um quadrado
    public JButton getSquare(int row, int col) {
        return squares[row][col];
    }

    public Peca getPeca(int row, int col) {
        return pecas[row][col];
    }

    public void removepeca(int row, int col) {
        pecas[row][col] = null;
    }

    public void addpeca(int row, int col, Peca peca) {
        pecas[row][col] = peca;
    }

    public static ImageIcon loadScaledIcon(String path, int width, int height) {
        URL img_url = ChessBoard.class.getResource("/Images/" + path); //metodo para pegar a /Images/ + path (so o nome da peca) e transforma em URL q ja vai p imagem
        Image img = new ImageIcon(img_url).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public void startmoving() {
        this.ismoving = true;
    }

    public void stopmoving() {
        this.ismoving = false;
    }

    public boolean ismoving() {
        return ismoving;
    }

    private Peca encontrarrei(String cor) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pecas[i][j] != null && pecas[i][j].getType().equals("Rei") && pecas[i][j].getColor().equals(cor)) {
                    return pecas[i][j];
                }
            }
        }
        return null;
    }

    public boolean reiemcheque(String corRei) {
        Peca rei = encontrarrei(corRei);
        if (rei == null) return false;

        String corAtacante = corRei.equals("Branco") ? "Preto" : "Branco";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Peca peca = pecas[i][j];
                if (peca != null && peca.getColor().equals(corAtacante)) {
                    ArrayList<Casa> movimentos = peca.gerarMovimentos(this);
                    for (Casa movimento : movimentos) {
                        if (movimento.x == rei.getRow() && movimento.y == rei.getCol()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean movlegais(String corJogador) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Peca peca = getPeca(i, j);
                if (peca != null && peca.getColor().equals(corJogador)) {
                    ArrayList<Casa> movimentos = peca.gerarMovimentos(this);
                    int originalRow = peca.getRow();
                    int originalCol = peca.getCol();
                    boolean originalHasMoved = peca.getHasMoved();

                    for (Casa destino : movimentos) {
                        Peca pecaCapturada = getPeca(destino.x, destino.y);
                        addpeca(destino.x, destino.y, peca);
                        removepeca(originalRow, originalCol);
                        peca.setRow(destino.x);
                        peca.setCol(destino.y);

                        if (!reiemcheque(corJogador)) {
                            addpeca(originalRow, originalCol, peca);
                            peca.setRow(originalRow);
                            peca.setCol(originalCol);
                            peca.setHasMoved(originalHasMoved);
                            removepeca(destino.x, destino.y);
                            if (pecaCapturada != null) addpeca(destino.x, destino.y, pecaCapturada);
                            return true;
                        }

                        addpeca(originalRow, originalCol, peca);
                        peca.setRow(originalRow);
                        peca.setCol(originalCol);
                        peca.setHasMoved(originalHasMoved);
                        removepeca(destino.x, destino.y);
                        if (pecaCapturada != null) addpeca(destino.x, destino.y, pecaCapturada);
                    }
                }
            }
        }
        return false;
    }


    public void verificarfimdejogo() {
        String proximoJogador = lastmoved.getColor().equals("Branco") ? "Preto" : "Branco";
        Timer timer = new Timer(100, e -> {
            if (reiemcheque(proximoJogador)) {
                if (!movlegais(proximoJogador)) {
                    String vencedor = lastmoved.getColor();
                    JOptionPane.showMessageDialog(this, "Xeque-mate! O jogador " + vencedor + " venceu.", "Partida Finalizada", JOptionPane.INFORMATION_MESSAGE);

                    Object[] options = {"Fechar o Jogo"};
                    int escolha = JOptionPane.showOptionDialog(this, "A partida terminou.", "Fim de Jogo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    if (escolha == 0) {
                        this.dispose();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Xeque! O jogador " + proximoJogador + " deve proteger seu Rei.", "Aviso de Xeque", JOptionPane.WARNING_MESSAGE);
                }

            }
            else {
                if (!movlegais(proximoJogador)) {
                    JOptionPane.showMessageDialog(this, "O jogo terminou em empate.", "Partida Finalizada", JOptionPane.INFORMATION_MESSAGE);

                    Object[] options = {"Fechar o Jogo"};
                    int escolha = JOptionPane.showOptionDialog(this, "A partida terminou.", "Fim de Jogo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    if (escolha == 0) {
                        this.dispose();
                    }
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
