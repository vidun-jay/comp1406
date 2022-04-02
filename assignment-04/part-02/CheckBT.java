import java.util.Random;

public class CheckBT extends BinaryTree{
    static boolean verb = true;
    static String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String TAB = "...";
    static String TAB2 = TAB + TAB;
    static Random rnd = new Random();

    static void shuffle(String[] arr){
        String tmp = null;
        for(int i =0; i<arr.length-1; i+=1){
            int j = rnd.nextInt(i+1, arr.length);
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
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

    public static String checkContains(boolean act, boolean exp, String target){
        if(exp == act){
            return TAB + " contains(\"" + target + "\") == " + exp + "  (passed)";
        }
        return TAB + " contains(\"" + target + "\") == " + exp + "  (failed)";
    }

    public static double checkContains(double outof){
        double grade = 0.0;
        String s = "";
        String[] in;
        String[] out;
        boolean expect, actual;

        System.out.println("########################");
        System.out.println("CHECKING     .contains()");
        System.out.println("########################");


        // empty tree
        System.out.println("\ncheck empty tree");
        BinaryTree t = new BinaryTree();
        if(verb) System.out.println(t);
        expect = false;
        s = "";
        actual = t.contains(s);
        System.out.println(checkContains(actual, expect, s));

        // size = 1
        System.out.println("\n\ncheck tree with size = 1");
        int pos = rnd.nextInt(0, LETTERS.length());
        s = LETTERS.substring(pos,pos+1);
        t = new BinaryTree(s);
        if(verb) System.out.println(t);
        expect = true;
        actual = t.contains(s);
        System.out.println(checkContains(actual, expect, s));

        out = new String[]{s+s, "", null};
        for(String ss : out){
            expect = false;
            actual = t.contains(ss);
            System.out.println(checkContains(actual, expect, ss));

        }

        // size = 2
        System.out.println("\n\ncheck tree with size = 2");

        System.out.println("\n" + TAB + "tree 1");
        t = new BinaryTree();
        t.root = new Node("Q", new Node("Z"), null);
        t.size = 2;
        if(verb) System.out.println(t);
        in = new String[]{"Q", "Z"};
        out = new String[]{"A", "", null, "W"};
        for(String ss : in){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, true, ss));
        }
        for(String ss : out){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, false, ss));
        }


        System.out.println("\n" + TAB + "tree 2");
        t.root = new Node("Q", null, new Node("Z"));
        if(verb) System.out.println(t);
        in = new String[]{"Q", "Z"};
        out = new String[]{"A", "", null, "W"};
        for(String ss : in){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, true, ss));
        }
        for(String ss : out){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, false, ss));
        }


        // size = 4
        System.out.println("\n\ncheck tree with size = 4");
        String[] alph = {"A", "B", "C", "D"};

        System.out.println("\n" + TAB + "tree 1");
        shuffle(alph);
        t = new BinaryTree();
        t.root = new Node(alph[0], new Node(alph[1]), new Node(alph[2], new Node(alph[3]), null));
        t.size = 4;
        if(verb) System.out.println(t);
        in = alph;
        out = new String[]{"AA", "AB", "", "E"};
        for(String ss : in){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, true, ss));
        }
        for(String ss : out){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, false, ss));
        }

        System.out.println("\n" + TAB + "tree 2");
        shuffle(alph);
        t = new BinaryTree();
        t.root = new Node(alph[0], null, new Node(alph[1], new Node(alph[2]), new Node(alph[3])));
        t.size = 4;
        if(verb) System.out.println(t);
        in = alph;
        out = new String[]{"AA", "AB", "", "E"};
        for(String ss : in){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, true, ss));
        }
        for(String ss : out){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, false, ss));
        }

        System.out.println("\n" + TAB + "tree 3");
        shuffle(alph);
        t = new BinaryTree();
        t.root = new Node(alph[0],
                          null,
                          new Node(alph[1],
                                   new Node(alph[2], new Node(alph[3]), null),
                                   null));
        t.size = 4;
        if(verb) System.out.println(t);
        in = alph;
        out = new String[]{"AA", "AB", "", "E"};
        for(String ss : in){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, true, ss));
        }
        for(String ss : out){
            actual = t.contains(ss);
            System.out.println(checkContains(actual, false, ss));
        }

        return grade;
    }

    static String checkIsBST(boolean act, boolean exp){
        if(act == exp){
            return TAB +  " isBST() == " + exp + "  (passed)";
        }
        return TAB +  " isBST() == " + exp + "  (failed)";
    }
    static double checkIsBST(double outof){
        double grade = 0.0;
        boolean actual, expect;
        BinaryTree t;
        String s;

        System.out.println("\n\n########################");
        System.out.println("CHECKING        .isBST()");
        System.out.println("########################");

        // empty tree
        System.out.println("\ncheck empty tree");
        t = new BinaryTree();
        if(verb) System.out.println(t);
        expect = true;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));

        // tree of size 1
        System.out.println("\ncheck tree with size 1");
        int pos = rnd.nextInt(0, LETTERS.length());
        s = LETTERS.substring(pos,pos+1);
        t = new BinaryTree(s);
        if(verb) System.out.println(t);
        expect = true;
        actual = t.isBST();
        System.out.println(checkIsBST(actual, expect));

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



        return grade;
    }


    public static void main(String[] args){

        checkContains(1);
        checkIsBST(1);
    }
}