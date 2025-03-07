import GUI.SudokuGUI;
import Solver.SudokuSolver;
import Solver.Board;

public class SudokuApplication {
    public static void main(String[] args) {
        SudokuSolver sud = new Board();
        SudokuGUI gui = new SudokuGUI(sud);
    }
}
