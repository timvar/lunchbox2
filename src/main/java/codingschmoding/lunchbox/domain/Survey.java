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
public class Survey {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonView(View.SurveyFilter.class)
	private long surveyId;
	
	@JsonView(View.SurveyFilter.class)
	private String surveyName;
	
	@OneToMany
	@JsonIgnore
	private List<Survey> surveys;
	
	@ManyToOne
    @JoinColumn(name = "id")
	@JsonView(View.SurveyFilter.class)
	private User user;
	
	public Survey() {
		
	}
	

	public Survey(String surveyName, User user) {
		super();
		this.surveyName = surveyName;
		this.user = user;
	}

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", surveyName=" + surveyName + "]";
	}
	
	
	
	

}
