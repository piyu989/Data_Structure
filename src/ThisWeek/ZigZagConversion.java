package ThisWeek;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="PAYPALISHIRING";
		System.out.println(ans(s,3));
	}
	
	static String ans(String s,int row) {
		StringBuilder sb=new StringBuilder("");
		
		for(int i=0;i<row;i++) {
			int idx=i;
			int goingDown=2*(row-i-1);
			int goingUp=2*i;
			boolean goingsouth=true;
			
			while(idx<s.length()) {
				sb.append(s.charAt(idx));
				if(i==0) {
					idx+=goingDown;
				}else if(i==row-1){
					idx+=goingUp;
				}else {
					if(goingsouth) {
						idx+=goingDown;
					}else {
						idx+=goingUp;
					}
				}
				goingsouth=!goingsouth;
			}
		}
		return sb.toString();
	}

}
