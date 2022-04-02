import java.util.Random;

public class CheckBST extends BST{
    static boolean verb = true;
    static String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String TAB = "...";
    static String TAB2 = TAB + TAB;
    static Random rnd = new Random();

    static void shuffle(String[] arr){
        String tmp = null;
        for(int i =0; i<arr.length-1; i+=1){
            int j = rnd.nextInt(i+1, arr.length);
            tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
    }

    public BinaryTree makeEmptyTree(){
        return new BinaryTree();
    }

    public BinaryTree makeTree1(){
        BinaryTree t = new BinaryTree();
        Node root = new Node("Q");
        return t;
    }

    static String checkAdd(BinaryTree b1, BinaryTree b2, String s){
        if(b1.toString().equals(b2.toString())){
            if( b1.getSize() == b2.getSize()){
                return TAB +  " add(\"" + s + "\")  (passed)";
            }else{
                return TAB +  " add(\"" + s + "\")  (partial passed / size not correct)";
            }
        }
        return TAB +  " add(\"" + s + "\")  (failed)\n" + TAB + " expecting\n" + b2.toString();

    }
    static double checkAdd(double outof){
        double grade = 0.0;
        boolean actual, expect;
        BinaryTree t,bst;
        String s;

        System.out.println("\n\n########################");
        System.out.println("CHECKING          .add()");
        System.out.println("########################");

        // empty tree
        System.out.println("\nadd to  empty tree");
        int pos = rnd.nextInt(0, LETTERS.length());
        s = LETTERS.substring(pos,pos+1);
        bst = new BST();
        bst.root = new Node(s);
        bst.size = 1;
        t = new BST();
        if(verb) System.out.println("tree before add");
        if(verb) System.out.println(t);
        t.add(s);
        if(verb) System.out.println("tree after add");
        if(verb) System.out.println(t);
        System.out.println(checkAdd(t,bst,s));

        // tree of size 1
        System.out.println("\nadd to tree with size 1");
        t = new BST();
        t.root = new Node("A", null, new Node("Q"));
        t.size = 2;
        s = "H";
        bst = new BST();
        bst.root = new Node("A", null, new Node("Q", new Node(s), null));
        bst.size = 3;
        if(verb) System.out.println("tree before add");
        if(verb) System.out.println(t);
        t.add(s);
        if(verb) System.out.println("tree after add");
        if(verb) System.out.println(t);
        System.out.println(checkAdd(t,bst,s));


        System.out.println("\nadd to tree with size 1");
        t = new BST();
        t.root = new Node("A", null, new Node("Q"));
        t.size = 2;
        s = "W";
        bst = new BST();
        bst.root = new Node("A", null, new Node("Q", null, new Node(s)));
        bst.size = 3;
        if(verb) System.out.println("tree before add");
        if(verb) System.out.println(t);
        t.add(s);
        if(verb) System.out.println("tree after add");
        if(verb) System.out.println(t);
        System.out.println(checkAdd(t,bst,s));


        System.out.println("\nadd to tree with size 1");
        t = new BST();
        t.root = new Node("K", new Node("B"), null);
        t.size = 2;
        s = "W";
        bst = new BST();
        bst.root = new Node("K", new Node("B"), new Node(s) ) ;
        bst.size = 3;
        if(verb) System.out.println("tree before add");
        if(verb) System.out.println(t);
        t.add(s);
        if(verb) System.out.println("tree after add");
        if(verb) System.out.println(t);
        System.out.println(checkAdd(t,bst,s));

        System.out.println("\nadd to tree with size 1");
        t = new BST();
        t.root = new Node("K", new Node("B"), null);
        t.size = 2;
        s = "A";
        bst = new BST();
        bst.root = new Node("K", new Node("B", new Node(s),null), null ) ;
        bst.size = 3;
        if(verb) System.out.println("tree before add");
        if(verb) System.out.println(t);
        t.add(s);
        if(verb) System.out.println("tree after add");
        if(verb) System.out.println(t);
        System.out.println(checkAdd(t,bst,s));


        // larger tree
        System.out.println("\nadd to larger tree");
        Node ace1 = new Node("C", new Node("A"), new Node("E"));
        Node hik1 = new Node("I", new Node("H"), new Node("K"));
        Node fmq1 = new Node("M", new Node("F"), new Node("Q"));
        fmq1.getLeft().setLeft(ace1);
        fmq1.getLeft().setRight(hik1);
        Node root1 = new Node("S", fmq1, new Node("X"));
        t = new BST();
        t.root = root1;
        t.size = 11;
        s = "J";
        Node ace2 = new Node("C", new Node("A"), new Node("E"));
        Node hik2 = new Node("I", new Node("H"), new Node("K", new Node(s), null));
        Node fmq2 = new Node("M", new Node("F"), new Node("Q"));
        fmq2.getLeft().setLeft(ace2);
        fmq2.getLeft().setRight(hik2);
        Node root2 = new Node("S", fmq2, new Node("X"));
        bst = new BST();
        bst.root = root2;
        bst.size = 12;
        if(verb) System.out.println("tree before add");
        if(verb) System.out.println(t);
        t.add(s);
        if(verb) System.out.println("tree after add");
        if(verb) System.out.println(t);
        System.out.println(checkAdd(t,bst,s));


        /*
        // tree of size 2
        System.out.println("\n\ncheck tree with size = 2");

        System.out.println("\n" + TAB + "tree 1");
        t = new BinaryTree();
        t.root = new Node("Q", new Node("E"), null);
        t.size = 2;
        if(verb) System.out.println(t);
        expect = true;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));


        System.out.println("\n" + TAB + "tree 2");
        t = new BinaryTree();
        t.root = new Node("Q", new Node("Y"), null);
        t.size = 2;
        if(verb) System.out.println(t);
        expect = false;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));



        System.out.println("\n" + TAB + "tree 3");
        t = new BinaryTree();
        t.root = new Node("Q", null, new Node("Y"));
        t.size = 2;
        if(verb) System.out.println(t);
        expect = true;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));

        System.out.println("\n" + TAB + "tree 4");
        t = new BinaryTree();
        t.root = new Node("Y", null, new Node("Q"));
        t.size = 2;
        if(verb) System.out.println(t);
        expect = false;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));


        // size = 4
        System.out.println("\n\ncheck tree with size = 4");
        String[] alph = {"A", "B", "C", "D"};

        System.out.println("\n" + TAB + "tree 1");
        t = new BinaryTree();
        t.root = new Node(alph[0], new Node(alph[1]), new Node(alph[2], new Node(alph[3]), null));
        t.size = 4;
        if(verb) System.out.println(t);
        expect = false;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));

        System.out.println("\n" + TAB + "tree 2");
        t = new BinaryTree();
        t.root = new Node(alph[1], new Node(alph[0]), new Node(alph[3], new Node(alph[2]), null));
        t.size = 4;
        if(verb) System.out.println(t);
        expect = true;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));

        System.out.println("\n" + TAB + "tree 3");
        t = new BinaryTree();
        t.root = new Node(alph[0], null, new Node(alph[2], new Node(alph[1]), new Node(alph[3])));
        t.size = 4;
        if(verb) System.out.println(t);
        expect = true;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));


        System.out.println("\n" + TAB + "tree 4");
        t = new BinaryTree();
        t.root = new Node(alph[0], null, new Node(alph[1], new Node(alph[2]), new Node(alph[3])));
        t.size = 4;
        if(verb) System.out.println(t);
        expect = false;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));

        System.out.println("\n" + TAB + "tree 5");
        t = new BinaryTree();
        t.root = new Node(alph[0],
                          null,
                          new Node(alph[3],
                                   new Node(alph[2], new Node(alph[1]), null),
                                   null));
        t.size = 4;
        if(verb) System.out.println(t);
        expect = true;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));

        System.out.println("\n" + TAB + "tree 6");
        t = new BinaryTree();
        t.root = new Node(alph[3],
                          null,
                          new Node(alph[1],
                                   new Node(alph[0], new Node(alph[2]), null),
                                   null));
        t.size = 4;
        if(verb) System.out.println(t);
        expect = false;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));

        */

        return grade;
    }
    public static void main(String[] args){
        checkAdd(1);
    }
}