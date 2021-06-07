package bank.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author Uellington Damasceno
 * @git https://github.com/UellingtonDamasceno
 */
public class Solution {

    private final static Set<Integer> uniqueValues = new HashSet();

    public static void main(String[] args) throws IOException {
        try ( var br = new BufferedReader(new InputStreamReader(System.in))) {
            int numTests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numTests; i++) {

                Integer numPass = Integer.parseInt(br.readLine());

                int[] splitInt = Stream.of(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                quickSort(0, numPass - 1, splitInt);
                System.out.println(numPass - uniqueValues.size());
                uniqueValues.clear();
            }
        }
    }

    private static void quickSort(int start, int end, int... array) {
        if (start < end) {
            int left = start;
            int pivot = end;
            int right = end - 1;
            while (left <= right) {
                while (left <= right && array[left] > array[pivot]) {
                    left++;
                }
                while (left <= right && array[right] < array[pivot]) {
                    right--;
                }
                if (left <= right) {
                    swap(left, right, array);
                    left++;
                    right--;
                }
            }
            swap(left, pivot, array);
            quickSort(start, left - 1, array);
            quickSort(left + 1, end, array);
        }
    }

    private static void swap(int i, int j, int... array) {
        if (array[i] != array[j]) {
            uniqueValues.add(i);
            uniqueValues.add(j);
            
            //XOR SWAP
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
/*
        Outras formas de fazer swap:

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        array[i] += array[j];
        array[j] -= array[j];
        array[i] -= array[j];

        array[i] = (array[i] + array[j]) - (array[j] = array[i]);
*/
        }
    }
}
