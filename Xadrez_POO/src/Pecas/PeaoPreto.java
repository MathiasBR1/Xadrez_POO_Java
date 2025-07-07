package Pecas;

import Tabuleiro.ChessBoard;
import Tabuleiro.Casa;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PeaoPreto extends Peca{
    public PeaoPreto(int row, int col,ImageIcon imagem) {super(row,col,"Peao","Preto",imagem);}
    public void move(ChessBoard tabuleiro){

        tabuleiro.startmoving();
        ArrayList<Casa> movimentos = new ArrayList<>();
        if(row == 1){
            if( tabuleiro.getPeca(row+2, col) == null){
                Casa aux = new Casa(row+2,col);
                movimentos.add(aux);
            }
        }
        if(row<7 && tabuleiro.getPeca(row+1, col) == null){
            Casa aux = new Casa(row+1,col);
            movimentos.add(aux);
        }
        if(row < 7 && col > 0 && tabuleiro.getPeca(row+1, col-1) != null && tabuleiro.getPeca(row+1,col-1).getColor().equals("Branco")){
            Casa aux = new Casa(row+1,col-1);
            movimentos.add(aux);
        }
        if(row < 7 && col < 7 && tabuleiro.getPeca(row+1, col+1) != null && tabuleiro.getPeca(row+1,col+1).getColor().equals("Branco")){
            Casa aux = new Casa(row+1,col+1);
            movimentos.add(aux);
        }
        visualizarmovimentos(tabuleiro, movimentos);


    }



}
