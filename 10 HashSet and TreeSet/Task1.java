import java.util.*;
public class Task1{
	public static void main(String[]args){
		ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		int randSize = (int)(Math.random() * 11) + 2;
		for(int i = 0; i < randSize; i++){
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(4);
			while(set.size() < 10){
				set.add((int)(Math.random() * 30) + 1);
			}
			list.add(set);
		}
		System.out.println("Original Sets");
		for(int i = 0; i < list.size(); i++){
			System.out.println("Size: "+list.get(i).size()+"    List: "+list.get(i));
		}
		System.out.println();

		/*tests
		System.out.println("Inter: "+intersection(list.get(0), list.get(1))+" Size: "+intersection(list.get(0), list.get(1)).size());
		System.out.println("Union: "+union(list.get(0), list.get(1))+" Size: "+union(list.get(0), list.get(1)).size());
		System.out.println("InteE: "+intersectionEven(list.get(0), list.get(1))+" Size: "+intersectionEven(list.get(0), list.get(1)).size());
		System.out.println("UnioE: "+unionEven(list.get(0), list.get(1))+" Size: "+unionEven(list.get(0), list.get(1)).size());
		*/
		HashSet<Integer> curInter = list.get(0);
		HashSet<Integer> curUnion = list.get(0);
		HashSet<Integer> curInterEven = list.get(0);
		HashSet<Integer> curUnionEven = list.get(0);

		for(int i = 1; i < list.size(); i++){
			curInter = intersection(curInter, list.get(i));
			curUnion = union(curUnion, list.get(i));
			curInterEven = intersectionEven(curInterEven, list.get(i));
			curUnionEven = unionEven(curUnionEven, list.get(i));

		}
		System.out.println("Intersection: All values that are common in all the sets");
		System.out.println("Size: "+curInter.size()+"\nList: "+curInter);
		System.out.println();

		System.out.println("Union: All values that are unique in all the sets");
		System.out.println("Size: "+curUnion.size()+"\nList: "+curUnion);
		System.out.println();

		System.out.println("Intersection Even: All even values that are common in all the sets");
		System.out.println("Size: "+curInterEven.size()+"\nList: "+curInterEven);
		System.out.println();

		System.out.println("Union Even: All even values that are unique in all the sets");
		System.out.println("Size: "+curUnionEven.size()+"\nList: "+curUnionEven);
		System.out.println();



	}
	public static HashSet<Integer> intersection(HashSet<Integer> s1, HashSet<Integer> s2){
		HashSet<Integer> newSet = new HashSet<Integer>();
		HashSet<Integer> newSet2 = new HashSet<Integer>();
		for(Integer num : s1){
			if(!newSet.add(num)){
				newSet2.add(num);
			}
		}
		for(Integer num : s2){
						//System.out.println("hewe");

			if(!newSet.add(num)){
				newSet2.add(num);
			}
		}
		return newSet2;
	}
	public static HashSet<Integer> union(HashSet<Integer> s1, HashSet<Integer> s2){
		HashSet<Integer> newSet = new HashSet<Integer>();
		for(Integer num : s1)
			newSet.add(num);
		for(Integer num : s2)
			newSet.add(num);
		return newSet;
	}
	public static HashSet<Integer> intersectionEven(HashSet<Integer> s1, HashSet<Integer> s2){
		HashSet<Integer> newSet = intersection(s1, s2);
		Iterator<Integer> iterator = newSet.iterator();
		while (iterator.hasNext()) {
			Integer num = iterator.next();
			if (num%2!=0) {
				iterator.remove();
			}
		}
		return newSet;
	}
	public static HashSet<Integer> unionEven(HashSet<Integer> s1, HashSet<Integer> s2){
		HashSet<Integer> newSet = union(s1, s2);
		Iterator<Integer> iterator = newSet.iterator();
		while (iterator.hasNext()) {
			Integer num = iterator.next();
			if (num%2!=0) {
				iterator.remove();
			}
		}

		return newSet;
	}

}