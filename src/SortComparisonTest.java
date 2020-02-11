import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------

//github page:https://github.com/lil137/22010_SortingAlgorithm

// If you want to print the performance experiment time for each sort,
// then uncomment the testSort method and the main method, then run this test file




/**
 *  Test class for SortComparison.java

 *
 *  @author Yuxiao Hu (19321099)
 *  @version HT 2020
 */
/* 							Insert			Selection			MergeRecursive			MergeIterative			Quick
 * 10 random				0.0056ms		0.0152ms			0.027ms					0.0227ms				0.0078ms
 * 100 random				0.1569ms		0.169ms				0.0694ms				0.0792ms				0.0419ms
 * 1000 random				10.3426ms		4.6504ms			0.9442ms				0.6296ms				0.4226ms
 * 1000 few unique			1.5529ms		3.0996ms			0.2558ms				0.4981ms				0.2609ms
 * 1000 nearly ordered		0.3666ms		0.2725ms			0.1941ms				0.1620ms				0.1301ms
 * 1000 reverse order		0.5416ms		0.5399ms			0.1977ms				0.1482ms				0.7608ms
 * 1000 sorted				0.3978ms		0.4969ms			0.1428ms				0.2354ms				0.4014ms
 * 
 * 
 * */

/*
a. Which of the sorting algorithms does the order of input have an impact on? Why?
Insertion sort, the best case for insertion sort is the ordered array while the worst is the reverse ordered array
since in each run, insertion sort would compare the current element with all the previous elements and swap if it's smaller,
in the reverse ordered array, this swap would happen every time so it would take longer time.
*/

/*
b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
In theory, the selection sort is not sensitive to the input order, but according to the performance result,
the selection sort performance worst for different files with both 1000 numbers.

For my implemention, while the pivot for quick sort is always the first one, then its performance might also 
differ quite large between best and worst cases

Also, for insertion sort, the best case is the sorted array, the worst case is the reverse ordered array, and the 
time complexity is O(N) and O(N^2), which should also be obvious but it didn't show in the experiment.


*/

/*
/*c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.

According to the performance experiment result,  MergeSortIterative seems have the best scalability. 
*/

/*
d. Did you observe any difference between iterative and recursive implementations of merge
sort?
The iterative version would sort the array by size 1,2,4,8 from the start while the recursive version 
just continue to divide the array into two parts. I wrote two different merge methods to fit different version.
The iterative version is more concise and direct than the recursive version.


*/

/*
e. Which algorithm is the fastest for each of the 7 input files?

For the 10random, 100random, 1000random, the quick sort would be the best.
For the 1000Duplicates, quick sort and mergerSortRecursive has almost the same performance.
For the 1000Rerverse, the mergeSortIterative seems to be the best.
For the 1000Ordered, the mergeSortRecursive has the best performance.
*/
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

	@Test
    public void testSorts() {
    	double[] testArray= new double[] {4,3,2,8,6,42,5,7,9,12};
    	double[] sortedTestArray  = new double[testArray.length];
    	double[] trueArray = new double[] {2,3,4,5,6,7,8,9,12,42};
    	
    	sortedTestArray = SortComparison.insertionSort(testArray);
    	for( int i = 0; i < trueArray.length; i ++) {
    		assertEquals(trueArray[i], sortedTestArray[i], 1e-6);
    	}
    	
    	testArray= new double[] {4,3,2,8,6,42,5,7,9,12};
    	sortedTestArray = SortComparison.selectionSort(testArray);
    	for( int i = 0; i < trueArray.length; i ++) {
    		assertEquals(trueArray[i], sortedTestArray[i], 1e-6);
    	}
    	
    	testArray= new double[] {1,2,3,4,5};
    	double[] trueArray3 = new double[] {1,2,3,4,5};
    	sortedTestArray = SortComparison.quickSort(testArray);
    	for( int i = 0; i < trueArray3.length; i ++) {
    		assertEquals(trueArray3[i], sortedTestArray[i], 1e-6);
    	}
    	
    	testArray= new double[] {4,3,2,8,6,42,5,7,9,12,1242,456,213,35};
    	double[] trueArray2 = new double[] {2,3,4,5,6,7,8,9,12,35,42,213,456,1242};
    	sortedTestArray = SortComparison.quickSort(testArray);
    	for( int i = 0; i < trueArray2.length; i ++) {
    		assertEquals(trueArray2[i], sortedTestArray[i], 1e-6);
    	}
    	
    	testArray= new double[] {4,3,2,8,6,42,5,7,9,12};
    	sortedTestArray = SortComparison.mergeSortRecursive(testArray);
    	for( int i = 0; i < trueArray.length; i ++) {
    		assertEquals(trueArray[i], sortedTestArray[i], 1e-6);
    	}
    	
    	testArray= new double[] {4,3,2,8,6,42,5,7,9,12};
    	sortedTestArray = SortComparison.mergeSortIterative(testArray);
    	for( int i = 0; i < trueArray.length; i ++) {
    		assertEquals(trueArray[i], sortedTestArray[i], 1e-6);
    	}
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmptyAndSingle()
    {
    	double[] emptyArray = new double[] {};
    	double[] singleElementArray = new double[] {1.0};
    	double[] sortedTestArray = new double[emptyArray.length];
    	sortedTestArray = SortComparison.insertionSort(emptyArray);
    	assertEquals(emptyArray, sortedTestArray);
    	sortedTestArray = SortComparison.insertionSort(singleElementArray);
    	assertEquals(singleElementArray,sortedTestArray);
    	
    	sortedTestArray = SortComparison.selectionSort(emptyArray);
    	assertEquals(emptyArray, sortedTestArray);
    	sortedTestArray = SortComparison.selectionSort(singleElementArray);
    	assertEquals(singleElementArray,sortedTestArray);
    	
    	sortedTestArray = SortComparison.quickSort(emptyArray);
    	assertEquals(emptyArray, sortedTestArray);
    	sortedTestArray = SortComparison.quickSort(singleElementArray);
    	assertEquals(singleElementArray,sortedTestArray);
    	
    	sortedTestArray = SortComparison.mergeSortRecursive(emptyArray);
    	assertEquals(emptyArray, sortedTestArray);
    	sortedTestArray = SortComparison.mergeSortRecursive(singleElementArray);
    	assertEquals(singleElementArray,sortedTestArray);
    	
    	sortedTestArray = SortComparison.mergeSortIterative(emptyArray);
    	assertEquals(emptyArray, sortedTestArray);
    	sortedTestArray = SortComparison.mergeSortIterative(singleElementArray);
    	assertEquals(singleElementArray,sortedTestArray);
    	
    	
    	
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    /*public static float testSort(String filename, String sortName, int len) throws Exception {
    	double[] temp = new double[len];
    	if(len == 10) {
    		temp = ReadFile.readFile10Num(filename);
    	}else if(len == 100) {
    		temp = ReadFile.readFile100Num(filename);
    	}else if(len == 1000){
    		temp = ReadFile.readFile1000Num(filename);
    	}else if(len == 10000){
    		temp = ReadFile.readFile10000Num(filename);
    	}else if(len == 100000){
    		temp = ReadFile.readFile100000Num(filename);
    	}
    	
    	long startTime = System.nanoTime();
    	long endTime = System.nanoTime();
    	
    	if(sortName == "insertion") {
    		startTime = System.nanoTime();
    		//System.out.println(startTime);
        	SortComparison.insertionSort(temp);
        	endTime = System.nanoTime(); 	
        	
        	//System.out.println(endTime);
    	}else if(sortName == "selection") {
    		startTime = System.nanoTime();
        	SortComparison.selectionSort(temp);
        	endTime = System.nanoTime();	
    	}else if(sortName == "quick") {
    		startTime = System.nanoTime();
        	SortComparison.quickSort(temp);
        	endTime = System.nanoTime();
    	}else if(sortName == "mergeRecursive") {
    		startTime = System.nanoTime();
        	SortComparison.mergeSortRecursive(temp);
        	endTime = System.nanoTime();	
    	}else if(sortName == "mergeIterative") {
    		startTime = System.nanoTime();
        	SortComparison.mergeSortIterative(temp);
        	endTime = System.nanoTime(); 	
    	}
    	
    	return (float)(endTime-startTime)/1000000;
    	
    	
    }*/

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws Exception 
     *
     */
    /*public static void main(String[] args) throws Exception
    {
        //TODO: implement this method
    	//SortComparison SortCom = new SortComparison();
    	
    	String fileName1 = "numbers10.txt";
    	String fileName2 = "numbers100.txt";
    	String fileName3 = "numbers1000.txt";
    	String fileName4 = "numbers1000Duplicates.txt";
    	String fileName5 = "numbersNearlyOrdered1000.txt";
    	String fileName6 = "numbersReverse1000.txt";
    	String fileName7 = "numbersSorted1000.txt";
    	
    	
    	String fileName8 = "numbers10000.txt";
    	String fileName9 = "numbers10000Duplicates.txt";	
    	String fileName10 = "numbers100000.txt";
    	String fileName11 = "numbersReverse10000.txt";
    	String fileName12 = "numbersSorted10000.txt";
    	String fileName13 = "resNearlyOrdered10000.txt";
    	
    	String sortName1 = "insertion";
    	String sortName2 = "selection";
    	String sortName3 = "quick";
    	String sortName4 = "mergeRecursive";
    	String sortName5 = "mergeIterative";
    	
    	
    	System.out.println("Runtime for " + sortName1 + " " + fileName1 + " " + testSort(fileName1, sortName1, 10) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName2 + " " + testSort(fileName2, sortName1, 100) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName3 + " " + testSort(fileName3, sortName1, 1000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName4 + " " + testSort(fileName4, sortName1, 1000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName5 + " " + testSort(fileName5, sortName1, 1000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName6 + " " + testSort(fileName6, sortName1, 1000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName7 + " " + testSort(fileName7, sortName1, 1000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName8 + " " + SortComparison.testSort(fileName8, sortName1, 10000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName9 + " " + SortComparison.testSort(fileName9, sortName1, 10000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName10 + " " + SortComparison.testSort(fileName10, sortName1, 100000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName11 + " " + SortComparison.testSort(fileName11, sortName1, 10000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName12 + " " + SortComparison.testSort(fileName12, sortName1, 10000) + "ms");
    	System.out.println("Runtime for " + sortName1 + " " + fileName13 + " " + SortComparison.testSort(fileName13, sortName1, 10000) + "ms");
    	
    	System.out.println("");
    	
    	
    	System.out.println("Runtime for " + sortName2 + " " + fileName1 + " " + testSort(fileName1, sortName2, 10) + "ms");
    	System.out.println("Runtime for " + sortName2 + " " + fileName2 + " " + testSort(fileName2, sortName2, 100) + "ms");
    	System.out.println("Runtime for " + sortName2 + " " + fileName3 + " " + testSort(fileName3, sortName2, 1000) + "ms");
    	System.out.println("Runtime for " + sortName2 + " " + fileName4 + " " + testSort(fileName4, sortName2, 1000) + "ms");
    	System.out.println("Runtime for " + sortName2 + " " + fileName5 + " " + testSort(fileName5, sortName2, 1000) + "ms");
    	System.out.println("Runtime for " + sortName2 + " " + fileName6 + " " + testSort(fileName6, sortName2, 1000) + "ms");
    	System.out.println("Runtime for " + sortName2 + " " + fileName7 + " " + testSort(fileName7, sortName2, 1000) + "ms");
    	System.out.println("");
    	
    	System.out.println("Runtime for " + sortName3 + " " + fileName1 + " " + testSort(fileName1, sortName3, 10) + "ms");
    	System.out.println("Runtime for " + sortName3 + " " + fileName2 + " " + testSort(fileName2, sortName3, 100) + "ms");
    	System.out.println("Runtime for " + sortName3 + " " + fileName3 + " " + testSort(fileName3, sortName3, 1000) + "ms");
    	System.out.println("Runtime for " + sortName3 + " " + fileName4 + " " + testSort(fileName4, sortName3, 1000) + "ms");
    	System.out.println("Runtime for " + sortName3 + " " + fileName5 + " " + testSort(fileName5, sortName3, 1000) + "ms");
    	System.out.println("Runtime for " + sortName3 + " " + fileName6 + " " + testSort(fileName6, sortName3, 1000) + "ms");
    	System.out.println("Runtime for " + sortName3 + " " + fileName7 + " " + testSort(fileName7, sortName3, 1000) + "ms");
    	System.out.println("");
    	
    	System.out.println("Runtime for " + sortName4 + " " + fileName1 + " " + testSort(fileName1, sortName4, 10) + "ms");
    	System.out.println("Runtime for " + sortName4 + " " + fileName2 + " " + testSort(fileName2, sortName4, 100) + "ms");
    	System.out.println("Runtime for " + sortName4 + " " + fileName3 + " " + testSort(fileName3, sortName4, 1000) + "ms");
    	System.out.println("Runtime for " + sortName4 + " " + fileName4 + " " + testSort(fileName4, sortName4, 1000) + "ms");
    	System.out.println("Runtime for " + sortName4 + " " + fileName5 + " " + testSort(fileName5, sortName4, 1000) + "ms");
    	System.out.println("Runtime for " + sortName4 + " " + fileName6 + " " + testSort(fileName6, sortName4, 1000) + "ms");
    	System.out.println("Runtime for " + sortName4 + " " + fileName7 + " " + testSort(fileName7, sortName4, 1000) + "ms");
    	System.out.println("");
    	
    	System.out.println("Runtime for " + sortName5 + " " + fileName1 + " " + testSort(fileName1, sortName5, 10) + "ms");
    	System.out.println("Runtime for " + sortName5 + " " + fileName2 + " " + testSort(fileName2, sortName5, 100) + "ms");
    	System.out.println("Runtime for " + sortName5 + " " + fileName3 + " " + testSort(fileName3, sortName5, 1000) + "ms");
    	System.out.println("Runtime for " + sortName5 + " " + fileName4 + " " + testSort(fileName4, sortName5, 1000) + "ms");
    	System.out.println("Runtime for " + sortName5 + " " + fileName5 + " " + testSort(fileName5, sortName5, 1000) + "ms");
    	System.out.println("Runtime for " + sortName5 + " " + fileName6 + " " + testSort(fileName6, sortName5, 1000) + "ms");
    	System.out.println("Runtime for " + sortName5 + " " + fileName7 + " " + testSort(fileName7, sortName5, 1000) + "ms");
    	System.out.println("");
	
    }

}*/

/*
class ReadFile {
	
	public static double[] readFile10Num(String filename) throws Exception {
		// Create a File instance
	    java.io.File file = new java.io.File(filename);
	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);
	    double[] Nums = new double[10];
	    int index = 0;
	    // Read data from a file
	    while (input.hasNext()) {
	    	Nums[index] = input.nextDouble();
	    	index++;
	    }
	    // Close the file
	    input.close();	    
	    return Nums;
	}
	
	public static double[] readFile100Num(String filename) throws Exception {
		// Create a File instance
	    java.io.File file = new java.io.File(filename);
	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);
	    double[] Nums = new double[100];
	    int index = 0;
	    // Read data from a file
	    while (input.hasNext()) {
	    	Nums[index] = input.nextDouble();
	    	index++;
	    }
	    // Close the file
	    input.close();	    
	    return Nums;
	}
	
	public static double[] readFile1000Num(String filename) throws Exception {
		// Create a File instance
	    java.io.File file = new java.io.File(filename);
	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);
	    double[] Nums = new double[1000];
	    int index = 0;
	    // Read data from a file
	    while (input.hasNext()) {
	    	Nums[index] = input.nextDouble();
	    	index++;
	    }
	    // Close the file
	    input.close();	    
	    return Nums;
	}
	
	public static double[] readFile10000Num(String filename) throws Exception {
		// Create a File instance
	    java.io.File file = new java.io.File(filename);
	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);
	    double[] Nums = new double[10000];
	    int index = 0;
	    // Read data from a file
	    while (input.hasNext()) {
	    	Nums[index] = input.nextDouble();
	    	index++;
	    }
	    // Close the file
	    input.close();	    
	    return Nums;
	}
	
	public static double[] readFile100000Num(String filename) throws Exception {
		// Create a File instance
	    java.io.File file = new java.io.File(filename);
	    // Create a Scanner for the file
	    Scanner input = new Scanner(file);
	    double[] Nums = new double[100000];
	    int index = 0;
	    // Read data from a file
	    while (input.hasNext()) {
	    	Nums[index] = input.nextDouble();
	    	index++;
	    }
	    // Close the file
	    input.close();	    
	    return Nums;
	}
	*/
}




