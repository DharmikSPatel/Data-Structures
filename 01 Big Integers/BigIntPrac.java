import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class BigIntPrac{
	public static void main(String[]args){
		File file = new File("LucasNumberFile.txt");

		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = br.readLine()) != null){
				BigInteger first = new BigInteger("2");
				BigInteger second = new BigInteger("1");
				BigInteger sum = new BigInteger("0");

				if(line.equals("0")){
					System.out.println(line + "\t" + first);
				}
				else if(line.equals("1")){
					System.out.println(line + "\t" + second);
				}
				else{
					for(BigInteger x = new BigInteger("1"); x.compareTo(new BigInteger(line))<0; x = x.add(BigInteger.ONE)){
						sum = first.add(second);
						first = new BigInteger(second.toString());
						second = new BigInteger(sum.toString());
					}
					System.out.println(line + "\t" + sum);
				}

			}

		}catch(Exception e){
			System.out.println("error");
		}
		/*
		BigInteger b = new BigInterger("101");  or (""+101);
		b = BigInteger.valueOf(101);
		b = BigInteger.ONE; or. ZERO;

		cant to math, ex: b+=1;

		b.add(1) //no
		b.(BigInterger.1); //no
		b = b.add(BigInteger.add(1));
		for(BigInteger i = new BigInteger("2"); i.compareTo(new BigInteger(line))<0; i = i.add(BigInteger.ONE)){
								sum = first.add(second);
								first = new BigInteger(second.toString());
								second = new BigInteger(sum.toString());
					}
		*/
	}

}





