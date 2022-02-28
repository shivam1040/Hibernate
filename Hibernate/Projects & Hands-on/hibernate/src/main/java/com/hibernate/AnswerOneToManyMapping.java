package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerOneToManyMapping {
	@Id
	private int answerId;
	private String answer;
	
	@ManyToOne //estabilishing many answer one que type relation, since relation is defined in both classes so it's bidirectional mapping 
	private QuestionOneToManyMapping questionOneToManyMapping;

	public AnswerOneToManyMapping(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}

	public QuestionOneToManyMapping getQuestionOneToManyMapping() {
		return questionOneToManyMapping;
	}

	public void setQuestionOneToManyMapping(QuestionOneToManyMapping questionOneToManyMapping) {
		this.questionOneToManyMapping = questionOneToManyMapping;
	}

	@Override
	public String toString() {
		return "AnswerOneToManyMapping [answerId=" + answerId + ", answer=" + answer + ", questionOneToManyMapping="
				+ questionOneToManyMapping + "]";
	}

	public AnswerOneToManyMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
