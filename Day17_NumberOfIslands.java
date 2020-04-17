/* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

package LeetCode;

public class Day17_NumberOfIslands {
	
	public static void merge(char[][] grid, int i, int j) {
		
	    int m=grid.length;
	    int n=grid[0].length;
	 
	    if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1')
	        return;
	 
	    grid[i][j]='X';
	 
	    merge(grid, i-1, j);
	    merge(grid, i+1, j);
	    merge(grid, i, j-1);
	    merge(grid, i, j+1);
	}
	
	public static int numIslands(char[][] grid) {
		
		if(grid==null || grid.length==0 || grid[0].length==0)
	        return 0;
	 
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    int count=0;
	    for(int i=0; i<m; i++) {
	        for(int j=0; j<n; j++) {
	            if(grid[i][j]=='1') {
	                count++;
	                merge(grid, i, j);
	            }
	        }
	    }
	 
	    return count;
		
	}

	public static void main(String[] args) {
		
		char[][] islands = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		
		System.out.println(numIslands(islands));

	}

}
