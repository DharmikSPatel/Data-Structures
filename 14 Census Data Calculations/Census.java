import java.io.*;
import java.util.*;
public class Census{
	ArrayList<Citizen> ppl = new ArrayList<Citizen>();
	public Census(){
		File file = new File("FedCensus1930_CambriaCountyPA.txt");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = br.readLine()) != null){
				if(line.length() >= 1 && line.charAt(0) == '1'){
					String first = line.substring(71,88).trim();
					String last = line.substring(55,71).trim();
					String streetName = line.substring(20,36).trim();
					String streetNum = line.substring(36,45).trim();
					String relation = line.substring(88,108).trim();
					String rentOwn = line.substring(108,113).trim();
					String propValue = line.substring(113,121).trim();
					String gender = line.substring(133,134).trim();
					String age = line.substring(143,151).trim();
					String marrStat = line.substring(151,156).trim();
					String fstMarrAge = line.substring(156,162).trim();
					String attendSchool = line.substring(162,167).trim();
					String canRead = line.substring(167,173).trim();
					String bp = line.substring(173,190).trim();
					String fbp = line.substring(190,207).trim();
					String mbp = line.substring(207,224).trim();
					String lang = line.substring(224,235).trim();
					String yearImm = line.substring(235,241).trim();
					String job = line.substring(252,274).trim();
					String industry = line.substring(274,303).trim();
					String notes = line.substring(342).trim();

					if(!first.equals(".") && !last.equals(".")){
						Citizen cit = new Citizen(first, last, streetName, streetNum, relation, rentOwn, propValue, gender, age, marrStat, fstMarrAge, attendSchool, canRead, bp, fbp, mbp, lang, yearImm, job, industry, notes);
						ppl.add(cit);
					}
				}
			}
		}
		catch(Exception e){
			System.out.println("Here: " + e.toString());
		}

		Collections.sort(ppl);
		for(Citizen person : ppl)
			System.out.println(person);
		lineOfStars();
		streetCitizens();
		lineOfStars();
		birthPlaceAges();
		lineOfStars();
		langFullName();
		lineOfStars();
		jobFBP();
		lineOfStars();
		genderRemarks();
		lineOfStars();
		rentOwnPropValues();
		lineOfStars();
		//genderJobs();
		streetAttenSchool();
		lineOfStars();
	}
	public void streetAttenSchool(){
		System.out.println("Where would the school be located in Cambria, PA?");
		TreeMap<String, ArrayList<Boolean>> treeMap = new TreeMap<String, ArrayList<Boolean>>();
		for(Citizen c : ppl){
			if(!treeMap.containsKey(c.getStreetName()))
				treeMap.put(c.getStreetName(), new ArrayList<Boolean>());
			treeMap.get(c.getStreetName()).add(c.attenSchool());
		}
		Iterator<String> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			String street = it.next();
			System.out.println(street+":");
			ArrayList<Boolean> list = treeMap.get(street);
			int yesC = 0;
			int noC = 0;
			for(boolean b : list){
				if(b)
					yesC++;
				else
					noC++;
			}
			System.out.println("\t"+yesC + " people have attended school on this street.");
			System.out.println("\t"+noC + " people have not attended school on this street.");
		}
		System.out.println("\nFrom seeing how many people went to school on each street, we can guess \nthat there might have been a school on Grant Street or Wilbur Street.");
	}
	public void genderJobs(){
		TreeMap<String, TreeSet<String>> treeMap = new TreeMap<String, TreeSet<String>>();
		for(Citizen c : ppl){
			if(!treeMap.containsKey(c.getGender()))
				treeMap.put(c.getGender(), new TreeSet<String>());
			treeMap.get(c.getGender()).add(c.getJob());
		}
		Iterator<String> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			String gender = it.next();
			System.out.println(gender+":");
			TreeSet<String> set = treeMap.get(gender);
			for(String j : set){
				System.out.println("\t"+j);
			}
		}
	}
	public void rentOwnPropValues(){
		TreeMap<String, TreeSet<Double>> treeMap = new TreeMap<String, TreeSet<Double>>();
		for(Citizen c : ppl){
			if(!treeMap.containsKey(c.getRentOrOwn()))
				treeMap.put(c.getRentOrOwn(), new TreeSet<Double>());
			treeMap.get(c.getRentOrOwn()).add(c.getPropValue());
		}
		Iterator<String> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			String rentOwn = it.next();
			System.out.println(rentOwn+":");
			TreeSet<Double> set = treeMap.get(rentOwn);
			for(Double d : set){
				System.out.println("\t$"+d+"0");
			}
		}
	}
	public void genderRemarks(){
		TreeMap<String, HashSet<String>> treeMap = new TreeMap<String, HashSet<String>>();
		for(Citizen c : ppl){
			if(!treeMap.containsKey(c.getGender()))
				treeMap.put(c.getGender(), new HashSet<String>());
			treeMap.get(c.getGender()).add(c.getNotes());
		}
		Iterator<String> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			String gender = it.next();
			System.out.println(gender+":");
			HashSet<String> set = treeMap.get(gender);
			for(String s : set){
				if(s.length()!=1)
					System.out.println("\t"+s);
			}
		}
	}
	public void jobFBP(){
		TreeMap<String, HashSet<String>> treeMap = new TreeMap<String, HashSet<String>>();
		for(Citizen c : ppl){
			if(!treeMap.containsKey(c.getJob()))
				treeMap.put(c.getJob(), new HashSet<String>());
			treeMap.get(c.getJob()).add(c.getfbp());
		}
		Iterator<String> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			String job = it.next();
			System.out.println(job+":");
			HashSet<String> set = treeMap.get(job);
			for(String s : set){
				System.out.println("\t"+s);
			}
		}
	}
	public void langFullName(){
		TreeMap<String, ArrayList<String>> treeMap = new TreeMap<String, ArrayList<String>>();
		for(Citizen c : ppl){
			if(!treeMap.containsKey(c.getLang()))
				treeMap.put(c.getLang(), new ArrayList<String>());
			treeMap.get(c.getLang()).add(c.getFullName());
		}
		Iterator<String> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			String lang = it.next();
			if(lang.length() != 1)
				System.out.println(treeMap.get(lang).size() + " have "+lang +" as their mother tongue.");
			else
				System.out.println("We do not know the mother tongue of " +treeMap.get(lang).size()+" people.");
		}
	}
	public void birthPlaceAges(){
		TreeMap<String, PriorityQueue<Double>> treeMap = new TreeMap<String, PriorityQueue<Double>>();
		for(Citizen c : ppl){
			if(!treeMap.containsKey(c.getbp()))
				treeMap.put(c.getbp(), new PriorityQueue<Double>());
			treeMap.get(c.getbp()).add(c.getAge());
		}
		Iterator<String> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			String bp = it.next();
			System.out.println(bp+":");
			PriorityQueue<Double> pq = treeMap.get(bp);
			if(!bp.equals("Pennsylvania")){
				System.out.print("[");
				while(pq.peek()!=null){
					double age = pq.poll();
					if(age >= 0){
						System.out.print(age);
						if(!pq.isEmpty())
							System.out.print(", ");
					}
				}
				System.out.print("]"+"\n");
			}
			else{
				System.out.print(pq.size()+" People\n");
			}
		}
	}
	public void streetCitizens(){
		TreeMap<String, TreeSet<Citizen>> treeMap = new TreeMap<String, TreeSet<Citizen>>();
		for(Citizen c : ppl){
			if(!treeMap.containsKey(c.getStreetName()))
				treeMap.put(c.getStreetName(), new TreeSet<Citizen>());
			treeMap.get(c.getStreetName()).add(c);
		}
		Iterator<String> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			String street = it.next();
			System.out.println(street+":");
			TreeSet<Citizen> set = treeMap.get(street);
			for(Citizen c : set){
				System.out.println("\t"+c);
			}
		}
	}

	public void lineOfStars(){
		for(int i = 0; i < 100; i++)
			System.out.print("*");
		System.out.println();
	}
	public class Citizen implements Comparable<Citizen>{
		private String first;
		private String last;
		private String streetName;
		private int streetNum;
		private String relation;
		private String rentOwn;
		private double propValue;
		private String gender;
		private double age;
		private String marrStat;
		private double fstMarrAge;
		private boolean attenSchool;
		private boolean canRead;
		private String bp;
		private String fbp;
		private String mbp;
		private int yearImm;
		private String mt;
		private String job;
		private String industry;
		private String notes;
		public String getFullName(){
			return last+", "+first;
		}
		public String getFirst(){
			return first;
		}
		public String getLast(){
			return last;
		}
		public String getStreetName(){
			return streetName;
		}
		public int getStreetNumber(){
			return streetNum;
		}
		public String getRelation(){
			return relation;
		}
		public String getRentOrOwn(){
			return rentOwn;
		}
		public double getPropValue(){
			return propValue;
		}
		public String getGender(){
			return gender;
		}
		public double getAge(){
			return age;
		}
		public String getMarrStat(){
			return marrStat;
		}
		public double getAgeAtFirstMarr(){
			return fstMarrAge;
		}
		public boolean attenSchool(){
			return attenSchool;
		}
		public boolean canRead(){
			return canRead;
		}
		public String getbp(){
			return bp;
		}
		public String getfbp(){
			return fbp;
		}
		public String getmbp(){
			return mbp;
		}
		public int getYearImm(){
			return yearImm;
		}
		public String getLang(){
			return mt;
		}
		public String getJob(){
			return job;
		}
		public String getIndustry(){
			return industry;
		}
		public String getNotes(){
			return notes;
		}

		public Citizen(String... parts){
			first = parts[0];
			last = parts[1];
			streetName = parts[2];
			try{
				streetNum = Integer.parseInt(parts[3]);
			}catch(Exception e){
				streetNum = -1;
			}

			relation = parts[4];
			rentOwn = parts[5].substring(0,1);

			if(parts[6].equals("un") || parts[6].equals(".")){
				propValue = 0;
			}
			else if(parts[6].contains("$")){
				propValue = Double.parseDouble(parts[6].replaceAll("[$,* ]", ""));
			}
			else if(parts[6].contains("/")){
				propValue = fracToDec(parts[6]);
			}
			else{
				propValue = Double.parseDouble(parts[6]);
			}

			gender = parts[7];

			if(parts[8].contains("/")){
				age = fracToDec(parts[8].replaceAll("[*]", "6"));
			}
			else if(parts[8].equals("un") || parts[8].charAt(0) == '.'){
				age = -1;
			}
			else{
				age = Double.parseDouble(parts[8].replaceAll("[*]", ""));
			}

			if(parts[9].equals("."))
				marrStat = "S";
			else
				marrStat = parts[9];


			if(parts[10].equals(".") || parts[10].equals("*"))
				fstMarrAge = -1;
			else
				fstMarrAge = Double.parseDouble(parts[10]);

			if(parts[11].equals("Yes"))
				attenSchool = true;
			else
				attenSchool = false;

			if(parts[12].equals("Yes"))
				canRead = true;
			else
				canRead = false;

			bp = parts[13];
			fbp = parts[14];
			mbp = parts[15];
			mt = parts[16];

			try{
				yearImm = Integer.parseInt(parts[17]);
			}catch(Exception e){
				yearImm = -1;
			}


			job = properCase(parts[18]);

			industry = properCase(parts[19]);

			notes = parts[20];
		}
		public String properCase(String s){
			String r = "";
			String[] words = s.split(" ");
			r = words[0].substring(0, 1).toUpperCase() + words[0].substring(1).toLowerCase();
			for(int i = 1; i < words.length; i++)
				r+=" "+words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
			return r;
		}
		public double fracToDec(String frac){
			double whole = 0;
			try{
				whole = Double.parseDouble(frac.substring(0, frac.indexOf(" ")));
			}
			catch(Exception e){
				whole = 0;
			}
			double num = Double.parseDouble(frac.substring(frac.indexOf(" ")+1, frac.indexOf("/")));
			double den = Double.parseDouble(frac.substring(frac.indexOf("/")+1, frac.length()));
			return whole+(num/den);
		}
		public int compareTo(Citizen other){
			if(getFirst().compareTo(other.getFirst()) < 0)
				return -1;
			if(getFirst().compareTo(other.getFirst()) > 0)
				return 1;
			if(getLast().compareTo(other.getLast()) < 0)
				return -1;
			if(getLast().compareTo(other.getLast()) > 0)
				return 1;
			if(getStreetName().compareTo(other.getStreetName()) < 0)
				return -1;
			if(getStreetName().compareTo(other.getStreetName()) > 0)
				return 1;
			if(getStreetNumber() < other.getStreetNumber())
				return -1;
			if(getStreetNumber() > other.getStreetNumber())
				return 1;
			if(getRelation().compareTo(other.getRelation()) < 0)
				return -1;
			if(getRelation().compareTo(other.getRelation()) > 0)
				return 1;
			if(getRentOrOwn().compareTo(other.getRentOrOwn()) < 0)
				return -1;
			if(getRentOrOwn().compareTo(other.getRentOrOwn()) > 0)
				return 1;
			if(getPropValue() < other.getPropValue())
				return -1;
			if(getPropValue() > other.getPropValue())
				return 1;
			if(getGender().compareTo(other.getGender()) < 0)
				return -1;
			if(getGender().compareTo(other.getGender()) > 0)
				return 1;
			if(getAge() < other.getAge())
				return -1;
			if(getAge() > other.getAge())
				return 1;
			if(getMarrStat().compareTo(other.getMarrStat()) < 0)
				return -1;
			if(getMarrStat().compareTo(other.getMarrStat()) > 0)
				return 1;
			if(getAgeAtFirstMarr() < other.getAgeAtFirstMarr())
				return -1;
			if(getAgeAtFirstMarr() > other.getAgeAtFirstMarr())
				return 1;
			if(attenSchool())
				return -1;
			if(!attenSchool())
				return 1;
			return 0;
		}
		public String toString(){
			return String.format("%-25sAge: %s", last+", "+first, age);
		}


	}

	public static void main(String[] args){
		Census app = new Census();
	}

}