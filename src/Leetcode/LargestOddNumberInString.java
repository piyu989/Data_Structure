package Leetcode;

public class LargestOddNumberInString {
	
	public static String ans(String num) {
		for(int i=num.length()-1;i>=0;i--) {
			if(num.charAt(i)-'0'%2!=0) {
				return num.substring(0,i+1);
			}
		}
		return "";
	}
	
	 public String largestOddNumber(String num) {
        int ans=-1;

        if(Integer.parseInt(num)%2!=0)return num;

        for(int i=num.length()-1;i>=0;i--){
            int temp=Integer.parseInt(num.substring(0,1));
            if(temp%2!=0){
                ans=Math.max(ans,temp);
            }
        }
    
        if(ans==-1){
            return "";
        }
        return ans+"";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ans("233223"));
	}

}
