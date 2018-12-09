package main;

import chess.Creator;
import chess.Display;

import java.util.Scanner;

public class Main {

    /**
     * Creates and displays the chess table of size N with the solution or partial solution.
     * @param args Arguments passed to main. Not neccesarry.
     */
    public static void main(String[] args) {

        int size = read_number();

        Creator creator = new Creator(size);
        creator.compute();

        Display display = new Display(size, creator.getQueens());
        display.displayChessTable();

    }

    /**
     * Method which reads and validates the size of the chess table.
     * @return The size of the chess table.
     */
    private static int read_number(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the size of the table. ( 1 < size < 100)");
        int size;

        try{

            size = keyboard.nextInt();

            if ( (size > 100) || (size < 1)){
                System.out.println("Invalid size.");
                System.exit(-1);
                return -1;
            }

            return size;

        }catch (Exception e){
            System.out.println("Invalid size.");
            System.exit(-1);
        }

        return 0;

    }
}
