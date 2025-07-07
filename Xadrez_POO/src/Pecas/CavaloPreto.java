package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.util.ArrayList;

public class CavaloPreto extends Peca {
    public CavaloPreto(int row, int col, ImageIcon imagem) {
        super(row, col, "Cavalo", "Preto", imagem);
    }

    public void move(ChessBoard tabuleiro) {
        tabuleiro.startmoving();
        ArrayList<Casa> movimentos = new ArrayList<>();
        // implementação dos movimentos da peça Cavalo Preto - movimentos sempre em "L".
        if (row > 1 && col > 0) {
            if (tabuleiro.getPeca(row - 2, col - 1) == null) {
                Casa aux = new Casa(row - 2, col - 1);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row - 2, col - 1) != null && tabuleiro.getPeca(row - 2, col - 1).getColor().equals("Branco")) {
                    Casa aux = new Casa(row - 2, col - 1);
                    movimentos.add(aux);
                }
            }
        }

        if (row > 1 && col < 7) {
            if (tabuleiro.getPeca(row - 2, col + 1) == null) {
                Casa aux = new Casa(row - 2, col + 1);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row - 2, col + 1) != null && tabuleiro.getPeca(row - 2, col + 1).getColor().equals("Branco")) {
                    Casa aux = new Casa(row - 2, col + 1);
                    movimentos.add(aux);
                }
            }
        }

        if (row > 0 && col > 1) {
            if (tabuleiro.getPeca(row - 1, col - 2) == null) {
                Casa aux = new Casa(row - 1, col - 2);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row - 1, col - 2) != null && tabuleiro.getPeca(row - 1, col - 2).getColor().equals("Branco")) {
                    Casa aux = new Casa(row - 1, col - 2);
                    movimentos.add(aux);
                }
            }
        }

        if (row > 0 && col < 6) {
            if (tabuleiro.getPeca(row - 1, col + 2) == null) {
                Casa aux = new Casa(row - 1, col + 2);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row - 1, col + 2) != null && tabuleiro.getPeca(row - 1, col + 2).getColor().equals("Branco")) {
                    Casa aux = new Casa(row - 1, col + 2);
                    movimentos.add(aux);
                }
            }
        }

        if (row < 7 && col > 1) {
            if (tabuleiro.getPeca(row + 1, col - 2) == null) {
                Casa aux = new Casa(row + 1, col - 2);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row + 1, col - 2) != null && tabuleiro.getPeca(row + 1, col - 2).getColor().equals("Branco")) {
                    Casa aux = new Casa(row + 1, col - 2);
                    movimentos.add(aux);
                }
            }
        }

        if (row < 7 && col < 6) {
            if (tabuleiro.getPeca(row + 1, col + 2) == null) {
                Casa aux = new Casa(row + 1, col + 2);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row + 1, col + 2) != null && tabuleiro.getPeca(row + 1, col + 2).getColor().equals("Branco")) {
                    Casa aux = new Casa(row + 1, col + 2);
                    movimentos.add(aux);
                }
            }
        }

        if (row < 6 && col > 0) {
            if (tabuleiro.getPeca(row + 2, col - 1) == null) {
                Casa aux = new Casa(row + 2, col - 1);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row + 2, col - 1) != null && tabuleiro.getPeca(row + 2, col - 1).getColor().equals("Branco")) {
                    Casa aux = new Casa(row + 2, col - 1);
                    movimentos.add(aux);
                }
            }
        }

        if (row < 6 && col < 7) {
            if (tabuleiro.getPeca(row + 2, col + 1) == null) {
                Casa aux = new Casa(row + 2, col + 1);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row + 2, col + 1) != null && tabuleiro.getPeca(row + 2, col + 1).getColor().equals("Branco")) {
                    Casa aux = new Casa(row + 2, col + 1);
                    movimentos.add(aux);
                }
            }
        }
        visualizarmovimentos(tabuleiro, movimentos);
    }
}
