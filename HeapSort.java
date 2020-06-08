package CodeSnippets;

import java.util.Scanner;

public class HeapSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HeapSort h = new HeapSort();
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        h.sort(a);
        h.printArray(a);
        sc.close();
    }

    public void printArray(int[] a) {
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void sort(int a[]) {
        // 1, 2, 4, 5, 7, 9
        // heapify the array
        /**
         * We try to build the max heap with leaf nodes. In case of a complete binary tree,
         * the leaf nodes start from floor(n/2) + 1 to n. 
         * 
         * So, all the leaf nodes are already a heap. Hence, we start the heapification of tree
         * from the last node which is not a leaf, i.e, n/2th node.
         */
        int n = a.length;
        for(int i = n/2 - 1; i >= 0; i--){      // This will build the max heap
            maxHeapify(a, n, i);
        }
        printArray(a);
        /**
         * One thing to note is that you will have the max element at root of the node 
         * after heapification.
         *  */    
        // take the first one and put at the last
        // Note: here the i is n - 1 bcz we know that after hepification of the array, the max element is already found. 
        // So, we need to modify the remaining (n - 1) elements
        for(int i = n - 1; i > 0; i--){
            // Swap out the max element at 0th index with last index to place that element.
            swap(a, 0, i);
            // Once swaped, the elements again needs to be heapified
            // Note: The size of heap is reducing by 1 each time, i.e, i
            maxHeapify(a, i, 0);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    public void maxHeapify(int a[], int heapSize, int index) {
        int left, right;
        left = getLeftChild(index);
        right = getRightChild(index);
        int largest = index;
        if(left < heapSize && a[left] > a[index]){
            largest = left;
        }
        if(right < heapSize && a[right] > a[largest]){
            largest = right;
        }

        if(largest != index){
            swap(a, largest, index);
            maxHeapify(a, heapSize, largest);
        }
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int parent(int index){
        return (int) Math.floor((index - 1)/2);
    }

}