import java.io.*;
import java.util.*;

public class Task1{
	public static void main(String[] args){
		File file = new File("text.txt");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			Queue<Word> qw = new LinkedList<Word>();
			PriorityQueue<Word> pqw = new PriorityQueue<Word>();
			PriorityQueue<Word> pqw2 = new PriorityQueue<Word>();

			while((line = br.readLine())!=null){
				String[] words = line.split(" ");
				for(String w : words){
					qw.add(new Word(w, 0));
					pqw.add(new Word(w, -1));
					pqw2.add(new Word(w, 1));
				}
			}
			System.out.println(String.format("%-30s%-30s%-30s","Queue", "Priority Queue - Ascending", "Priority Queue - Descending"));
			while(!qw.isEmpty()){
			    System.out.println(String.format("%-30s%-30s%-30s",qw.poll(), pqw.poll(), pqw2.poll()));
			}

		}catch(Exception e){
			System.out.println(e.toString());
		}

	}
	public static class Word implements Comparable<Word>{
		private String word;
		private int type;
		public Word(String word2, int type){
			//type =  0 then this word is in regular queue
			//type = -1 then sort in alphabetical order in priority queue
			//type = +1 then sort in reverse alphabetical order in priority queue
			//65 - 90 Upper C
			//97 - 122 Lower C
			this.type = type;
			String clean = "";
			for(int i = 0; i < word2.length(); i++){
				char c = word2.charAt(i);
				if((c >= 65 && c <= 90)||(c >= 97 && c <= 122)){
					clean = clean+c;
				}
			}
			this.word = clean;
		}
		public String getWord(){
			return word;
		}
		public String toString(){
			return word;
		}
		public int compareTo(Word word){
			String word1 = this.getWord().toLowerCase();
			String word2 = word.getWord().toLowerCase();
			if(type == 1)
				return -(word1.compareTo(word2));
			else if(type == -1)
				return (word1.compareTo(word2));
			else
				return 0;
		}

	}
}
