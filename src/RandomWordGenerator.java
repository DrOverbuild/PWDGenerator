/**
 * Created by jasper on 12/20/13.
 * Copyright (c) Jasper Reddin (AKA tenny1028) 2013
 */

import java.util.ArrayList;
import java.util.Random;

public class RandomWordGenerator {
	public static Random intGenerator = new Random();

	public static String nextWord(int length, boolean includeCaps,boolean includeLowerCase,boolean includeNumbers){

		String word = "";
	    // c for Caps
		// l for Lowercase
		// n for Numbers
		ArrayList<String> charTypes = new ArrayList();
		if(includeCaps){
			charTypes.add("c");
		}
		if(includeLowerCase){
			charTypes.add("l");
		}
		if(includeNumbers){
			charTypes.add("n");
		}

		for(int i=0;i<=length;i++){

			String charType = charTypes.get(intGenerator.nextInt(charTypes.size()));
			System.out.println(charType);
			char charType2 = charType.charAt(0);

			//x = minRange
			//y = maxRange

			//nextInt(y-x) + x;
			switch (charType2){
				case 'c':
					int char1 = intGenerator.nextInt(90-65) + 65;
					char char2 = (char) char1;
					word+=char2;
					break;
				case 'l':
					int char3 = intGenerator.nextInt(122-97) + 97;
					char char4 = (char) char3;
					word+= char4;
					break;
				case 'n':
					int char5 = intGenerator.nextInt(57-48) + 48;
					char char6 = (char) char5;
					word+= char6;
					break;
			}

		}
		return word;

	}

}
