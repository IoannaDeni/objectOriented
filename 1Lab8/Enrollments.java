/**
 * This minilab will be showing the resylts of statistical analysis on the enrollment in courses 
 * required for the CS major over the past 4 years.
 * 
 * @author Ioanna Deni 
 * @version 24th April 2017
 */
public class Enrollments
{   
    //This is an array that holds the name of the courses as the numbers
    private static int[] courses = {101, 201, 211, 221, 312, 322};

    //This is an array that holds the two semester of the last four years in Mount Holyoke College 
    private static String [] years = {"S'13", "F'14", "S'14", "F'15", "S'15", "F'16", "S'16", "F'17"};

    //This is a 2D array holding all enrolments for the two semester of each year for the last 4 years 
    private static int[][] enrollmentData =
        { {32, 30, 36, 51, 71, 51, 63, 60},
            {22, 18, 27, 29, 35, 48, 37, 40},
            {11, 22, 12, 18, 20, 28, 39, 35},
            { 0, 21, 0, 27, 8, 26, 18, 28},
            { 0, 22, 0, 25, 0, 27, 23, 25},
            {12, 0, 17, 0, 24, 0, 22, 0}};

    /**
     * This is instead of a begin method so for the program to print the statistical data 
     * we will have to call this method.
     */
    public static void main (String[] args) {
        Enrollments enrollments = new Enrollments();

        //Here we call all the methods.
        enrollments.calculateTotal ();
        enrollments.calculateCourseTotal (0);
        enrollments.calculateSemesterTotal (0);
        enrollments.report (4, 3);
    }

    /**
     * This should take 2 parameters, a course index and a semester index
     * and will look up the enrollment for a single offering of a particular course. 
     */
    public void report (int theCourse, int theSemester)
    {
        //First all the indexes as checked

        for (int lesson = 0; lesson < courses.length; lesson++) {

            //For every single index in the course array if the course number is equal to the course number given 
            //go through every single semester in the semester array
            if ( courses[lesson] == courses[theCourse])
            {
                //Here we create a local variable that holds the position of the course
                int courseNum = lesson;

                //for every single semester in the semester array 
                for (int time = 0; time < years.length; time++) {

                    if (years[time] == years[theSemester])
                    {
                        //Here we create a local variable that holds the position of the course
                        int semesterNum = time;

                        System.out.println ("The enrollment in 312 in Sprint 2015 is " + enrollmentData [courseNum][semesterNum] + "!" );
                    }
                }
            }
        }
    }

    /**
     * Total of all courses over all semesters 
     */
    private void calculateTotal () {
        //first initialize total to zero
        int total = 0 ;

        for (int i = 0; i < courses.length; i++) {

            //For every single index in the course array go through every single semester in the semester array and add all enrollmentData to totall
            for (int j = 0; j < years.length; j++) {

                //here we give value to the total
                total = enrollmentData [i][j] + total;
            }
        }

        System.out.println ("The total enrollment for CS across all semesters is " + total + "! Yeah!");
    }

    /**
     * This method gives the total enrolment of one course over all semesters. This method
     *  should take a course index (a number between 0 and 5). 
     */
    private void calculateCourseTotal(int theCourse)
    {
        //Here we initialize the total of the enrollment of all semesters for that specified course
        int total = 0;

        for (int i = 0; i < courses.length; i++) {

            //For every single index in the course array go through every single semester in the semester array and add all enrollmentData to totall
            if ( courses[i] == courses[theCourse])
            {
                //for every single semester in the semester array 
                for (int j = 0; j < years.length; j++) {

                    //Here we keep adding to the total
                    total = enrollmentData [theCourse][j] + total;
                }
            }
        }
        
        System.out.println ("The total enrollment for 101 across all semesters is " + total + "!");
    }
    
    /**
     * This method gives the total of all courses over one semester. This method 
     * should take a semester index (a number between 0 and 7). 
     */
    private void calculateSemesterTotal(int theSemester)
    {
        //Here we initialize the total of the enrollment of all enrollment in all courses for that specified semester
        int total = 0;

        for (int i = 0; i < years.length; i++) {

            //For every single index in the years array go through every single course and add all enrollmentData to totall
            if ( years[i] == years[theSemester])
            {
                //for every single course in the semester array 
                for (int j = 0; j < courses.length; j++) {

                    //Here we keep adding to the total
                    total = enrollmentData [j][theSemester] + total;
                }
            }
        }

        System.out.println ("The total enrollment for Spring 2013 across all courses is " + total + "!");
    }
}
