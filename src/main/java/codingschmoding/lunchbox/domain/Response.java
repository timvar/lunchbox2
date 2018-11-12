package codingschmoding.lunchbox.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Response {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long responseId;
	private String response;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Question question;
	
	public Response(String response) {
		super();
		this.response = response;
	}
	
	
	public Response(String response, Question question) {
		super();
		this.response = response;
		this.question = question;
	}


	public Response() {}

	public Long getResponseId() {
		return responseId;
	}

	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	

}
