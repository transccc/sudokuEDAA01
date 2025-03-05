package GUI;

import javax.swing.JButton;

import Solver.SudokuSolver;




public class SudokuGridButton extends JButton {
    private int row;
    private int col;
    private int value;

    private SudokuSolver sud;
    
    public SudokuGridButton(int row, int col, SudokuSolver sud){
        this.row = row;
        this.col = col;
        this.sud = sud;
        this.setText("");
        this.addActionListener(e -> {
            if (this.sud.get(row, col) == 0){
                this.sud.set(row, col, 1);
                this.setText("1");
            } else {
                this.sud.set(row, col, 0);
                this.setText("");
            }
        });
    }
}
