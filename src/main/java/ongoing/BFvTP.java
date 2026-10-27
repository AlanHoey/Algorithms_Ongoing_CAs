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




}

