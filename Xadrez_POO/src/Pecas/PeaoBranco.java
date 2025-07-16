package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PeaoBranco extends Peca{

    public PeaoBranco(int row, int col, ImageIcon imagem) {
        super(row,col,"Peao","Branco",imagem);
    }
    public void move(ChessBoard tabuleiro){
        ArrayList<Casa> movimentos = getMovimentosLegais(tabuleiro);
        if (movimentos.isEmpty()) {
            return;
        }
        tabuleiro.startmoving();
        visualizarmovimentos(tabuleiro, movimentos);
    }
    @Override
    protected void visualizarmovimentos(ChessBoard tabuleiro, ArrayList<Casa> movimentos) {
        Color destaque = new Color(204, 204, 0);
        for (Casa casa : movimentos){
            JButton botao = tabuleiro.getSquare(casa.x,casa.y);
            botao.setBackground(destaque);
            botao.addActionListener(e ->{
                if(row == 3 ){
                    if(tabuleiro.getLastmoved().getType().equals("Peao") && tabuleiro.getLastmoved().fezpassoduplo && (tabuleiro.getLastmoved() == tabuleiro.getPeca(casa.x+1,casa.y))){
                        tabuleiro.removepeca( casa.x+1,casa.y);
                        tabuleiro.removepeca( casa.x+1,casa.y);
                    }
                }
                if(row == 6 && casa.x == 4){
                    fezpassoduplo = true;
                }
                tabuleiro.changelastmoved(this);
                tabuleiro.removepeca(row,col);
                tabuleiro.addpeca(casa.x, casa.y, this);
                row = casa.x;
                col = casa.y;
                
                if (row == 0) {
                    ImageIcon rainhaBranca = loadScaledIcon("White_Queen.png", 100, 100);
                    tabuleiro.removepeca(row, col);
                    tabuleiro.addpeca(row, col, new RainhaBranco(row, col, rainhaBranca));
                }

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
    @Override
    public ArrayList<Casa> gerarMovimentos(ChessBoard tabuleiro) {
        ArrayList<Casa> movimentos = new ArrayList<>();

        if(row == 3){
            if(col <7){
                if(tabuleiro.getPeca(row,col+1) == tabuleiro.getLastmoved() && tabuleiro.getLastmoved().fezpassoduplo){
                    Casa aux = new Casa(row -1, col +1);
                    movimentos.add(aux);
                }
            }
            if(col > 0){
                if(tabuleiro.getPeca(row,col-1) == tabuleiro.getLastmoved() && tabuleiro.getLastmoved().fezpassoduplo){
                    Casa aux = new Casa(row -1, col -1);
                    movimentos.add(aux);
                }
            }
        }

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
        return movimentos;
    }
}
