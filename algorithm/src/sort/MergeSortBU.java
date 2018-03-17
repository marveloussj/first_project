package sort;

public class MergeSortBU {

//自底向上的归并排序
	private static void mergeSortBU(int[] a, int n) {
		for(int sz=1;sz<=n;sz+=sz){
			for(int i=0;i+sz<=n;i+=sz+sz){
				merge(a,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
			}
		}
		
	}
	//重新写一遍
	private static void merge(int[] a, int l, int mid, int r) {
		int[] b=new int[r-l+1];
		for(int i=l;i<=r;i++){
			b[i-l]=a[i];
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
		mergeSortBU(a,n);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
