package leetcode;

public class FloodFillAlgorithms {
	/*
	In flood fill algorithm we replace the old number along with all consecutive old numbers which are directly reachable 
	with the new number.
	for example in the following program we have taken a two dimensional array, 
	the intent here is to replace all consecutive/reachable number 5 with number 6
	the last array has 5 but its not directly reachable and not consecutive hence can not be replaced by 6.
	*/
	

	public static void main(String[] args) {
		
		int [][] darr = new int[][] {
			{0,2,3,4,7,8,4,3,2,1}, 
			{0,2,3,4,5,7,4,3,2,1},
			{0,2,3,5,5,5,4,3,2,1},
			{0,2,3,4,5,5,4,3,2,1},
			{0,2,3,4,5,5,4,3,2,1},
		    {0,2,3,5,5,5,4,3,2,1},
		    {0,2,3,4,5,5,5,3,2,1},
		    {0,2,3,4,5,5,4,3,2,1},
		    {0,2,3,4,5,3,4,3,2,1},
		    {0,2,3,4,3,7,4,3,5,1}};
		
		floodFillAlgo(darr, 3, 4, 6);
		
		for (int i = 0; i < darr.length; i++) {
			for (int j = 0; j < darr.length; j++) {
				System.out.print(darr[i][j]);
			}
			System.out.println("  ");
		}

	}
	
	private static void floodFillAlgo(int[][] darr, int x, int y, int newNum) {
		int oldNum = darr[x][y];
		System.out.println("-------------------oldNum--------------:"+oldNum);
		floodFillAlgo_fill(darr, x, y, newNum, oldNum);
		
	}

	private static void floodFillAlgo_fill(int[][] darr, int x, int y, int newNum, int oldNum) {
		if(x<0 || y<0 || x>=10 || y>=10) {
			return;
		}
		if(darr[x][y]!=oldNum) {
			return;
		}
		darr[x][y] = newNum;
		floodFillAlgo_fill(darr, x+1, y, newNum, oldNum);
		floodFillAlgo_fill(darr, x-1, y, newNum, oldNum);
		floodFillAlgo_fill(darr, x, y+1, newNum, oldNum);
		floodFillAlgo_fill(darr, x, y-1, newNum, oldNum);
		
	}

}
