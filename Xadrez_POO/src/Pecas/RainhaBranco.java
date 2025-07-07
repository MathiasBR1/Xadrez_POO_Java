package Pecas;

import Tabuleiro.ChessBoard;

import javax.swing.*;

public class RainhaBranco extends Peca {
    public RainhaBranco(int row, int col, ImageIcon imagem) {
        super(row, col, "Rainha", "Branco", imagem);
    }

    public void move(ChessBoard tabuleiro) {}
}