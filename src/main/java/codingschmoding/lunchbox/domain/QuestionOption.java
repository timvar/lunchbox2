package codingschmoding.lunchbox.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class QuestionOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionOptionId;
	private String questionOption;
	
	@ManyToOne
    @JoinColumn(name = "questionId")
	
	private Question question;
	
	

	public QuestionOption() {
		super();
	}



	public QuestionOption(String questionOption, Question question) {
		super();
		this.questionOption = questionOption;
		this.question = question;
	}



	public Long getQuestionOptionId() {
		return questionOptionId;
	}



	public void setQuestionOptionId(Long questionOptionId) {
		this.questionOptionId = questionOptionId;
	}



	public String getQuestionOption() {
		return questionOption;
	}



	public void setQuestionOption(String questionOption) {
		this.questionOption = questionOption;
	}



	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}
	

}
