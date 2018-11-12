package codingschmoding.lunchbox.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String questionType;
	
	@OneToMany
	@JsonIgnore
	private List<Question> questions;

	public Question() {
		super();
	}

	public Question(String question, String questionType) {
		super();
		this.question = question;
		this.questionType = questionType;
		this.questions = questions;
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



	public String getQuestionType() {
		return questionType;
	}



	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}



	public List<Question> getQuestions() {
		return questions;
	}



	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}	
	
	
	
	
}
