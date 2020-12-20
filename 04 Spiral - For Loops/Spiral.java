import java.io.*;
public class Spiral{
	int curRow = 0;
	int curCol = 0;
	int move = 0;
	char[][] pat;
	public static void main(String[]args){
		Spiral spiral = new Spiral();
	}
	public Spiral(){
		File file = new File("Spiraling.txt");
		String line = "";

		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine())!=null){
				makePattern(Integer.parseInt(line));
			}
		}catch(Exception e){
			System.out.println("error");
		}

	}
	public void makePattern(int num){
		System.out.println("Num"+ num);
		curRow = 0;
		curCol = 0;
		move = 0;
		pat = new char[num][num];
		for(int row = 0; row < num; row++){
			for(int col = 0; col < num; col++){
				pat[row][col] = '_';
			}
		}
		int temp = curCol + num;
		for(int col = curCol; col < temp; col++){
			pat[curRow][col] = '*';
			curCol = col;
		}
		move++;
		for(int x = num-1; x >= 1; x-=2){
			for(int i = 0; i < 2 && !(x==1 && i==1); i++){
				if(move == 0)
					moveRight(x);
				else if(move == 1)
					moveDown(x);
				else if(move == 2)
					moveLeft(x);
				else
					moveUp(x);
			}
		}
		printArray(pat);
	}


	public void moveRight(int n){
		int temp = curCol + n;
		for(int col = curCol; col <= temp; col++){
			pat[curRow][col] = '*';
			curCol = col;
		}
		move++;
	}
	public void moveDown(int n){
		int temp = curRow + n;
		for(int row = curRow; row <= temp; row++){
			pat[row][curCol] = '*';
			curRow = row;
		}
		move++;
	}
	public void moveLeft(int n){
		int temp = curCol - n;
		for(int col = curCol; col >= temp; col--){
			pat[curRow][col] = '*';
			curCol = col;
		}
		move++;
	}
	public void moveUp(int n){
		int temp = curRow - n;
		for(int row = curRow; row >= temp; row--){
			pat[row][curCol] = '*';
			curRow = row;
		}
		move = 0;
	}
	public void printArray(char[][] pat){
		for(int row = 0; row < pat.length; row++){
			for(int col = 0; col < pat[row].length; col++){
				System.out.print(pat[row][col]+" ");
			}
			System.out.println();
		}
	}
}
