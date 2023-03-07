import java.util.*;
import java.util.stream.*;

class StreamAPI
{
	public static void main(String[] args) 
	{
		String[] strArray = {"Soumya","Sai","Sanvi","AbhayPradhan","Sunita"};

		Stream<String> strStream = Stream.of(strArray);

		strStream.forEach(e->{
			System.out.println(e);
		});


	}
}