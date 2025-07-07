package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import java.util.ArrayList;
import javax.swing.*;

public class BispoPreto extends Peca {
    public BispoPreto(int row, int col, ImageIcon imagem) {
        super(row, col, "Bispo", "Preto", imagem);
    }
    public void move(ChessBoard tabuleiro) {
        tabuleiro.startmoving();
        ArrayList<Casa> movimentos = new ArrayList<>();
        // implementação dos movimentos da peça Bispo Preto - movimentos sempre nas diagonais até encontrar uma peça da mesma cor (para de movimentar até aquela casa) ou de uma peça da cor contrária (para de movimentar para realizar a captura).
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
        visualizarmovimentos(tabuleiro, movimentos);
    }
}
