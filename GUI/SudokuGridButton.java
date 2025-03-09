package GUI;

import javax.swing.JButton;
import Solver.SudokuSolver;
import Solver.SudokuSolver;
import Solver.Board;


public class SudokuGridButton extends JButton {
    private int row;
    private int col;
    private int value;
    private SudokuGUI gui;
    private SudokuSolver sud;
    
    public SudokuGridButton(int row, int col, SudokuSolver sud, SudokuGUI gui){
        this.row = row;
        this.col = col;
        this.sud = sud;
        this.gui = gui;
        this.setText("");
        this.addActionListener(e -> {
            gui.setSelectedButton(this);
            
            /* if (this.sud.get(row, col) == 0){
                this.sud.set(row, col, 1);
                this.setText("1");
            } else {
                this.sud.set(row, col, 0);
                this.setText("");
            } */
        });
    }

    public void update(int value) {
        setText(value == 0 ? "" : String.valueOf(value));
    }
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }

}
