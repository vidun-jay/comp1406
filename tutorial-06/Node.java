public class Node{
	protected String data;
	protected Node   next;

	public Node(String s){
		this(s, null);
	}
	public Node(String s, Node n){
		this.data = s;
		this.next = n;
	}

	public String getData(){ return data; }
	public Node   getNext(){ return next; }

	public void setData(String s){ data = s; }
	public void setNext(Node n){ next = n;}




	// prints out node (with following nodes, showing data and "position" assuming that start is head of list)
	public static void print(Node start){
		if(start == null){ System.out.println("[]"); return;}

		String out = "";
		int count = 0;
		Node tmp = start;
		while(tmp != null){
			out += "[" + tmp.data + "," + count + "]->";
			tmp = tmp.next;
			count +=1;
		}
		System.out.println(out.substring(0,out.length()-2));

	}


	@Override
	public String toString(){
		return this.data;
	}

	public static void main(String[] args){
		System.out.println("testing the Node class");
		Node backHalf = new Node("E", new Node("F", new Node("G", new Node("H")))); 
		Node example = new Node("A", new Node("B", new Node("C", new Node("D", backHalf))));
		print(backHalf);
		print(example);
	}

}
