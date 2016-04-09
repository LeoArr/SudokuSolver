import java.util.ArrayList;
import java.util.List;

/**
 * Created by leopold on 2015-02-17.
 */
public class Solver {


    public static Sudoku solve(Sudoku sudoku) {
        int contrl = 40;
        int varVar = 2;
        int outputIndex = varVar;
        int iterVar = 0;
        int change = 1;

        while (contrl != 0 && change != 0) {
            change = 0;


            if(outputIndex == varVar){
                outputIndex = 0;
                double percVar = ((81 - contrl) * 100.0f) / 81;
                System.out.println("Working" + ": " + iterVar + ": " + percVar + "% done\n");
                iterVar++;
            } else {outputIndex++;}

            contrl = 0;

            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    if (!sudoku.getSquareAt(x, y).isSolved()){
                        change += discern(x, y, sudoku);
                        change += analyze(x, y, sudoku);
                    }
                }
            }

            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    if (!sudoku.getSquareAt(x, y).isSolved()){
                        contrl++;
                    }
                }
            }
        }

        return sudoku;
    }

    private static int discern(int x, int y, Sudoku sudoku){
        //init
        List<Number> possible = sudoku.getSquareAt(x, y).getPossibles();

        //check horizontal
        for(int h = 0; h < 9; h++) {
            if(sudoku.getSquareAt(h, y).isSolved()) {
                Number e = sudoku.getSquareAt(h, y).getValue();
                if(possible.contains(e.intValue())) {
                    possible.remove(e);
                }
            }
        }

        //check vertical
        for(int v = 0; v < 9; v++) {
            if(sudoku.getSquareAt(x, v).isSolved()) {
                Number e = sudoku.getSquareAt(x, v).getValue();
                if(possible.contains(e.intValue())) {
                    possible.remove(e);
                }
            }
        }

        //check own 3x3
        int topLeftY = (y/3) * 3;
        int topLeftX = (x/3) * 3;

        for(int v = topLeftY; v < topLeftY + 3; v++){
            for(int h = topLeftX; h < topLeftX + 3; h++){
                if(sudoku.getSquareAt(h, v).isSolved()) {
                    Number e = sudoku.getSquareAt(h, v).getValue();
                    if (possible.contains(e.intValue())) {
                        possible.remove(e);
                    }
                }
            }
        }

        //discern if solved, change if so
        if(possible.size() == 1) {
            sudoku.getSquareAt(x, y).setValue(possible.get(0).intValue());
            return 1;
        }
        sudoku.getSquareAt(x, y).setPossibles(possible);
        return 0;

    }

    public static int analyze(int x, int y, Sudoku sudoku) {
        //init
        List<Number> possible = sudoku.getSquareAt(x, y).getPossibles();
        int counter;

        //check horizontal
        for(Number n : possible) {
            counter = 0;
            for(int h = 0; h < 9; h++) {
                if(h != x && !sudoku.getSquareAt(h, y).getPossibles().contains(n)) {
                    counter++;
                }
            }
            if(counter == 8){
                sudoku.getSquareAt(x, y).setValue(n.intValue());
                return 1;
            }

        }

        //check vertical
        for(Number n : possible) {
            counter = 0;
            for(int v = 0; v < 9; v++) {
                if(v != y && !sudoku.getSquareAt(x, v).getPossibles().contains(n)) {
                    counter++;
                }
            }
            if(counter == 8){
                sudoku.getSquareAt(x, y).setValue(n.intValue());
                return 1;
            }

        }

        //check own 3x3
        int topLeftY = (y/3) * 3;
        int topLeftX = (x/3) * 3;

        for(Number n : possible) {
            counter = 0;
            for (int v = topLeftY; v < topLeftY + 3; v++) {
                for (int h = topLeftX; h < topLeftX + 3; h++) {
                    if (v != y && h != x && !sudoku.getSquareAt(x, v).getPossibles().contains(n)) {
                        counter++;
                    }
                }
            }
            if(counter == 8) {
                sudoku.getSquareAt(x, y).setValue(n.intValue());
                return 1;
            }
        }

        return 0;
    }
}
