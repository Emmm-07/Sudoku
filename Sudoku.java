import java.util.Scanner;
public class Sudoku {						// 9x9 Sudoku Game
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
        printBoard();
       countBlanks();
		
          
         do {
 		System.out.print("\nInput a number [1-9]: ");inp = sc.next().charAt(0);
 		System.out.print("At Row [0-8]: ");r = sc.nextInt();
 		System.out.print("At Column [0-8]: ");c = sc.nextInt();
 		
 		if(goodNum(inp,r,c)) {
 			boardArr[r][c]=inp;
 			blanks--;
 			if(blanks==0) {
 				System.out.println("\nAll slots are filled: YOU WIN!!!");
 				break;
 			}
 		}else {
 			System.out.println("\n*****Error: Input already exists in the row/column/subgrid! Try another number*****");
 			wrong++;
 			System.out.println("Wrong inputs left: "+(3-wrong));
 			if(wrong==3) {
 				System.out.println("\nYou have reached the maximum numbers of wrong inputs: GAME OVER!!!");
 				break;
 			}
 			
 		}
 		printBoard();
         }while(true);
        System.out.println("\nThank you for playing!");
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
			

}

