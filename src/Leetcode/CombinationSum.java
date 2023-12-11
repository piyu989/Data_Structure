package Leetcode;

//https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> ans(int candidates[],int target){
		List<List<Integer>>ans=new ArrayList<>();
		dfs(candidates,0,new ArrayList<Integer>(),target, ans);
		return ans;
	}
	static void dfs(int arr[],int i,List<Integer>li,int target,List<List<Integer>>ans) {
		if(target==0) {
			ans.add(new ArrayList<>(li));
			return;
		}
		if(i==arr.length) {
			return;
		}
		dfs(arr, i+1,li, target, ans);
		if(target>=0) {
			li.add(arr[i]);
			dfs(arr, i, li, target-arr[i], ans);
			li.remove(li.size()-1);
		}
	}
	
	 static List<List<Integer>> ans=new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer>li=new ArrayList<>();
        help(candidates,target,0,0,li);       
        return ans; 
    }

    static void help(int[]arr,int target,int i,int cursum,ArrayList<Integer>li){
        if(cursum>target){
            return;
        }
        if(i==arr.length){
            if(cursum==target){
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        cursum+=arr[i];
        li.add(arr[i]);
        help(arr,target,i,cursum,li);
        cursum-=arr[i];
        li.remove(li.size()-1);

        help(arr,target,i+1,cursum,li);


    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
