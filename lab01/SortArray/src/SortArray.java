import java.util.Scanner;

public class SortArray {
	
	void bubbleSort(int arr[]) {
		int n = arr.length;
		
		for(int i = 0 ; i < n - 1;i++) {
			for(int j = 0; j< n - i -1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	void printArr(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(" "+arr[i]);
		}
	}
	
	int sum(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
		}
		return sum;
	}
	
	double avg(int[] arr) {
		double result = ((double)(sum(arr))) / ((double)(arr.length));
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr=null;
		int size;
		
		Scanner sc =  new Scanner(System.in);
		
		SortArray sortArr = new SortArray();
		
		System.out.println("Enter size of array:");
		size = sc.nextInt();
		
		arr = new int[size];
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("Enter element a["+ i+"]");
			arr[i]=sc.nextInt();
		}
		
		sortArr.bubbleSort(arr);
		System.out.println("Sorted array:");
		sortArr.printArr(arr);
		
		System.out.println("Sum of array is:"+sortArr.sum(arr));
		System.out.println("Average of array is:"+ sortArr.avg(arr));
		
		
		
	}
}
