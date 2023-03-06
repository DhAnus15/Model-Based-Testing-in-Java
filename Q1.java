import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

class RsaRepository {

    private Stack<Integer> s;

    public RsaRepository(Stack<Integer> stack) {
        this.s = stack;
    }

    public Integer store(int x) {

        Integer result_code;

        s.setSize(5);

        try {

            s.push(x);

            if (s.peek() == x) {

                result_code = 1;

            } else {

                result_code = 0;
            }
        } catch (IndexOutOfBoundsException e) {
            return 2;
        }

        return result_code;
    }

    public String retrive() {

        String resultString = "";
        String element;

        if (s.isEmpty()) {

            resultString = "# Repository Empty";

        } else {

            try {

                Integer popped_element = s.pop();
                element = popped_element.toString();
                resultString = "# Success";

            } catch (Exception e) {

                resultString = "# Failure for unknown reason";

            }
        }
        return resultString;
    }

    public Vector<Integer> display() {

        Vector<Integer> v = s;

        return v;
    }
}

class TestCases {

    private Stack<Integer> s = new Stack<Integer>();
    private RsaRepository rsa = new RsaRepository(s);
    private Vector<Integer> res = new Vector<Integer>();

    public TestCases(Stack<Integer> s, RsaRepository rsa) {
        this.s = s;
        this.rsa = rsa;
    }

    // Check if repository is empty
    public void testCase1(RsaRepository rsa, Stack<Integer> s) {

        res = rsa.display();
        if (res.isEmpty()) {
            System.out.println("# Test Case 1: Successful. Repository is Empty");
        } else {
            System.out.println("# Test Case 1: Failed. Repository not empty");
        }
    }

    // Retrieve for empty Repository
    public void testCase2(RsaRepository rsa, Stack<Integer> s) {

        String message = rsa.retrive();

        if (message == "# Success" && s.empty()) {
            System.out.println("Test Case 6: Successful. As Stack is empty element not popped");
        } else {
            System.out.println("Test Case 6: Failed.");
        }
    }

    // Store for Empty Repository
    public void testCase3(RsaRepository rsa, Stack<Integer> s) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer to push: ");
        Integer ele = sc.nextInt();
        Integer s1 = rsa.store(ele);
        if (s1 == 1 && s.empty()) {
            System.out.println("# Test Case 3: Passed. Element is stored and Repository is empty");
        } else if (s1 == 1) {
            System.out.println("# Test Case 3: Failed. Repository is not empty but Element Stored");
        } else {
            System.out.println("# Test Case 3: Failed due to Index out Of Bounds");
        }
    }

    // Display for empty Repository
    public void testCase4(RsaRepository rsa, Stack<Integer> s) {

        res = rsa.display();
        if (!res.isEmpty()) {
            System.out.println("# Test Case 4: Successful. Repository is not Empty");
            System.out.println(res);
        } else {
            System.out.println("# Test Case 4: Failed. Repository empty");
        }
    }

    // Retrieve for Partially filled Repository
    public void testCase5(RsaRepository rsa) {

        String message = rsa.retrive();

        if (message == "# Success") {
            System.out.println("Test Case 5: Successful. Element Popped");
        } else {
            System.out.println("Test Case 5: Failed. Element Not Popped");
        }
    }

    // Store for partially filled Repository
    public void testCase6(RsaRepository rsa, Stack<Integer> s) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer to push: ");
        Integer ele = sc.nextInt();
        Integer s1 = rsa.store(ele);
        if (s1 == 1) {
            System.out.println("# Test Case 6: Passed. Element is stored and Repository is empty");
        } else if (s1 == 0) {
            System.out.println("# Test Case 6: Failed. Element not stored");
        } else {
            System.out.println("# Test Case 6: Failed due to Index out Of Bounds");
        }
    }

    // Display for Repository Full condition
    public void testCase7(RsaRepository rsa) {

        res = rsa.display();
        if (res.size() == 5) {
            System.out.println("Test Case 7: Passed. Vector is Full.");
            System.out.println(res);
        } else {
            System.out.println("Test Case 7: Failed. Vector not Full.");
        }
    }

    // Retrive for Repository Full Condition
    public void testCase8(RsaRepository rsa, Stack<Integer> s) {

        res = rsa.display();
        String message = rsa.retrive();

        if (message == "# Success" && res.size() == 5) {
            System.out.println("Test Case 8: Successful. Element Popped");
        } else if (message == "# Success") {
            System.out.println("Test Case 8: Failed. Element Popped but Repository not full");
        } else {
            System.out.println("Test Case 8: Failed. Element not popped");
        }
    }

    // Store for Full Repository
    public void testCase9(RsaRepository rsa) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer to push: ");
        Integer ele = sc.nextInt();
        Integer s1 = rsa.store(ele);
        if (s1 == 1 && s.empty()) {

            System.out.println("# Test Case 3: Failed as Repository not full. Element stored.");
        } else if (s1 == 0) {
            System.out.println("# Test Case 3: Failed. Element is not stored");
        } else {
            System.out.println("# Test Case 3: Passed. Repository is Full");
        }
    }
}

class Q1 {

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();
        RsaRepository rsa = new RsaRepository(s);
        TestCases tc = new TestCases(s, rsa);
        int option = 0;

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Insert Item in Repository");
            System.out.println("2. Remove Item from Repository");
            System.out.println("3. Display Repository Items");
            System.out.println("4. Exit");

            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            if (option == 1) {

                tc.testCase1(rsa, s);
                tc.testCase3(rsa, s);
                tc.testCase6(rsa, s);
                tc.testCase9(rsa);

            } else if (option == 2) {

                tc.testCase1(rsa, s);
                tc.testCase2(rsa, s);
                tc.testCase5(rsa);
                tc.testCase8(rsa, s);

            } else if (option == 3) {

                tc.testCase1(rsa, s);
                tc.testCase4(rsa, s);
                tc.testCase7(rsa);

            } else if (option == 4) {

                break;

            } else {

                System.out.println("Invalid Choice");
            }
        }
        // tc.testCase1(rsa, s);
        // tc.testCase3(rsa, s);
        // tc.testCase2(rsa, s);
        // tc.testCase4(rsa, s);
        // tc.testCase5(rsa);
        // tc.testCase6(rsa, s);
        // tc.testCase7(rsa);
        // tc.testCase8(rsa, s);
        // tc.testCase9(rsa);
    }
}