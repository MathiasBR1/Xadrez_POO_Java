package Pecas;

import javax.swing.*;

public class PeaoBranco extends Peca{
    public PeaoBranco(int row, int col, ImageIcon imagem) {
        super(row,col,"Peao","Branco",imagem);
    }
    public void move(){
        System.out.println("O peao Branco mexeu");
    }
}
