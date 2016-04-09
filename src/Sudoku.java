import java.util.List;

/**
 * Created by leopold on 2015-02-17.
 */
public class Sudoku {
    private Square[][] board;

    public Sudoku(Square[][] board) {
        if(board.length == 9 && board[0].length == 9) {
            this.board = board;
        } else {
            throw new AbstractMethodError();
        }
    }

    public Sudoku() {
        this.board = new Square[9][9];
    }

    public Square getSquareAt(int x, int y) {
        return board[y][x];
    }

    public void setSquareAt(int x, int y, Square square) {
        this.board[y][x] = square;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Sudoku:" + "\n");
        for(int y = 0; y <= board.length + 3; y++){
            for(int x = 0; x <= board[0].length + 3; x++){
                if ((y % 4 == 0) || (x % 4 == 0)){
                    result.append("###");
                } else {
                    result.append(" " + board[y - (y + 4)/4][x - (x + 4)/4] + " ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
