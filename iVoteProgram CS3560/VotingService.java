import java.util.HashMap;

public class VotingService{
	private Question question; // The given question type
	private HashMap<String, String> answers; // Dictionary for answers from students, only keeps last submission
	private HashMap<String, Integer> results; // This is to store the results where String will be the key and the value will be the amount of times that choice is chosen
	

	public VotingService(Question question){ // Initalizes the dictionary, and sets the question which holds the String question and ArrayList of possible answers
		this.question = question;
		answers = new HashMap<>();
		results = new HashMap<>();
	}

	public void submission(String ID, String response){ // Takes in the submissions from the students, and stores them in a HashMap with the student ID as the key
		answers.put(ID, response);
	}

	private void calculateResults(){
		for(String studentAnswers : answers.values()){ // Traverse through the answers given by the students
			String[] finalAnswers = studentAnswers.split(" "); // Splitting the answers by space for cases of multiple choice answers
			for(String s : finalAnswers){
				results.put(s, results.getOrDefault(s, 0) + 1); // Will add a new option or increment the amount of times it has been selected
			}
		}
	}

	public void displayQuestion(){ // Display the question and possible choices
		System.out.print(question.question);
		if(question instanceof MultipleChoiceQuestion){ // Displays question type with question
			System.out.println(" (Select multiple choices.)");
		}
		else{
			System.out.println(" (Select a single choice.)");
		}

		System.out.println();
		question.answers.forEach((k, v)-> { // Traverses through each key and value of the question answers dictionary
			System.out.println(k + ": " + v);
		});
	}

	public void displayResult(){
		System.out.println();
		System.out.println("Results are: ");
		calculateResults();
		results.forEach((k, v) -> { // Traverses through each key and value of the answers dictionary
			System.out.print(k + ": " + v + "   ");
		});
	}






}
