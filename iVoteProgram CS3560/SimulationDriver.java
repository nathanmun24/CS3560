import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

public class SimulationDriver {

	private static Random rand = new Random(); // Random object so I dont recreate one each time the generate functions are used

	private static ArrayList<String> generateRandomMultipleChoice(String [] choices){
		int choicesAmount = rand.nextInt(choices.length) + 1; // Random amount of selected answers
		HashSet<String> answers = new HashSet<>(); // Ensuring the amount of selected answers are the same
		ArrayList<String> submissions = new ArrayList<>(); // What will be returned for the submission method of VotingService class

		for(int i = 0; i < choicesAmount; i++){
			int choiceIndex = rand.nextInt(choices.length); // Random choice

			if(answers.contains(choices[choiceIndex])){ // If the choice was already selected, must choose again
				while(answers.contains(choices[choiceIndex])){
					choiceIndex = rand.nextInt(choices.length); // Get a new answer until it isnt seen in the set
				}
			}
			answers.add(choices[choiceIndex]); // Add the answer to the set
		}
		for(String s : answers){ // Put the answers into the ArrayList to be returned
			submissions.add(s);
		}

		return submissions;
	}

	private static String generateRandomSingleChoice(String[] choices){
		int choiceIndex = rand.nextInt(choices.length); // A random choice
		
		return choices[choiceIndex];
	}

	public static void main(String[] args) {
		System.out.println("iVote Simulator By N. Munoz");
		System.out.println();

		String[] options = {"A", "B", "C", "D"}; // For my application I decided on making four options for each question for both single and multiple choice
		int studentAmount = rand.nextInt(1, 101); // Random amount of students
		ArrayList<Student> students = new ArrayList<>(); // Array of students to hold the random amount of students

		for(int i = 0; i < studentAmount; i++){ // Creating student objects and storing them in the students array
			students.add(new Student());
		}
		// Creating the random question, its about my favorite anime
		Question question1 = new SingleChoiceQuestion("What is your favorite One Piece character?", new HashMap<>(Map.of("A", "Luffy", "B", "Chopper", "C", "Zoro", "D", "Sanji")));

		// Creating VotingService object for given question
		VotingService query = new VotingService(question1);

		for(Student s : students){
			if(question1 instanceof SingleChoiceQuestion){
				query.submission(s.getId(), generateRandomSingleChoice(options));
				if(Integer.parseInt(s.getId()) % 2 == 0){ // This is to incorporate some multiple submission cases for the part about taking the most recent submission
					query.submission(s.getId(), generateRandomSingleChoice(options));
				}
			}

			else{
				ArrayList<String> studentAnswers = generateRandomMultipleChoice(options);
				String finalAnswer = String.join(" ", studentAnswers); // Will give the multiple answers to VotingService class as a String of the answers seperated by spaces

				query.submission(s.getId(), finalAnswer);

				if(Integer.parseInt(s.getId()) % 2 == 0){ // This is to incorporate some multiple submission cases for the part about taking the most recent submission
					ArrayList<String> studentAnswers2 = generateRandomMultipleChoice(options);
					String finalAnswer2 = String.join(" ", studentAnswers2); // Will give the multiple answers to VotingService class as a String of the answers seperated by spaces

					query.submission(s.getId(), finalAnswer2);
				}
			}
		}

		query.displayQuestion();
		query.displayResult();
	}
}
