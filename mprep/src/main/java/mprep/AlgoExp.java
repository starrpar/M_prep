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

    public int[] sortedSquaredArray(int[] array) {
        if (array.length <= 0)
            return new int[] {};

        int[] rtnArr = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            rtnArr[i] = array[i] * array[i];
            // System.out.println(array[i] + ", " + rtnArr[i]);
        }
        Arrays.sort(rtnArr);

        return rtnArr;
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

    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int changeTotal = 0;
        for (int coin : coins) {
            if (coin > changeTotal + 1) {
                return changeTotal + 1;
            }
            changeTotal += coin;
        }

        return changeTotal + 1; // if got to end of coins array
    }

    public int[][] transposeMatrix(int[][] matrix) {

        // assume at a minimum a 1x1
        // rows are first dimension, columns second
        // so [[1,2]] has 1 row, 2 columns, so is a 1x2
        // whereas [[1,2],[3,4],[5,6]] is 3x2

        int[][] rtnMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rtnMatrix[j][i] = matrix[i][j];
            }
        }
        return rtnMatrix;
    }

    public int findClosestValueInBst(BST tree, int target) {

        boolean found = false;

        System.out.println(tree.value + ", " + target);

        // only cases failing: targets: 29751 && 30000 (both closer to 55000, not 4500)
        // {"id": "100", "left": "5", "right": "502", "value": 100},
        // {"id": "502", "left": "204", "right": "55000", "value": 502},
        // {"id": "55000", "left": "1001", "right": null, "value": 55000},
        // {"id": "1001", "left": null, "right": "4500", "value": 1001},
        // {"id": "4500", "left": null, "right": null, "value": 4500},

        // base case
        if (tree.value == target) {
            return target;
        }
        // navigate
        int previous = 1;
        int retVal = 0;
        while (!found) {
            if (tree.value > target) {
                if (tree.left != null) {
                    System.out.println(tree.value);
                    System.out.println("Prev1:" + Math.abs(previous - target));
                    System.out.println("Next1:" + Math.abs(tree.left.value - target));
                    if (Math.abs(tree.value - target) < Math.abs(previous - target)) {
                        System.out.println("changing to: " + tree.value);
                        previous = tree.value;
                    }
                    tree = tree.left;
                    System.out.println(tree.value);
                } else {
                    System.out.println("Prev2:" + Math.abs(previous - target));
                    System.out.println("Next2:" + Math.abs(tree.value - target));
                    if (Math.abs(previous - target) < Math.abs(tree.value - target)) {
                        System.out.println("using previous" + previous);
                        retVal = previous;
                    } else {
                        retVal = tree.value;
                    }
                    System.out.println("return: " + retVal);
                    found = true;
                    return retVal;
                }
            } else if (tree.right != null) {
                // System.out.println(tree.value);
                System.out.println("Prev3:" + Math.abs(previous - target));
                System.out.println("Next3:" + Math.abs(tree.value - target));
                if (Math.abs(tree.value - target) < Math.abs(previous - target)) {
                    System.out.println("changing to: " + tree.value);
                    previous = tree.value;
                }
                tree = tree.right;
                // System.out.println(tree.value);
            } else {
                System.out.println("Prev4:" + Math.abs(previous - target));
                System.out.println("Next4:" + Math.abs(tree.value - target));
                if (Math.abs(previous - target) < Math.abs(tree.value - target)) {
                    System.out.println("using previous" + previous);
                    retVal = previous;
                } else {
                    retVal = tree.value;
                }
                System.out.println("return: " + retVal);
                found = true;
                return retVal;
            }
        }
        return -1;
    }

    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
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

    // depthFirstSearch
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

    public int minimumWaitingTime(int[] queries) {
        // assumptions - input array is non-empty
        System.out.println("input array: ");
        for (int i = 0; i < queries.length - 1; i++) {
            System.out.print(queries[i]);
        }
        // time values are how long query runs for
        int waitTimeTotal = 0;
        if (queries.length > 0) {
            Arrays.sort(queries);
            System.out.println("\nsorted: ");
            for (int i = 0; i < queries.length - 1; i++) {
                System.out.print(queries[i]);
            }
            for (int i = 0; i < queries.length - 1; i++) {
                for (int j = 0; j <= i; j++) {
                    waitTimeTotal += queries[j];
                    System.out.print("\nwaitTimeTotal: " + waitTimeTotal);
                }
            }
        } else {
            waitTimeTotal = -1;
        }

        return waitTimeTotal;
    }

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // assumptions - both input arrays will contain AT LEAST 1 entry each

        boolean photoCanBeTaken = true;

        System.out.println("red: ");
        for (int i = 0; i < redShirtHeights.size(); i++) {
            System.out.print(redShirtHeights.get(i));
        }
        System.out.println("\nblue: ");
        for (int i = 0; i < redShirtHeights.size(); i++) {
            System.out.print(blueShirtHeights.get(i));
        }
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        System.out.println("\nred, sorted: ");
        for (int i = 0; i < redShirtHeights.size(); i++) {
            System.out.print(redShirtHeights.get(i));
        }
        System.out.println("\nblue, sorted: ");
        for (int i = 0; i < redShirtHeights.size(); i++) {
            System.out.print(blueShirtHeights.get(i));
        }

        // first determine which row must be front and which is back
        if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            // then determine if all students in respective rows are of acceptable height
            // i.e. that all students in the back row are "strictly" taller than each
            // respective
            // student in the front row
            for (int i = 0; i < redShirtHeights.size(); i++) {
                if (!(redShirtHeights.get(i) > blueShirtHeights.get(i))) {
                    photoCanBeTaken = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < redShirtHeights.size(); i++) {
                if (!(blueShirtHeights.get(i) > redShirtHeights.get(i))) {
                    photoCanBeTaken = false;
                    break;
                }
            }
        }
        return photoCanBeTaken;
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

    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        // assumptions - each job takes 1 day to complete;
        // - deadline is how many days from the beginning you have to complete it
        // - only 1 job can be worked on at a time (no parallel tasks)

        int retVal = 0;
        int length_of_week = 7;

        // values in jobs are "deadline": number of days until must be complete,
        // "payment": dollar amount payment
        // maximizing profit means completing the most profitable jobs possibly within
        // the constrained timeframe

        // each job takes 1 day, so time to complete is uniform

        // methodology: find most profitable and see how many can be fit in before their
        // deadline
        // strategy: work backwards starting with most-profitable for each day
        // update: need to compare payments first - example, if there is a 7 day job
        // that pays way more than
        // the total of all others combined, then THAT is the job to do, only...
        // (so DO need to work backwards)

        // any for deadline of 7? 6?
        // which is most profitable for given day
        // sum together - return total

        // create a (temp) list to stuff payment amounts in for a given deadline
        // then sort them and keep only the highest value for that given day's work

        // TODO:
        // need to add ability to handle longest deadline AND all those less than that
        // (meaning for all
        // deadlines of 2, for instance, do the highest paying 2 on day 1, and do the
        // next highest paying
        // job on the next day (day 2))
        Map<Integer, List<Integer>> deadlinePayments = new HashMap<>();
        Map<Integer, List<Integer>> candidates = new HashMap<>();
        // for(Map<String, Integer> job : jobs){
        // if(job.keySet().contains("deadline")){
        // System.out.println("deadline: " + job.get("deadline"));
        // }
        // if(job.keySet().contains("payment")){
        // System.out.println("payment: " + job.get("payment"));
        // }
        // }

        // System.out.println("*******************************");

        List<Integer> tmpPayments = new ArrayList<>();
        for (Map<String, Integer> job : jobs) {
            int deadline = 1;
            if (job.keySet().contains("deadline")) {
                deadline = job.get("deadline");
                // System.out.println("deadline: " + deadline);
                if (deadline > length_of_week) {
                    deadline = length_of_week;
                    // System.out.println("modified deadline: " + deadline);
                }
            }
            int payment = 0;
            if (job.keySet().contains("payment")) {
                payment = job.get("payment");
                // System.out.println("payment: " + payment);
            }

            System.out.println("*******************************");

            // because each job takes 1 day, the approach could be to store up to as many
            // day's worth of
            // jobs as that deadline equals (so for deadline of 7, chose from 7 jobs, for
            // deadline of 6, choose from 6
            // sorted by highest paying first - need to select highest paid that "fit"
            // within the timeframe)
            if (job.keySet().contains("payment")) {
                System.out.println(
                        "deadline:" + deadline + " not contained?  " + !deadlinePayments.keySet().contains(deadline));
                if (!(deadlinePayments.keySet().contains(deadline))) {
                    tmpPayments = new ArrayList<>();
                } else {
                    tmpPayments = deadlinePayments.get(deadline);
                }
                int pmt = job.get("payment");
                System.out.println("deadline:" + deadline + " inserting pmt: " + pmt);
                System.out.println("tmpPayments already contains " + tmpPayments.size() + " records");
                for (int i = 0; i < tmpPayments.size(); i++) {
                    System.out.println("tmpPayment existing content: " + tmpPayments.get(i));
                }
                tmpPayments.add(pmt);
                for (int i = 0; i < tmpPayments.size(); i++) {
                    System.out.println("tmpPayment contents after insertion: " + tmpPayments.get(i));
                }
                System.out.println(
                        "Inserting into deadlinePayments; tmpPayments contains " + tmpPayments.size() + " records");
                deadlinePayments.put(deadline, tmpPayments);
                System.out.println("Inserting deadline: " + deadline + ", payment: " + payment);
                System.out.println("tmpPayments length: " + tmpPayments.size());
            }

            System.out.println("*******************************");
            System.out.println("*******************************");
        }

        // sort payments lists in reverse order (highest amount first)
        for (Integer k : deadlinePayments.keySet()) {
            List<Integer> pymts = deadlinePayments.get(k);
            // Collections.sort(pymts);
            System.out.println("k:" + k + ", pymts size:" + pymts.size());
            for (int i = 0; i < pymts.size(); i++) {
                System.out.println("i:" + i + ", " + pymts.get(i));
            }
            deadlinePayments.put(k, pymts);
        }

        Map<Integer, List<Integer>> paymentForEachDay = new HashMap<>();

        // now go through list of payments for each deadline day and choose largest
        // paying job for that day
        System.out.println("deadlinePayments contains " + deadlinePayments.size() + " records...");

        // fill all days with jobs (deadline) that will allow enough time (doesn't have
        // to be compressed,
        // since answer only wants payment total, so can fill from back to front for
        // easiest calculation)

        // sort by highest paying jobs, then "fit in" by going in reverse order in the
        // week by deadline

        System.out.println("deadlinePayments...");
        for (Integer k : deadlinePayments.keySet()) {
            for (int j = 1; j <= length_of_week; j++) {
                // System.out.println("k: " + k + " j: " + j);
                if (Integer.valueOf(k) == j) {
                    List<Integer> pymts = deadlinePayments.get(k);
                    System.out.println(
                            "Deadline matches (" + k + "); Payments list contains " + pymts.size() + " records...");
                    for (int i = 0; i < pymts.size(); i++) {
                        System.out.print("i=" + i + ", " + k + ":" + pymts.get(i) + ";  ");
                    }
                    System.out.println();
                    paymentForEachDay.put(k, pymts);
                }
            }
        }

        // last part - pick highest paying tasks and work backwards in timeframe to fit
        // them in
        // specifically pick highest paying job for last day it can be done, and if next
        // highest can still
        // fit within timeframe, add that too
        // for each day (moving backwards through week) highest paying jobs with a
        // deadline of that day
        // or more is right job to choose - fill each days slot and once day 0 is filled
        // we're done
        List<Integer> payments = new ArrayList<>();
        // List<Integer> candidates = new ArrayList<>();
        int highest = 0;
        int deadlineMatchingHighestPayment = -1;
        Map<Integer, List<Integer>> candidatePayments = new HashMap<>();
        List<Integer> candidateList = new ArrayList<>();
        for (Integer k : paymentForEachDay.keySet()) {
            for (int j = length_of_week; j >= 1; j--) {
                if (Integer.valueOf(k) >= j) {
                    // eligible candidates for given j
                    System.out.println("Deadline matches - value: " + k + ", j = " + j);
                    List<Integer> pymts = paymentForEachDay.get(k);
                    for (Integer n : pymts) {
                        if (n > highest) {
                            if (highest > 0) {
                                System.out.println("...adding " + highest + " to candidatesList");
                                candidateList.add(highest);
                                Collections.reverse(candidateList);
                                System.out.println("...adding candidatesList containing " + candidateList.size()
                                        + " records to candidatePayments for deadline: " + k);
                                candidatePayments.put(k, candidateList);
                            }
                            highest = n;
                            deadlineMatchingHighestPayment = Integer.valueOf(k);
                            System.out.println(
                                    "highest: " + highest + " for deadline: " + deadlineMatchingHighestPayment);
                        }
                        // for(int i = 0; i < pymts.size(); i++){
                        // System.out.print(pymts.get(i));
                        // }
                        System.out.println(
                                "\nPayments list for deadline: " + k + " contains " + pymts.size() + " records...");
                    }

                }
            }
            payments.add(highest);

            // cleanup and reset values
            // Collections.reverse(candidateList);
            // candidatePayments.put(k, candidateList);
            List<Integer> tmpPmts = paymentForEachDay.get(deadlineMatchingHighestPayment);
            Collections.reverse(tmpPmts);
            System.out.println("removing: " + highest);
            // tmpPmts.remove(tmpPmts.indexOf(highest));
            paymentForEachDay.put(deadlineMatchingHighestPayment, tmpPmts);
            System.out.println("\nPayments list for deadline: " + deadlineMatchingHighestPayment + " now contains " +
                    paymentForEachDay.get(deadlineMatchingHighestPayment).size() + " records...");
            highest = 0;
            deadlineMatchingHighestPayment = -1;
            candidateList = new ArrayList<>();
        }

        for (Integer k : candidatePayments.keySet()) {
            int m = 1;
            System.out.println("deadline: " + k);
            List<Integer> p = candidatePayments.get(k);
            if (p != null) {
                if (m < p.size()) {
                    System.out.println("size = " + p.size() + ", payment: " + p.get(m));
                }
            }
            m++;
        }

        System.out.println("size: " + paymentForEachDay.size());
        for (int i = 1; i <= length_of_week; i++) {
            List<Integer> p1 = paymentForEachDay.get(i);
            if (p1 == null) {
                System.out.println("opening at " + i);
                for (Integer k : candidatePayments.keySet()) {
                    int m = 0;
                    System.out.println("deadline: " + k);
                    List<Integer> p2 = candidatePayments.get(k);
                    if (p2 != null) {
                        if (m < p2.size()) {
                            if (Integer.valueOf(k) >= i) {
                                candidatePayments.put(i, p2);
                                System.out.println("size = " + p2.size() + ", payment: " + p2.get(m));
                            }
                        }
                    }
                    m++;
                }
            } else {
                System.out.println("num records for " + i + " = " + p1.size());
            }
        }

        // last problem is here - TC#11

        // for (1) should be values 34 (not 23)
        // for (3) should only be 2 (not 23)

        // Deadline matches (1); Payments list contains 2 records...
        // 23
        // Deadline matches (2); Payments list contains 1 records...
        // 1
        // Deadline matches (3); Payments list contains 2 records...
        // 23
        // Deadline matches (4); Payments list contains 3 records...
        // 123
        // Deadline matches (5); Payments list contains 1 records...
        // 4
        // Deadline matches (7); Payments list contains 1 records...
        // 1

        int highestCandidate = 0;
        int deadlineForHighestCandidate = -1;
        List<Integer> candidatePaymentsList = new ArrayList<>();
        for (int i = 1; i < candidatePayments.size(); i++) {
            // if given workday in week does not yet have a candidate
            // choose from those that have deadlines of that number or higher
            if (!paymentForEachDay.keySet().contains(i)) {
                for (int j = 0; j < 7; j++) {
                    System.out.println("i: " + i + ", j: " + j);
                    if (j >= i) {
                        List<Integer> tmpL = paymentForEachDay.get(i);
                        if (tmpL == null) {
                            List<Integer> tmpL2 = candidatePayments.get(i);
                            if (tmpL2 != null) {
                                System.out.println("i: " + i);
                                highestCandidate = tmpL2.get(0);
                                System.out.println("candidatePayments.get(i): " + candidatePayments.get(i));
                                System.out
                                        .println("candidatePayments.get(i).get(0): " + candidatePayments.get(i).get(0));
                                deadlineForHighestCandidate = i;
                            }
                        }
                    }
                }
                candidatePaymentsList.add(highestCandidate);
                paymentForEachDay.put(i, candidatePaymentsList);
                System.out.println("Adding " + highestCandidate + " to payments list");
                payments.add(highestCandidate);

                System.out.println("paymentForEachDay now contains " + paymentForEachDay.size() + " records...");
            }
        }
        for (int i = 0; i < payments.size(); i++) {
            System.out.println("payments list: " + payments.get(i));
            retVal += payments.get(i);
            System.out.println("retVal: " + retVal);
        }
        return retVal;
    }

    public int getNthFib(int n) {
        if (n <= 2) {
            return n - 1;
        }
        return getNthFib(n - 1) + getNthFib(n - 2);
    }

    public int binarySearchIterative(int[] array, int target) {
        int retVal = -1;
        boolean found = false;
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;

        // can assume input array is sorted per requirements
        while (left <= right) {

            mid = (left + right) / 2;

            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }

        return retVal;
    }

    public int binarySearch(int[] array, int target) {

        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    public int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target == array[mid]) {
            return mid;
        } else if (target < array[mid]) {
            return binarySearchHelper(array, target, left, mid - 1);
        } else {
            return binarySearchHelper(array, target, mid + 1, right);
        }
    }

    public boolean arePalindromes(String s1, String s2) {

        char[] cArr1 = s1.toCharArray();
        char[] cArr2 = s2.toCharArray();

        if (cArr1.length != cArr2.length) {
            return false;
        }
        for (int i = 0; i < cArr2.length; i++) {
            if (cArr1[i] != cArr2[cArr2.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public int firstNonRepeatingCharacter(String string) {
        int index1 = 0;

        System.out.println("For reference: " + string);
        // assumption - incoming string is all lowercase (no need to force)
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Map<Integer, Integer>> map2 = new HashMap<>();
        char[] cArr = string.toCharArray();

        // oops - I found first repeating char - need to find first non-repeating
        // character
        for (int i = 0; i < cArr.length; i++) {
            if (!map1.containsKey(cArr[i])) {
                map1.put(cArr[i], i);
            } else {
                if (map1.containsKey(cArr[i])) {
                    index1 = map1.get(cArr[i]);
                    break;
                }
            }
        }

        Map<Integer, Integer> map3 = new HashMap<>();
        // find first NON-repeating character ;)
        for (int i = 0; i < cArr.length; i++) {
            map3 = new HashMap<>();
            if (!map2.containsKey(cArr[i])) {
                // System.out.println("if: " + cArr[i] + ": " + i);
                map3.put(i, 1);
                map2.put(cArr[i], map3);
            } else {
                // System.out.println("else: ");
                if (map2.containsKey(cArr[i])) {
                    // System.out.println(cArr[i] + ": " + map2.get(cArr[i]));
                    Map tmpMap = map2.get(cArr[i]);
                    Integer tmpInt1 = null;
                    Integer tmpInt2 = null;

                    Set<Integer> keys = map2.get(cArr[i]).keySet();
                    for (Integer myInt : keys) {
                        // should only be a single value here, so assign to tmpInt
                        tmpInt1 = myInt;
                    }
                    tmpInt2 = map2.get(cArr[i]).get(tmpInt1);
                    Integer newInt = tmpInt2.intValue() + 1;
                    map3.put(tmpInt1, newInt);

                    map2.put(cArr[i], map3);
                    continue;
                }
            }
        }

        System.out.println(map2);

        int earliestNonRepeatingCharIndex = Integer.MAX_VALUE;
        char earliestNonRepeatingChar = '\0';
        for (char c : map2.keySet()) {
            // System.out.println(c);
            Integer tmpInt1 = null;
            Set<Integer> keys = map2.get(c).keySet();
            for (Integer myInt : keys) {
                // should only be a single value here, so assign to tmpInt
                // System.out.println(c + ": " + myInt);
                tmpInt1 = myInt;
            }
            if (map2.get(c).get(tmpInt1) == 1) {
                if (tmpInt1 < earliestNonRepeatingCharIndex) {
                    earliestNonRepeatingCharIndex = tmpInt1;
                    earliestNonRepeatingChar = c;
                    System.out.println("Current earliest occurring non-repeating char: " +
                            earliestNonRepeatingChar + ", occurring at: " +
                            earliestNonRepeatingCharIndex);
                }
                System.out.println("char: " + c + ", index: " + tmpInt1);
            }
        }

        if (earliestNonRepeatingCharIndex == Integer.MAX_VALUE) {
            earliestNonRepeatingCharIndex = -1;
        }
        // System.out.println("Returning: " + earliestNonRepeatingCharIndex);
        return earliestNonRepeatingCharIndex;
    }

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {

        // brute force approach
        // go through each string in array and compare with every other words in array
        // to determine if they are palindromes
        // of one another

        // once any pairs are found, create a "paired array" and insert that 2 word
        // array into an array of such pairs and return that

        ArrayList<ArrayList<String>> retVal = new ArrayList<>();
        ArrayList<String> tmpArr = new ArrayList<>();
        ArrayList<String> tmpArrRev = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                tmpArr = new ArrayList<>();
                tmpArrRev = new ArrayList<>();
                if (i != j) {
                    if (arePalindromes(words[i], words[j])) {
                        tmpArr.add(words[i]);
                        tmpArr.add(words[j]);

                        // a bit ugly but it works
                        tmpArrRev.add(words[j]);
                        tmpArrRev.add(words[i]);

                        if (!retVal.contains(tmpArr) && !retVal.contains(tmpArrRev)) {
                            retVal.add(tmpArr);
                        }
                    }
                }
            }
        }
        return retVal;
    }

    // This is an input class. Do not edit.
    public class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        // assumptions - passed-in LinkedList IS sorted, so no need to address any
        // out-of-order aspects

        LinkedList pointerToOriginalHead = linkedList;

        while (linkedList != null && linkedList.next != null) {
            while (linkedList.next != null && linkedList.next.value <= linkedList.value) {
                linkedList.next = linkedList.next.next;
            }
            if (linkedList.next != null) {
                linkedList = linkedList.next;
            }
        }
        return pointerToOriginalHead;
    }

    // Medium difficulty algorithms:

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

}