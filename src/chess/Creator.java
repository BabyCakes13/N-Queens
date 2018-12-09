package chess;
import java.util.*;

/**
 * Class which handles the validation and creation of the chess table.
 */
public class Creator {

    private int size;
    private Stack<Integer> queens;
    private ArrayList<Integer> array;

    /**
     * Method which returns the current queen stack.
     * @return Returns a Stack object representing the queens and their positions.
     */
    public Stack<Integer> getQueens() { return queens; }

    /**
     * Constructor for the Creator class.
     * @param size The size of the chess table.
     */
    public Creator(int size){

        this.size = size;
        queens = new Stack<>();

    }

    /**
     * Verifies if a solution to the problem exists.
     * Takes (column, row) pairs and validates their position keeping track of the stack.
     */
    public void compute(){

        boolean exists = true;

        loop:
        for(int j = 0; j < size; j++){
            for(int i = 0; i < size; i++){

                if(validate(i, j)){

                    queens.push(i);
                    System.out.println("*pushed " + i + "*: " + queens);
                    break;

                } else if(i == size-1){

                    System.out.println("\nNO SOLUTION.\n");
                    System.out.println("LAST COLUMN: " + queens.size() + "\n");
                    exists = false;
                    break loop;

                }

            }
        }

        if (exists){
            System.out.println("\nSOLUTION: " + queens + "\n");
        }

    }

    /**
     * Validates the position of the possible queen.
     * Checks three possibilities:
     *  1. No two queens shall be on the same row.
     *  2. No two queens shall be on the same principal diagonal.
     *  3. No two queens shall be on the same secondary diagonal.
     * If the position is valid, row i will be pushed at position j in the stack.
     * @param i Row of the table
     * @param j Column of the table.
     * @return True if the position is valid.
     */
    private boolean validate(int i, int j){

        array = new ArrayList<>();

        while (!queens.empty()) {
            array.add(queens.pop());
        }

        Collections.reverse(array);

        array.add(i);

        if ( !lineConflict() || !principalDConflict(i, j) || !secondaryDConflict(i, j)){
            return false;
        }

        array.remove(array.size() - 1);

        for (Integer element : array) {
            queens.push(element);
        }

        return true;

    }

    /**
     * Method which returns true if the new element in the array is a duplicate.
     * Ensures no two queens are on the same line.
     * @return Boolean
     */
    private boolean lineConflict(){

        Set<Integer> set = new HashSet<>(array);

        if ((array.size()) != (set.size())) {

            array.remove(array.size() - 1);

            for (Integer element : array) {
                queens.push(element);
            }

            return false;
        }

        return true;

    }

    /**
     * Method which returns true if a queen in on the same principal diagonal as the current position.
     * @param i Current line to put the queen.
     * @param j Current column to put the queen.
     * @return Boolean
     */
    private boolean principalDConflict(int i, int j){

        int row = i;
        int column = j;

        while ((row != 0) && (column != 0)) {

            row--;
            column--;

            try {
                if (existsConflict(row, column)){
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {
                assert true;
            }
        }

        return true;

    }

    /**
     *  Method which returns true if a queen in on the same secondary diagonal as the current position.
     * @param i Current line to put the queen.
     * @param j Current column to put the queen.
     * @return Boolean
     */
    private boolean secondaryDConflict(int i, int j){

        int row = i;
        int column = j;

        while ((row != size - 1) && (column != 0)) {
            row++;
            column--;

            try {
                if (existsConflict(row, column)){
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {
                assert true;
            }

        }

        return true;

    }

    /**
     * If we find a queen on that position, the diagonal condition is broken.
     * @param row The current row.
     * @param column The current column.
     * @return Boolean
     */
    private boolean existsConflict(int row, int column){

        if (array.get(column) == row) {

            array.remove(array.size() - 1);

            for (Integer element : array) {
                queens.push(element);
            }

            return true;
        }

        return false;
    }

}
