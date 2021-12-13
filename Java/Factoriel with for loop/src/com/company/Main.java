package com.company;

// Java implementation of iterative Binary Search
class BinarySearch {
    // Returns index of x if it is present in arr[],
    // else return -1
    int binarySearch(char arr[], char x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }
}
class Main{
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        char arr[] = { 9, 8, 7, 'я', 'ю', 'ъ', 'о' };
        char chars[] = { '9', '1', '1', '0', '4', 'п', 'и', 'л', 'а', 'ф','о', 'в' };
        int n = arr.length;
        for (char ch : chars){
            char x = ch;
            int result = ob.binarySearch(arr, x);
            if (result == -1)
                System.out.println("Element not present");
            else
                System.out.println("Element found at "
                        + "index " + result);
        }
    }
}