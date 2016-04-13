import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class: Assign3
 * Purpose: Contains method main, opens and reads from a file, handles any errors
 * Author: Brian Thompson
 * Date: March 5, 2016
 * Data: fileIn: Scanner - load a file through Scanner
 * Methods: main
 */
public class Assign3 {

	public static void main(String[] args){
		String file;
		Scanner input = new Scanner(System.in);
		boolean badFile = false;
		Course course = new Course();
		
		//GET COURSE FILE NAME*************************************************
		System.out.print("Enter name of course file to process: ");
		file = input.nextLine();
		try(Scanner courseFile = new Scanner(new File(file))){
			if(course.processCourseFile(courseFile)==false){
				badFile = true;
			}
		}catch(FileNotFoundException e){
			System.out.println("The file was not found. Program terminating.");
			badFile = true;
		}//end catch
		
		//GET STUDENT FILE NAME********************************************
		if(!badFile){
			System.out.print("\nEnter name of student file to process: ");
			file = input.nextLine();
			try(Scanner studentFile = new Scanner(new File(file))){
				while(studentFile.hasNextLine()){
					if(course.processStudentFile(studentFile)==false){
						badFile = true;
						break;
					}
					System.out.println();
					course.displayFinalGrade();
				}
			}catch(FileNotFoundException e){
				System.out.println("The file was not found.Program terminating.");
				badFile = true;
			}//end catch
		}//end if file OK
		input.close();
	}//end main
}//end class Assign3
