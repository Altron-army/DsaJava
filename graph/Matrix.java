//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] arr)
    {
        // Code here
        int m=arr.length,n=arr[0].length;
        int [] rowarr={-1,0,1,0};
        int [] colarr={0,1,0,-1};
        int [][] newarr=new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(newarr[i], Integer.MAX_VALUE); 
        }
        Queue<int []> q =new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1)
                {
                     q.add(new int []{i,j,0});
                     newarr[i][j]=0;
                }
            }
        }
        while (!q.isEmpty()) {
            int [] cur=q.remove();
            int row=cur[0];
            int col=cur[1];
            int dist=cur[2];
            for(int i=0;i<4;i++)
            {
                int newrow=row+rowarr[i];
                int newcol=col+colarr[i];
                if(newrow>=0 && newrow<m && newcol>=0 && newcol<n && arr[newrow][newcol]==0) {
                    if(newarr[newrow][newcol]>dist+1)
                    {
                        newarr[newrow][newcol]=dist+1;
                        q.add(new int[] {newrow,newcol,dist+1});
                    }
                }
            }
            
        }
        return newarr;
    }
}