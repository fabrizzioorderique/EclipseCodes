package myAPQuestions;

import java.util.ArrayList;

public class A{
	public static int mystery(ArrayList<Integer> numList)

	{

	if (numList.size() == 0)

	{

	return 0;

	}

	else

	{

	int val = numList.remove(0);

	return val + mystery(numList);

	}

	}
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(4);
		ints.add(52);
		ints.add(32);
		ints.add(12);
		System.out.println(mystery(ints));
		
	}
} 
