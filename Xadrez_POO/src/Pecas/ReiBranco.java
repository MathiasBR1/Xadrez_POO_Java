package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.util.ArrayList;

public class ReiBranco extends Peca{
    public ReiBranco(int row, int col, ImageIcon imagem) {super(row,col,"Rei","Branco",imagem);}

    @Override
    public ArrayList<Casa> getmoves(ChessBoard tabuleiro) {
        return null;
    }

    public void move(ChessBoard tabuleiro){}
}
