

/*--------------------------------
        Tue 14 June 2022
        Daily Coding from Coplit CodeStates
        14_superIncreasing

        Input integer array,
        return boolean type answer whether each element is bigger than the sum of the elements before it.

--------------------------------- */

public class superIncreasing {
    public static void main(String[] args) {

        int[] arr = {1, 3, 6, 13, 54};  // true
        // int [] arr = {1, 3, 5, 9};   // false

        if(arr.length == 0) System.out.println("false");
        int sum = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= sum) System.out.println("false");
            sum = sum + arr[i];
        }
        System.out.println("true");
    }
}
