package Pecas;

import Tabuleiro.Casa;
import Tabuleiro.ChessBoard;

import javax.swing.*;
import java.util.ArrayList;

public class ReiPreto extends Peca{
    public ReiPreto(int row, int col, ImageIcon imagem) {super(row,col,"Rei","Preto",imagem);}

    @Override
    public ArrayList<Casa> getmoves(ChessBoard tabuleiro) {
        return null;
    }

    public void move(ChessBoard tabuleiro){}
}
