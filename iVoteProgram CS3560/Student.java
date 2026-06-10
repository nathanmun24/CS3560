
public class Student{
	private String id; // ID will be created when student object is declared
	private static int counter = 1000; // This is a static counter to assign to a student and is incremented after a student object is created

	public Student(){
		this.id = Integer.toString(counter); // Converted the counter to a string to meet project specifications of id being string type
		counter++;
	}

	public String getId(){ // Returns the id of a student
		return id;
	}
	
}