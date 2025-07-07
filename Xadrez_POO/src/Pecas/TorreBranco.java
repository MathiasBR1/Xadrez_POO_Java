package Pecas;

import Tabuleiro.ChessBoard;

import javax.swing.*;

public class TorreBranco extends Peca {
    public TorreBranco(int row, int col, ImageIcon imagem) {
        super(row, col, "Torre", "Branco", imagem);
    }

    public void move(ChessBoard tabuleiro) {}
}
