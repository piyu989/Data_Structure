package ThisWeek;

//https://leetcode.com/problems/zigzag-conversion/description/

public class ZigZag {

	public static void main(String args[]){
		String s="PAYPALISHIRING";
		int row=3;
        
		String ans=optimize(s,row);
        
        System.out.println(ans);
        System.out.println(ans.length());
        
    }
	
	static String optimize(String s,int row) {
		if(row==1||s.length()==row)return s;
		
		StringBuilder sb=new StringBuilder("");
		
		for(int i=0;i<row;i++) {
			int idx=i;
			int goingDown=2*(row-i-1);
			int goingUp=2*i;
			boolean goingSouth=true;
			
			while(idx<s.length()) {
				sb.append(s.charAt(idx));
				if(i==0) {
					idx+=goingDown;
				}else if(i==row-1) {
					idx+=goingUp;
				}else {
					if(goingSouth) {
						idx+=goingDown;
					}else {
						idx+=goingUp;
					}
				}
				goingSouth=!goingSouth;
			}
		}
		return sb.toString();
	}

    public static String ans(String s,int row){
        String dp[][]=new String[row][s.length()];

        int col=0;
        for(int i=0;i<=row;i++){
            if(i==row){
                i=i-2;
                col++;
                while(i>0){
                    if(s.isEmpty()||s.isBlank())break;
                    dp[i--][col++]=s.charAt(0)+"";
                    s=s.substring(1);
                }
            }
            if(s.isEmpty()||s.isBlank())break;
            dp[i][col]=s.charAt(0)+"";
            s=s.substring(1);
        }

        String ans="";

        for(int i=0;i<row;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[i][j]!=null) ans+=dp[i][j];
            }
        }
        return ans;
    }

}
