package Leetcode;

//https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/?envType=daily-question&envId=2023-12-06

public class CalculateMoneyInLeetcodeBank {

	public int totalMoney(int n) {
        int arr[]={1,2,3,4,5,6,7};
        
        int ans=0;
        int temp=0;
        for(int i=0;i<n;i++){
            if(temp==7){
                temp=0;
            }
            ans+=arr[temp++]++;
        }
        return ans;

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
