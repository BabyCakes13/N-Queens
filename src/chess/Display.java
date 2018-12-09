package chess;

import java.util.Stack;

/**
 * Class which handles pretty printing of the chess table.
 *Pretty neat, huh?
 */
public class Display {

    private int size;
    private Stack<Integer> queens;

    /**
     * Constructor for the Display class.
     * @param size The size of the chess table.
     * @param queens The stack of queens and their positions.
     */
    public Display(int size, Stack<Integer> queens){

        this.size = size;
        this.queens = queens;

    }

    /**
     * Pretty prints the chess table.
     */
    public void displayChessTable(){

        for(int row = 0; row < size; row++){
            for(int column = 0; column < size; column++){

                try{
                    if( row == queens.get(column)){
                        System.out.print("X  ");
                    }else{
                        System.out.print("O  ");
                    }
                }catch (IndexOutOfBoundsException e){
                    System.out.print("O  ");
                }


            }
            System.out.println("");
        }

    }

}
