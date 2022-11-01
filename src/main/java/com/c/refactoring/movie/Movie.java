package com.c.refactoring.movie;

import com.c.refactoring.StringUtils;

public class Movie {

    String rating;

    public Movie(String rating) {
        super();
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    /*Axx or By
    Where x represents any digit between 0 and 9, and y represents 
    any digit between 1 and 4*/


    public boolean isValidRating() {

        if (this.getRating() == null)
            return false;
        if (isValidARating(this.getRating()))
            return true;
        return isValidBRating(this.getRating());
    }

    public boolean isBRating(String str) {
        int validLengthOfBRating = 2;
        return str.substring(0, 1).equalsIgnoreCase("B")
                && str.length() == validLengthOfBRating;
    }

    public boolean isValidBRating(String str) {
        String toCheck = str.substring(1, 2);
        return this.isBRating(str) && StringUtils.isNumeric(toCheck)
                && Integer.parseInt(toCheck) > 0
                && Integer.parseInt(toCheck) < 5;
    }


    public boolean isARating(String str) {
        int validLengthOfARating = 3;
        return str.substring(0, 1).equalsIgnoreCase("A")
                && str.length() == validLengthOfARating;
    }

    public boolean isValidARating(String str) {
        return this.isARating(str)
                && StringUtils.isNumeric(rating.substring(1, 3));
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
