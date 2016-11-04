/*
 * Jamal Scott
 * Cs 221
 * Wittman B
 * Assignment 7
 */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Sorting 
{
	public static void main(String[] args) 
	{	
		int number1 = 10000, number2 = 100000, number3 = 1000000;

		//Create our arrays of specific sizes.
		int[] array10k = new int[number1];
		int[] array100k = new int[number2];
		int[] array1m = new int[number3];

		double start, end, runTime;

		//Populate our arrays.
		for(int i = 0; i < array10k.length; i++)
		{
			array10k[i] = (int) (Math.random()*1000000);
		}
		for(int i = 0; i < array100k.length; i++)
		{
			array100k[i] = (int) (Math.random()*1000000);
		}
		for(int i = 0; i < array1m.length; i++)
		{
			array1m[i] = (int) (Math.random()*1000000);
		}

		//Make copies of the original arrays to be sorted for each test case.
		int[] array10k_A = Arrays.copyOf(array10k, number1);
		int[] array10k_B = Arrays.copyOf(array10k, number1);
		int[] array10k_C =Arrays.copyOf(array10k, number1);
		int[] array10k_D = Arrays.copyOf(array10k, number1);


		int[] array100k_A = Arrays.copyOf(array100k, number2);
		int[] array100k_B = Arrays.copyOf(array100k, number2);
		int[] array100k_C = Arrays.copyOf(array100k, number2);
		int[] array100k_D = Arrays.copyOf(array100k, number2);


		int[] array1m_A = Arrays.copyOf(array1m, number3);
		int[] array1m_B = Arrays.copyOf(array1m, number3);
		int[] array1m_C = Arrays.copyOf(array1m, number3);
		int[] array1m_D = Arrays.copyOf(array1m, number3);

		//==============================================================================================================
		//Test Case 10,000 Elements
		//==============================================================================================================
		start = System.nanoTime();
		quickSort( array10k_A, 0,array10k_A.length );
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.println("Array length:     10,000");
		System.out.format("Quick Sort:       %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		mergeSort(array10k_B);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Merge Sort:       %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		heapSort(array10k_C);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Heap Sort:        %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		radixSort(array10k_D);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Radix Sort:       %.4f seconds. \n",runTime);
		System.out.print("\n");
		start = 0;
		end = 0;
		runTime = 0;

		//==============================================================================================================
		//Test Case 100,000 Elements
		//==============================================================================================================
		start = System.nanoTime();
		quickSort( array100k_A, 0,array100k_A.length );
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.println("Array length:     100,000");
		System.out.format("Quick Sort:       %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		mergeSort(array100k_B);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Merge Sort:       %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		heapSort(array100k_C);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Heap Sort:        %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		radixSort(array100k_D);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Radix Sort:       %.4f seconds. \n",runTime);
		System.out.print("\n");
		start = 0;
		end = 0;
		runTime = 0;

		//==============================================================================================================
		//Test Case 1,000,000 Elements
		//==============================================================================================================
		start = System.nanoTime();
		quickSort( array1m_A, 0,array1m_A.length );
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.println("Array length:     1,000,000");
		System.out.format("Quick Sort:       %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		mergeSort(array1m_B);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Merge Sort:       %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		heapSort(array1m_C);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Heap Sort:        %.4f seconds. \n",runTime);
		start = 0;
		end = 0;
		runTime = 0;

		start = System.nanoTime();
		radixSort(array1m_D);
		end = System.nanoTime();
		runTime = (end - start) /1000000000.0;
		System.out.format("Radix Sort:       %.4f seconds. \n",runTime);
		System.out.print("\n");
		start = 0;
		end = 0;
		runTime = 0;

	}


	public static void mergeSort(int[] array) 
	{
		if(array.length > 1) 
		{
			//Assign array 'a' half the elements in the original array.
			int[] a = new int[array.length/2];

			//Put what's left in the original array into array 'b.'
			int[] b = new int[array.length - a.length];

			//Populate our arrays.
			for( int i = 0; i < a.length; ++i )
			{
				a[i] = array[i];
			}

			for( int i = 0; i < b.length; ++i )
			{
				b[i] = array[i + a.length];
			}

			//Recursively break the arrays down into one element then calls the merge
			//method to merge the arrays.
			mergeSort(a);
			mergeSort(b);
			merge(array, a, b);
		}	
	}

	//Method for merging the elements from mergeSort.
	public static void merge(int[] array, int[] a, int[] b) 
	{
		//indexers to move through the arrays.
		int indexA = 0;
		int indexB = 0;

		//Here we compare the values of the elements and then merge them.
		for( int i = 0; i < array.length; ++i ) 
		{
			if( indexA >= a.length )
			{
				array[i] = b[indexB++];
			}
			else if( indexB >= b.length )
			{
				array[i] = a[indexA++];
			}
			else if( a[indexA] <= b[indexB] )
			{
				array[i] = a[indexA++];
			}
			else
			{
				array[i] = b[indexB++];
			}
		}		
	}

	public static void quickSort(int[] array, int start, int end)
	{
		int pivotingPoint = 0;

		if(start < end - 1)
		{
			//Here we partition the array and go into the recursive calls to sort the array.
			pivotingPoint = partition(array, start ,start , end -1);
			quickSort(array, start , pivotingPoint);
			quickSort(array, pivotingPoint + 1, end);
		}
	}

	private static int partition(int[] array, int index, int left, int right) 
	{
		//Assign the pivoting value as the first element in the array.
		int pivotingPoint = array[index];

		int temp = array[index];
		array[index] = array[right];
		array[right] = temp;

		index = left; 

		for(int i = left; i <right; i++)
		{
			//If we find a value less than the pivoting point, rotate it.
			if(array[i] <= pivotingPoint)
			{
				temp = array[i];
				array[i] = array[index];
				array[index] = temp;
				index++;
			}
		}

		temp = array[index];
		array[index] = array[right];
		array[right] = temp;

		return index;
	}


	public static void heapSort(int[] array)
	{
		int count = array.length;

		//Here we have to "heapify" the array. Placing it in a max-order heap.
		heapify(array, count);

		//gets the size of the heap/the last element.
		int size = count - 1;

		while(size > 0)
		{
			//Switches the root with the last element using a 3 line swap.
			int temp = array[size];
			array[size] = array[0];
			array[0] = temp;

			//put the heap back in max-heap order
			bubbleDown(array, 0, size - 1);

			//Decrement the size so that we may break out of the while loop when the swapping is done.
			size--;
		}
	}

	public static void heapify(int[] array, int count)
	{
		//start is assigned the index in a of the last parent node
		int start = (count - 2) / 2; 

		while(start >= 0)
		{
			bubbleDown(array, start, count - 1);
			start--;
		}
	}

	//Method for bubbling down elements in the heap. 
	public static void bubbleDown(int[] array, int start, int size)
	{
		int maxValue = start;

		while((maxValue * 2 + 1) <= size)
		{    
			//Method for finding the left child.
			int child = maxValue * 2 + 1;    

			//Compares the children and redirects the pointers.
			if(child + 1 <= size && array[child] < array[child + 1])
			{
				child = child + 1;
			}

			//Rearranges the heap back in to a max-heap.
			if(array[maxValue] < array[child])
			{     
				int tmp = array[maxValue];
				array[maxValue] = array[child];
				array[child] = tmp;
				maxValue = child;          
			}

			else
				return;
		}
	}

	public static void radixSort(int[] array)
	{
		//We will loop up to the size of the value's we're sorting, integer.size would be the # of digits
		for (int movePosition = Integer.SIZE - 1; movePosition > -1; movePosition--) 
		{
			//Create a temp array to hold values.
			int[] temp = new int[array.length];

			//Use this to move through the digits
			int j = 0;

			for (int i = 0; i < array.length; i++) 
			{
				boolean change = array[i] << movePosition >= 0;

				if (movePosition == 0 ? !change : change)
				{
					temp[j] = array[i];
					j++;
				} 
				else 
				{
					array[i - j] = array[i];
				}
			}

			//places elements into the temp array.
			for (int i = j; i < temp.length; i++) 
			{
				temp[i] = array[i - j];
			}

			//dumps the values from temp (sorted) back into the original array.
			array = temp;
		}
	}
}