import java.util.*;

public class SearchPerformance {
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000};
        int target = -1; 

        for (int size : sizes) {
            int[] data = generateData(size);

            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();

           
            Arrays.sort(data);
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();

           
            System.out.println("Dataset Size:", size);
            System.out.println("Linear Search Time:", (endLinear - startLinear) / 1e6);
            System.out.println("Binary Search Time:", (endBinary - startBinary) / 1e6);
        }
    }

    static int[] generateData(int size) {
        int[] data = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 10); 
        }
        return data;
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
