package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.util.ArrayList;

public class TorrePreto extends Peca {
    public TorrePreto(int row, int col, ImageIcon imagem) {
        super(row, col, "Torre", "Preto", imagem);
    }

    @Override
    public ArrayList<Casa> getmoves(ChessBoard tabuleiro) {
        ArrayList<Casa> movimentos = new ArrayList<>();
        // implementação dos movimentos da peça Torre Branca - enquanto não houver peça da mesma cor nos seus possíveis movimentos,
        // se movimenta para casas nas direções horizontais e verticais. quando encontra uma peça de cor contrária, para a movimentação para captura.
        int i = row - 1;
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

    public void move(ChessBoard tabuleiro) {
        tabuleiro.startmoving();
        ArrayList<Casa> movimentos = getmoves(tabuleiro);

        visualizarmovimentos(tabuleiro, movimentos);
    }
}
