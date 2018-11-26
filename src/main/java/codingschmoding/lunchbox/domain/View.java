package codingschmoding.lunchbox.domain;

public class View {
	public interface QuestionFilter {}

	public interface QuestionTypeFilter {}
	
	public interface ResponseFilter {}
	
	public interface SurveyFilter {}
	
	public interface UserFilter {}
	
	public interface ResponseSumFilter extends ResponseFilter {}
	
	public interface QuestionSumFilter extends QuestionFilter, SurveyFilter, QuestionTypeFilter {}
}
