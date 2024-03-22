package mprep;

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
}
