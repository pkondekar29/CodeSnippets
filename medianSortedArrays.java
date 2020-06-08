package CodeSnippets;

class medianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x = nums1.length;
        int y = nums2.length;
        
        int low = 0;
        int high = x;
        if(low == high){
            return findMedian(y, nums2);
        }
        int partitionX, partitionY;
        while(low <= high){
            partitionX = (low + high) / 2;
            partitionY = ((x + y + 1) / 2) - partitionX;
            
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE: nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
                
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if(((x + y) / 2) % 2 == 0){ // even number of elements
                    return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2;
                } else{
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY){
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
    
    private static double findMedian(int s, int[] a){
        if(s%2 == 0) {
            return (double)(a[s/2] + a[s/2 - 1]) / 2;
        } else {
            return (double)a[s/2];
        }
    }

    public static void main(String[] args){
	int [] a = {1, 3, 5 ,6};
	int [] b = {4, 7, 8, 9,11};
    	
	System.out.println(findMedianSortedArrays(a, b));
    }
}
