/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False
*/
class DetectCapital {
    public boolean detectCapitalUse(String word) {
      //convert String to char array
        char[] charArray = word.toCharArray();
        boolean status = Character.isUpperCase(charArray[0]);
        if(status){
            status = checkIfAllAreUpperCase(charArray);
            if(!status){
                status = checkIfAllAreLowerCase(charArray,true);
            }
        }else{
            status = checkIfAllAreLowerCase(charArray,false);
        } 
        return status;
    }
    public boolean checkIfAllAreLowerCase(char[] charArray,boolean skipFirst){
        for(int i=0; i < charArray.length; i++){
            if( skipFirst && i == 0){
                
            }else{
                //if any character is not in lower case, return false
                if(!Character.isLowerCase( charArray[i] )){
                    return false;
                }        
            }
        }
        return true;
    }
    
    public boolean checkIfAllAreUpperCase(char[] charArray){
        boolean status = false;
        for(int i=0; i < charArray.length; i++){
            //if any character is not in upper case, return false
            if(!Character.isUpperCase( charArray[i] )){
                return false;
            }    
        }
        return true;
    }
}
