import java.io.*;
import java.util.*;
public class HashMapsandTreeMaps{
	public HashMapsandTreeMaps(){
		File file = new File("BowlingData.txt");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			TreeMap<Integer, PriorityQueue<Bowler>> map = new TreeMap<Integer, PriorityQueue<Bowler>>();
			while((line = br.readLine())!=null){
				String[] words = line.split(" ");
				Bowler b = new Bowler(words[0], words[1], Integer.parseInt(words[2]));
				//System.out.println(b);
				if(!map.containsKey(b.sc)){
					PriorityQueue<Bowler> pq = new PriorityQueue<Bowler>();
					pq.add(b);
					map.put(b.sc, pq);
				}
				else{
					PriorityQueue<Bowler> pq = map.get(b.sc);
					pq.add(b);
					map.put(b.sc, pq);
				}
			}
			System.out.println(map);
			System.out.println("+++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++KEYS++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++++");

			Iterator keys = map.keySet().iterator();
			while(keys.hasNext()){
				System.out.println(keys.next());
			}
			System.out.println("+++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++ENTRY SET+++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++++");

			Iterator entry = map.entrySet().iterator();
			while(entry.hasNext()){
				System.out.println(entry.next());
			}
			System.out.println("+++++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++++++VALUES+++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++++");

			for(PriorityQueue<Bowler> pq : map.values()){
				System.out.print("[");
				while(!pq.isEmpty()){
					System.out.print(pq.poll());
					if(pq.peek()!=null)
						System.out.print(", ");
				}
				System.out.println("]");
			}

		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	public class Bowler implements Comparable<Bowler>{
		String fn, ln;
		int sc;
		public Bowler(String fn, String ln, int score){
			this.fn = fn;
			this.ln = ln;
			this.sc = score;

		}
		public String toString(){
			return String.format("%s %s", fn, ln);
		}
		public int compareTo(Bowler b){
			if(ln.compareTo(b.ln) != 0)
				return ln.compareTo(b.ln);
			else
				return fn.compareTo(b.fn);
		}


	}
	public static void main(String[]args){
		HashMapsandTreeMaps app = new HashMapsandTreeMaps();
	}
}