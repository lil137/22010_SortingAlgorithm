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

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
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
    	long startTime = System.currentTimeMillis();
    	String fileName1 = "numbers10.txt";
    	String fileName2 = "numbers100.txt";
    	String fileName3 = "numbers1000.txt";
    	String fileName4 = "numbers1000Duplicates.txt";
    	String fileName5 = "numbersNearlyOrdered1000.txt";
    	String fileName6 = "numbersReverse1000.txt";
    	String fileName7 = "numbersSorted1000.txt";
    	double[] InsertionSort_test1 = SortComparison.insertionSort(ReadFile.readFile10Num(fileName1));
    	long endTime = System.currentTimeMillis(); 
    		System.out.println("Runtime for insertionSort numbers10 " + (endTime - startTime) + "ms");
    	/*for (int i =0 ; i < InsertionSorttest1.length; i++) {
    		System.out.println(test1[i]);
    	}*/
    	double[] SelectionSort_test1 = SortComparison.selectionSort(ReadFile.readFile10Num(fileName1));
    	/*for (int i =0 ; i < SelectionSort_test1.length; i++) {
    		System.out.println(SelectionSort_test1[i]);
		}*/
    	
    	//System.out.println("Random number:" + (int)(Math.random() * 100));
    	double[] QuickSort_test1 = SortComparison.quickSort(ReadFile.readFile100Num(fileName2));
    	/*for (int i =0 ; i < QuickSort_test1.length; i++) {
    		System.out.println(QuickSort_test1[i]);
		}*/
    	
    	double[] mergeSortRecursive_test1 = SortComparison.mergeSortRecursive(ReadFile.readFile10Num(fileName1));
    	for (int i =0 ; i < mergeSortRecursive_test1.length; i++) {
    		System.out.println(mergeSortRecursive_test1[i]);
		}
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

