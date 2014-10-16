package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
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



}