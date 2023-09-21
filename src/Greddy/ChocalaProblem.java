package Greddy;

import java.util.Arrays;
import java.util.Collections;

public class ChocalaProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Integer costver[]= {2,1,3,4,1};
		Integer costhor[]= {4,1,2};
		
		Arrays.sort(costhor,Collections.reverseOrder());
		Arrays.sort(costver,Collections.reverseOrder());
		
		int h=0,v=0,hp=1,vp=1,cost=0;
		
		while(h<costhor.length &&v<costver.length) {
			if(costhor[h]>=costver[v]) {

				cost+=(costhor[h]*vp);
				hp++;
				h++;
			}else {

				cost+=(costver[v]*hp);
				vp++;
				v++;
			
			}
		}
		while(h<costhor.length) {
			cost+=(costhor[h]*vp);
			hp++;
			h++;
		}
		while(v<costver.length) {
			cost+=(costver[v]*hp);
			vp++;
			v++;
		}
		System.out.println(cost);

	}

}
