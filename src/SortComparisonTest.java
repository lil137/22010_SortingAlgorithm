import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Yuxiao Hu (19321099)
 *  @version HT 2020
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

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws Exception 
     *
     */
    public static void main(String[] args) throws Exception
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
    	
    	double[] temp10 = new double[10];
    	double[] temp100 = new double[100];
    	double[] temp1000 = new double[1000];
    	
    	temp10 = ReadFile.readFile10Num(fileName1);
    	long startTime = System.currentTimeMillis();
    	SortComparison.insertionSort(temp10);
    	long endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for insertionSort numbers10 " + (endTime - startTime) + "ms");
    	
    	temp100 = ReadFile.readFile100Num(fileName2);
    	startTime = System.currentTimeMillis();
    	SortComparison.insertionSort(temp100);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for insertionSort numbers100 " + (endTime - startTime) + "ms");
    	
    	
    	temp1000 = ReadFile.readFile1000Num(fileName3);
    	startTime = System.currentTimeMillis();
    	SortComparison.insertionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for insertionSort numbers1000 " + (endTime - startTime) + "ms");
    	
    	
    	temp1000 = ReadFile.readFile1000Num(fileName4);
    	startTime = System.currentTimeMillis();
    	SortComparison.insertionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for insertionSort numbers1000Duplicates " + (endTime - startTime) + "ms");
    	
    	temp1000 = ReadFile.readFile1000Num(fileName5);
    	startTime = System.currentTimeMillis();
    	SortComparison.insertionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for insertionSort numbersNearlyOrdered1000 " + (endTime - startTime) + "ms");
    	
    	temp1000 = ReadFile.readFile1000Num(fileName6);
    	startTime = System.currentTimeMillis();
    	SortComparison.insertionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for insertionSort numbersReverse1000 " + (endTime - startTime) + "ms");
    	
    	temp1000 = ReadFile.readFile1000Num(fileName7);
    	startTime = System.currentTimeMillis();
    	SortComparison.insertionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for insertionSort numbersSorted1000 " + (endTime - startTime) + "ms");
    	
    	System.out.println("");
    	//double[] SelectionSort_test1 = SortComparison.selectionSort(ReadFile.readFile10Num(fileName1));
    	/*for (int i =0 ; i < SelectionSort_test1.length; i++) {
    		System.out.println(SelectionSort_test1[i]);
		}*/
    	
    	temp10 = ReadFile.readFile10Num(fileName1); 
    	startTime = System.currentTimeMillis();
    	SortComparison.selectionSort(temp10);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for selectionSort numbers10 " + (endTime - startTime) + "ms");
    	
    	
    	temp100 = ReadFile.readFile100Num(fileName2);
    	startTime = System.currentTimeMillis();
    	SortComparison.selectionSort(temp100);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for selectionSort numbers100 " + (endTime - startTime) + "ms");
    	
    	temp1000 = ReadFile.readFile1000Num(fileName3);
    	startTime = System.currentTimeMillis();
    	SortComparison.selectionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for selectionSort numbers1000 " + (endTime - startTime) + "ms");
    	
    	temp1000 = ReadFile.readFile1000Num(fileName4);
    	startTime = System.currentTimeMillis();
    	SortComparison.selectionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for selectionSort numbers1000Duplicates " + (endTime - startTime) + "ms");
    	
    	temp1000 = ReadFile.readFile1000Num(fileName5);
    	startTime = System.currentTimeMillis();
    	SortComparison.selectionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for selectionSort numbersNearlyOrdered1000 " + (endTime - startTime) + "ms");
    	
    	temp1000 = ReadFile.readFile1000Num(fileName6);
    	startTime = System.currentTimeMillis();
    	SortComparison.selectionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for selectionSort numbersReverse1000 " + (endTime - startTime) + "ms");
    	
    	temp1000 = ReadFile.readFile1000Num(fileName7);
    	startTime = System.currentTimeMillis();
    	SortComparison.selectionSort(temp1000);
    	endTime = System.currentTimeMillis(); 
    	System.out.println("Runtime for selectionSort numbersSorted1000 " + (endTime - startTime) + "ms");
    	
        System.out.println("");
    	//System.out.println("Random number:" + (int)(Math.random() * 100));
    	double[] QuickSort_test1 = SortComparison.quickSort(ReadFile.readFile100Num(fileName2));
    	/*for (int i =0 ; i < QuickSort_test1.length; i++) {
    		System.out.println(QuickSort_test1[i]);
		}*/
    	
    	double[] mergeSortRecursive_test1 = SortComparison.mergeSortRecursive(ReadFile.readFile10Num(fileName1));
    	/*for (int i =0 ; i < mergeSortRecursive_test1.length; i++) {
    		System.out.println(mergeSortRecursive_test1[i]);
		}*/
    	
    	double[] mergeSortIterative_test1 = SortComparison.mergeSortIterative(ReadFile.readFile1000Num(fileName3));
    	/*for (int i =0 ; i < mergeSortIterative_test1.length; i++) {
    		System.out.println(mergeSortIterative_test1[i]);
		}*/
    }

}

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
}

