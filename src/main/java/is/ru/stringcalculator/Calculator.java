package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("//")){
			return sum(findDeliminater(text));
		}
		
		if(text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}
		
		else{
			return toInt(text);
		}
		
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    String newString = numbers.replaceAll("\n", ",");
	    //http://stackoverflow.com/questions/14305593/how-to-split-a-string-with-multiple-delimiters-in-java
	    return newString.split(",");
	    
	}
	
	private static String[] splitNumbersNewLine(String number){
		return number.split("\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
		}
    
    private static String[] findDeliminater(String text){
    	Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(text);
    	m.matches();
    	String delimiter = m.group(1);
    	String numbers = m.group(2);
    	return splitNumbers(numbers, delimiter);
    }
    private static String[] splitNumbers(String numbers, String delimiter)
    {
    	return numbers.split(delimiter);
    }
    
    


}