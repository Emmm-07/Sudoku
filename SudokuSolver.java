import java.util.Scanner;
public class SudokuSolver {						//9x9 Sudoku Game
	static char[][] boardArr;
	static int blanks=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char inp;	
		int r,c;
		int wrong =0;
		boardArr = new char[][]{ 
			{ '3', ' ', '6', '5', ' ', '8', '4', ' ', ' ' },
            { '5', '2', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', '8', '7', ' ', ' ', ' ', ' ', '3', '1' },
            { ' ', ' ', '3', ' ', '1', ' ', ' ', '8', ' ' },
            { '9', ' ', ' ', '8', '6', '3', ' ', ' ', '5' },
            { ' ', '5', ' ', ' ', '9', ' ', '6', ' ', ' ' },
            { '1', '3', ' ', ' ', ' ', ' ', '2', '5', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', '7', '4' },
            { ' ', ' ', '5', '2', ' ', '6', '3', ' ', ' ' } };
        System.out.println("\n\n\t==========SAMPLE SUDOKU BOARD=========\n");
        printBoard();
 
        
        sudokuSolved();
        System.out.println("\n\n\t============SUDOKU SOLVED===========\n");
        printBoard();
       
	}
	
	
	
	
	//METHODS
	
	private static void printBoard() {
		System.out.println("\t     0 1 2     3 4 5     6 7 8 ");
		for(int i=0;i<9;i++) {
			
			if(i%3==0&&i!=0) {
				System.out.print("\n\t    ---------------------------\n\t");
			}else {
				System.out.print("\t \n\t");
			}
			System.out.print(i+"   ");
			for(int j=0;j<9;j++) {
				if(j%3==0&&j!=0) {
					System.out.print("|   |"+boardArr[i][j]);
				}else {
					System.out.print("|"+boardArr[i][j]);
				}
				
			}
			System.out.print("|");
		}
	}
	
	
	private static void countBlanks() { 				//Counts how many blanks should be filled
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(boardArr[i][j]==' ')blanks++;
			}
		}
		
	}
	//Checker
	static boolean goodNum(char input,int row,int col) {
		//Checker if input is in Row
		for(int i=0;i<9;i++) {									
			if(boardArr[row][i]==input) {
			
				return false;
			}
		}
		
		//Checker if input is in Column
		for(int i=0;i<9;i++) {												
			if(boardArr[i][col]==input) {
				
				return false;
			}
		}
		
		//Checker if input is in Box/Subgrid (3x3)
		int boxRow = row-row%3;
		int boxCol = col-col%3;
	
		for(int i=boxRow;i<boxRow+3;i++) {
			for(int j=boxCol;j<boxCol+3;j++) {
				if(boardArr[i][j]==input) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	static boolean sudokuSolved() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(boardArr[i][j]==' ') {
					for(char c='1';c<='9';c++) {
						if(goodNum(c,i,j)) {
							boardArr[i][j]=c;
							if(sudokuSolved()) {			//Backtrack
								return true;
							}else {
								boardArr[i][j]=' ';
							}
					  }
					}
					return false;
				}
			}
		}
		return true;
	}
		

}


