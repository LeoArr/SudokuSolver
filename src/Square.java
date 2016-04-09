import java.util.ArrayList;
import java.util.List;

/**
 * Created by leopold on 2015-02-17.
 */
public class Square {
    private boolean solved = false;
    int value;
    List<Number> possibles = new ArrayList<Number>(9);

    public List<Number> getPossibles() {
        return possibles;
    }

    public void setPossibles(List<Number> possibles) {
        this.possibles = possibles;
    }

    public Square() {
        this.possibles = new ArrayList<Number>(9);
        for(int i = 1; i <= 9; i++) {
            Number a = i;
            this.possibles.add(a);
        }
    }

    public Square(int n){
        this.solved = true;
        this.value = n;
        this.possibles.add(0);
    }

    public boolean isSolved() {
        return solved;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        this.solved = true;
        this.possibles.clear();
        this.possibles.add(0);
    }

    @Override
    public String toString() {
        if (this.solved){
            return String.valueOf(getValue());
        } else {
            return " ";
        }
    }
}
