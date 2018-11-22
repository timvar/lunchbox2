package codingschmoding.lunchbox.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Question {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@JsonView(View.Summary.class)
	private long questionId;
	
	private String question;
	private boolean questionOptionExist;
	
	@ManyToOne
    @JoinColumn(name = "questionTypeId")
	@JsonView(View.Summary.class)
	private QuestionType questionType;
	
	@ManyToOne
    @JoinColumn(name = "surveyId")
	@JsonView(View.Summary.class)
	private Survey survey;
	
	@OneToMany
	@JsonIgnore
	private List<Question> questions;

	public Question() {
		super();
	}

	public Question(String question, QuestionType questionType, boolean questionOptionExists, Survey survey) {
		super();
		this.question = question;
		this.questionType = questionType;
		this.questionOptionExist = questionOptionExists;
		this.survey = survey;
	}



	public long getQuestionId() {
		return questionId;
	}



	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public QuestionType getQuestionType() {
		return questionType;
	}



	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}


	public boolean isQuestionOptionExist() {
		return questionOptionExist;
	}

	public void setQuestionOptionExist(boolean questionOptionExist) {
		this.questionOptionExist = questionOptionExist;
	}

	public List<Question> getQuestions() {
		return questions;
	}



	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}	
	
	
	
	
	
	
}
