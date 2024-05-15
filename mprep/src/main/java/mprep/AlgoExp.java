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

    // public int[] twoNumberSum(int[] array, int targetSum) {
    // int[] rtnArr = new int[2];

    // for (int i = 0; i < array.length - 1; i++) {
    // for (int j = i + 1; j < array.length; j++) {
    // if (array[i] + array[j] == targetSum) {
    // rtnArr[0] = array[i];
    // rtnArr[1] = array[j];
    // return rtnArr;
    // }
    // }
    // }
    // return new int[0];
    // }

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

    // This is the class of the input root. Do not edit it.
    public class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        // BinaryTree(int value) {
        // this.value = value;
        // this.left = null;
        // this.right = null;
        // }
    }

    public List<Integer> branchSums(BinaryTree root) {

        List<Integer> sums = new ArrayList<>();
        List<Integer> currentSum = new ArrayList<>();
        int sum = -1;
        boolean done = false;

        if (root.left == null && root.right == null) {
            sums.add(root.value);
            return sums;
        } else {
            while (sum != 0) {
                System.out.println("Will add: " + root.value + ", currentSum: " + currentSum);
                currentSum.add(root.value);
                sum = sumHelper(root, currentSum, sums, done);
                System.out.println("done = " + done);
                if (sum > 0)
                    sums.add(sum);
                currentSum.clear();
            }
        }

        System.out.println("Final: " + sums);
        return sums;
    }

    private int sumHelper(BinaryTree root, List<Integer> currentSum, List<Integer> sums, boolean done) {
        int sum = 0;

        // base case
        if (root.left == null && root.right == null) {
            System.out.println("At base case, current value is: " + root.value);
            sum = calculateSum(root.value, currentSum);
            if (sum > 0) {
                System.out.println("adding: " + sum);
                sums.add(sum);
                System.out.println("sums: " + sums);
            }
            done = true;
            System.out.println("Returning: " + sum);
            currentSum.remove(currentSum.size() - 1);
            return sum;
        }
        if (root.left != null) {
            System.out.println("Left: " + root.value);
            // sums.add(root.value);
            System.out.println("Will add: " + root.left.value + ", currentSum: " + currentSum);
            currentSum.add(root.left.value);
            sumHelper(root.left, currentSum, sums, done);
            System.out.println("After: " + currentSum);
        }
        if (root.right != null) {
            System.out.println("Right: " + root.value);
            // sums.add(root.value);
            System.out.println("Will add: " + root.right.value + ", currentSum: " + currentSum);
            currentSum.add(root.right.value);
            sumHelper(root.right, currentSum, sums, done);
            System.out.println("After: " + currentSum);
        }

        currentSum.remove(currentSum.size() - 1);
        System.out.println("Returning: " + sum);
        return sum;
    }

    private int calculateSum(int currentValue, List<Integer> sumList) {
        // sumList.add(currentValue);
        int sum = 0;
        for (int i = 0; i < sumList.size(); i++) {
            sum += sumList.get(i);
            System.out.println("Adding: " + sumList.get(i));
        }
        System.out.println("Returning from calculate: " + sum);
        return sum;
    }

    public int nodeDepths(BinaryTree root) {
        int depth = 0;
        int sum = 0;
        return walkNodes(root, depth, sum);
    }

    public int walkNodes(BinaryTree root, int depth, int sum) {

        if (root.left != null) {
            sum = walkNodes(root.left, depth + 1, sum);
        }
        if (root.right != null) {
            sum = walkNodes(root.right, depth + 1, sum);
        }

        sum += depth;
        return sum;
    }

    // class BinaryTree {
    // int value;
    // BinaryTree left;
    // BinaryTree right;

    // public BinaryTree(int value) {
    // this.value = value;
    // left = null;
    // right = null;
    // }
    // }

    public int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int currentMin = Integer.MAX_VALUE;
        int arr1Val = -1;
        int arr2Val = -1;
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                int diff = Math.abs(arrayOne[i] - arrayTwo[j]);
                if (diff < currentMin) {
                    currentMin = diff;
                    arr1Val = arrayOne[i];
                    arr2Val = arrayTwo[j];
                }
            }
        }
        return new int[] { arr1Val, arr2Val };
    }

    public static List<Integer> moveElementToEnd(
            List<Integer> array, int toMove) {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == toMove) {
                indices.add(i);
                array.add(toMove);
                array.remove(i);
            }
        }
        for (int i = 0; i < array.size(); i++) {
            array.add(i, null);
        }
        return new ArrayList<Integer>();
    }

    public boolean isMonotonic(int[] array) {

        // scenarios
        // - empty/single entry - monotonic by definition
        // - two entries - also monotonic, since whichever direction it goes is the
        // direction
        // - 3 entries - only monotonic if doesn't go in "other" direction from 2 to 3,
        // vs. from 1 to 2

        boolean retVal = true;

        if (array.length <= 2)
            return true;

        int previous = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= previous) {
                previous = array[i];
            } else {
                retVal = false;
            }
            // if got through whole array without returning false, return true
            if (i == array.length - 1 && retVal == true) {
                return true;
            }
        }
        // reset values
        retVal = true;
        previous = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= previous) {
                previous = array[i];
            } else {
                retVal = false;
            }
            // if got through whole array without returning false, return true
            if (i == array.length - 1 && retVal == true) {
                return true;
            }
        }

        return retVal;
    }

    public class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            if (!this.children.isEmpty()) {
                for (int i = 0; i < this.children.size(); i++) {
                    array = this.children.get(i).depthFirstSearch(array);
                }
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public int tandemBicycle(
            int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int speed = 0;
        int arrayLength = redShirtSpeeds.length;

        // approach:
        // find highest values (or lowest if fastest is set to false)
        // that simulateds making fastest or slowest "pairings"

        // need to think on what the trick is for this...

        // one approach: go "back-and-forth" between arrays until "expected number" of
        // spots are filled in output array
        List<Integer> speeds = new ArrayList<>();
        List<Integer> reds = new ArrayList<>();
        List<Integer> blues = new ArrayList<>();

        if (redShirtSpeeds.length <= 0 || blueShirtSpeeds.length <= 0)
            return 0;

        // move data from arrays into ArrayLists (dynamic/mutable arrays):
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            reds.add(redShirtSpeeds[i]);
        }
        for (int i = 0; i < blueShirtSpeeds.length; i++) {
            blues.add(blueShirtSpeeds[i]);
        }

        if (fastest) {
            int nextHighestRed = Collections.max(reds);
            int nextHighestBlue = Collections.max(blues);

            // go through blueShirtSpeeds array content and select the largest values to
            // fill remaining spaces

            // go until output array (list) is filled
            while (speeds.size() < arrayLength) {
                int largest = -1;
                nextHighestRed = Collections.max(reds);
                nextHighestBlue = Collections.max(blues);

                // for red, compare with next highest blue
                // before leaving red, capture next highest red
                // then go over to blue and compare with next highest red,
                // choosing max from blue until done (filled output array or reached
                // next highest red - if filled, done... if reach next highest red,
                // capture next highest blue and go back over to selecting from red
                // ... rinse and repeat until done

                System.out.println("speeds: " + speeds.size() + ", " + "reds: " + reds.size());

                // find largest in blues set
                for (int i = 0; i < blues.size(); i++) {
                    if (blues.get(i) >= largest) {
                        nextHighestBlue = largest;
                        largest = blues.get(i);
                        System.out.println("largest1: " + largest);
                    }
                }

                for (int i = 0; i < blues.size(); i++) {
                    if (blues.get(i) >= nextHighestRed && largest >= 0) {
                        speeds.add(largest);
                        System.out.println("adding1: " + largest + ", nextHighestRed: " + nextHighestRed);
                        blues.remove(blues.indexOf(largest));
                        System.out.println(blues);
                        break;
                    }
                }
                // don't continue to 2nd half of while if already meeting full array condition
                // of while loop
                if (speeds.size() >= arrayLength) {
                    break;
                }
                largest = -1;
                for (int i = 0; i < reds.size(); i++) {
                    if (reds.get(i) >= largest) {
                        nextHighestRed = largest;
                        largest = reds.get(i);
                        System.out.println("largest2: " + largest);
                    }
                }
                for (int i = 0; i < reds.size(); i++) {
                    if (reds.get(i) >= nextHighestBlue && largest >= 0) {
                        speeds.add(largest);
                        System.out.println("adding2: " + largest + ", nextHighestBlue: " + nextHighestBlue);
                        reds.remove(reds.indexOf(largest));
                        System.out.println(reds);
                        break;
                    }
                    // break out if condition for while loop is met already (before completing for
                    // loop)
                    if (speeds.size() >= arrayLength) {
                        break;
                    }
                }
            }

            for (int i = 0; i < speeds.size(); i++) {
                speed += speeds.get(i);
                System.out.println(speeds.get(i) + ", " + speed);
            }
            System.out.println(speeds + ", " + speed);
            return speed;

        }
        // that approach works for "fastest" (picking biggest numbers), but does NOT
        // work
        // for slowest - meaning you still have to "count" the higher numbers to get the
        // slowest overall speeds, it's just that those higher numbers "mask" higher
        // numbers
        // in the other set (red vs. blue) thereby not having to count EVERY high number
        // differrent philosophy...

        else {

            int highestRed = Collections.max(reds);
            int highestBlue = Collections.max(blues);

            // go through blueShirtSpeeds array content and select the largest values to
            // fill remaining spaces

            // go until output array (list) is filled
            while (speeds.size() < arrayLength) {
                int largest = -1;
                highestRed = Collections.max(reds);
                highestBlue = Collections.max(blues);

                // for red, compare with next highest blue
                // before leaving red, capture next highest red
                // then go over to blue and compare with next highest red,
                // choosing max from blue until done (filled output array or reached
                // next highest red - if filled, done... if reach next highest red,
                // capture next highest blue and go back over to selecting from red
                // ... rinse and repeat until done

                System.out.println("speeds: " + speeds.size() + ", " + "reds: " + reds.size());

                // find largest in blues set
                for (int i = 0; i < blues.size(); i++) {
                    if (blues.get(i) >= largest) {
                        largest = blues.get(i);
                        highestBlue = largest;
                        System.out.println("largest1: " + largest);
                    }
                }

                for (int i = 0; i < blues.size(); i++) {
                    if (blues.get(i) >= highestRed && largest >= 0) {
                        speeds.add(largest);
                        System.out.println("adding1: " + largest + ", removing: " + highestRed);
                        blues.remove(blues.indexOf(largest));
                        reds.remove(reds.indexOf(highestRed));
                        System.out.println(reds);
                        break;
                    }
                }
                // don't continue to 2nd half of while if already meeting full array condition
                // of while loop
                if (speeds.size() >= arrayLength) {
                    break;
                }
                largest = -1;
                for (int i = 0; i < reds.size(); i++) {
                    if (reds.get(i) >= largest) {
                        largest = reds.get(i);
                        highestRed = largest;
                        System.out.println("largest2: " + largest);
                    }
                }
                for (int i = 0; i < reds.size(); i++) {
                    if (reds.get(i) >= highestBlue && largest >= 0) {
                        speeds.add(largest);
                        System.out.println("adding2: " + largest + ", removing: " + highestBlue);
                        reds.remove(reds.indexOf(largest));
                        blues.remove(blues.indexOf(highestBlue));
                        System.out.println(blues);
                        break;
                    }
                    // break out if condition for while loop is met already (before completing for
                    // loop)
                    if (speeds.size() >= arrayLength) {
                        break;
                    }
                }
            }

            for (int i = 0; i < speeds.size(); i++) {
                speed += speeds.get(i);
                System.out.println(speeds.get(i) + ", " + speed);
            }
            System.out.println(speeds + ", " + speed);
            return speed;

        }
    }
}