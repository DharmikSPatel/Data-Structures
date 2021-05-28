import java.util.ArrayList;

import org.graalvm.compiler.java.LambdaUtils;

public class TreeSet<E extends Comparable<E>>{
    public static void main(String[] args){
		System.out.println(">>>>>>STEPS 1-3");
		TreeSet<Integer> tree = new TreeSet<Integer>();
		String s = "[";
		for(int i = 0; tree.size()!=30; i++){
			int rand = ((int)(Math.random()*100)+1);
			if(tree.add(rand))
				s+=rand+", ";
		}
		System.out.println("Original Tree: "+s.substring(0, s.length()-2)+"]");
		System.out.println("Size: "+tree.size());
		System.out.println("\n>>>>>>STEPS 4-9");
		System.out.println("OG Tree");
		System.out.println("OG\tPreOrder: "+tree.preOrder());
		System.out.println("OG\tInOrder: "+tree.inOrder());
		System.out.println("OG\tPostOrder: "+tree.postOrder());
		System.out.println("OG\tSize: "+tree.size());
		System.out.println("\n\nMaking Pre Order Copy");
		String[] temp = tree.preOrder().substring(1, tree.preOrder().length()-1).split(", ");
		TreeSet<Integer> copyPre = new TreeSet<Integer>();
		for(int i = 0; i < temp.length; i++){
			copyPre.add(Integer.parseInt(temp[i]));
		}
		System.out.println("PreOrder Copy\tPreOrder: "+copyPre.preOrder());
		System.out.println("PreOrder Copy\tInOrder: "+copyPre.inOrder());
		System.out.println("PreOrder Copy\tPostOrder: "+copyPre.postOrder());
		System.out.println("PreOrder Copy\tSize: "+copyPre.size());
		System.out.print("The preOrder copy has the exact structure as my OG tree");

		System.out.println("\n\nMaking In Order Copy");
		temp = tree.inOrder().substring(1, tree.inOrder().length()-1).split(", ");
		TreeSet<Integer> copyin = new TreeSet<Integer>();
		for(int i = 0; i < temp.length; i++){
			copyin.add(Integer.parseInt(temp[i]));
		}
		System.out.println("InOrder Copy\tPreOrder: "+copyin.preOrder());
		System.out.println("InOrder Copy\tInOrder: "+copyin.inOrder());
		System.out.println("InOrder Copy\tPostOrder: "+copyin.postOrder());
		System.out.println("InOrder Copy\tSize: "+copyin.size());
		System.out.print("I noticed that the inOrder copy's preOrder and inOrder outputs are exactly the same.");
		System.out.print("\nAlso the inOrder copy's postOrder output is the reverse of the inOrder copy's preOrder and inOrder outputs.");

		System.out.println("\n\nMaking Post Order Copy");
		temp = tree.postOrder().substring(1, tree.postOrder().length()-1).split(", ");
		TreeSet<Integer> copypost = new TreeSet<Integer>();
		for(int i = 0; i < temp.length; i++){
			copypost.add(Integer.parseInt(temp[i]));
		}
		System.out.println("PostOrder Copy\tPreOrder: "+copypost.preOrder());
		System.out.println("PostOrder Copy\tInOrder: "+copypost.inOrder());
		System.out.println("PostOrder Copy\tPostOrder: "+copypost.postOrder());
		System.out.println("PostOrder Copy\tSize: "+copypost.size());
		System.out.print("I noticed that the postOrder copy's inOrder output is the same as the OG, PreOrder Copy and In Order Copy's In Order Outputs.");
		System.out.println("\n\n>>>>>>STEPS 10-11");
		TreeSet<String> treeString = new TreeSet<String>();
		s = "[";
		while(treeString.size() != 20){
			String s2 = "";
			for(int i = 0; i < 5; i++){
				int rand = ((int)(Math.random()*26)+97);
				s2+=(char)rand;
			}
			if(treeString.add(s2))
				s+=s2+", ";
		}
		System.out.println("Original String Tree: "+s.substring(0, s.length()-2)+"]");
		System.out.println("Original String Tree");
		System.out.println("Original String Tree\tPreOrder: "+treeString.preOrder());
		System.out.println("Original String Tree\tInOrder: "+treeString.inOrder());
		System.out.println("Original String Tree\tPostOrder: "+treeString.postOrder());
		System.out.println("Original String Tree\tSize: "+treeString.size());

		System.out.println("\n>>>>>>STEP 12");
		treeString.rotateRight();
		System.out.println("Rotate Right");
		System.out.println("Rotate Right 1\tPreOrder: "+treeString.preOrder());
		System.out.println("Rotate Right 1\tInOrder: "+treeString.inOrder());
		System.out.println("Rotate Right 1\tPostOrder: "+treeString.postOrder());
		System.out.println("Rotate Right 1\tSize: "+treeString.size());
		treeString.rotateRight();
		System.out.println("Rotate Right");
		System.out.println("Rotate Right 2\tPreOrder: "+treeString.preOrder());
		System.out.println("Rotate Right 2\tInOrder: "+treeString.inOrder());
		System.out.println("Rotate Right 2\tPostOrder: "+treeString.postOrder());
		System.out.println("Rotate Right 2\tSize: "+treeString.size());
		System.out.println("Rotate Right");
		System.out.println("Rotate Right 3\tPreOrder: "+treeString.preOrder());
		System.out.println("Rotate Right 3\tInOrder: "+treeString.inOrder());
		System.out.println("Rotate Right 3\tPostOrder: "+treeString.postOrder());
		System.out.println("Rotate Right 3\tSize: "+treeString.size());
		System.out.println("\n>>>>>>STEP 13");
		treeString.rotateLeft();
		System.out.println("Rotate Left");
		System.out.println("Rotate Left 1\tPreOrder: "+treeString.preOrder());
		System.out.println("Rotate Left 1\tInOrder: "+treeString.inOrder());
		System.out.println("Rotate Left 1\tPostOrder: "+treeString.postOrder());
		System.out.println("Rotate Left 1\tSize: "+treeString.size());
		treeString.rotateLeft();
		System.out.println("Rotate Left");
		System.out.println("Rotate Left 2\tPreOrder: "+treeString.preOrder());
		System.out.println("Rotate Left 2\tInOrder: "+treeString.inOrder());
		System.out.println("Rotate Left 2\tPostOrder: "+treeString.postOrder());
		System.out.println("Rotate Left 2\tSize: "+treeString.size());
		System.out.println("Rotate Left");
		System.out.println("Rotate Left 3\tPreOrder: "+treeString.preOrder());
		System.out.println("Rotate Left 3\tInOrder: "+treeString.inOrder());
		System.out.println("Rotate Left 3\tPostOrder: "+treeString.postOrder());
		System.out.println("Rotate Left 3\tSize: "+treeString.size());
		System.out.println("\n>>>>>>STEPS 14-16");
		TreeSet<Integer> treeSetInt = new TreeSet<Integer>();
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		while(treeSetInt.size() != 10){
			int i = (int)(Math.random()*10);
			treeSetInt.add(i);
			listInt.add(i);
		}

		System.out.println("OG List: \t"+listInt);
		System.out.println("The list is longer than the treeset because the treeSet can not contain duplicates, but the list can contain duplicates.");
		System.out.println("OG Int Tree");
		System.out.println("OG Int Tree\tPreOrder: "+treeSetInt.preOrder());
		System.out.println("OG Int Tree\tInOrder: "+treeSetInt.inOrder());
		System.out.println("OG Int Tree\tPostOrder: "+treeSetInt.postOrder());
		System.out.println("OG Int Tree\tSize: "+treeSetInt.size());

		while(treeSetInt.size() != 0){
			int iRemove = (int)(Math.random()*listInt.size());
			int valRemove = listInt.remove(iRemove);
			treeSetInt.remove(valRemove);
			System.out.println("Removing "+valRemove);
			System.out.println("OG Int Tree\tPreOrder: "+treeSetInt.preOrder());
			System.out.println("OG Int Tree\tInOrder: "+treeSetInt.inOrder());
			System.out.println("OG Int Tree\tPostOrder: "+treeSetInt.postOrder());
			System.out.println("OG Int Tree\tSize: "+treeSetInt.size());		
		}
		
		/*
		TreeSet<Character> tree = new TreeSet<Character>();
		int sum = 0;
		for(int i = 0; i < 30; i++){
			int rand = ((int)(Math.random()*26)+97);
			if(tree.add((char)rand))
				sum+=rand;
		}
		System.out.printf("The average character (rounded down) is '%s'. \nThe average ASCII value (rounded down) is %s.\n", (char)(sum/tree.size()), sum/tree.size());
		System.out.println(String.format("Size: \t\t%s Characters", tree.size));
		System.out.println("PreOrder: \t"+tree.preOrder());
		System.out.println("InOrder: \t"+tree.inOrder());
		System.out.println("PostOrder: \t"+tree.postOrder());
		*/

		/*
		TreeSet<Character> tree=new TreeSet<Character>();
		for(int i = 0; i < 30; i++){
			tree.add((char)((int)(Math.random() * 26) + 97));
		}

		System.out.println("OG tree");
		System.out.println("PreOrder: "+tree.preOrder());
		System.out.println("InOrder: "+tree.inOrder());
		System.out.println("PostOrder: "+tree.postOrder());
		System.out.println("Size: "+tree.size());

		System.out.println("\nrotate right twice");
		tree.rotateRight();
		tree.rotateRight();
		System.out.println("PreOrder: "+tree.preOrder());
		System.out.println("InOrder: "+tree.inOrder());
		System.out.println("PostOrder: "+tree.postOrder());
		System.out.println("Size: "+tree.size());

		System.out.println("\nrotate left twice");
		tree.rotateLeft();
		tree.rotateLeft();
		System.out.println("PreOrder: "+tree.preOrder());
		System.out.println("InOrder: "+tree.inOrder());
		System.out.println("PostOrder: "+tree.postOrder());
		System.out.println("Size: "+tree.size());

		System.out.println("Once I rotate right twice and rotate left twice, the tree goes back to OG position, so the rotate methods work.");

		System.out.println("\n************************");
		System.out.println("OG Tree");
		System.out.println("PreOrder Copy\tPreOrder: "+tree.preOrder());
		System.out.println("PreOrder Copy\tInOrder: "+tree.inOrder());
		System.out.println("PreOrder Copy\tPostOrder: "+tree.postOrder());
		System.out.println("PreOrder Copy\tSize: "+tree.size());
		System.out.println("\nMaking Pre Order Copy");
		String[] temp = tree.preOrder().substring(1, tree.preOrder().length()-1).split(", ");
		TreeSet<Character> copyPre = new TreeSet<Character>();
		for(int i = 0; i < temp.length; i++){
			copyPre.add(temp[i].charAt(0));
		}
		System.out.println("PreOrder Copy\tPreOrder: "+copyPre.preOrder());
		System.out.println("PreOrder Copy\tInOrder: "+copyPre.inOrder());
		System.out.println("PreOrder Copy\tPostOrder: "+copyPre.postOrder());
		System.out.println("PreOrder Copy\tSize: "+copyPre.size());

		System.out.println("\nMaking In Order Copy");
		temp = tree.inOrder().substring(1, tree.inOrder().length()-1).split(", ");
		TreeSet<Character> copyin = new TreeSet<Character>();
		for(int i = 0; i < temp.length; i++){
			copyin.add(temp[i].charAt(0));
		}
		System.out.println("InOrder Copy\tPreOrder: "+copyin.preOrder());
		System.out.println("InOrder Copy\tInOrder: "+copyin.inOrder());
		System.out.println("InOrder Copy\tPostOrder: "+copyin.postOrder());
		System.out.println("InOrder Copy\tSize: "+copyin.size());

		System.out.println("\nMaking Post Order Copy");
		temp = tree.postOrder().substring(1, tree.postOrder().length()-1).split(", ");
		TreeSet<Character> copypost = new TreeSet<Character>();
		for(int i = 0; i < temp.length; i++){
			copypost.add(temp[i].charAt(0));
		}
		System.out.println("PostOrder Copy\tPreOrder: "+copypost.preOrder());
		System.out.println("PostOrder Copy\tInOrder: "+copypost.inOrder());
		System.out.println("PostOrder Copy\tPostOrder: "+copypost.postOrder());
		System.out.println("PostOrder Copy\tSize: "+copypost.size());
		*/
    }

	private TreeNode<E> root;
	private int size;
	private String str;
	public TreeSet(){
		root = null;
		size = 0;
		str = "[]";
	}

	public void rotateRight(){
		rotateRight(root);
	}
	private void rotateRight(TreeNode<E> curr){
		if(curr == null || curr.getLeft() == null)
			return;
		else{
			TreeNode<E> temp = curr.getLeft();
			curr.setLeft(temp.getRight());
			temp.setRight(curr);
			root = temp;
		}
	}
	public void rotateLeft(){
		rotateLeft(root);
	}
	private void rotateLeft(TreeNode<E> curr){
		if(curr == null || curr.getRight() == null)
			return;
		else{
			TreeNode<E> temp = curr.getRight();
			curr.setRight(temp.getLeft());
			temp.setLeft(curr);
			root = temp;
		}
	}
	public int size(){
		return size;
	}
	public TreeNode<E> getRoot(){
		return root;
	}
	public void remove(E value){
		if(root == null)
			return;
		if(contains(root, value)){
			if(root.getLeft() == null && root.getRight() == null){
				size=0;
				root=null;
				return;
			}
			else{
				size--;
				root = remove(root, value);
				return;
			}
		}
	}
	private TreeNode<E> remove(TreeNode<E> temp, E value){
		if(temp == null){
			return temp;
		}
		if(temp.getValue().compareTo(value) < 0){
			temp.setRight(remove(temp.getRight(), value));
			return temp;
		}
		else if(temp.getValue().compareTo(value) > 0){
			temp.setLeft(remove(temp.getLeft(), value));
			return temp;
		}
		else{
			if(temp.getLeft() == null && temp.getRight() == null){
				temp = null;
				return temp;
			}
			else if(temp.getLeft() == null)
				return temp.getRight();
			else if(temp.getRight() == null)
				return temp.getLeft();
			else{
				E tempMinValue = minValue(temp.getRight());
				temp.setValue(tempMinValue);
				temp.setRight(remove(temp.getRight(), tempMinValue));
				return temp;
			}
		}

	}

	public boolean contains(TreeNode<E> temp, E value){
		if(temp == null)
			return false;
		if(temp.getValue().compareTo(value) == 0)
			return true;
		else if(temp.getValue().compareTo(value) < 0)
			return contains(temp.getRight(), value);
		else
			return contains(temp.getLeft(), value);
	}
	public E minValue(TreeNode<E> temp){
		return temp.getLeft() == null ? temp.getValue() : minValue(temp.getLeft());
	}
	public boolean add(E value){
		if(root == null){
			root = new TreeNode<E>(value);
			size++;
			return true;
		}
		else{
			return add(root, value);
		}
	}
	private boolean add(TreeNode<E> curNode, E value){
		E curValue = curNode.getValue();
		if(curValue.compareTo(value) == 0)
			return false;
		else if(curValue.compareTo(value) > 0){
			if(curNode.getLeft() == null){
				curNode.setLeft(new TreeNode<E>(value));
				size++;
				return true;
			}
			else{
				return add(curNode.getLeft(), value);
			}
		}
		else{
			if(curNode.getRight() == null){
				curNode.setRight(new TreeNode<E>(value));
				size++;
				return true;
			}
			else{
				return add(curNode.getRight(), value);
			}
		}
	}
	public String preOrder(){
		if(size == 0){
			return "[]";
		}
		else{
			str = "[";
			preOrder(root);
			return str.substring(0, str.length()-2)+"]";
		}
	}
	private void preOrder(TreeNode<E> curNode){
		if(curNode!=null){
			str+=curNode.getValue().toString()+", ";
			preOrder(curNode.getLeft());
			preOrder(curNode.getRight());
		}
	}
	public String inOrder(){
		if(size == 0){
			return "[]";
		}
		else{
			str = "[";
			inOrder(root);
			return str.substring(0, str.length()-2)+"]";
		}
	}
	private void inOrder(TreeNode<E> curNode){
		if(curNode!=null){
			inOrder(curNode.getLeft());
			str+=curNode.getValue().toString()+", ";
			inOrder(curNode.getRight());
		}
	}
	public String postOrder(){
		if(size == 0){
			return "[]";
		}
		else{
			str = "[";
			postOrder(root);
			return str.substring(0, str.length()-2)+"]";
		}
	}
	private void postOrder(TreeNode<E> curNode){
		if(curNode!=null){
			postOrder(curNode.getLeft());
			postOrder(curNode.getRight());
			str+=curNode.getValue().toString()+", ";
		}
	}


    private static class TreeNode<E extends Comparable<E>>{
        private E value;
        private TreeNode<E> left;
        private TreeNode<E> right;
        public TreeNode(E value){
            this.value = value;
            left = null;
            right = null;
        }
        public TreeNode<E> getRight(){
			return right;
		}
        public TreeNode<E> getLeft(){
			return left;
		}
		public void setRight(TreeNode<E> newRight){
			right = newRight;
		}
		public void setLeft(TreeNode<E> newLeft){
			left = newLeft;
		}
		public E getValue(){
			return value;
		}
		public void setValue(E v){
			value = v;
		}
		public String toString(){
			return value.toString();
		}
    }

}