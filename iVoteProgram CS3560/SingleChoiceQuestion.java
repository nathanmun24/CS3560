import java.util.HashMap;

// This class is to make the internal representation to be SingleChoiceQuestion for the driver class
public class SingleChoiceQuestion extends Question{
	public SingleChoiceQuestion(String question, HashMap<String, String> answers){
		super(question, answers);
	}
}
