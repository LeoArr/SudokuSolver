import java.util.List;

/**
 * Created by leopold on 2015-02-17.
 */
public class MainTest {
    public static void main(String[] args) {
        Square[][] board =
                {{new Square(), new Square(), new Square(), new Square(), new Square(), new Square(9), new Square(), new Square(), new Square(3)},
                {new Square(), new Square(), new Square(), new Square(3), new Square(), new Square(1), new Square(9), new Square(2), new Square()},
                {new Square(), new Square(3), new Square(), new Square(), new Square(), new Square(6), new Square(), new Square(), new Square(1)},
                {new Square(7), new Square(), new Square(8), new Square(), new Square(), new Square(3), new Square(1), new Square(), new Square()},
                {new Square(), new Square(), new Square(), new Square(), new Square(5), new Square(), new Square(), new Square(), new Square()},
                {new Square(), new Square(), new Square(6), new Square(9), new Square(), new Square(), new Square(2), new Square(), new Square(4)},
                {new Square(8), new Square(), new Square(), new Square(1), new Square(), new Square(), new Square(), new Square(5), new Square()},
                {new Square(), new Square(1), new Square(4), new Square(2), new Square(), new Square(8), new Square(), new Square(), new Square()},
                {new Square(9), new Square(), new Square(), new Square(6), new Square(), new Square(), new Square(), new Square(), new Square()}};
        Sudoku test1 = new Sudoku(board);
        System.out.println(test1);
        Sudoku test2 = Solver.solve(test1);
        System.out.println(test2);
    }
}
