package Pecas;
import javax.swing.*;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class Peca {
    protected int row;
    protected int col;
    protected String type;
    protected String color;
    protected ImageIcon imagem;
    protected boolean fezpassoduplo=false;
    protected boolean hasmoved=false;
    public Peca(int row, int col, String type, String color, ImageIcon imagem) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.color = color;
        this.imagem = imagem;
    }
    public int getRow() {return this.row;}
    public int getCol() {return this.col;}
    public void setRow(int row) {this.row = row;}
    public void setCol(int col) {this.col = col;}
    public String getType() {return this.type;}
    public String getColor() {return this.color;}
    public ImageIcon getImagem() {return this.imagem;}

    public boolean getHasMoved() {return this.hasmoved;}
    public void setHasMoved(boolean hasmoved) {this.hasmoved = hasmoved;}

    public abstract void move(ChessBoard tabuleiro);
    public abstract ArrayList<Casa> gerarMovimentos(ChessBoard tabuleiro);
    protected void visualizarmovimentos(ChessBoard tabuleiro, ArrayList<Casa> movimentos){
        Color destaque = new Color(204, 204, 0);
        for (Casa casa : movimentos){
            JButton botao = tabuleiro.getSquare(casa.x,casa.y);
            botao.setBackground(destaque);
            botao.addActionListener(e ->{
                hasmoved=true;
                tabuleiro.changelastmoved(this);
                tabuleiro.removepeca(row,col);
                tabuleiro.addpeca(casa.x, casa.y, this);
                row = casa.x;
                col = casa.y;
                apagarmovimentos(tabuleiro, movimentos);
                tabuleiro.atualizarIcones();
                tabuleiro.verificarfimdejogo();
            });
        }
    }
    public void apagarmovimentos(ChessBoard tabuleiro, ArrayList<Casa> movimentos){
        for(Casa move : movimentos){
            JButton casa = tabuleiro.getSquare(move.x,move.y);
            if ((move.x + move.y) % 2 == 0) {
                casa.setBackground(Color.WHITE);
            } else {
                casa.setBackground(Color.DARK_GRAY);
            }
            for (ActionListener al : casa.getActionListeners()) {
                casa.removeActionListener(al);
            }

            casa.addActionListener(e -> {
                if(!tabuleiro.ismoving()){
                    if(tabuleiro.getPeca(move.x,move.y ) != null) {
                        if(!tabuleiro.getPeca(move.x,move.y).getColor().equals(tabuleiro.getLastmoved().getColor())) {
                            tabuleiro.getPeca(move.x, move.y).move(tabuleiro);
                            tabuleiro.changemoving(tabuleiro.getPeca(move.x,move.y));
                        }
                    }
                }else{
                    tabuleiro.getcurrentmove().cancelarmovimentos(tabuleiro);
                }
            });

        }
    }
    public void cancelarmovimentos(ChessBoard tabuleiro){
        ArrayList<Casa> movimentos = getMovimentosLegais(tabuleiro);

        for(Casa move : movimentos){
            JButton casa = tabuleiro.getSquare(move.x,move.y);
            if((move.x + move.y)%2 == 0){
                casa.setBackground(Color.WHITE);
            }else{
                casa.setBackground(Color.DARK_GRAY);
            }
            for(ActionListener al : casa.getActionListeners()){
                casa.removeActionListener(al);
            }
            tabuleiro.stopmoving();
            tabuleiro.changemoving(null);
            tabuleiro.atualizarIcones();
            casa.addActionListener(e -> {
                if(!tabuleiro.ismoving()){
                    if(tabuleiro.getPeca(move.x,move.y ) != null) {
                        if(!tabuleiro.getPeca(move.x,move.y).getColor().equals(tabuleiro.getLastmoved().getColor())) {
                            tabuleiro.getPeca(move.x, move.y).move(tabuleiro);
                            tabuleiro.changemoving(tabuleiro.getPeca(move.x,move.y));
                        }
                    }
                }else{
                    tabuleiro.getcurrentmove().cancelarmovimentos(tabuleiro);
                }
            });
        }
    }

    public final ArrayList<Casa> getMovimentosLegais(ChessBoard tabuleiro) {
        ArrayList<Casa> movimentosCandidatos = this.gerarMovimentos(tabuleiro);
        ArrayList<Casa> movimentosLegais = new ArrayList<>();
        String minhaCor = this.getColor();
        int originalRow = this.getRow();
        int originalCol = this.getCol();

        for (Casa destino : movimentosCandidatos) {
            Peca pecaCapturada = tabuleiro.getPeca(destino.x, destino.y);
            tabuleiro.addpeca(destino.x, destino.y, this);
            tabuleiro.addpeca(originalRow, originalCol, null);
            this.setRow(destino.x);
            this.setCol(destino.y);
            boolean isLegal = !tabuleiro.reiemcheque(minhaCor);
            tabuleiro.addpeca(originalRow, originalCol, this);
            tabuleiro.addpeca(destino.x, destino.y, pecaCapturada);
            this.setRow(originalRow);
            this.setCol(originalCol);
            if (isLegal) {
                movimentosLegais.add(destino);
            }
        }

        return movimentosLegais;
    }
}
