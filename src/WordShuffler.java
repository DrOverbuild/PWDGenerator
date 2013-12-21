/**
 * Created by jasper on 12/20/13.
 * Copyright (c) Jasper Reddin (AKA tenny1028) 2013
 */

import java.util.Random;
public class WordShuffler {

/*

Start up a generator
Find the length of the input string called length
Start up a character Array called outputArray
Convert the input string into a character array called inputToArray
Start up a boolean array the same length as the character array called isTakenArray
Set all values in isTakenArray to false

For each character in the string...
	Take the character and call it character
	reserve an int named place
	do this...
		Set place to a generated random number from 0 to length
		Assign the character to place in outputArray
		Set isTakenArray[place] to true
	while isTakenArray[place] is not true
Convert the outputArray to a String named outputStr
Return outputStr

*/

	public static String shuffle(String input){
		Random gen = new Random();
		int length = input.length();
		char[] outputArray = new char[length];
		char[] inputToArray = input.toCharArray();
		boolean[] isTakenArray = new boolean[length];
		int lengthPlusOne = length++;
		for (int i=0;i<lengthPlusOne;i++) {
			isTakenArray[i]=false;
		}

		for (int i=0;i<lengthPlusOne;i++) {
			char character = inputToArray[i];
			int place = gen.nextInt(length-1);
			while (true) {
				if (!isTakenArray[place]) {
					outputArray[place] = character;
					isTakenArray[place] = true;
					break;
				}else{
					place = gen.nextInt(length-1);
				}
			}
		}

		String outputStr = new String(outputArray);
		return outputStr;

	}

}