package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReiBranco extends Peca{
    public ReiBranco(int row, int col, ImageIcon imagem) {super(row,col,"Rei","Branco",imagem);}

    @Override
    public ArrayList<Casa> gerarMovimentos(ChessBoard tabuleiro) {
        ArrayList<Casa> movimentos = new ArrayList<>();
        if(row < 7 && (tabuleiro.getPeca(row+1,col) == null || tabuleiro.getPeca(row+1,col).getColor().equals("Preto"))) {
            movimentos.add(new Casa(row+1, col));
        }
        if(col < 7 && (tabuleiro.getPeca(row, col+1) == null || tabuleiro.getPeca(row, col+1).getColor().equals("Preto"))) {
            movimentos.add(new Casa(row, col+1));
        }
        if(col > 0 && (tabuleiro.getPeca(row, col-1) == null || tabuleiro.getPeca(row, col-1).getColor().equals("Preto"))) {
            movimentos.add(new Casa(row, col-1));
        }
        if(row > 0 && (tabuleiro.getPeca(row-1, col) == null || tabuleiro.getPeca(row-1, col).getColor().equals("Preto"))) {
            movimentos.add(new Casa(row-1, col));
        }
        if(row > 0 && col < 7 && (tabuleiro.getPeca(row-1, col+1) == null || tabuleiro.getPeca(row-1, col+1).getColor().equals("Preto"))) {
            movimentos.add(new Casa(row-1, col+1));
        }
        if(row < 7 && col > 0 && (tabuleiro.getPeca(row+1, col-1) == null || tabuleiro.getPeca(row+1, col-1).getColor().equals("Preto"))) {
            movimentos.add(new Casa(row+1, col-1));
        }
        if(row > 0 && col > 0 && (tabuleiro.getPeca(row-1, col-1) == null || tabuleiro.getPeca(row-1, col-1).getColor().equals("Preto"))) {
            movimentos.add(new Casa(row-1, col-1));
        }
        if(row < 7 && col < 7 && (tabuleiro.getPeca(row+1, col+1) == null || tabuleiro.getPeca(row+1, col+1).getColor().equals("Preto"))) {
            movimentos.add(new Casa(row+1, col+1));
        }

        if(!hasmoved){
            int i = col-1;
            while( i > 0 && tabuleiro.getPeca(row,i) == null){
                i--;
            }
            if(i == 0){
                if(tabuleiro.getPeca(row,i) != null && !tabuleiro.getPeca(row,i).hasmoved){
                    movimentos.add(new Casa(row,col-2));
                }
            }
            i = col+1;
            while( i < 7 && tabuleiro.getPeca(row,i) == null){
                i++;
            }
            if(i == 7){
                if(tabuleiro.getPeca(row,i) != null && !tabuleiro.getPeca(row,i).hasmoved){
                    movimentos.add(new Casa(row,col+2));
                }
            }
        }
        return movimentos;
    }
    @Override
    public void visualizarmovimentos(ChessBoard tabuleiro, ArrayList<Casa> movimentos) {
        Color destaque = new Color(204, 204, 0);
        for (Casa casa : movimentos){
            JButton botao = tabuleiro.getSquare(casa.x,casa.y);
            botao.setBackground(destaque);
            botao.addActionListener(e ->{
                if(col+2 == casa.y){
                    Peca torre = tabuleiro.getPeca(7,7);
                    torre.row=7;
                    torre.col=5;
                    tabuleiro.removepeca(7,7);
                    tabuleiro.addpeca(7,5,torre);
                }
                if(col-2 == casa.y){
                    Peca torre = tabuleiro.getPeca(7,0);
                    torre.row=7;
                    torre.col=3;
                    tabuleiro.removepeca(7,0);
                    tabuleiro.addpeca(7,3,torre);
                }
                hasmoved=true;
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


    public void move(ChessBoard tabuleiro){
        ArrayList<Casa> movimentos = getMovimentosLegais(tabuleiro);
        if (movimentos.isEmpty()) {
            return;
        }
        tabuleiro.startmoving();
        visualizarmovimentos(tabuleiro, movimentos);
    }
}
