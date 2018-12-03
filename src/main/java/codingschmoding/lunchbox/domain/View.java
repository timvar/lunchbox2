package codingschmoding.lunchbox.domain;

public class View {
	public interface QuestionFilter {}
	
	public interface QuestionSumFilter {} 

	public interface QuestionTypeFilter {}
	
	public interface QuestionOptionFilter {}
	
	public interface ResponseFilter {}
	
	public interface SurveyFilter {}
	
	public interface UserFilter {}
	
	public interface ResponseSumFilter extends ResponseFilter, QuestionFilter {}
	
	public interface QuestionRestFilter extends QuestionSumFilter, QuestionFilter, SurveyFilter, QuestionTypeFilter, QuestionOptionFilter, UserFilter {} 
	
	public interface QuestionOptionRestFilter extends QuestionOptionFilter, QuestionFilter {}
}
