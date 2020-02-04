// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author   Yuxiao Hu (19321099)
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){

        //todo: implement the sort
    	if(a.length == 0 || a.length == 1) {
    		return a;
    	}
    	
    	double temp;
    	for(int i= 1; i< a.length; i++) {
    		for(int j = i; j > 0; j--){
    				if(a[j] < a[j-1]){
    						temp = a[j];
    						a[j] = a[j-1];
    						a[j-1] = temp;
    				}
    		}
    	}
    	return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	
    	 //todo: implement the sort
		if(a.length == 0 || a.length == 1) {
			return a;
		}
		
		for(int i= 0; i< a.length-1; i++)
		{
		
			int min_idx= i;
			for(int j = i+1; j < a.length; j++)
				if(a[j] < a[min_idx]) {
					min_idx= j;
				}
			
			double temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}

		return a;
        

    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
		 //todo: implement the sort
    	if(a.length == 0 || a.length == 1) {
			return a;
		}
    	
    	if(a.length <= 15) {
    		return insertionSort(a);
    	}
    	
    	quickSortHelper(a,0,a.length-1);
    	return a;
    	
    }
    
    public static void quickSortHelper(double[] a, int lo, int hi) {
    	if(lo >= hi) {
    		return;
    	}
    	
    	int pivotIndex = partition(a,lo,hi);
    	quickSortHelper(a,lo,pivotIndex-1);
    	quickSortHelper(a,pivotIndex+1,hi); 	
    }
    
    public static int partition(double[] a, int low, int high) {
    	int i = low;
    	int j = high;
    	double pivot = a[low];
    	
    	for(;;) {
    		while(a[++i] < pivot) {
    			if(i == high) {
    				break;
    			}
    		}
    		
    		while(a[j] > pivot) {
    			if(j == low) {
    				break;
    			}
    			j--;
    		}
    		
    		if( i >= j) {
    			break;
    		}
    		
    		double temp = a[i];
    		a[i] = a[j];
    		a[j] = temp;
    	}
    	
    	a[low] = a[j];
    	a[j] = pivot;
    	return j;
    }
    
    
    //end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
		return a;

		 //todo: implement the sort
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	//todo: implement the sort
    	mergeSortRecursiveHelper(a,0,a.length-1);
    	
    	return a;
	
   }//end mergeSortRecursive
    
    public static void mergeSortRecursiveHelper( double[] a, int low, int high) {
    	if (low >= high)  
            return;  
        int mid = low + (high-low)/2;      
        mergeSortRecursiveHelper(a, low, mid);  
        mergeSortRecursiveHelper(a, mid+1, high); 
        //System.out.println("low: " + low + " high: " + high + " mid: " + mid );
        merge(a, low, high);  
    }
    
    public static void merge( double[] a , int l,  int h) {
    	int mid= l + (h-l)/1 ;
        int i=l;
        int j=mid+1;
        int count=0;
        double temp[]=new double[h-l+1];
        while(i<=mid&&j<=h){
            if(a[i]<a[j]){
                temp[count++]=a[i++];
            }else{
                temp[count++]=a[j++];
            }        
        }
        while(i<=mid){
            temp[count++]=a[i++];
        }
        while(j<=h){
            temp[count++]=a[j++];
        }
        
        
        count=0;
        while(l<=h){
            a[l++]=temp[count++];
        }

    	
    }
    	

    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class
