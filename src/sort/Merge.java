package sort;

/**
 * �鲢����
 * ����˼�룺 �ݹ�ذ�����ֳ�����ֱ������ٺϲ�
 * �ص㣺��֤�����ⳤ�����飬ʱ�临�Ӷ�ΪNlogN
 * 			����Ҫ����Ĵ洢�ռ�N
 * @author XRR
 *
 */
public class Merge {
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length]; 
		sort(a,0,a.length-1);
	}
	
	//��[lo,hi]��������
	private static void sort(Comparable[] a,int lo,int hi){
		if(lo>=hi)return;
		
		int mid = lo+(hi-lo)/2;
		
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	//��[lo,mid]��[mid+1,hi]�ϲ�
	private static void merge(Comparable[] a,int lo,int mid,int hi){
		int i = lo,j=mid+1;
		
		for(int k=lo;k<=hi;k++){
			aux[k] = a[k];
		}
		
		for(int k=lo;k<=hi;k++){
			if(i>mid){
				a[k] = aux[j++];
			}else if(j>hi){
				a[k] = aux[i++];
			}else if(less(aux[j], aux[i])){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];
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
