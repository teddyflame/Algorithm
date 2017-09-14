package sort;


/**
 * 选择排序
 * 最简单的排序
 * 特点：时间固定，数据移动最少
 * @author XRR
 *
 */
public class Selection {

	//升序排列
	public static void sort(Comparable[] a){
		int N = a.length;
		for(int i=0;i<N;i++){

			for(int j=i+1;j<N;j++){
				if(less(a[j],a[i])){

					exch(a,i,j);
				}

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
