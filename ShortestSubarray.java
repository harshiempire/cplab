import java.util.Scanner;

public class ShortestSubarray {

    public static int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int minLength = n + 1;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            currentSum += A[end];

            while (currentSum >= K) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= A[start++];
            }
        }

        return minLength == n + 1 ? -1 : minLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the array:");
        int n = scanner.nextInt();
        int[] A = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println("Enter the value of K:");
        int K = scanner.nextInt();

        int result = shortestSubarray(A, K);
        System.out.println("The length of the shortest subarray with sum at least " + K + " is: " + result);

        scanner.close();
    }
}