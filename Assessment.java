import java.util.Scanner;

/**
 * Class:	Course
 * Purpose:	This class will model a single assessment with its grade
 * 			and what that assessment is out of in any category
 * Author:	Brian Thompson
 * Date:	March 5, 2016
 * Data:	private String assessmentName
 * 			private float gradeReceived
 * 			private float outOfGrade
 * Methods: processCourseFile - Method to process courseFile (boolean return true if successful, false if fail)
 * 			processStudentFile - Method to process studentFile (boolean return true if successful, false if fail)
 * 			calculateGrade - Method to calculate grade (float return calculated grade)
 */
public class Assessment {

	@SuppressWarnings("unused")
	private String assessmentName;
	private float gradeReceived;
	private float outOfGrade;
	
	public Assessment(){
		assessmentName = "Void";
		gradeReceived = 0;
		outOfGrade = 0;
	}//end constructor
	
	/**Method to process courseFile*/
	public boolean processCourseFile(Scanner courseFile){
		if(courseFile.hasNext()){
			assessmentName = courseFile.next();
		}
		else{
			System.out.println("Error processing assessment name. Exiting.");
			return false;
		}//end process assessmentName
		
		if(courseFile.hasNextFloat()){
			outOfGrade = courseFile.nextFloat();
			if(outOfGrade<0){
				System.out.println("Error processing out of grade. Exiting");
				return false;
			}
		}
		else{
			System.out.println("Error processing out of grade. Exiting");
			return false;
		}//end process outOfGrade
		return true;
	}//end processCourseFile
	
	/**Method to process studentFile*/
	public boolean processStudentFile(Scanner studentFile){
		if(studentFile.hasNextInt()){
			gradeReceived = studentFile.nextInt();
			if(gradeReceived<0){
				System.out.println("Error processing grade received. Exiting.");
				return false;
			}
		}
		else{
			System.out.println("Error processing grade received. Exiting.");
			return false;
		}//end process gradeReceived
		return true;
	}//end processStudentFile
	
	/**Method to calculate grade*/
	public float calculateGrade(){
		return gradeReceived/outOfGrade;
	}//end calculateGrade
	
}//end class Assessment
