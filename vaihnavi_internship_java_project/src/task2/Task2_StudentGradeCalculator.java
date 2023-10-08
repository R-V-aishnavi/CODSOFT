package task2;



/**
 *
 * @author Vaishnavi R
 */
                            // Task- 2: Student Grade Calculator

import java.util.Scanner;

public class Task2_StudentGradeCalculator 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int num = sc.nextInt();

        int[] marks = new int[num];
        int totalMarks = 0;

        for (int i = 0; i < num; i++)
        {
            System.out.print("Enter marks obtained in Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / (num * 100) * 100;

        System.out.println("Result:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + averagePercentage + "%");

        String grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);
        

        sc.close();
    }

    public static String calculateGrade(double percentage)
    {
        if (percentage>= 90) 
        {
            return " A+ ";
        }
        else if (percentage>= 80)
        {
            return " A ";
        }
        else if (percentage>= 70)
        {
            return " B ";
        }
        else if (percentage>= 60)
        {
            return " C ";
        } 
        else if (percentage>= 50) 
        {
            return " D ";
        } 
        else 
        {
            return " F ";
        }
    }
}

