package sort;

public class MergeSort {
	
	public static void mergeSort(int[] a,int n){
		mergesort(a,0,n-1);	
	}
	
	private static  void mergesort(int[] a, int l, int r) {
		if(l>=r)
			return;
		int mid=(l+r)/2;
		mergesort(a, l, mid);
		mergesort(a, mid+1, r);
		merge(a,l,mid,r);
	}
//将数组的[l,mid]和[mid+1,r]进行归并
	private static void merge(int[] a, int l, int mid, int r) {
		int[] b=new int[r-l+1];
		for(int i=l;i<=r;i++){
			b[i-l]= a[i];
		}
		int x=l,y=mid+1;
		for(int k=l;k<=r;k++){
			if(x>mid){
				a[k]=b[y-l];
				y++; 
			}else if(y>r){
				a[k]=b[x-l];
				x++;
			}else if(b[x-l]<b[y-l]){
				a[k]=b[x-l];
				x++;
			}else{
				a[k]=b[y-l];
				y++;
			}
			
		}
	}

	public static void main(String[] args) {
		int[] a = {8,6,7,54,1,4,4,7,41,3}; 
		int n = 10;
		mergeSort(a,n);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
		
}
