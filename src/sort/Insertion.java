package sort;

/**
 * 插入排序
 * 时间视数组的有序程度而定
 * 特别适用于小数组 (5-15)
 * @author XRR
 *
 */
public class Insertion {
	
	public static void sort(Comparable[] a){
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0 && less(a[j], a[j-1]);j--){
				exch(a, j, j-1);
			}
		}
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
