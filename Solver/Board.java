
package Solver;
import java.util.HashSet;
import java.util.Set;
public class Board implements SudokuSolver {
	private int[][] matrix;
    private int[][][]fullboard;
    private int row;
    private int col;

	public Board() {
        this.row = 0;
        this.col= 0;
        this.matrix= new int[][]{
        { 0, 0, 0},
        { 0, 0, 0},
        { 0, 0, 0} };;
        this.fullboard[0] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.fullboard[1] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.fullboard[2] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.fullboard[3] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.fullboard[4] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.fullboard[5] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.fullboard[6] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.fullboard[7] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.fullboard[8] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
	}
    private int findbox(int row, int col){
        int boxIndex = (row / 3) * 3 + (col / 3);
        this.row = row%3;
        this.col = col%3;
        return boxIndex;
    }
    @Override
    public void set(int row, int col, int digit){
        int boxIndex = findbox(row, col);
        fullboard[boxIndex][this.row][this.col] = digit;
    }
    @Override
    public int get(int row, int col){
        int boxIndex = row  + (col / 3);
        row = row%3;
        col = col%3;
        return fullboard[boxIndex][row][col];
    }
    @Override
    public void clear(int row, int col){
        int boxIndex = findbox(row, col);
        fullboard[boxIndex] = new int[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
    }
    @Override
    public boolean isValid(int row, int col){
        Set<Integer> trunum = new HashSet<>();
        int boxIndex = findbox(row, col);
        for(int[] row1 : fullboard[boxIndex]){
            for(int i : row1){
                trunum.add(i);
            }
        }
        if(trunum.size() == 9){
            return true;
        }
        else{
            return false;
        }
    }
}
