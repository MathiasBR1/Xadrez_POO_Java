package Pecas;

import Tabuleiro.ChessBoard;

import javax.swing.*;

public class BispoBranco extends Peca {
    public BispoBranco(int row, int col, ImageIcon imagem) {
        super(row, col, "Bispo", "Branco", imagem);
    }

    public void move(ChessBoard tabuleiro) {}
}