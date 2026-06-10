
import java.util.HashMap;
public abstract class Question{
	protected String question; // The given question
	protected HashMap<String, String> answers; // A list of the answers

	public Question(String question, HashMap<String, String> answers){
		this.question = question;
		this.answers = answers;
	}

	/** This method gets the string question from the question object
	 * @return String the question
	 */
	public String getQuestion(){
		return question;
	}

	/** This method gets the list of answers from the question object
	 * @return ArrayList<String> the answers
	*/
   public HashMap<String, String> getAnswers(){
		return answers;
   }

}
