 package ThisWeek;

// https://leetcode.com/problems/set-matrix-zeroes/
 
public class SetMatrixZero {
	public static void main(String args[]) {
		int arr[][]= {{0,0,5,8,3,8},
					 {9,4,1,9,9,5},
					 {0,4,3,0,2,7},
					{1,6,0,0,3,0},
					 {4,4,0,3,3,7},
					{0,3,7,5,1,0}};
		
		optimize(arr);
		// System.out.println(arr.length);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void optimize(int arr[][]){
		int r=arr.length;
		int c=arr[0].length;
		
		int[] row=new int[r];
		int col[]=new int[c];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==0) {
					row[i]=1;
					col[j]=1;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(row[i]==1||col[j]==1) {
					arr[i][j]=0;
				}
			}
		}
		
	}
	
	static void ans(int arr[][]) {
		int temp[]=new int[arr.length+arr[0].length+arr.length+100];
		
		int k=0;
		boolean f=false;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==0) {
					temp[k++]=i;
					temp[k++]=j;
					f=true;
				}
			}
		}

		if(arr.length==1&&f){
			for(int i=0;i<arr.length;i++) {
				arr[0][i]=0;
			}
		}
		
		
		for(int i=0;i<temp.length-1;i=i+2) {
			if(i>0&&temp[i]==0&&temp[i+1]==0){break;}
			// System.out.println(temp[i]+" "+temp[i+1]+"    "+arr[temp[i]][temp[i+1]]+"   "+i);
			if(arr[temp[i]][temp[i+1]]==0) {
				// System.out.println("popo");
			setZero(arr, temp[i],temp[i+1]);}	
			else break;
		}
	}
	
	static void setZero(int arr[][],int i,int j) {
		int temp=i;
		while(temp>=0) {
			arr[temp--][j]=0;
		}
		temp=i;
		while(temp<arr.length) {
			arr[temp++][j]=0;
		}
		temp=j;
		while(temp>=0) {
			arr[i][temp--]=0;
		}
		temp=j;
		while(temp<arr[0].length) {
			arr[i][temp++]=0;
		}
	}
}
