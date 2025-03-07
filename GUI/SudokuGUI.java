package GUI;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import Solver.SudokuSolver;
import Solver.Board;



public class SudokuGUI {
    private JFrame frame;
    private Container pane;
    private SudokuSolver sud;
    private static final int size = Board.size;
    private static final int subsize = Board.subsize;

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
        this.buttons = new SudokuGridButton[size][size];
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(size , size));
        grid.setPreferredSize(new Dimension(500, 500));

        for(int i=0; i<size*size;i++){
            int row = i/size;
            int col = i%size;
            SudokuGridButton button = new SudokuGridButton(row, col, sud);
            buttons[row][col] = button;
            grid.add(button);
        }
    }

    private void makeButtons(){
        JButton solve = new JButton("Solve");
        JButton clear = new JButton("Clear");

        solve.addActionListener(e -> {
            
        });

        clear.addActionListener((e) -> {
            sud.clearAll();
            update();
        });

    }

    private void show() {
        frame.pack();
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void update() {    // Update the GUI with the current state of the Sudoku grid
        int[][] grid = sud.getGrid();
        int amount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (sud.get(r, c) != 0) {
                    amount++;
                }
                buttons[r][c].update(grid[r][c]);
            }
        }
        progressBar.setValue(amount);
    }


    private void solveButton(JButton solve){

    }


}
