public class solution{
    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
        
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        
        return slow;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 3, 4, 2, 2}, 
            {3, 1,3,4, 2}, 
            {1, 1,5,4}, 
            {1, 4, 4, 2, 3}, 
            {1, 2, 3, 4, 5, 6, 7, 50000, 8, 9, 50000}
        };

        for (int[] test : testCases) {
            System.out.println("Duplicate number:" + findDuplicate(test));
        }
    }
}
