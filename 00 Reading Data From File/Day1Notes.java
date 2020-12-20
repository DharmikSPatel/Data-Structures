import java.io.*;
public class Day1Notes{
	/*using a text file, it adds up all the number
	SKIP LINE
	1, 1, 3
	1, 1
	3rtrgf
	2, 1
	tg
	reer
	1, 10

	*/
	public Day1Notes(){
		File fileName = new File("example.txt");
		try{
			BufferedReader input = new BufferedReader(new FileReader(fileName));
			String text;

			int sum = 0;
			input.readLine();
			while((text=input.readLine())!=null){
				String[] piecesPerLine = text.split(", ");  //need to put space after comma

				int num;
				try{
					for(int x = 0; x<piecesPerLine.length;x++){
						//System.out.println(piecesPerLine[x]);
						num = Integer.parseInt(piecesPerLine[x]);
						//System.out.println(num);

						sum+=num;
					}

				}catch(NumberFormatException nfe){
				}

			}
			System.out.println(sum);
		}catch(IOException ioe){ //put this exception when dealing with reading and writng file
			System.out.println("File not found.");
		}


	}


	public static void main(String[]args){
		Day1Notes app = new Day1Notes();
	}




}
