package sort;

/**
 * ϣ������
 * ����˼�룺 ������������Ϊh��Ԫ�ض��������
 * Ȼ������Сh��ֵ��1
 * @author XRR
 *
 */
public class Shell {
	
	public static void sort(Comparable[] a){
		int h=1;
		while(h<a.length/3){
			h = h*3+1;
		}
		
		while(h>=1){
			for(int i=h;i<a.length;i++){
				for(int j=i;j>=h && less(a[j], a[j-h]);j-=h){
					exch(a, j-h, j);
				}
			}
			h=h/3;
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
