import java.util.HashMap;

// This class is to make the internal representation to be MultipleChoiceQuestion for the driver class
public class MultipleChoiceQuestion extends Question{

	public MultipleChoiceQuestion(String question, HashMap<String, String> answers){
		super(question, answers);
	}
}
