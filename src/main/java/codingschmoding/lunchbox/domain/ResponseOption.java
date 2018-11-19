package codingschmoding.lunchbox.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class ResponseOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long responseOptionId;
	private String responseOption;
	
	@ManyToOne
    @JoinColumn(name = "questionId")
	
	private Question question;
	
	

	public ResponseOption() {
		super();
	}



	public ResponseOption(Long responseOptionId, String responseOption, Question question) {
		super();
		this.responseOptionId = responseOptionId;
		this.responseOption = responseOption;
		this.question = question;
	}



	public Long getResponseOptionId() {
		return responseOptionId;
	}



	public void setResponseOptionId(Long responseOptionId) {
		this.responseOptionId = responseOptionId;
	}



	public String getResponseOption() {
		return responseOption;
	}



	public void setResponseOption(String responseOption) {
		this.responseOption = responseOption;
	}



	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}
	

}
