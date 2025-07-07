package Pecas;

import Tabuleiro.ChessBoard;

import javax.swing.*;

public class CavaloPreto extends Peca {
    public CavaloPreto(int row, int col, ImageIcon imagem) {
        super(row, col, "Cavalo", "Preto", imagem);
    }

    public void move(ChessBoard tabuleiro) {}
}