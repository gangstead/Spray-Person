import java.util.regex.Pattern;


public class PoBoxRegTest {

	/**
     * Patterns are greatest things in Java. The following pattern can identify the Post Box
     */
    static final String thePattern =
"([\\w\\s*\\W]*(P(OST)?.?\\s*((O(FF(ICE)?)?)?.?\\s*(B(IN|OX|.?))|B(IN|OX))+))[\\w\\s*\\W]*";   
     
    /**
     *
     * @param str - PO Box string to validate
     * @return if the input string is a valid PO Box format.
     */
    public static boolean isValid(String str) {
        return Pattern.matches(thePattern, str);
    }
 
    public static void main (String [] args ) {
        /**
         * Doing unit test with several different PO Box usage alterations.
         */
        String [] itemsToValidate = {
                "PO Box",
                "P O Box",
                "P. O. Box",
                "P.O.Box",
                "Post Box",
                "Post Office Box 429",
                "Post Office",
                "P.O.B",
                "P.O.B.",
                "POB",
                "Post Office Bin",
                "Box",
                "Bin",
                "Post",
                "Postal Code",
                "100,, P O Box Des Moines",
                " P O Box DesMoines1000",
                " P O Box Des Moines 1000",
                " Post Office Box",
                " Post Office Box  ",
                "Post Box #"};                                      
 
        for (int index = 0; index < itemsToValidate.length; index++) {
            String item = itemsToValidate[index];
            boolean isValid = isValid(itemsToValidate[index].toUpperCase());
            System.out.println(item + " : " + (isValid ? "Valid" : "Invalid"));
        }
    }

}
