import java.util.Random;

// Class to sort data of different datasets efficiently
public class SortData {
    public static void main(String[] args) {
        // Use random to generate random integers for arrays of sizes 1_000, 10_000, and 1_000_000
        int[] data1 = generateRandomArray(1_000, 1_000);
        int[] data2 = generateRandomArray(10_000, 10_000);
        int[] data3 = generateRandomArray(1_000_000, 1_000_000);

        System.out.println("Sorting Performance on Different Dataset Sizes:");

        // Sorting data1 (1,000 elements)
        compareSorts(data1.clone(), "Dataset Size: 1,000");

        // Sorting data2 (10,000 elements)
        compareSorts(data2.clone(), "Dataset Size: 10,000");

        // Sorting data3 (1,000,000 elements)
        compareSorts(data3.clone(), "Dataset Size: 1,000,000");
    }

    // method to generate a random array of given size and range
    static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for(int i=0;i<size;i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    // Method to compare Bubble Sort, Merge Sort, and Quick Sort
    static void compareSorts(int[] data, String datasetInfo) {
        System.out.println(datasetInfo);

        long startTime, endTime;

        // Bubble Sort
        int[] bubbleData = data.clone();
        if(bubbleData.length==1_000_000) System.out.println("Bubble sort is not feasible for this dataset");
        else {
            startTime = System.nanoTime();
            bubbleSort(bubbleData);
            endTime = System.nanoTime();
            System.out.println("Bubble Sort Time: " + (endTime - startTime) / 1e6 + " ms");
        }

        // Merge Sort
        int[] mergeData = data.clone();
        startTime = System.nanoTime();
        mergeSort(mergeData, 0, mergeData.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTime - startTime) / 1e6 + " ms");

        // Quick Sort
        int[] quickData = data.clone();
        startTime = System.nanoTime();
        quickSort(quickData, 0, quickData.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime) / 1e6 + " ms\n");
    }

    // Bubble Sort Algorithm
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Merge Sort Algorithm
    static void mergeSort(int[] arr, int left, int right) {
        if(left<right) {
            int mid = left + (right-left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid+1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while(i<n1 && j<n2) {
            if(leftArr[i]<=rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while(i<n1) arr[k++] = leftArr[i++];
        while(j<n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort Algorithm
    static void quickSort(int[] arr, int low, int high) {
        if(low<high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low;j<high;j++) {
            if (arr[j]<pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
// Sample Output ->
// Sorting Performance on Different Dataset Sizes:
// Dataset Size: 1,000
// Bubble Sort Time: 3.59075 ms
// Merge Sort Time: 0.664375 ms
// Quick Sort Time: 0.320667 ms

// Dataset Size: 10,000
// Bubble Sort Time: 69.867959 ms
// Merge Sort Time: 1.132375 ms
// Quick Sort Time: 0.761416 ms

// Dataset Size: 1,000,000
// Bubble sort is not feasible for this dataset
// Merge Sort Time: 120.926625 ms
// Quick Sort Time: 67.156458 ms