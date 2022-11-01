package com.b.simple.design.business.text;

public class TextHelper {

    //My first version of method
//    public String swapLastTwoCharacters(String str) {
//        if (str.length() >= 2) {
//            StringBuilder result = new StringBuilder("");
//            for (int i = 0; i < str.length() - 2; i++) {
//                result.append(str.charAt(i));
//            }
//            result.append(str.charAt(str.length() - 1));
//            result.append(str.charAt(str.length() - 2));
//            return result.toString();
//        } else return str;
//    }

    //My second version of method
    public String swapLastTwoCharacters(String str) {
        if (str.length() < 2) return str;

        int length = str.length();
        char lastCharacter = str.charAt(length - 1);
        char beforeLastCharacter = str.charAt(length - 2);
        String restOfString = str.substring(0, length - 2);
        return restOfString + lastCharacter + beforeLastCharacter;

    }

    //My first version of method
//    public String truncateAInFirst2Positions(String str) {
//        if (str.length() >= 2) {
//            if (str.charAt(0) != 'A' && str.charAt(1) != 'A') {
//                return str;
//            } else {
//                if (str.charAt(0) == 'A' && str.charAt(1) == 'A') {
//                    return str.substring(2);
//                } else if (str.charAt(0) == 'A' && str.charAt(1) != 'A') {
//                    return str.substring(1);
//                } else if (str.charAt(0) != 'A' && str.charAt(1) == 'A') {
//                    return str.charAt(0) + str.substring(2);
//                }
//            }
//        } else if (str.length() == 1){
//            if (str.charAt(0) == 'A'){
//                return str.substring(1);
//            }
//        }
//        return str;
//    }
    //My second version of method:
//    public int returnPositionOfAInString(String str) {
//        if (str.length() >= 2) {
//            if (str.charAt(0) == 'A' && str.charAt(1) == 'A') return 2;
//            else if (str.charAt(0) == 'A') return 0;
//            else if (str.charAt(1) == 'A') return 1;
//        } else if (str.length() == 1) {
//            if (str.charAt(0) == 'A') return 0;
//        } else return -1;
//        return -1;
//    }
//
//    public String truncateAInFirst2Positions(String str) {
//        int position = returnPositionOfAInString(str);
//        if (position == 0) return str.substring(1);
//        else if (position == 1) return str.charAt(0) + str.substring(2);
//        else if (position == 2) return str.substring(2);
//        return str;
//    }

    //MY THIRD VERSION OF METHOD :
    public String truncateAInFirst2Positions(String str){
        if (str.length() < 2) return str.replaceAll("A","");
        String first2Characters = str.substring(0,2);
        String first2CharactersUpdated = first2Characters.replaceAll("A", "");
        String restOfString = str.substring(2);
        return first2CharactersUpdated + restOfString;
    }

}
