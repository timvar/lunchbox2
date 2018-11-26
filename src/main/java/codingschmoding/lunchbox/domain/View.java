package codingschmoding.lunchbox.domain;

public class View {
	public interface QuestionFilter {}

	public interface QuestionTypeFilter {}
	
	public static class ResponseFilter {}
	
	public interface SurveyFilter {}
	
	public static class UserFilter {}
	
	public static class ResponseSumFilter extends ResponseFilter {}
	
	public interface QuestionSumFilter extends QuestionFilter, SurveyFilter, QuestionTypeFilter {}
}
