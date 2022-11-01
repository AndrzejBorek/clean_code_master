package com.c.refactoring.movie;

import com.c.refactoring.StringUtils;

public class Movie {

    private final int VALID_LENGTH_OF_B_RATING = 2;

    private final int VALID_LENGTH_OF_A_RATING = 3;
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

        if (this.getRating() != null) {
            if (isBRating(this.getRating())) {
                return isValidBRating(this.getRating());
            } else return isValidARating(this.getRating());

        }
        return false;
    }

    public boolean isValidBRating(String str) {
        String toCheck = str.substring(1, 2);
        return StringUtils.isNumeric(toCheck)
                && Integer.parseInt(toCheck) > 0
                && Integer.parseInt(toCheck) < 5;
    }

    public boolean isBRating(String str) {
        return str.substring(0, 1).equalsIgnoreCase("B")
                && str.length() == VALID_LENGTH_OF_B_RATING;
    }

    public boolean isValidARating(String str) {
        return str.substring(0, 1).equalsIgnoreCase("A")
                && str.length() == VALID_LENGTH_OF_A_RATING
                && StringUtils.isNumeric(str.substring(1, 3));
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
