// Class to compute fibonacci using recursive and iterative approach
public class RecursiveIterativeFibonacci {
    public static void main(String[] args) {
        // Compare both approaches for different number of n
        compareApproach(10);
        compareApproach(30);
        compareApproach(50);
    }

    // method to compare recursive and iterative approach
    static void compareApproach(int n) {
        System.out.println("Current number is: " + n);
        // Define variables startTime and endTime to store time
        long startTime, endTime;

        // Recursive approach time
        if(n==50) {
            System.out.println("Recursive approach is unfeasible.");
        } else {
            startTime = System.nanoTime();
            long res = fibonacciRecursive(n);
            endTime = System.nanoTime();
            System.out.printf("The fibonacci number %d is: %d\n", n, res);
            System.out.printf("The time taken by recursive approach is: %.4fms\n\n", (endTime - startTime) / 1e6);
        }

        // Iterative approach time
        startTime = System.nanoTime();
        long res = fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.printf("The fibonacci number %d is: %d\n", n, res);
        System.out.printf("The time taken by iterative approach is: %.4fms\n\n", (endTime - startTime) / 1e6);
    }

    // method to calculate fibonacci number using recursive approach
    static long fibonacciRecursive(int n) {
        if(n<=1) return n;
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    // method to calculate fibonacci number using iterative approach
    static long fibonacciIterative(int n) {
        long a = 0, b = 1, sum;
        for(int i=2;i<=n;i++){
            sum = a+b;
            a = b;
            b = sum;
        }
        return b;
    }
}
// Sample Output ->
// Current number is: 10
// The fibonacci number 10 is: 55
// The time taken by recursive approach is: 0.0057ms

// The fibonacci number 10 is: 55
// The time taken by iterative approach is: 0.0020ms

// Current number is: 30
// The fibonacci number 30 is: 832040
// The time taken by recursive approach is: 4.5240ms

// The fibonacci number 30 is: 832040
// The time taken by iterative approach is: 0.0007ms

// Current number is: 50
// Recursive approach is unfeasible.
// The fibonacci number 50 is: 12586269025
// The time taken by iterative approach is: 0.0008ms