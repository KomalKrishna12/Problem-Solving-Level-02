import java.util.HashMap;
import java.util.Scanner;
// in this ques we have given an array 
// we are required to find out the smallest subarray who is containing all occurence most frequently used elments
// arr : [1,2,2,3,1]
// in this array 1 and 2 are the elements with high freq 2
// we have to find out the smallest subarray in which all the freq can be added
// for element 1 : [1,2,2,3,1] len : 5
// for element 2 : [2,2] len : 2
// so the subarray [2,2] will be our final ans
// display the element, it's starting index and end index
public class Q39_Smallest_subarray_with_highest_frequency_of_elements {
    public static void solution(int[] arr) {
        // create two hashmap, fremap and indexmap
        // in fremap add all element with its freq
        // in idxmap add all element with its starting index so it'll help in calculating length of array
        // create 4 variable hf, si, ei and len
        // start traversing array arr
        // check that arr[i] is in fmap or not
        // if not then add it into fmap with freq 1 and in imap with inde value i
        // if it is available then increase its freq by 1
        // now compare its freq by hf
        // if greater than hf then update all
        // if it is equal then check the len
        // if it's len is small then update all 
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