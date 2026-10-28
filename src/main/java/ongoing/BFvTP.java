package ongoing;

import java.util.Arrays;

public class BFvTP {

    //Brute Force Approach:
    /** Problem 1:
     * Checks whether two arrays contain the same values and counts.
     * The order of the values does not matter.

     * @param array_1 the first non-null array
     * @param array_2 the second non-null array
     * @return true if the contents match, otherwise false
     * */

    public static boolean compareArrayContentBF(
            int[] array_1, int[] array_2) {

        if (array_1.length != array_2.length) {
            return false;
        }

        for (int i = 0; i < array_1.length; i++) {
            int count_1 = 0;
            int count_2 = 0;

            for (int j = 0; j < array_1.length; j++) {
                if (array_1[j] == array_1[i]) {
                    count_1++;
                }
            }

            for (int k = 0; k < array_2.length; k++) {
                if (array_2[k] == array_1[i]) {
                    count_2++;
                }
            }

            if (count_1 != count_2) {
                return false;
            }
        }

        return true;
    }

    //Two-Pointer Approach:
    /**
     * Checks array contents by sorting copies and comparing their values.
     * The original arrays are not changed.

     * @param array_1 the first non-null array
     * @param array_2 the second non-null array
     * @return true if the contents match, otherwise false
     */

    public static boolean comparrArrayContentTP(
            int[] array_1, int[] array_2) {

        if (array_1.length != array_2.length) {
            return false;
        }

        int[] sorted_1 = Arrays.copyOf(array_1, array_1.length);
        int[] sorted_2 = Arrays.copyOf(array_2, array_2.length);

        Arrays.sort(sorted_1);
        Arrays.sort(sorted_2);

        int first = 0;
        int second = 0;

        while (first < sorted_1.length && second < sorted_2.length) {
            if (sorted_1[first] != sorted_2[second]) {
                return false;
            }
            first++;
            second++;
        }

        return true;
    }


    //Problem 2:

    //Brute Force Approach:
    /**
     * Checks whether a string reads the same forwards and backwards.
     * Includes case differences, spaces and punctuation.

     * @param data the non-null string to check
     * @return true if the string is a palindrome, otherwise false
     */

    public static boolean palindromeBF(String data) {
        for (int i = 0; i < data.length(); i++) {
            char first = data.charAt(i);
            char last = data.charAt(data.length() - 1 - i);

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    //Two-Pointer Approach:
    /**
     * Checks for a palindrome by comparing characters from both ends.
     * Includes case differences, spaces and punctuation.

     * @param data the non-null string to check
     * @return true if the string is a palindrome, otherwise false
     */

    public static boolean palindromeTP(String data) {
        int left = 0;
        int right = data.length() - 1;
        while (left < right) {
            if (data.charAt(left) != data.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Problem 3:

    //Brute Force Approach:
    /**
     * Finds the shortest contiguous subarray with a sum greater than the target.
     * Keeps the latest answer when shortest lengths are equal.

     * @param input_array the non-null array of positive integers
     * @param target_sum the positive target sum
     * @return inclusive start and end indexes, or {0} if none is found
     */

    public static int[] shortestSubarrayBF(
            int[] input_array, int target_sum) {

        int shortest_length = input_array.length + 1;
        int best_start = -1;
        int best_end = -1;
        for (int start_index = 0;
             start_index < input_array.length;
             start_index++) {

            long current_sum = 0;

            for (int end_index = start_index;
                 end_index < input_array.length;
                 end_index++) {
                current_sum += input_array[end_index];

                if (current_sum > target_sum) {
                    int current_length = end_index - start_index + 1;

                    if (current_length <= shortest_length) {
                        shortest_length = current_length;
                        best_start = start_index;
                        best_end = end_index;
                    }
                    break;
                }
            }
        }
        if (best_start == -1) {
            return new int[]{0};
        }
        return new int[]{best_start, best_end};
    }

    //Two-Pointer Approach:
    /**
     * Finds the shortest subarray with a sum greater than the target.
     * Uses a sliding window and keeps the earliest equal-length answer.

     * @param input_array the non-null array of positive integers
     * @param target_sum the positive target sum
     * @return inclusive start and end indexes, or {0} if none is found
     */

    public static int[] shortestSubarrayTP(
    int[] input_array, int target_sum) {

        int left = 0;
        long current_sum = 0;
        int shortest_length = input_array.length + 1;
        int best_start = -1;
        int best_end = -1;

        for (int right = 0; right < input_array.length; right++){
            current_sum += input_array[right];
            while (left <= right && current_sum > target_sum) {
                int current_length = right - left + 1;

                if (current_length < shortest_length) {
                    shortest_length = current_length;
                    best_start = left;
                    best_end = right;
                }
                current_sum -= input_array[left];
                left++;
            }
        }
        if (best_start == -1) {
            return new int[]{0};
        }
        return new int[]{best_start, best_end};
    }

    //Problem 4:

    //Brute Force Approach:
    /**
     * Reverses English vowels by storing them and reading them backwards.
     * Other characters stay in their original positions.

     * @param word the non-null string to process
     * @return the string with its vowels reversed
     */

    public static String reverseVowelOrderBF(String word) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] result_word = word.toCharArray();
        char[] stored_vowels = new char[word.length()];

        int count = 0;
        for (int i = 0; i < result_word.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (result_word[i] == vowels[j]) {
                    stored_vowels[count] = result_word[i];
                    count++;
                    break;
                }
            }
        }

        int next = count - 1;
        for (int i = 0; i < result_word.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (result_word[i] == vowels[j]) {
                    result_word[i] = stored_vowels[next];
                    next--;
                    break;
                }
            }
        }
        return new String(result_word);
    }

    //Two-Pointer Approach:
    /**
     * Reverses English vowels by swapping vowels from opposite ends.
     * Other characters stay in their original positions.
     *
     * @param word the non-null string to process
     * @return the string with its vowels reversed
     */

    public static String reverseVowelOrderTP(String word) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] result_word = word.toCharArray();

        int left = 0;
        int right = result_word.length - 1;

        while (left < right) {
            boolean left_vowel = false;
            boolean right_vowel = false;

            for (int i = 0; i < vowels.length; i++) {
                if (result_word[left] == vowels[i]) {
                    left_vowel = true;
                }
                if (result_word[right] == vowels[i]) {
                    right_vowel = true;
                }
            }
            if (!left_vowel) {
                left++;
            } else if (!right_vowel) {
                right--;
            } else {
                char temporary = result_word[left];
                result_word[left] = result_word[right];
                result_word[right] = temporary;
                left++;
                right--;
            }
        }
        return new String(result_word);
    }

}

