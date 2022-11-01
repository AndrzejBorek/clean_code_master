package com.b.simple.design.business.student;

public class StudentHelper {


    private static final int GRADE_B_LOWER_LIMIT = 51;
    private static final int GRADE_B_UPPER_LIMIT = 80;
    private static final int EXTRA_FOR_MATH = 10;
    /* PROBLEM 1 */
    /*
     * You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
     */
    //FIRST VERSION:
    //    public boolean isGradeB(int marks, boolean isMaths) {
    //        return isMaths ? marks >= 51 && marks <= 90 : marks >= 51 && marks <= 80;
    //    }
    //FIXED VERSION:

    public boolean isGradeB(int marks, boolean isMaths) {
        int extra = isMaths ? EXTRA_FOR_MATH : 0;
        int upperLimit = GRADE_B_UPPER_LIMIT + extra;
        return marks >= GRADE_B_LOWER_LIMIT && marks <= upperLimit;
    }
    /* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/
    //FIRST VERSION
    //    public String getGrade(int mark, boolean isMaths) {
    //        String grade = "C";
    //
    //        if (isGradeA(mark, isMaths))
    //            grade = "A";
    //        else if (isBGrade(mark, isMaths)) {
    //            grade = "B";
    //        }
    //        return grade;
    //    }

    //FIXED VERSION
    public String getGrade(int mark, boolean isMaths) {
        int extraLimit = isMaths ? 5 : 0;
        if (mark >= 91 + extraLimit)
            return "A";
        if (mark >= 51 + extraLimit)
            return "B";
        return "C";
    }


    //THOSE @ METHODS ARE NOT NEEDED :
//    private boolean isGradeA(int mark, boolean isMaths) {
//        int lowerLimitForAGrade = isMaths ? 95 : 90;
//        return mark > lowerLimitForAGrade;
//    }


//    private boolean isBGrade(int mark, boolean isMaths) {
//        int lowerLimitGradeB = isMaths ? 55
//                : 50;
//        return mark > lowerLimitGradeB && mark < 90;
//    }

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     *
     * Return value can be YES, NO or MAYBE.
     *
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     *
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     *
     * marks1 - your marks
     * marks2 - your friends marks
     */

    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {

        if (isNotGood(marks1, isMaths) || isNotGood(marks2, isMaths)) return "NO";
        if (isGood(marks1, isMaths) || isGood(marks2, isMaths)) return "YES";
        return "MAYBE";
    }

    private static boolean isGood(int marks1, boolean isMaths) {
        int extraLimit = isMaths ? 5 : 0;
        return marks1 >= 80 + extraLimit;
    }

    private static boolean isNotGood(int marks1, boolean isMaths) {
        int extraLimit = isMaths ? 5 : 0;
        return marks1 <= 20 + extraLimit;
    }

}