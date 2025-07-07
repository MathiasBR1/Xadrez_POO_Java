package Pecas;

import Tabuleiro.ChessBoard;

import javax.swing.*;

public class CavaloBranco extends Peca {
    public CavaloBranco(int row, int col, ImageIcon imagem) {
        super(row, col, "Cavalo", "Branco", imagem);
    }

    public void move(ChessBoard tabuleiro) {}
}
