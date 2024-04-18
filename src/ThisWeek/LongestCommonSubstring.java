package ThisWeek;

import java.util.HashSet;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s="pwwkew";
		System.out.println(ans(s));
	}
	
	static int ans(String s) {
		HashSet<Character>hs=new HashSet<>();

        int l=0,r=0,ans=0;

        while(l<s.length()){
            if(!hs.contains(s.charAt(l))){
                hs.add(s.charAt(l));
                ans=Math.max(hs.size(),ans);
                l++;
            }else{
                hs.remove(s.charAt(r));
                r++;
            }
        }
        return ans;
	}

}
