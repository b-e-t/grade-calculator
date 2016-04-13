import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class:	Course
 * Purpose:	This class will model a course
 * Author:	Brian Thompson
 * Date:	March 5, 2016
 * Data:	private String courseName
 * 			private String studentName
 * 			private int numCategories
 * 			private LinkedList<GradeCategory> allGrades
 * Methods: processCourseFile - Method to process course file (boolean return true if successful, false if fail)
 * 			processStudentFile - Method to process student file (boolean return true if successful, false if fail)
 * 			displayFinalGrade - Method to display final grade
 */
public class Course {

	private String courseName;
	private String studentName;
	private int numCategories;
	private ArrayList<GradeCategory> allGrades;
	
	public Course(){
		courseName = "Void";
		studentName = "Void";
		numCategories = 0;
		allGrades = new ArrayList<GradeCategory>();
	}//end constructor
	
	/**Method to process course file*/
	public boolean processCourseFile(Scanner courseFile){
		if(courseFile.hasNext()){
			courseName = courseFile.next();
		}
		else{
			System.out.println("Error processing course name. Exiting.");
			return false;
		}//end process courseName
		
		if(courseFile.hasNextInt()){
			numCategories = courseFile.nextInt();
			if(numCategories<0){
				System.out.println("Error processing number of categories. Exiting.");
				return false;
			}
		}
		else{
			System.out.println("Error processing number of categories. Exiting.");
			return false;
		}//end process numCategories
		
		for(int i=0; i<numCategories; i++){
			GradeCategory category = new GradeCategory();
			if(category.processCourseFile(courseFile)==false){
				return false;
			}
			allGrades.add(category);
		}//end process and add category
		
		return true;
	}//end processCourseFile
	
	/**Method to process student file*/
	public boolean processStudentFile(Scanner studentFile){
		if(studentFile.hasNext()){
			studentName = studentFile.next();
		}
		else{
			System.out.println("Error processing student name. Exiting.");
			return false;
		}//end process studentName
		
		for(int i=0; i<numCategories; i++){
			if(allGrades.get(i).processStudentFile(studentFile)==false){
				return false;
			}
		}//end pass studentFile
		
		if(studentFile.hasNextFloat()){
			System.out.println("Error processing " +studentName +". Exiting.");
			return false;
		}//check if OK to move to next student

		return true;
	}//end processStudentFile
	
	/**Method to display final grade*/
	public void displayFinalGrade(){
		float finalGrade=0;
		System.out.println("Grades for " +studentName +" in " +courseName);
		for(int i=0; i<numCategories; i++){
			finalGrade += allGrades.get(i).displayGrade();
		}
		System.out.println("Final Grade: " +finalGrade);
	}//end displayFinalGrade
	
}//end class Course
