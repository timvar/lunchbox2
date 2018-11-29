package codingschmoding.lunchbox.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class QuestionType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonView(View.QuestionTypeFilter.class)
	private long questionTypeId;

	@JsonView(View.QuestionTypeFilter.class)
	private String questionType;
	
	@OneToMany
	@JsonIgnore
	private List<QuestionType> questionTypes;
	
	public QuestionType() {
		
	}
	
	public QuestionType(String questionType) {
		super();
		this.questionType = questionType;
	}

	public long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@Override
	public String toString() {
		return "QuestionType [questionTypeId=" + questionTypeId + ", questionType=" + questionType + "]";
	}
	
	
	
}
