class ReverseString {

    String reverse(String inputString) {
    	
    	String returnString = "";
    	boolean inputNotEmpty = !(inputString == null) && !(inputString.equals(""));
    	
        if(inputNotEmpty) {
        	for(char c: inputString.toCharArray()) {
        		returnString = c + returnString;
        	}
        }
        
        return returnString;
    }
}