import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class:	GradeCategory
 * Purpose:	This class will model a single category in a grade calculation
 * Author:	Brian Thompson
 * Date:	March 5, 2016
 * Data:	private String categoryName
 * 			private float categoryWeight
 * 			private int numAssessments
 * 			private LinkedList<Assessment> assessments
 * Methods: processCourseFile - Method to process courseFile (boolean return true if successful, false if fail)
 * 			processStudentFile - Method to process studentFile (boolean return true if successful, false if fail)
 * 			displayGrade - Method to display grade from each category (float return total)
 */
public class GradeCategory {

	private String categoryName;
	private float categoryWeight;
	private int numAssessments;
	private LinkedList<Assessment> assessments;
	
	public GradeCategory(){
		categoryName = "Void";
		categoryWeight = 0;
		numAssessments = 0;
		assessments = new LinkedList<Assessment>();
	}//end constructor
	
	/**Method to process courseFile*/
	public boolean processCourseFile(Scanner courseFile){
		if(courseFile.hasNext()){
			categoryName = courseFile.next();
		}
		else{
			System.out.println("Error processing category name. Exiting.");
			return false;
		}//end process categoryName
		
		if(courseFile.hasNextFloat()){
			categoryWeight = courseFile.nextFloat();
			if(categoryWeight<0){
				System.out.println("Error processing category weight. Exiting.");
				return false;
			}
		}
		else{
			System.out.println("Error processing category weight. Exiting.");
			return false;
		}//end process categoryWeight
		
		if(courseFile.hasNextInt()){
			numAssessments = courseFile.nextInt();
			if(numAssessments<0){
				System.out.println("Error processing number of assessments. Exiting.");
				return false;
			}
		}
		else{
			System.out.println("Error processing number of assessments. Exiting.");
			return false;
		}//end process numAssessments
		
		for(int i=0; i<numAssessments; i++){
			Assessment assessment = new Assessment();
			if(assessment.processCourseFile(courseFile)==false){
				return false;
			}
			assessments.add(assessment);
		}
		return true;
	}//end processCourseFile
	
	/**Method to process studentFile*/
	public boolean processStudentFile(Scanner studentFile){
		for(int i=0; i<numAssessments; i++){
			if(assessments.get(i).processStudentFile(studentFile)==false){
				return false;
			}
		}
		
		return true;
	}//end processStudentFile
	
	/**Method to display grade from each category*/
	public float displayGrade(){
		float assessmentTotal=0;
		for(int i=0; i<numAssessments; i++){
			assessmentTotal += assessments.get(i).calculateGrade();
		}
		assessmentTotal = (assessmentTotal * categoryWeight) / numAssessments;
		System.out.println(categoryName +" " +assessmentTotal +" / " +categoryWeight);
		return assessmentTotal;
	}//end displayGrade
	
}//end class GradeCategory
