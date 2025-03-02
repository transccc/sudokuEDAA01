
package Solver;
import java.util.HashSet;
import java.util.Set;
public class Board implements SudokuSolver {
    private int[][][]fullboard;
    private int row;
    private int col;

	public Board() {
        this.row = 0;
        this.col= 0;
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
        int boxIndex = row + col/3;
        this.row = row%3;
        this.col = col%3;
        return boxIndex;
    }
    private int findboxRow(int row){
        this.row = row%3;
        return row/3;
    }
    private int findboxCol(int col){
        this.col = col%3;
        return col/3;
    }
    private Set<Integer> rowIritiate(int row){
        int startbox = findboxRow(row);
        Set<Integer> trunum = new HashSet<>();
        for(int i = 0; i<3; i++){
            for(int j : fullboard[this.row][startbox + i])
            trunum.add(j);
            }
        return trunum;
        
    }
    private Set<Integer> colIritiate(int col){
        int startbox = findboxCol(row);
        Set<Integer> trunum = new HashSet<>();
        for(int i = 0; i<3; i++){
            for(int j : fullboard[this.col][startbox + i])
            trunum.add(j);
            }
        return trunum;
    }
    @Override
    public void set(int row, int col, int digit){
        int boxIndex = findbox(row, col);
        fullboard[boxIndex][this.row][this.col] = digit;
    }
    @Override
    public int get(int row, int col){
        int boxIndex = findbox(row, col);
        return fullboard[boxIndex][this.row][this.col];
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
    public void clearAll(){
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
    private boolean checkBox(int row, int col){
        
        Set<Integer> trunum = new HashSet<>();
        int boxIndex = findbox(row, col);
        for(int[] row1 : fullboard[boxIndex]){
            for(int i : row1){
                trunum.add(i);
            }
        }
           return trunum.size() == 9;
    }
    private boolean checkBox(int boxindex){
        Set<Integer> trunum = new HashSet<>();
        for(int[] row1 : fullboard[boxindex]){
            for(int i : row1){
                trunum.add(i);
            }
        }
           return trunum.size() == 9;
    }
    private boolean checkRow(int row){
        return rowIritiate(row).size() == 9;

    }
    private boolean checkCol(int col){
        return colIritiate(col).size() == 9;
    }
    @Override
    public boolean isValid(int row, int col){
        return checkBox(row,col) && checkRow(row) && checkCol(col);

    }//etc
    @Override
    public boolean isAllValid(){
        for(int i = 0; i<9; i++){
            if(!checkBox(i)|| !checkRow(i) || !checkCol(i)){
                return false;
            
            }
        }
        return true; 

    }
    private void con2Dto3D(int[][] m){
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                fullboard[findbox(i, j)][this.row][this.col] = m[i][j];
            }
        }
        
    }
    private int[][] con3Dto2D(){
        int[][] board2d = new int[9][9];
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                board2d[i][j] = fullboard[findbox(i, j)][this.row][this.col];
            }
        }
        return board2d;
    }
    
    @Override 
    public void setGrid(int[][] m){
        con2Dto3D(m);
    }
    @Override
    public int[][] getGrid(){
        return con3Dto2D();
    }

}
