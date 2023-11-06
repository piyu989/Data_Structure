package Graph;

public class FloodFill {
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if(image[sr][sc]==color)return image;
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    static void fill(int image[][],int sr,int sc,int color,int orgCol){
    	if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=orgCol){
            return;
        }
        image[sr][sc]=color;
        fill(image, sr-1, sc, color, orgCol);
        fill(image, sr+1, sc, color, orgCol);
        fill(image, sr, sc-1, color, orgCol);
        fill(image, sr, sc+1, color, orgCol);
    }
    
    public static void main(String args[]){
        int arr[][]={{0,0,0},{0,0,0},{0,0,0}};
        arr=floodFill(arr,2,2,2);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
    }
}
