package Pecas;

import Tabuleiro.ChessBoard;

import javax.swing.*;

public class TorrePreto extends Peca {
    public TorrePreto(int row, int col, ImageIcon imagem) {
        super(row, col, "Torre", "Preto", imagem);
    }

    public void move(ChessBoard tabuleiro) {}
}