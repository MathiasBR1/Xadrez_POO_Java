package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.util.ArrayList;

public class PeaoBranco extends Peca{
    public PeaoBranco(int row, int col, ImageIcon imagem) {
        super(row,col,"Peao","Branco",imagem);
    }
    public void move(ChessBoard tabuleiro){
        tabuleiro.startmoving();
        ArrayList<Casa> movimentos = new ArrayList<>();

        if(row<7 && tabuleiro.getPeca(row-1, col) == null){
            if(row == 6){
                if( tabuleiro.getPeca(row-2, col) == null){
                    Casa aux = new Casa(row-2,col);
                    movimentos.add(aux);
                }
            }
            Casa aux = new Casa(row-1,col);
            movimentos.add(aux);

        }
        if(row > 0 && col > 0 && tabuleiro.getPeca(row-1, col-1) != null && tabuleiro.getPeca(row-1,col-1).getColor().equals("Preto")){
            Casa aux = new Casa(row-1,col-1);
            movimentos.add(aux);
        }
        if(row > 0 && col < 7 && tabuleiro.getPeca(row-1, col+1) != null && tabuleiro.getPeca(row-1,col+1).getColor().equals("Preto")){
            Casa aux = new Casa(row-1,col+1);
            movimentos.add(aux);
        }
        visualizarmovimentos(tabuleiro, movimentos);;
    }
}
