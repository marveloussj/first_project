package interview.binarysearch;

public class BinarySearch {
	public int binarySearch(int[] arr,int num){
		int a=0;
		int b=arr.length-1;//[a,b)
		while(a<=b){
			int mid=a+(b-a)/2;
			if(arr[mid]<num){
				a=mid+1;
			}else if(arr[mid]>num){
				b=mid-1;
			}else{
				return mid;
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		BinarySearch bs=new BinarySearch();
		int a[]={1,2,4,5,9,12};
		System.out.println(bs.binarySearch(a, 9));	
		}

}
