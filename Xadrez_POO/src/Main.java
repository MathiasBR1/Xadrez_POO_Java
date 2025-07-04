import javax.swing.*;
import java.awt.*;
import Pecas.*;
public class Main {

    public static void  adicionapeca(int row, int col, ImageIcon icon, ChessBoard board) {
        JButton square = board.getSquare(row,col);
        square.setLayout(new BorderLayout());
        JLabel label = new JLabel(icon);
        square.add(label, BorderLayout.CENTER);
        square.revalidate();
        square.repaint();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessBoard board = new ChessBoard();
            board.setVisible(true);
        });

    }

}