package ongoing;

import java.util.Arrays;

public class BFvTP {

    // Problem 1:
        // Given two supplied arrays of ints, determine if the contents are equal (this can be in the same or different order).
        //Return true if the arrays are equal, false otherwise.

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


    //Problem 2:
        //Given a supplied String, determine whether it is a palindrome (case-insensitive).
        //Note: this should ignore punctuation and spaces.
        //Compare only those characters that should be considered.
        //Return true if the String is a palindrome, false otherwise

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


    //Problem 3:
    //Given an array of positive integers and a target value, identify the shortest possible contiguous subarray whose sum is at least the target.
    //Find the shortest valid subarray fulfilling the requirement.
    //Where a valid solution is found, return an array containing the identified start and end positions.
    //Where no valid solution is found, return an array containing 0

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

    //Problem 4:
    //Given a string, reverse only the vowels in the string and return it. Note: Strings cannot be edited in Java. You may wish to convert this to an array of characters before beginning your process, then convert it to a String again at the end.
    //Vowels should switch places – the first vowel should become the last vowel; the last vowel should become the first vowel.
    //Only vowels should be reordered. All other characters should remain in their original position.

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


}

