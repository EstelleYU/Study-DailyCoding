import java.util.Arrays;

/* ------------------------------
24_isSubsetOf
Daily Coding from CodeStates
Wed 29 June 2022

From two integer arrays(base, sample),
Return whether sample is a subset of base or not(answer as boolean).
 ------------------------------ */
public class isSubsetOf {
    public static void main(String[] args) {
//        int[] base = {1, 2, 3, 4, 5};
//        int[] sample = {1, 7};

        int[] base = {10, 99, 123, 7, 30};
        int[] sample = {7, 10, 123, 99};

        boolean status = true;
        for (int j=0; j<sample.length; j++){
            status = contains(base, sample[j]);
            if (status == false) break;
        }
        System.out.println(String.valueOf(status));

        //return status;
    }
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
}
