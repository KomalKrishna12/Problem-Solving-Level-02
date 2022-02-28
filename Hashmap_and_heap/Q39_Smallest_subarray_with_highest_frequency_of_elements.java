import java.util.HashMap;
import java.util.Scanner;

public class Q39_Smallest_subarray_with_highest_frequency_of_elements {
    public static void solution(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> startingIndexMap = new HashMap<>();

        int highestFreq = 0;
        int startIndex = 0;
        int endIndex = 0;
        int length = endIndex - startIndex + 1;

        for (int i = 0; i < arr.length; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
                startingIndexMap.put(arr[i], i);
            }
            if (freqMap.get(arr[i]) > highestFreq) {
                highestFreq = freqMap.get(arr[i]);
                startIndex = startingIndexMap.get(arr[i]);
                endIndex = i;
                length = endIndex - startIndex + 1;
            } else if (freqMap.get(arr[i]) == highestFreq) {
                int challengeLen = i - startingIndexMap.get(arr[i]) + 1;
                if (challengeLen < length) {
                    highestFreq = freqMap.get(arr[i]);
                    startIndex = startingIndexMap.get(arr[i]);
                    endIndex = i;
                    length = endIndex - startIndex + 1;
                }
            } 
        }

        System.out.println(arr[startIndex]);
        System.out.println(startIndex);
        System.out.println(endIndex);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        solution(arr);
    }
}