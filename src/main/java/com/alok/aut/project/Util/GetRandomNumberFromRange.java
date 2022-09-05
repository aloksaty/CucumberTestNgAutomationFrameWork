package com.alok.aut.project.Util;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class GetRandomNumberFromRange {
	
	List<Integer> RandomNumbersList= new LinkedList<>();
	List<String> RandomLoanList= new LinkedList<>();
	
	public int getRandomNumber() {
		Random randomInteger = new Random();
		int randomInt = randomInteger.nextInt(50) + 1;
		System.out.println("Random number generated is : " + randomInt);
		return randomInt;
	}
	public List<Integer> getRandomNumbers(int startno,int endno,int count) 
	{
		for(int i =0; i<count; i++)
		{
			Random randomInteger = new Random();
			int randomInt = startno + randomInteger.nextInt(endno - startno + 1);
			System.out.println("Random number generated is : " + randomInt);
		}
		return RandomNumbersList;
	}
	public List<String> getRandomLoanNumbers(List<String> loanlist,int count) {
		for(int i=1; i<count + 1; i++){
			Random randomInteger = new Random();
			System.out.println("Value of i is : " + i);
//			int listofitemsloanlist = loanlist.size();

			int randomInt = randomInteger.nextInt(loanlist.size());
			
			System.out.println("RandomInt value is :-" +randomInt);
			while (RandomNumbersList.contains(randomInt))
			{
				randomInt = 1 + randomInteger.nextInt(loanlist.size() - 1);
				System.out.println("Value of randomint after addition of new number is : " + randomInt);
				if (!RandomNumbersList.contains(randomInt))
				{
//					randomInt = randomInt - 1;
//					System.out.println("Final value of duplicated randomint after addition of new number is : " + randomInt);
					break;
				}
				else
				{
					randomInt = 1 + randomInteger.nextInt(loanlist.size() - 1);
					randomInt = randomInt - 1;
//					System.out.println("Final value of duplicated randomint after addition of new number is : " + randomInt);
				}
				
			}
			RandomLoanList.add(loanlist.get(randomInt));
			RandomNumbersList.add(randomInt);
			System.out.println("Random loan list generated is : " + randomInt);
		}
		return RandomLoanList;
	}

}
