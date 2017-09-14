package sort;

/**
 * ��������
 * �ص㣺ԭ�����򣬽���Ҫһ����С�ĸ���ջ
 * 			��ʱ���ȶ�ΪNlogN
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
	 * ����������з�
	 * �������з�Ϊ[lo,i-1] [i] [i+1,hi]������
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(Comparable[] a,int lo,int hi){
		int i=lo,j=hi+1;
		//��a[lo]��ֵ��Ϊ�ο��������з�
		Comparable v = a[lo];
		
		//��������ָ��i��j
		//i��ǰ���ɨ��ͣ����a[i]>v��λ�ã���֤iǰ��Ķ�������v��
		//j�Ӻ���ǰɨ��ͣ����a[j]<v��λ�ã���֤j����Ķ���С��v��
		//Ȼ�󽻻�i��j��ֵ�����һ��ѭ����
		//��i��j����ʱ��ѭ������
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
		
		//���ս���v��a[j]�������ο�ֵ������j��λ�á�
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
