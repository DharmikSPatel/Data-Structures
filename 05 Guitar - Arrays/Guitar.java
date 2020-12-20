import java.io.*;

public class Guitar{
	int[][] ref = {
		{29, 24, 19, 14, 10, 5},
		{28, 23, 18, 13, 9 , 4},
		{27, 22, 17, 12, 8 , 3},
		{26, 21, 16, 11, 7 , 2},
		{25, 20, 15, 10, 6 , 1}
	};
	String[][] refNote = {
		{"E", "A", "D", "G", "B", "E"},
		{"F", "A#", "D#", "G#", "C", "F"},
		{"F#", "B", "E", "A", "C#", "F#"},
		{"G", "C", "F", "A#", "D", "G"},
		{"G#", "C#", "F#", "B", "D#", "G#"}
	};

	String[][] print;

	public Guitar(){
		File file  = new File("GuitarTabFile.txt");
		String[][] text = new String[5][];
		try{
			BufferedReader input = new BufferedReader(new FileReader(file));
			String line = "";
			int lineNum = 0;
			while((line = input.readLine())!=null){
				String[] parts = line.split(",");
				text[lineNum] = parts;
				lineNum++;
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
		print = new String[30][text[0].length+1];
		setUp();
		//printArray2(text,",");
		for(int mes = 0; mes < text[0].length; mes++){
			for(int row = 0; row < text.length; row++){
				char[] curr = (text[row][mes]).toCharArray();
				for(int x = 0; x < curr.length; x++){
					if(curr[x] == 'o' || curr[x] == '*'){
						print[ref[row][x]][mes+1] = "O\t";
					}
				}
			}
		}
		System.out.println();
		printArray2(print,"");
	}
	public static void main(String[]args){
		Guitar g = new Guitar();
	}
	public void printArray2(String[][] text, String space){
		for(int x = 0; x < text.length; x++){
			for(int y = 0; y < text[x].length; y++){
				System.out.print(text[x][y]+""+space);
			}
			System.out.println();
		}
	}

	public void setUp(){
		for(int x = 0; x < print.length; x++){
			for(int y = 0; y < print[x].length; y++){
				print[x][y] = "\t";
			}
		}
		print[0][0] = "Measure\t\t";
		for(int col = 1; col < print[0].length; col++){
			print[0][col] = col+"\t";
		}
		int temp = 1;
		for(int c = refNote[0].length-1; c >= 0; c--){
			for(int r = refNote.length-1; r >= 0; r--){
				if(c != 4 || r != 0){
					print[temp][0] = refNote[r][c]+"\t\t";
					temp++;
				}

			}
		}
	}
}