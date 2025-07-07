package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.util.ArrayList;

public class RainhaPreto extends Peca{
    public RainhaPreto(int row, int col, ImageIcon imagem) {super(row,col,"Rainha","Preto",imagem);}

    @Override
    public ArrayList<Casa> getmoves(ChessBoard tabuleiro) {
        ArrayList<Casa> movimentos = new ArrayList<>();
        // implementação dos movimentos da peça Rainha Preta, que se movimenta tanto nas diagonais, quanto nas horizontais e verticais,
        // até encontrar uma peça da mesma cor ou uma peça da cor contrária e realizar a captura.
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (tabuleiro.getPeca(i, j) == null) {
                Casa aux = new Casa(i, j);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(i, j).getColor().equals("Branco")) {
                    Casa aux = new Casa(i, j);
                    movimentos.add(aux);
                }
                break;
            }
            i -= 1;
            j -= 1;
        }

        i = row - 1;
        j = col + 1;
        while (i >= 0 && j <= 7){
            if (tabuleiro.getPeca(i, j) == null) {
                Casa aux = new Casa(i, j);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(i, j).getColor().equals("Branco")) {
                    Casa aux = new Casa(i, j);
                    movimentos.add(aux);
                }
                break;
            }
            i -= 1;
            j += 1;
        }

        i = row + 1;
        j = col - 1;
        while (i <= 7 && j >= 0) {
            if (tabuleiro.getPeca(i, j) == null) {
                Casa aux = new Casa(i, j);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(i, j).getColor().equals("Branco")) {
                    Casa aux = new Casa(i, j);
                    movimentos.add(aux);
                }
                break;
            }
            i += 1;
            j -= 1;
        }

        i = row + 1;
        j = col + 1;
        while (i <= 7 && j <= 7) {
            if (tabuleiro.getPeca(i, j) == null) {
                Casa aux = new Casa(i, j);
                movimentos.add(aux);
            }
            else {
                if(tabuleiro.getPeca(i, j).getColor().equals("Branco")){
                    Casa aux = new Casa(i, j);
                    movimentos.add(aux);
                }
                break;
            }
            i += 1;
            j += 1;
        }
        i = row - 1;
        while (i >= 0) {
            if (tabuleiro.getPeca(i, col) == null) {
                Casa aux = new Casa(i, col);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(i, col).getColor().equals("Branco")) {
                    Casa aux = new Casa(i, col);
                    movimentos.add(aux);
                }
                break;
            }
            i -= 1;
        }

        i = row + 1;
        while (i <= 7) {
            if (tabuleiro.getPeca(i, col) == null) {
                Casa aux = new Casa(i, col);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(i, col).getColor().equals("Branco")) {
                    Casa aux = new Casa(i, col);
                    movimentos.add(aux);
                }
                break;
            }
            i += 1;
        }

        i = col - 1;
        while (i >= 0) {
            if (tabuleiro.getPeca(row, i) == null) {
                Casa aux = new Casa(row, i);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row, i).getColor().equals("Branco")) {
                    Casa aux = new Casa(row, i);
                    movimentos.add(aux);
                }
                break;
            }
            i -= 1;
        }

        i = col + 1;
        while (i <= 7) {
            if (tabuleiro.getPeca(row, i) == null) {
                Casa aux = new Casa(row, i);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(row, i).getColor().equals("Branco")) {
                    Casa aux = new Casa(row, i);
                    movimentos.add(aux);
                }
                break;
            }
            i += 1;
        }
        return movimentos;
    }

    public void move(ChessBoard tabuleiro){
        tabuleiro.startmoving();
        ArrayList<Casa> movimentos = getmoves(tabuleiro);

        visualizarmovimentos(tabuleiro, movimentos);
    }
}
