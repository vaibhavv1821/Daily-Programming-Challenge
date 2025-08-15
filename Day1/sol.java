class sol{
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,0,0,1,2,0,1,2,0,1,1,1,0,2,1,0,1,2,0,1,2,0,1,1,1,0,2,1,0,1,2,0,1,2,0,1};

        int n=arr.length;

        int low=0;
        int mid=0;
        int high=n-1;
        while(mid <= high) {
            if(arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        System.out.println("Sorted Array: ");
        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}