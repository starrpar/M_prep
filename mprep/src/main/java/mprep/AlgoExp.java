package mprep;

import java.util.*;

public class AlgoExp {

    public int[] twoNumberSum(int[] array, int targetSum) {
        int[] rtnArr = new int[2];

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    rtnArr[0] = array[i];
                    rtnArr[1] = array[j];
                    return rtnArr;
                }
            }
        }
        return new int[0];
    }

    public boolean isValidSubsequence(
            List<Integer> array, List<Integer> sequence) {
        int j = 0;
        // System.out.println(array + ", size: " + array.size());
        // System.out.println(sequence + ", size: " + sequence.size());
        for (int i = 0; i < array.size(); i++) {
            // System.out.println("i: " + i + " : " + array.get(i) + ", j: " + j + " : " +
            // sequence.get(j));
            if (array.get(i).equals(sequence.get(j))) {
                // System.out.println("Matched");
                if (j >= sequence.size() - 1) {
                    return true;
                }
                j++;
            }
            continue;
        }
        return false;
    }

    public int[] twoNumberSum(int[] array, int targetSum) {
        int[] rtnArr = new int[2];

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    rtnArr[0] = array[i];
                    rtnArr[1] = array[j];
                    return rtnArr;
                }
            }
        }
        return new int[0];
    }

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> teamWins = new HashMap<>();
        System.out.println(competitions);
        System.out.println(results);

        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 1) {
                if (teamWins.get(competitions.get(i).get(0)) == null) {
                    teamWins.put(competitions.get(i).get(0), 3);
                } else {
                    teamWins.put(competitions.get(i).get(0), teamWins.get(competitions.get(i).get(0)) + 3);
                }
            } else {
                if (teamWins.get(competitions.get(i).get(1)) == null) {
                    teamWins.put(competitions.get(i).get(1), 3);
                } else {
                    teamWins.put(competitions.get(i).get(1), teamWins.get(competitions.get(i).get(1)) + 3);
                }
            }
        }
        System.out.println(teamWins);
        // crass approach to finding top dog
        String winner = "";
        int numWins = 0;
        for (String s : teamWins.keySet()) {
            if (teamWins.get(s) != null && teamWins.get(s) > numWins) {
                numWins = teamWins.get(s);
                winner = s;
            }
        }
        System.out.println(winner);
        return winner;
    }

    // public static int findClosestValueInBst(BST tree, int target) {

    // boolean found = false;

    // System.out.println(tree.value + ", " + target);

    // // only cases failing: targets: 29751 && 30000 (both closer to 55000, not
    // 4500)
    // // {"id": "100", "left": "5", "right": "502", "value": 100},
    // // {"id": "502", "left": "204", "right": "55000", "value": 502},
    // // {"id": "55000", "left": "1001", "right": null, "value": 55000},
    // // {"id": "1001", "left": null, "right": "4500", "value": 1001},
    // // {"id": "4500", "left": null, "right": null, "value": 4500},

    // // base case
    // if (tree.value == target) {
    // return target;
    // }
    // // navigate
    // int previous = 1;
    // int retVal = 0;
    // while (!found) {
    // if (tree.value > target) {
    // if (tree.left != null) {
    // System.out.println(tree.value);
    // System.out.println("Prev1:" + Math.abs(previous - target));
    // System.out.println("Next1:" + Math.abs(tree.left.value - target));
    // if (Math.abs(tree.value - target) < Math.abs(previous - target)) {
    // System.out.println("changing to: " + tree.value);
    // previous = tree.value;
    // }
    // tree = tree.left;
    // System.out.println(tree.value);
    // } else {
    // System.out.println("Prev2:" + Math.abs(previous - target));
    // System.out.println("Next2:" + Math.abs(tree.value - target));
    // if (Math.abs(previous - target) < Math.abs(tree.value - target)) {
    // System.out.println("using previous" + previous);
    // retVal = previous;
    // } else {
    // retVal = tree.value;
    // }
    // System.out.println("return: " + retVal);
    // found = true;
    // return retVal;
    // }
    // } else if (tree.right != null) {
    // // System.out.println(tree.value);
    // System.out.println("Prev3:" + Math.abs(previous - target));
    // System.out.println("Next3:" + Math.abs(tree.value - target));
    // if (Math.abs(tree.value - target) < Math.abs(previous - target)) {
    // System.out.println("changing to: " + tree.value);
    // previous = tree.value;
    // }
    // tree = tree.right;
    // // System.out.println(tree.value);
    // } else {
    // System.out.println("Prev4:" + Math.abs(previous - target));
    // System.out.println("Next4:" + Math.abs(tree.value - target));
    // if (Math.abs(previous - target) < Math.abs(tree.value - target)) {
    // System.out.println("using previous" + previous);
    // retVal = previous;
    // } else {
    // retVal = tree.value;
    // }
    // System.out.println("return: " + retVal);
    // found = true;
    // return retVal;
    // }
    // }
    // return -1;
    // }

    // static class BST {
    // public int value;
    // public BST left;
    // public BST right;

    // public BST(int value) {
    // this.value = value;
    // }
    // }

    // not working:
    public int nonConstructibleChange(int[] coins) {
        int maxCoinSum = 0;
        for (int i = 0; i < coins.length; i++) {
            System.out.print(coins[i]);
            maxCoinSum += coins[i];
        }
        Arrays.sort(coins);
        System.out.println();
        for (int i = 0; i < coins.length; i++) {
            System.out.print(coins[i]);
        }

        int coinSum = 0;

        // create a list of all possible sums of any combination from 1 coin up to all
        // coins
        List<Integer> coinSums = new ArrayList<>();

        // brute force would be to simply add up the various possible combinations

        // Q: how to create a matrix of all possible combinations?
        // use recursion... seems best approach

        // summingHelperMethod();

        for (int i = 0; i < coins.length; i++) {
            coinSums.add(coins[i]); // 1, 1, 2, 3, 5, 7, 22
            for (int j = i + 1; j < coins.length; j++) {
                coinSums.add(coins[i] + coins[j]); // 1+1, 1+2, 1+3, 1+5, 1+7, 1+22
                                                   // 2+1, 2+2, 2+3, 2+5, 2+7, 2+22
            }
        }
        Collections.sort(coinSums);
        for (int i = 0; i < coinSums.size(); i++) {
            System.out.print(coinSums.get(i) + ", ");
        }
        System.out.println();
        int value = 1;
        boolean found = false;
        int minNotAble = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = i + 1; j < coins.length; j++) {
                System.out.println("value: " + value + ", coins: " + coins[i]);
                if (coins[i] == value) {
                    System.out.println("Matched");
                    value++;
                    break;
                }
            }
            if (found) {
                minNotAble = i;
            }
        }
        return minNotAble;
    }

}