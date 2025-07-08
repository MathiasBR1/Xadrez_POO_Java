package Pecas;

import Tabuleiro.ChessBoard;
import Tabuleiro.Casa;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;

public class PeaoPreto extends Peca{
    public PeaoPreto(int row, int col,ImageIcon imagem) {super(row,col,"Peao","Preto",imagem);}
    public void move(ChessBoard tabuleiro){
        ArrayList<Casa> movimentos = getMovimentosLegais(tabuleiro);
        if (movimentos.isEmpty()) {
            return;
        }
        tabuleiro.startmoving();
        visualizarmovimentos(tabuleiro, movimentos);
    }
    public ArrayList<Casa> gerarMovimentos(ChessBoard tabuleiro){
        ArrayList<Casa> movimentos = new ArrayList<>();

        if(row == 4){
            if(col <7){
                if(tabuleiro.getPeca(row,col+1) == tabuleiro.getLastmoved() && tabuleiro.getLastmoved().fezpassoduplo){
                    Casa aux = new Casa(row +1, col +1);
                    movimentos.add(aux);
                }
            }
            if(col > 0){
                if(tabuleiro.getPeca(row,col-1) == tabuleiro.getLastmoved() && tabuleiro.getLastmoved().fezpassoduplo){
                    Casa aux = new Casa(row +1, col -1);
                    movimentos.add(aux);
                }
            }
        }

        if(row<7 && tabuleiro.getPeca(row+1, col) == null){
            if(row == 1){
                if( tabuleiro.getPeca(row+2, col) == null){
                    Casa aux = new Casa(row+2,col);
                    movimentos.add(aux);
                }
            }
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
        return movimentos;
    }
    protected void visualizarmovimentos(ChessBoard tabuleiro, ArrayList<Casa> movimentos) {
        Color destaque = new Color(204, 204, 0);
        for (Casa casa : movimentos){
            JButton botao = tabuleiro.getSquare(casa.x,casa.y);
            botao.setBackground(destaque);
            botao.addActionListener(e ->{
                if(row == 4 ){
                    if(tabuleiro.getLastmoved().getType().equals("Peao") && tabuleiro.getLastmoved().fezpassoduplo && (tabuleiro.getLastmoved() == tabuleiro.getPeca(casa.x-1,casa.y))){
                        tabuleiro.removepeca( casa.x-1,casa.y);
                        tabuleiro.removepeca( casa.x-1,casa.y);
                    }
                }
                if(row == 1 && casa.x == 3){
                    fezpassoduplo = true;
                }
                tabuleiro.changelastmoved(this);
                tabuleiro.removepeca(row,col);
                tabuleiro.addpeca(casa.x, casa.y, this);
                row = casa.x;
                col = casa.y;
                apagarmovimentos(tabuleiro, movimentos);
                tabuleiro.atualizarIcones();
                new javax.swing.Timer(200, evt -> {
                    tabuleiro.stopmoving();
                    tabuleiro.verificarfimdejogo();
                    ((javax.swing.Timer) evt.getSource()).stop();
                }).start();
            });
        }
    }



}
