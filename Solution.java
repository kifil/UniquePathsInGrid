public class Solution {
    Integer[][] memo;
    Integer totalRows;
    Integer totalCols;
    
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
	    totalRows = a.size();
	    totalCols = a.get(0).size();
	    
	    memo = new Integer[totalRows][totalCols];
	    
	    //if at row,col == end return 1
	    //if out of bounds or blocked return 0
	    //return memo if it is filled
	    //else return recursive solution

	    return getPaths(0, 0, a);
	}
	
	int getPaths(int row, int col, ArrayList<ArrayList<Integer>> grid){
	    if(isOutOfBounds(row,col) || grid.get(row).get(col) == 1){
	        return 0;
	    }
	    else if(isDestination(row,col)){
	        //dont need to bother setting memo for just this one
	        return 1;
	    }
	    else if(memo[row][col] == null){
	        memo[row][col] = getPaths(row, col +1, grid) + getPaths(row + 1, col, grid);
	    }
	    
	    return memo[row][col];
	}
	
	Boolean isOutOfBounds(int row, int col){
	    if(row >= totalRows 
    	    || row < 0
    	    || col >= totalCols
    	    || col < 0
	    ){
	        return true;
	    }
	    
	    return false;
	}
	
	Boolean isDestination(int row, int col){
	    if(row == totalRows -1 && col == totalCols -1){
	        return true;
	    }
	    
	    return false;
	}
}
