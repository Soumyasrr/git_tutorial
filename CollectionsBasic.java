import java.util.*;

class CollectionsBasic
{
	public static void main(String[] args) 
	{
		ArrayList<String> names = new ArrayList();

		LinkedList list = new LinkedList();
		names.add("Sam");
		names.add("Ram");
		System.out.println(names);
		for(int i: names)
		{
			System.out.println("Names "+i);
		}
		
		
	}
}