package de.dhbwka.java.exercise.sorting;

class Quicksort {

    public static void main(String[] args) {
        int[] arr = {42, 17, 13, 0, 18, 2, 1, 9, 11};
        int[] sorted_array = quickSort(arr);
    }

    public static int[] quickSort(int[] array) {
        //corner cases
        if(array == null) return array;

        quickSort2(array, 0, array.length-1);
        return array;
    }

    //quicksort recursive method
    //takes in array, left index (inclusive), and right index (inclusive)
    public static void quickSort2(int[] array, int left, int right) {
        if(left < right) {
            //get pivot actual index and modify array base on pivot
            int p = partition(array, left, right);

            //divide from pivot index to two halves and quicksort each half
            quickSort2(array, left, p-1);
            quickSort2(array, p+1, right);
        }
    }

    //selecting a pivot and reorder the array base on it
    //returns pivot final/actual position index
    public static int partition(int[] array, int left, int right) {
        int piv = array[right]; //pivot value (right most element)
        int i =  left; //position the smaller (than pivot) values go until

        for(int j = left; j < right; j++) {
            //if current value is less than pivot
            //swap the value with value at a small-value-position
            //set small-val-pos to the next position
            if(array[j] < piv) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }
            //if not, do nothing
        }
        //switch the value after all the small values with pivot
        //pivot goes after all the values smaller than it
        array[right] = array[i];
        array[i] = piv;

        return i;
    }
}
