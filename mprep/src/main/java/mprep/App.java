package mprep;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        RemoveElement fcns = new RemoveElement();

        int[] arr1 = { 1, 2, 2, 3, 4, 5, 5, 1, 1 };
        int[] arr2 = { 1, 2, 2, 3, 4, 5, 5, 1, 1 };
        int val = 5;
        System.out.println("\nFirst - doesn't fix: ");
        int count = fcns.removeElement1(arr1, val);
        System.out.println("\n" + count);
        System.out.println("\nSecond - does fix: ");
        count = fcns.removeElement2(arr2, val);
        System.out.println("\n" + count);
    }
}
