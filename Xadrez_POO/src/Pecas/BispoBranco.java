package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.util.ArrayList;

public class BispoBranco extends Peca {
    public BispoBranco(int row, int col, ImageIcon imagem) {
        super(row, col, "Bispo", "Branco", imagem);
    }

    @Override
    public ArrayList<Casa> getmoves(ChessBoard tabuleiro) {
        ArrayList<Casa> movimentos = new ArrayList<>();
        // implementação dos movimentos da peça Bispo Branco - movimentos sempre nas diagonais até encontrar uma peça da mesma cor (para de movimentar até aquela casa) ou de uma peça da cor contrária (para de movimentar para realizar a captura).
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (tabuleiro.getPeca(i, j) == null) {
                Casa aux = new Casa(i, j);
                movimentos.add(aux);
            }
            else {
                if (tabuleiro.getPeca(i, j).getColor().equals("Preto")) {
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
                if (tabuleiro.getPeca(i, j).getColor().equals("Preto")) {
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
                if (tabuleiro.getPeca(i, j).getColor().equals("Preto")) {
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
                if(tabuleiro.getPeca(i, j).getColor().equals("Preto")){
                    Casa aux = new Casa(i, j);
                    movimentos.add(aux);
                }
                break;
            }
            i += 1;
            j += 1;
        }
        return movimentos;
    }

    public void move(ChessBoard tabuleiro) {
        tabuleiro.startmoving();
        ArrayList<Casa> movimentos = getmoves(tabuleiro);

        visualizarmovimentos(tabuleiro, movimentos);
    }
}
