package mprep;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        RemoveElement fcns = new RemoveElement();

        int[] arr = { 1, 2, 2, 3, 4, 5, 5, 1, 1 };
        int val = 5;
        int count = fcns.removeElement(arr, val);
        System.out.println(count);
    }
}
