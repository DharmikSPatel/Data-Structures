import java.util.*;
public class CW1{
	public static void main(String[]args){
		System.out.println("Fixed Tests dblLinear");
		System.out.println(dblLinear(10));
		System.out.println(dblLinear(20));
		System.out.println(dblLinear(30));
		System.out.println(dblLinear(50));
		/*
        testing(DoubleLinear.dblLinear(10), 22);
        testing(DoubleLinear.dblLinear(20), 57);
        testing(DoubleLinear.dblLinear(30), 91);
        testing(DoubleLinear.dblLinear(50), 175);
        */
	}
	public static int dblLinear (int n) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		int num = set.first();
		for(int i = 0; i < n; i++){
			set.add(2*num+1);
			set.add(3*num+1);
			num = set.higher(num);
		}
	    return num;
    }

}