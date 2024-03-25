package mprep;

import java.util.List;
import java.util.ArrayList;;

public class DynamicProgrammingMethods {

    // according to some guidance, dynamic programming primarily involves simply
    // breaking down bigger problems into smaller problems and using the solutions
    // of the smaller problems to build a solution to the bigger problem
    // recursion problems are apparently a subset of that category

    int calculateNthFibonacci(int n) {
        return fibo(n);
    }

    int fibo(int n) {
        int fibAns = 0;

        if (n <= 1) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            fibAns = fibo(n - 1) + fibo(n - 2);
        }
        return fibAns;
    }

    public class NQueensProblem {

        // Solve N Queen problem using backtracking, with recursion.
        boolean solveNQueens(int n) {

            // initialize board to all '0'
            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = 0;
                }
            }

            if (nQueenHelper(board, 0, n) == false) {
                System.out.print("\nNQueenProblem - Solution does not exist for n = " + n);
                return false;
            }

            printSolution(board, n);

            return true;
        }

        // Recursive method to attempt placing queens and rolling back if doesn't work
        // fully
        boolean nQueenHelper(int board[][], int col, int n) {

            // Base case: If all queens are placed, back out, returning true
            if (col >= n)
                return true;

            // Consider this column and try placing
            // this queen in all rows one by one
            for (int i = 0; i < n; i++) {

                // Check if the queen can be placed on
                // board[i][col]
                if (safeMove(board, i, col, n)) {

                    // output for debugging visibility
                    System.out.print("\nplacing queen at: " + i + ", " + col);

                    // Place current queen at [i][col]
                    board[i][col] = 1;

                    // Recursively try to place each queen
                    if (nQueenHelper(board, col + 1, n) == true) {
                        return true;
                    }

                    // output for debugging visibility
                    System.out.print("\nbacktracking: " + i + ", " + col);

                    // if placing a queen on current columns fails (returns false above)
                    // remove queen from current location [i][col]
                    board[i][col] = 0;
                }
            }

            // if no row works in current column, return false
            return false;
        }

        // Check only for columns "to left" (columns < current) for
        // if any can attack queen in current column and row location
        // return true if not in danger of any attack yet
        boolean safeMove(int board[][], int row, int col, int n) {
            int i, j;

            // Check row
            for (i = 0; i < col; i++)
                if (board[row][i] == 1)
                    return false;

            // Check diagonal above current row
            // from current row, col, go left and up 1 row / col at a time
            // to a limit of when either i or j = 0
            for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
                if (board[i][j] == 1)
                    return false;

            // Check diagonal below current row
            // from current row, col, go left and down by 1 row / col at a time
            // to a limit of when either i = n - 1 or j = 0
            for (i = row, j = col; j >= 0 && i < n; i++, j--)
                if (board[i][j] == 1)
                    return false;

            // return true if no attacking conditions apply above
            return true;
        }

        // print out representation of board for visiblity of solution
        void printSolution(int board[][], int n) {
            System.out.println("\n\nSolution: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1)
                        System.out.print("Q ");
                    else
                        System.out.print(". ");
                }
                System.out.println();
            }
        }
    }
}
