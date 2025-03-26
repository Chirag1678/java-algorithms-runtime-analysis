import java.util.Arrays;

// Class to search target in different sizes of datasets using linear and binary search
public class SearchTarget {
    public static void main(String[] args) {
        // Use random to generate random integers for arrays of sizes 1_000, 10_000, and 1_000_000
        int[] data1 = new int[1_000];
        int[] data2 = new int[10_000];
        int[] data3 = new int[1_000_000];

        // Generate random integers for data1
        for(int i=0;i<data1.length;i++) {
            data1[i] = (int)(Math.random()*1000);
        }

        // Generate random integers for data2
        for(int i=0;i<data2.length;i++) {
            data2[i] = (int)(Math.random()*10000);
        }

        // Generate random integers for data3
        for(int i=0;i<data3.length;i++) {
            data3[i] = (int)(Math.random()*1000000);
        }

        // Search target in data1
        compareSearches(data1, (int) (Math.random() * 1000));

        // Search target in data2
        compareSearches(data2, (int) (Math.random() * 10000));

        // Search target in data3
        compareSearches(data3, (int) (Math.random() * 1000000));
    }

    // method to compare linear search and binary search
    static void compareSearches(int[] data, int target) {
        System.out.println("Current Dataset Size: " + data.length);
        long startTime, endTime;

        // Linear Search time
        startTime = System.nanoTime();
        boolean found = false;
        for(int i=0;i<data.length;i++) {
            if(data[i]==target) {
                System.out.printf("%d is found at index: %d\n", target, i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(target + " is not found in the dataset.");
        }
        endTime = System.nanoTime();
        long linearTime = endTime - startTime;
        System.out.println("Time Taken by linear search: " + linearTime / 1e6 + "ms"); // in ms

        // Sort the array to perform binary search
        Arrays.sort(data);
        // Binary Search Time
        startTime = System.nanoTime();

        int low = 0 ,high = data.length - 1;
        found = false;

        while(low<=high) {
            int mid = low + (high-low) / 2;
            if(data[mid]==target){
                System.out.printf("%d is found at index: %d\n", target, mid);
                found = true;
                break;
            }
            else if(data[mid]<target) low = mid+1;
            else high = mid - 1;
        }

        if (!found) {
            System.out.println(target + " is not found in the dataset.");
        }

        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;
        System.out.println("Time taken by binary search: " + binaryTime / 1e6 + "ms"); // in ms

        // Compare time and display output
        if(linearTime<binaryTime) {
            System.out.println("Linear Search is faster by " + (binaryTime - linearTime) / 1e6 + "ms"); // in ms
        } else {
            System.out.println("Binary Search is faster by " + (linearTime - binaryTime) / 1e6 + "ms"); // in ms
        }

        System.out.println();
    }
}
// Sample Output ->
// Current Dataset Size: 1000
// 904 is found at index: 640
// Time Taken by linear search: 9.743ms
// 904 is found at index: 895
// Time taken by binary search: 0.088209ms
// Binary Search is faster by 9.654791ms

// Current Dataset Size: 10000
// 5750 is found at index: 4096
// Time Taken by linear search: 0.103458ms
// 5750 is found at index: 5770
// Time taken by binary search: 0.172625ms
// Linear Search is faster by 0.069167ms

// Current Dataset Size: 1000000
// 531080 is found at index: 163220
// Time Taken by linear search: 1.912166ms
// 531080 is found at index: 531386
// Time taken by binary search: 0.224875ms
// Binary Search is faster by 1.687291ms