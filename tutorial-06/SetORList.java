import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;    // a set (unordered)
import java.util.ArrayList;  // a list (using an array)
import java.util.TreeSet;    // a sorted set
import java.util.Collections;


public class SetORList{

	public static void main(String[] args){

		int size = 25000;

		if(args.length == 1){
			try{
				// try to convert args[0] to an integer
				size = Integer.parseInt(args[0]);
			}catch(Exception e){
				// if we cannot convert args[0] to an int then output this and continue with default value
				System.out.print("usage: java SetORLit [n]");
				System.out.print("       where n is an optional integer (size of set/list");
				System.out.print("       the value 25,000 used if no paramater is given");				
			}

		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> sortedset = new TreeSet<Integer>();

		// make an array and shuffle it
		Integer[] nums = new Integer[size];
		for(int i=0; i<size; i+=1){
			nums[i] = i;
		}
		List<Integer> nums_list = Arrays.asList(nums);
		Collections.shuffle(nums_list);
		nums_list.toArray(nums);
		

		System.out.println("making collections... ");
		long start_time = System.nanoTime();
		for(int i=0; i<size; i+=1){
			list.add(nums[i]);
		}
		long time = System.nanoTime()-start_time;
		System.out.println("         build the list : " + (time*1e-9) + " seconds");
		


		start_time = System.nanoTime();
		for(int i=0; i<size; i+=1){
			set.add(nums[i]);
		}
		time = System.nanoTime()-start_time;
		System.out.println("build the unordered set : " + (time*1e-9) + " seconds");
		start_time = System.nanoTime();
		for(int i=0; i<size; i+=1){
			sortedset.add(nums[i]);
		}
		time = System.nanoTime()-start_time;
		System.out.println("   build the sorted set : " + (time*1e-9) + " seconds");





		System.out.print("\nsearching in the collections...");
		System.out.println("(" + size + " hits and " + size + " misses)");
		
		start_time = System.nanoTime();
		for(int i=0; i<2*size; i+=1){sortedset.contains(i);		}
		long sortedset_time = System.nanoTime()-start_time;
		System.out.println("   sorted set time " + (sortedset_time*1e-9)+ " seconds");

		start_time = System.nanoTime(); 
		for(int i=0; i<2*size; i+=1){	set.contains(i); }
		long set_time = System.nanoTime()-start_time;
		System.out.println("unordered set time " + (set_time*1e-9)+ " seconds");

		start_time = System.nanoTime();
		for(int i=0; i<2*size; i+=1){list.contains(i);	}
		long list_time = System.nanoTime()-start_time;
		System.out.println("         list time " + (list_time*1e-9)+ " seconds");


	}


}
