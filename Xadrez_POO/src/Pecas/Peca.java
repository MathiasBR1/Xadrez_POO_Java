package Pecas;

import javax.swing.*;

public abstract class Peca {
    protected int row;
    protected int col;
    protected String type;
    protected String color;
    protected ImageIcon imagem;

    public Peca(int row, int col, String type, String color, ImageIcon imagem) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.color = color;
        this.imagem = imagem;
    }
    public int getRow() {return this.row;}
    public int getCol() {return this.col;}
    public String getType() {return this.type;}
    public String getColor() {return this.color;}
    public ImageIcon getImagem() {return this.imagem;}

    public abstract void move();
}
