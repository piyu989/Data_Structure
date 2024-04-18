// package ThisWeek;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String args[]){
        // int nums[]={1,2,3};
        // int nums[]={4,1,5,3,2};
        int nums[]={3,1,2};
        // for(int i:nums){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        ans(nums);
        System.out.println();
        for(int i:nums){
            System.out.print(i+" ");
        }
    }

    public static void ans(int nums[]){
        if(nums.length==1)return;
        int temp=-1;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                temp=i;
                break;
            }
        }

        if(temp==-1){
            Arrays.sort(nums);
            return;
        }

        int min=temp;

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[min]){
                min=i;
                break;
            }
        }

        int t=nums[min];
        nums[min]=nums[temp];
        nums[temp]=t;

        Arrays.sort(nums,temp+1,nums.length);

    }
}
