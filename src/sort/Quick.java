package sort;

/**
 * 快速排序
 * 特点：原地排序，仅需要一个很小的辅助栈
 * 			且时间稳定为NlogN
 * @author XRR
 *
 */
public class Quick {
	
	public static void sort(Comparable[] a){
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi){
		if(hi<lo)return;
		
		int j = partition(a,lo,hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	/**
	 * 快速排序的切分
	 * 将数组切分为[lo,i-1] [i] [i+1,hi]三部分
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(Comparable[] a,int lo,int hi){
		int i=lo,j=hi+1;
		//以a[lo]的值作为参考，进行切分
		Comparable v = a[lo];
		
		//设置两个指针i，j
		//i从前向后扫，停留在a[i]>v的位置（保证i前面的都不大于v）
		//j从后向前扫，停留在a[j]<v的位置（保证j后面的都不小于v）
		//然后交换i和j的值，完成一次循环；
		//当i和j相遇时，循环结束
		while(true){
			while(less(a[++i], v)){
				if(i==hi)break;
			}
			
			while(less(v, a[--j])){
				if(j==lo)break;
			}
			
			if(i>=j)break;
			exch(a, i, j);
		}
		
		//最终交换v和a[j]，这样参考值就留在j的位置。
		exch(a, lo, j);
		return j;
	}
	private static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable[] a,int i,int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
