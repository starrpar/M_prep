package mprep;

// import java.util.List;
// import java.util.ArrayList;

public class DynamicProgrammingMethods {

    // according to some guidance, dynamic programming primarily involves simply
    // breaking down bigger problems into smaller problems and using the solutions
    // of the smaller problems to build a solution to the bigger problem
    // recursion problems are apparently a subset of that category

    // Some examples:
    // Longest Common Subsequence
    // Knapsack
    // Matrix-chain multiplication
    // Coin Change
    // Fibonacci

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

    static class LIS {

        // Stores the LIS
        static int max_ref;

        // To make use of recursive calls, this function must
        // return two things: 1) Length of LIS ending with
        // element arr[n-1]. We use max_ending_here for this
        // purpose 2) Overall maximum as the LIS may end with an
        // element before arr[n-1] max_ref is used this purpose.
        // The value of LIS of full array of size n is stored in
        // *max_ref which is our final result
        static int _lis(int arr[], int n) {
            // Base case
            if (n == 1)
                return 1;

            // 'max_ending_here' is length of LIS ending with
            // arr[n-1]
            int res, max_ending_here = 1;

            // Recursively get all LIS ending with arr[0],
            // arr[1] ... arr[n-2]. If arr[i-1] is smaller
            // than arr[n-1], and max ending with arr[n-1] needs
            // to be updated, then update it
            for (int i = 1; i < n; i++) {
                res = _lis(arr, i);
                if (arr[i - 1] < arr[n - 1]
                        && res + 1 > max_ending_here)
                    max_ending_here = res + 1;
            }

            // Compare max_ending_here with the overall max. And
            // update the overall max if needed
            if (max_ref < max_ending_here)
                max_ref = max_ending_here;

            // Return length of LIS ending with arr[n-1]
            return max_ending_here;
        }

        // The wrapper function for _lis()
        public static int lis(int arr[], int n) {
            // The max variable holds the result
            max_ref = 1;

            // The function _lis() stores its result in max
            _lis(arr, n);

            // Returns max
            return max_ref;
        }
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
