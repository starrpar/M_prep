package mprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import mprep.AlgoExp.BinaryTree;

import java.util.Set;
import java.lang.reflect.Type;
import java.util.Collections;

public class App {

    public static void main(String[] args) {

        boolean runBasics = false;

        Practice practice = new Practice();

        String testString = "Computer programming or coding is the composition of sequences of instructions, called programs, that computers can follow to perform tasks.[1][2] It involves designing and implementing algorithms, step-by-step specifications of procedures, by writing code in one or more programming languages. Programmers typically use high-level programming languages that are more easily intelligible to humans than machine code, which is directly executed by the central processing unit. Proficient programming usually requires expertise in several different subjects, including knowledge of the application domain, details of programming languages and generic code libraries, specialized algorithms, and formal logic.  Auxiliary tasks accompanying and related to programming include analyzing requirements, testing, debugging (investigating and fixing problems), implementation of build systems, and management of derived artifacts, such as programs' machine code. While these are sometimes considered programming, often the term software development is used for this larger overall process – with the terms programming, implementation, and coding reserved for the writing and editing of code per se. Sometimes software development is known as software engineering, especially when it employs formal methods or follows an engineering design process.";
        String result = practice.removeVowelsUsingRegex(testString);
        System.out.println(result);
        System.out.println(testString.length() - result.length());

        String ipAddress = "192.168.0.1";
        System.out.println(practice.defangingAnIPAddress(ipAddress));

        // String jewels = "aA";
        // String stones = "aAAbbbb";
        // System.out.println(practice.deJewel(jewels, stones));
        String jewels = "aeiou";
        System.out.println(practice.deJewel(jewels, testString));

        String input = "codeleet";
        int[] indices = new int[] { 4, 5, 6, 7, 0, 2, 1, 3 };
        System.out.println(practice.shuffleString(input, indices));

        String rlStr1 = "RLRRLLRLRL";
        String rlStr2 = "RLRRRLLRLL";
        String rlStr3 = "LLLLRRRR";

        System.out.println(practice.splitBalancedStringIntoBalancedSubstrings(rlStr1));
        System.out.println(practice.splitBalancedStringIntoBalancedSubstrings(rlStr2));
        System.out.println(practice.splitBalancedStringIntoBalancedSubstrings(rlStr3));

        System.out.println(practice.strToLowerCase(testString));

        System.out.println(practice.countSubstringsWithOnlyOneDistinctLetter(input));

        System.out.println(practice.fizzBuzz(15));

        System.out.println("\nReverse string by character: \n" + practice.reverseString(testString));

        System.out.println("\nReverse string by word: \n" + practice.reverseStringByWord(testString));

        String palindrome = "A man, a plan, a canal, panama.";
        // String palindrome = "A man, a plant, a canal, panmama.";
        System.out.println("Is Palindrome? " + practice.isPalindrome(palindrome));

        System.out.println("Is Palindrome? " + practice.isPalindromeAllowForTypos(palindrome));

        Class<Integer> clsI = Integer.class;
        Object[] objs = new Object[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5,
                1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        Object[] rtnObns = practice.removeDupes(objs, clsI);
        for (Object obj : rtnObns) {
            System.out.print(obj);
        }

        System.out.print("\n");
        Class<String> clsS = String.class;
        char[] cArr = testString.toCharArray();
        objs = new Object[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            // System.out.print(cArr[i]);
            objs[i] = (Object) cArr[i];
        }
        rtnObns = practice.removeDupes(objs, clsS);
        for (Object obj : rtnObns) {
            System.out.print(obj);
        }

        System.out.print("\n");
        Map<Object, Integer> rtnMap = new HashMap<>();
        rtnMap = practice.countFrequencyOfObjectInArray(objs, clsS);
        for (Object obj : rtnMap.keySet()) {
            System.out.println(obj + ": " + rtnMap.get(obj));
        }
        System.out.print("\n");
        Map<Integer, List<Object>> sortedMap = practice.consolidateMapContents(rtnMap);
        sortedMap = practice.keyReverseSort(sortedMap);
        for (int i : sortedMap.keySet()) {
            System.out.println(i + ": " + sortedMap.get(i));
        }

        Employee employee = new Employee();
        employee.findOlderEmployees();

        AlgoExp algoExp = new AlgoExp();
        List<AlgoExp.BinaryTree> bTrees = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            AlgoExp.BinaryTree bTree = algoExp.new BinaryTree();
            bTree.value = i;
            // if (i % 2 == 0) {
            // bTree.right = bTrees.get(i);
            // } else {
            // bTree.left = bTrees.get(i - 1);
            // }

            bTrees.add(bTree);
        }
        // BTree Structure
        // 9
        // / \
        // 7 8
        // / /
        // 5 4
        // / / \
        // 3 2 6
        // /
        // 1

        bTrees.get(9).left = bTrees.get(7);
        bTrees.get(7).left = bTrees.get(5);
        bTrees.get(5).left = bTrees.get(3);
        bTrees.get(3).left = bTrees.get(1);

        bTrees.get(9).right = bTrees.get(8);
        bTrees.get(8).left = bTrees.get(4);
        bTrees.get(4).right = bTrees.get(6);
        bTrees.get(4).left = bTrees.get(2);

        System.out.println(algoExp.branchSums(bTrees.get(9)));

        System.out.println(algoExp.nodeDepths(bTrees.get(9)));

        List<String> walkedGraph = new ArrayList<>();

        AlgoExp.Node nodeA = algoExp.new Node("A");

        nodeA = nodeA.addChild("B");
        nodeA = nodeA.addChild("C");
        nodeA = nodeA.addChild("D");

        AlgoExp.Node nodeB = nodeA.children.get(0);
        AlgoExp.Node nodeC = nodeA.children.get(1);
        AlgoExp.Node nodeD = nodeA.children.get(2);

        nodeB = nodeB.addChild("E");
        nodeB = nodeB.addChild("F");

        AlgoExp.Node nodeE = nodeB.children.get(0);
        AlgoExp.Node nodeF = nodeB.children.get(1);

        nodeD = nodeD.addChild("G");
        nodeD = nodeD.addChild("H");

        AlgoExp.Node nodeG = nodeD.children.get(0);
        AlgoExp.Node nodeH = nodeD.children.get(1);

        nodeF = nodeF.addChild("I");
        nodeF = nodeF.addChild("J");

        AlgoExp.Node nodeI = nodeF.children.get(0);
        AlgoExp.Node nodeJ = nodeF.children.get(1);

        nodeG = nodeG.addChild("K");

        AlgoExp.Node nodeK = nodeG.children.get(0);

        walkedGraph = nodeA.depthFirstSearch(walkedGraph);
        System.out.println(walkedGraph);

        int[] redShirts = new int[] { 5, 5, 3, 9, 2 };
        int[] blueShirts = new int[] { 3, 6, 7, 2, 1 };
        boolean fastest = true;

        System.out.println(algoExp.tandemBicycle(redShirts, blueShirts, fastest));

        assert (algoExp.tandemBicycle(redShirts, blueShirts, fastest)) == 32;

        algoExp.firstNonRepeatingCharacter(testString);

        System.out.println("*********************************");
        System.out.println(algoExp.ArrayChallenge(21378));
        System.out.println("*********************************");
        
        int[] testArr3 = new int[] { 3, 6, 7, 2, 1, 21, 300, 27, 13, 13, 19 };
        int target = 19;
        Arrays.sort(testArr3);

        System.out.println(algoExp.binarySearchIterative(testArr3, target));
        System.out.println(algoExp.binarySearch(testArr3, target));

        String parenStr1 = "(a(b)c))";
        String parenStr2 = "(a(b)c)";
        String parenStr3 = ")()()";
        String parenStr4 = "(((((";
        String parenStr5 = "(()()(";
        System.out.print("input:  " + parenStr1);
        System.out.println("output: " + algoExp.balance(parenStr1));
        System.out.print("input:  " + parenStr2);
        System.out.println("output: " + algoExp.balance(parenStr2));
        System.out.print("input:  " + parenStr3);
        System.out.println("output: " + algoExp.balance(parenStr3));
        System.out.print("input:  " + parenStr4);
        System.out.println("output: " + algoExp.balance(parenStr4));
        System.out.print("input:  " + parenStr5);
        System.out.println("output: " + algoExp.balance(parenStr5));

        System.out.println(algoExp.isPalindromeInt(palindrome));

        int[] intArrLongestPeak = { 1, 1, 1, 2, 3, 10, 12, -3, -3, 2, 3, 45, 800, 99, 98, 0, -1, -1, 2, 3, 4, 5, 0, -1,
                -1 };
        System.out.println(algoExp.longestPeakJava(intArrLongestPeak));// correct answer is '9'

        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/
        // ***********************************************************/

        if (runBasics) {

            SimpleMethods simple = new SimpleMethods();
            ArrayMethods arrMethods = new ArrayMethods();
            TreeMethods treeMethods = new TreeMethods();
            DynamicProgrammingMethods dpMethods = new DynamicProgrammingMethods();
            DynamicProgrammingMethods.NQueensProblem nqMethods = dpMethods.new NQueensProblem();
            SearchAndSortMethods sortMethods = new SearchAndSortMethods();
            StackAndQueueMethods stackMethods = new StackAndQueueMethods();
            GraphMethods graphMethods = new GraphMethods();

            // String methods (20%)
            String testStr = "a man, a plan, a canal, panama.";
            System.out.println(simple.isPalindrome(testStr));

            String testStrA = "a man, a plan, a canal, panama";
            // String testStrA = "abbcca";
            // String testStrA = "aa";
            // String testStrA = "aaa";
            // String testStrA = "aaaaaaaaa";
            // String testStrA = "abba";
            // String testStrA = "abbcaacdda";
            // String testStrA = "aba";

            // System.out.println("removeSequences result: " +
            // simple.removeSequencesUsingRegEx(testStrA));
            System.out.println("removeSequences result: " +
                    simple.removeSequences(testStrA));

            for (int i = 0; i < 5; i++) {
                System.out.println(simple.alloc());
            }
            simple.free(2);
            simple.free(3);
            for (int i = 0; i < 5; i++) {
                System.out.println(simple.allocations[i]);
            }

            // Dynamic Programming (and Recursive) methods (20%)
            int inputVal = 8;
            System.out.println("\n" + inputVal + "th Fibonacci: " + simple.calculateNthFibonacci(inputVal));

            int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
            int len = arr.length;

            // Function call
            System.out.println("Length of lis is " + DynamicProgrammingMethods.LIS.lis(arr, len));

            // int n = 4; // n can be anything >= 4; try 8 for chessboard and n = 10
            int n = 8;
            // int n = 10;
            nqMethods.solveNQueens(n);

            // Array methods (20%)
            Integer[] testArray = { 1, 0, 2, 1, 2, 1, 0, 0, 2, 0, 1, 1, 2, 0, 2, 1, 2, 1, 2, 2, 0, 0, 2 };
            simple.moveZeroesMoreEfficient(testArray);

            int arrayLen = 100;
            int bnd = 100;
            int[] newIntArray = arrMethods.createRandomIntArray(arrayLen, bnd);
            int[] array0 = newIntArray.clone();
            System.out.println("\nNum primes: " + simple.countPrimes(array0));
            int[] array1 = newIntArray.clone();
            System.out.println("\nCount: " + simple.removeElementInPlace(array1, 8));

            Object[] array2 = new Object[newIntArray.length];
            for (int i = 0; i < newIntArray.length; i++) {
                array2[i] = (Object) newIntArray[i];
            }
            simple.countFrequencyOfElement(array2, (Object) 3);

            System.out.println("\nDuplicates removed: " + simple.removeDuplicates(array2));

            // Tree methods (15%)
            TreeMethods.BinaryTree tree = treeMethods.new BinaryTree();
            List<Integer> treeList = new ArrayList<>();
            List<Integer> treeTraversalOutputList = new ArrayList<>();

            // for (int i = 0; i < testArray.length; i++) {
            // treeList.add(testArray[i]);
            // }
            for (int i = 0; i < array0.length; i++) {
                treeList.add(array0[i]);
            }

            System.out.println("\nBuild tree; treeList length: " + treeList.size());
            tree = treeMethods.buildTree(treeList);

            System.out.println("\nTraverse tree: ");
            treeMethods.traverseTree(tree.root);
            treeTraversalOutputList = treeMethods.binaryTreeToList(tree.root);
            System.out.print("\nOutput of binaryTreeToList:\n" + treeTraversalOutputList);
            System.out.println("\nOriginal array: ");
            for (int i = 0; i < array0.length; i++) {

                System.out.print(array0[i] + ", ");
            }

            // Graph methods (15%)
            Set<GraphMethods.Node> s = new HashSet<>();
            int numNodesInGraph = 8;
            GraphMethods.Node prevNode = null;
            for (int i = 0; i < numNodesInGraph; i++) {
                GraphMethods.Node n1 = graphMethods.new Node();

                n1.value = i;
                if (prevNode != null) {
                    n1.neighbors.add(prevNode);
                }

                prevNode = n1;
                s.add(n1);
            }

            GraphMethods.Node source = null;
            GraphMethods.Node dest = null;
            for (GraphMethods.Node n2 : s) {
                if (n2.value == 0) {
                    dest = n2;
                }
                if (n2.value == s.size() - 1) {
                    source = n2;
                }
            }

            System.out.println("\n");
            System.out.println(s);
            System.out.println("\nDFS graph: " + graphMethods.DFS(source, dest, s));
            System.out.println("\nBFS graph: " + graphMethods.BFS(source, dest, s));
            System.out.println();

            // let's modify set now to force next relationships

            // attach Nodes in Set to tangible instances so can assign to neighbor lists
            GraphMethods.Node node0 = null;
            GraphMethods.Node node1 = null;
            GraphMethods.Node node2 = null;
            GraphMethods.Node node3 = null;
            GraphMethods.Node node4 = null;
            GraphMethods.Node node5 = null;
            GraphMethods.Node node6 = null;
            GraphMethods.Node node7 = null;
            for (GraphMethods.Node n3 : s) {

                if (n3.value == 0) {
                    node0 = n3;
                    node0.neighbors = new ArrayList<>();
                    System.out.println("0: " + n3);
                }
                if (n3.value == 1) {
                    node1 = n3;
                    node1.neighbors = new ArrayList<>();
                    System.out.println("1: " + n3);
                }
                if (n3.value == 2) {
                    node2 = n3;
                    node2.neighbors = new ArrayList<>();
                    System.out.println("2: " + n3);
                }
                if (n3.value == 3) {
                    node3 = n3;
                    node3.neighbors = new ArrayList<>();
                    System.out.println("3: " + n3);
                }
                if (n3.value == 4) {
                    node4 = n3;
                    node4.neighbors = new ArrayList<>();
                    System.out.println("4: " + n3);
                }
                if (n3.value == 5) {
                    node5 = n3;
                    node5.neighbors = new ArrayList<>();
                    System.out.println("5: " + n3);
                }
                if (n3.value == 6) {
                    node6 = n3;
                    node6.neighbors = new ArrayList<>();
                    System.out.println("6: " + n3);
                }
                if (n3.value == 7) {
                    node7 = n3;
                    node7.neighbors = new ArrayList<>();
                    System.out.println("7: " + n3);
                }
            }

            node0.neighbors.add(node1);
            node0.neighbors.add(node3);
            node1.neighbors.add(node2);
            node2.neighbors.add(node6);
            node2.neighbors.add(node3);
            node3.neighbors.add(node6);
            // node3.neighbors.add(node7);
            node4.neighbors.add(node5);
            node5.neighbors.add(node3);
            node5.neighbors.add(node7);
            node6.neighbors.add(node3);
            node6.neighbors.add(node4);

            for (GraphMethods.Node n2 : s) {
                if (n2.value == 0) {
                    source = n2;
                }
                if (n2.value == s.size() - 1) { // set dest to 7
                    dest = n2;
                }
            }
            System.out.println("\nDFS graph: " + graphMethods.DFS(source, dest, s));
            System.out.println("\nBFS graph: " + graphMethods.BFS(source, dest, s));

            for (GraphMethods.Node n2 : s) {
                if (n2.value == 0) {
                    source = n2;
                }
                if (n2.value == s.size() - 2) { // set dest to 6
                    dest = n2;
                }
            }
            System.out.println("\nDFS graph: " + graphMethods.DFS(source, dest, s));
            System.out.println("\nBFS graph: " + graphMethods.BFS(source, dest, s));

            // Search/Sort methods (10%)
            System.out.println("\n\nForward Sort: ");
            int[] array3 = newIntArray.clone();
            System.out.println("\nUnsorted array: ");
            System.out.print(Arrays.toString(array3));
            sortMethods.forwardSort(array3);
            System.out.println("\nSorted array: ");
            System.out.print(Arrays.toString(array3));

            System.out.println("\n\nReverse Sort (2 variations): ");
            int[] array4 = newIntArray.clone();
            int[] sortedArray = new int[array3.length];
            System.out.println("\nUnsorted array: ");
            System.out.print(Arrays.toString(array4));
            sortedArray = sortMethods.reverseSort(array4, false);
            System.out.println("\nSorted array: ");
            System.out.print(Arrays.toString(sortedArray));

            int[] array5 = newIntArray.clone();
            System.out.println("\nUnsorted array: ");
            System.out.print(Arrays.toString(array5));
            sortMethods.reverseSortInPlace(array5);
            System.out.println("\nSorted array: ");
            System.out.print(Arrays.toString(array5));

            int[] array6 = newIntArray.clone();

            System.out.println("\n\nBubble Sort: ");
            System.out.println("\n" + sortMethods.isSorted(array6));
            System.out.println("\nUnsorted array: ");
            for (int i = 0; i < array6.length; i++) {
                System.out.print(array6[i] + ", ");
            }
            sortMethods.bubbleSort(array6);
            System.out.println("\nSorted array: ");
            for (int i = 0; i < array6.length; i++) {
                System.out.print(array6[i] + ", ");
            }
            System.out.println("\n" + sortMethods.isSorted(array6));

            System.out.println("\n\nMergeSort: ");
            int[] array7 = newIntArray.clone();
            sortedArray = new int[array7.length];

            System.out.println("\nUnsorted array: ");
            for (int i = 0; i < array7.length; i++) {
                System.out.print(array7[i] + ", ");
            }
            sortedArray = sortMethods.mergeSort(array7);
            System.out.println("\nSorted array: ");
            for (int i = 0; i < sortedArray.length; i++) {
                System.out.print(sortedArray[i] + ", ");
            }

            // int[] array8 = newIntArray.clone();

            // System.out.println("\n\nQuick Sort: ");
            // System.out.println("\n" + sortMethods.isSorted(array8));
            // System.out.println("\nUnsorted array: ");
            // for (int i = 0; i < array8.length; i++) {
            // System.out.print(array8[i] + ", ");
            // }
            // sortMethods.quickSort(array8);
            // System.out.println("\nSorted array: ");
            // for (int i = 0; i < array8.length; i++) {
            // System.out.print(array8[i] + ", ");
            // }
            // System.out.println("\n" + sortMethods.isSorted(array8));

            // LinkedList methods (4%)

            // Stack/Queue methods (2%)
            int numNodes = 5;
            StackAndQueueMethods.Stack currentStack = stackMethods.new Stack();
            StackAndQueueMethods.Node[] nodes = new StackAndQueueMethods.Node[numNodes];
            for (int i = 0; i < numNodes; i++) {
                StackAndQueueMethods.Node newNode = stackMethods.new Node();
                newNode.value = i;
                nodes[i] = newNode;
            }
            for (int i = 0; i < numNodes; i++) {
                currentStack.push(nodes[i].value);
            }

            try {
                System.out.println("\nContents of stack, peeked: ");
                System.out.println(((Integer) currentStack.peek()).toString());

                System.out.println("Contents of stack, popped: ");
                for (int i = numNodes - 1; i >= 0; i--) {
                    System.out.println(((Integer) currentStack.pop()).toString());
                }

                // Commented out because will fail (stop program from running) by design
                if (!currentStack.empty()) {
                    System.out.println("Contents of stack, peeked (will now be empty): ");
                    int val = currentStack.peek();
                    System.out.println(((Integer) val).toString());
                }

            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage() + "; " + e.getStackTrace());
            }

            StackAndQueueMethods.Queue currentQueue = stackMethods.new Queue();
            for (int i = 0; i < numNodes; i++) {
                StackAndQueueMethods.Node newNode = stackMethods.new Node();
                newNode.value = i;
                nodes[i] = newNode;
            }
            for (int i = 0; i < numNodes; i++) {
                currentQueue.enqueue(nodes[i].value);
            }

            try {
                System.out.println("\nContents of queue, peeked: ");
                System.out.println(((Integer) currentQueue.peek()).toString());

                System.out.println("Contents of queue, dequeued: ");
                for (int i = numNodes - 1; i >= 0; i--) {
                    System.out.println(((Integer) currentQueue.dequeue()).toString());
                }

                // Commented out because will fail (stop program from running) by design
                if (!currentQueue.empty()) {
                    System.out.println("Contents of queue, peeked (will now be empty): ");
                    int val = currentQueue.peek();
                    System.out.println(((Integer) val).toString());
                }

            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage() + "; " + e.getStackTrace());
            }

            StackAndQueueMethods.QueueUsingStacks queueViaStacks = stackMethods.new QueueUsingStacks();
            for (int i = 0; i < numNodes; i++) {
                StackAndQueueMethods.Node newNode = stackMethods.new Node();
                newNode.value = i;
                nodes[i] = newNode;
            }
            for (int i = 0; i < numNodes; i++) {
                queueViaStacks.enQueue(nodes[i].value);
            }
            try {
                System.out.println("\nContents of queueByStacks, peeked: ");
                System.out.println(((Integer) queueViaStacks.peek()).toString());

                System.out.println("Contents of queueByStacks, dequeued: ");
                for (int i = numNodes - 1; i >= 0; i--) {
                    System.out.println(((Integer) queueViaStacks.deQueue()).toString());
                }

                // Commented out because will fail (stop program from running) by design
                if (!queueViaStacks.empty()) {
                    System.out.println("Contents of queueByStacks, peeked (will now be empty): ");
                    int val = queueViaStacks.peek();
                    System.out.println(((Integer) val).toString());
                }

            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage() + "; " + e.getStackTrace());
            }

        }
        // runAllOthers();
    }

    static void runAllOthers() {
        ArrayMethods arrMethods = new ArrayMethods();
        DynamicProgrammingMethods dp = new DynamicProgrammingMethods();
        StringMethods strMethods = new StringMethods();

        System.out.println("\nFib: " + dp.calculateNthFibonacci(6));

        int arrayLength = 100;
        int bound = 100;
        int[] newIntArr = arrMethods.createRandomIntArray(arrayLength, bound);
        char[] newCharArr = arrMethods.createRandomCharArray(arrayLength);
        int[] arr1 = newIntArr.clone();
        int[] arr2 = newIntArr.clone();
        int[] arr5 = newIntArr.clone();
        int intArrLen = newIntArr.length;
        int charArrLen = newCharArr.length;
        Object[] arr3 = new Object[intArrLen];
        for (int i = 0; i < intArrLen; i++) {
            arr3[i] = (Object) newIntArr[i];
        }
        Object[] arr4 = new Object[charArrLen];
        for (int i = 0; i < charArrLen; i++) {
            arr4[i] = (Object) newCharArr[i];
            // System.out.print(arr4[i]);
        }

        // int[] testArr1 = { 1, 2, 2, 3, 4, 5, 5, 17, 1, 1 };
        int[] testArr2 = { 13, 2, 2, 3, 4, 5, 5, 17, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
        long[] resultsArr = null;

        String testStr1 = "a man, a plan, a canal, panama";
        String testStr2 = "rrrrrrrrrrrrrrrrrrrrr";
        String testStr3 = "a man, a plant, a canal, panama"; // 1 typo
        String testStr4 = "a man, a plant, a canall, panama"; // 2 typos
        String testStr5 = "a main, a plant, a canall, panama"; // 3 typos

        // simplest form - does not tolerate typos
        System.out.println("\nPalindrome1? " + strMethods.isPalindrome1(testStr1));

        // this one will only succeed with a single typo to correct
        // System.out.println("\nPalindrome2? " + strMethods.isPalindrome2(testStr5));
        // System.out.println("\n\n");

        // this version will succeed with having to cleanup up multiple typos (as long
        // as
        // they are not adjacent to one another - to include adjacent when mirrored)
        // System.out.println("\nPalindrome3? " + strMethods.isPalindrome3(testStr5));

        System.out.println("\nNum primes: " + arrMethods.countPrimes(arr1));

        // for (int i = 0; i < testArr2.length; i++) {
        // System.out.print(testArr2[i] + " ");
        // }
        // System.out.println(" ");
        // resultsArr = arrMethods.sumOfAllElementsPreviousToSpecified(testArr2);
        // for (int i = 0; i < resultsArr.length; i++) {
        // System.out.print(resultsArr[i] + " ");
        // }

        /*
         * List<Integer[]> lexiList =
         * fcns.getNextLexicographicalOutputOfArray(testArr2);
         * if (lexiList.size() <= 0) {
         * System.out.println("lexiList is empty");
         * }
         * for (int i = 0; i < lexiList.size(); i++) {
         * System.out.print("\n");
         * for (int j = 0; j < lexiList.get(i).length; j++) {
         * System.out.print(lexiList.get(i)[j] + " ");
         * }
         * }
         */

        // int seqLen = arrMethods.findLongestIncreasingSequence(arr5, false);
        // System.out.println("\nLongestSequenceLength: " + seqLen);

        // ************************************************************

        int val = 8;
        System.out.println("\nFirst - doesn't fix: ");
        int count = arrMethods.removeElementInPlace1(arr1, val);
        System.out.println("\n" + count);
        System.out.println("\nSecond - does fix: ");
        count = arrMethods.removeElementInPlace2(arr2, val);
        System.out.println("\n" + count);
        System.out.println("\n" + arrMethods.removeDuplicates(arr3));
        System.out.println("\n" + arrMethods.removeDuplicates(arr4));

        int numIntOccurrences = arrMethods.countFrequencyOfElement(arr3, (Object) 3);
        System.out.println("\nFrequency of number 3: " + numIntOccurrences);
        int expectedOccurrences = arrayLength / bound;
        System.out.println("number of expected \"random\" occurrences in array of int of length: " + arrayLength
                + " is: " + expectedOccurrences);
        if (numIntOccurrences > expectedOccurrences) {
            System.out.println(
                    "...so value is more common than expected, so \'randomeness\' is more liberal in this case");
        } else {
            System.out.println(
                    "...so value is less common than expected, so \'randomeness\' is more conservative in this case");
        }

        int numCharOccurrences = arrMethods.countFrequencyOfElement(arr4, (Object) 'c');
        System.out.println("\nFrequency of character \'c\': " + numCharOccurrences);
        expectedOccurrences = arrayLength / 52;
        System.out.println("number of expected \"random\" occurrences in array of char of length: " + arrayLength
                + " is: " + expectedOccurrences);
        if (numCharOccurrences > expectedOccurrences) {
            System.out.println(
                    "...so value is more common than expected, so \'randomeness\' is more liberal in this case");
        } else {
            System.out.println(
                    "...so value is less common than expected, so \'randomeness\' is more conservative in this case");
        }

        Integer[] testArr = { 0, 1, 2, 1, 0, 0, 2, 0, 1, 1, 2, 0, 2, 1, 2, 1, 2, 2, 0, 0, 2 };
        List<Integer> listArr = Arrays.asList(testArr);
        System.out.println("listArr: " + listArr);
        List<Integer> resultArr = arrMethods.moveZeroes(listArr);
        System.out.println("resultArr: " + resultArr);
        resultArr = arrMethods.moveZeroesMoreEfficient(testArr);
        System.out.println("resultArr: " + resultArr);

    }
}
