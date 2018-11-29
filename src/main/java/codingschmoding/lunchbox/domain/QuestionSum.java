package codingschmoding.lunchbox.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

public class QuestionSum {
	
	@JsonView(View.QuestionSumFilter.class)
	private long questionId;
	
	@JsonView(View.QuestionSumFilter.class)
	private String questionContent;
	
	@JsonView(View.QuestionSumFilter.class)
	private boolean questionOptionExist;

	@JsonView(View.QuestionSumFilter.class)
	private QuestionType questionType;

	@JsonView(View.QuestionSumFilter.class)
	private Survey survey;
	
	@JsonView(View.QuestionSumFilter.class)
	private List<QuestionOption> questionOptions;
	
	

	public QuestionSum() {
		super();
	}



	public QuestionSum(long questionId, String questionContent, boolean questionOptionExist, QuestionType questionType,
			Survey survey, List<QuestionOption> questionOptions) {
		super();
		this.questionId = questionId;
		this.questionContent = questionContent;
		this.questionOptionExist = questionOptionExist;
		this.questionType = questionType;
		this.survey = survey;
		this.questionOptions = questionOptions;
	}



	public long getQuestionId() {
		return questionId;
	}



	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}



	public String getQuestionContent() {
		return questionContent;
	}



	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}



	public boolean isQuestionOptionExist() {
		return questionOptionExist;
	}



	public void setQuestionOptionExist(boolean questionOptionExist) {
		this.questionOptionExist = questionOptionExist;
	}



	public QuestionType getQuestionType() {
		return questionType;
	}



	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}



	public Survey getSurvey() {
		return survey;
	}



	public void setSurvey(Survey survey) {
		this.survey = survey;
	}



	public List<QuestionOption> getQuestionOptions() {
		return questionOptions;
	}



	public void setQuestionOptions(List<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}




}
