
import java.io.*;
import java.util.*;

class GFG{

static int N = 9;


static boolean isinRange(int[][] board)
{
	
	
	for(int i = 0; i < N; i++)
	{
		for(int j = 0; j < N; j++)
		{
			
			
			if (board[i][j] <= 0 ||
				board[i][j] > 9)
			{
				return false;
			}
		}
	}
	return true;
}


static boolean isValidSudoku(int board[][])
{
	
	
	if (isinRange(board) == false)
	{
		return false;
	}

	
	boolean[] unique = new boolean[N + 1];

	
	for(int i = 0; i < N; i++)
	{
		
		
		Arrays.fill(unique, false);

		
		for(int j = 0; j < N; j++)
		{
			
			
			int Z = board[i][j];

			
			if (unique[Z])
			{
				return false;
			}
			unique[Z] = true;
		}
	}

	
	for(int i = 0; i < N; i++)
	{
		
		
		Arrays.fill(unique, false);

		
		for(int j = 0; j < N; j++)
		{
			
			
			int Z = board[j][i];

			
			if (unique[Z])
			{
				return false;
			}
			unique[Z] = true;
		}
	}

	
	for(int i = 0; i < N - 2; i += 3)
	{
		
		
		for(int j = 0; j < N - 2; j += 3)
		{
			
			
			Arrays.fill(unique, false);

			
			for(int k = 0; k < 3; k++)
			{
				for(int l = 0; l < 3; l++)
				{
					
					
					int X = i + k;

					
					int Y = j + l;

					
					int Z = board[X][Y];

					
					if (unique[Z])
					{
						return false;
					}
					unique[Z] = true;
				}
			}
		}
	}

	
	return true;
}


public static void main(String[] args)
{
	int[][] board = { { 9, 5, 7, 6, 1, 3, 2, 8, 4 },
					{ 4, 8, 3, 2, 5, 7, 1, 9, 6 },
					{ 6, 1, 2, 8, 4, 9, 5, 3, 7 },
					{ 1, 7, 8, 3, 6, 4, 9, 5, 2 },
					{ 5, 2, 4, 9, 7, 1, 3, 6, 8 },
					{ 3, 6, 9, 5, 2, 8, 7, 4, 1 },
					{ 8, 4, 5, 7, 9, 2, 6, 1, 3 },
					{ 2, 9, 1, 4, 3, 6, 8, 7, 5 },
					{ 7, 3, 6, 1, 8, 5, 4, 2, 9 } };

	if (isValidSudoku(board))
	{
		System.out.println("Valid");
	}
	else
	{
		System.out.println("Not Valid");
	}
}
}


