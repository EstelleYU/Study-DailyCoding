
/* -----------------------------------------------
Wed 08 JUNE 2022
Daily Coding from Coplit CodeStates
12_reverseArr
- Return reversed array. (by elements)
--------------------------------------------------
example)

int[] arr = new int[]{3,5,7};
output = {7, 5, 3}
int[] ReversedArray(int[] arr)
--------------------------------------------------*/

import java.util.Arrays;

public class reverseArr {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println( Arrays.toString( ReversedArray(arr) ) );
    }
    public static int[] ReversedArray(int[] arr)  {
        if(arr.length == 0) return null;
        int[] head = Arrays.copyOfRange(arr, arr.length-1, arr.length);
        int[] tail = ReversedArray(Arrays.copyOfRange(arr, 0, arr.length-1));

        int[] output = new int[head.length + tail.length];
        System.arraycopy(head, 0, output, 0, head.length);
        System.arraycopy(tail, 0, output, head.length, tail.length);

        return output;
    }
}