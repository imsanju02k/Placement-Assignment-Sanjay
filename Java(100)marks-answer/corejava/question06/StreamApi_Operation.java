package corejava.question06;

import java.util.ArrayList;
import java.util.List;

public class StreamApi_Operation {

	public static void main(String[] args) {
		
		List<Integer> number=new ArrayList<>();
		for(int i=1;i<=1500000;i++) {
			number.add(i);
		}
		
		List<Integer> filteredList=number.stream().filter(n->n%2==0).sorted((a,b)->b-a).limit(10).toList();
		
		System.out.println("Filtered and sorted List: ");
		filteredList.forEach(System.out::println);

	}

}
