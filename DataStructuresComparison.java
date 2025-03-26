import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

// Class to find the time for searching in different data structures
public class DataStructuresComparison {
    public static void main(String[] args) {
        // Define an array of different dataset sizes
        int[] sizes = {1_000, 10_000, 1_000_000};

        // loop to create different data structures for sizes
        for(int size:sizes) {
            System.out.println("Dataset Size: " + size);

            // Generate different data structures
            int[] arr = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            // generate data structures with values
            generateStructures(size, arr, hashSet, treeSet);

            // Pick a random value to search
            int searchValue = arr[size/2];

            // Perform search operation and display time results
            compareSearching(arr, hashSet, treeSet, searchValue);
        }
    }

    // generate datasets and populate the dat structures
    static void generateStructures(int size, int[] arr, HashSet<Integer> hashSet, TreeSet<Integer> treeSet) {
        Random random = new Random();for (int i = 0; i < size; i++) {
            int value = random.nextInt(size * 10); // Random number within a range
            arr[i] = value;
            hashSet.add(value);
            treeSet.add(value);
        }
    }

    // method to compare searching in different datasets
    static void compareSearching(int[] arr, HashSet<Integer> hashSet, TreeSet<Integer> treeSet, int searchValue) {
        // Define variables to store start and end time
        long startTime, endTime;

        // Array search time
        startTime = System.nanoTime();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==searchValue){
                System.out.printf("The value %d is present at index: %d\n.", searchValue, i);
                break;
            }
        }
        endTime = System.nanoTime();
        System.out.printf("The time taken by array to search is: %.4fms\n", (endTime - startTime) / 1e6);

        // HashSet search time
        startTime = System.nanoTime();
        if(hashSet.contains(searchValue)) {
            System.out.printf("The value %d is present in hashSet.\n", searchValue);
        } else {
            System.out.printf("The value %d is not present in hashSet.\n", searchValue);
        }
        endTime = System.nanoTime();
        System.out.printf("The time taken by hashSet to search is: %.4fms\n", (endTime - startTime) / 1e6);

        // TreeSet search time
        startTime = System.nanoTime();
        if(treeSet.contains(searchValue)) {
            System.out.printf("The value %d is present in treeSet.\n", searchValue);
        } else {
            System.out.printf("The value %d is not present in treeSet.\n", searchValue);
        }
        endTime = System.nanoTime();
        System.out.printf("The time taken by treeSet to search is: %.4fms\n\n", (endTime - startTime) / 1e6);
    }
}
// Sample Output ->
// Dataset Size: 1000
// The value 941 is present at index: 500
// .The time taken by array to search is: 10.5181ms
// The value 941 is present in hashSet.
// The time taken by hashSet to search is: 0.0563ms
// The value 941 is present in treeSet.
// The time taken by treeSet to search is: 0.0630ms

// Dataset Size: 10000
// The value 984 is present at index: 5000
// .The time taken by array to search is: 0.1753ms
// The value 984 is present in hashSet.
// The time taken by hashSet to search is: 0.0436ms
// The value 984 is present in treeSet.
// The time taken by treeSet to search is: 0.0455ms

// Dataset Size: 1000000
// The value 6104316 is present at index: 500000
// .The time taken by array to search is: 3.0801ms
// The value 6104316 is present in hashSet.
// The time taken by hashSet to search is: 0.0440ms
// The value 6104316 is present in treeSet.
// The time taken by treeSet to search is: 0.0484ms