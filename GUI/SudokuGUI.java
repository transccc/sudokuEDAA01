package GUI;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.GridLayout;

import Solver.SudokuSolver;
import Solver.Board;



public class SudokuGUI {
    private JFrame frame;
    private Container pane;
    private SudokuSolver sud;
    private static final int SIZE = Board.SIZE;
    private static final int SUBSIZE = Board.SUBSIZE;

    private SudokuGridButton[][] buttons;

    private JLabel messageField;
    private JProgressBar progressBar;

    public SudokuGUI(SudokuSolver sud){
        this.sud = sud;
        frame = new JFrame("Sudoku");

        pane = frame.getContentPane(); // Get the content pane of the JFrame
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS)); // Set the layout of the content pane to BoxLayout with vertical alignment


    }

    public void makeGrid(){
        this.buttonGrid = new SudokuGridButton[SIZE][SIZE];
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(SIZE , SIZE));
        grid.setPreferredSize(new dimension(500, 500));

        for(int i=0; i<SIZE*SIZE;i++){
            int row = i/SIZE;
            int col = i%SIZE;
            SudokuGridButton button = new SudokuGridButton(row, col, sud);
            buttonGrid[row][col] = button;
            grid.add(button);
        }
    }

    private void makeButtons(){
        JButton solve = new JButton("Solve");
        JButton check = new JButton( "Check");
        JButton clear = new JButton("Clear");

        solve.addActionListener(e -> {
            
        });

        check.addActionListener((e) -> {
            
        });

        clear.addActionListener((e) -> {
            
        });
        
    }
}
