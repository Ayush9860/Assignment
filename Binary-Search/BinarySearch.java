package com.ign_hub.binarysearch;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [] sortedArray = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };

		System.out.print("Enter the target element to search : ");
		int targetElement = sc.nextInt();

		int index = binarySearch(sortedArray, targetElement);

		if (index != -1) {
			System.out.println("Element " + targetElement + " is found at index " + index);
		} else {
			System.out.println("Element " + targetElement + " is not present in the array");
		}

		sc.close();
	}

	// Simple binary search algorithm
	private static int binarySearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] == target) {
				return mid; 
			} else if (array[mid] < target) {
				low = mid + 1; 
			} else {
				high = mid - 1; 
			}
		}

		return -1;
	}
}
