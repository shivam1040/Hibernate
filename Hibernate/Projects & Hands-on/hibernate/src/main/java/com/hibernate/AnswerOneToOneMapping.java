package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AnswerOneToOneMapping {
	@Id
	private int answerId;
	private String answer;
	
	//@OneToOne //by writing oneToone in both the classes, it means that the onetoone relation is bidirectional, i.e. one que one ans and vice versa
	@OneToOne(mappedBy = "answerOneToOneMapping") //this tag ensures that only one FK field in dB is created and mapping should be done by answerOneToOneMapping var of QuestionOne... class and the relationshipdirection remains the same i.e bidirectional in this case.The FK DB field will now only be created in QuestiononetoOne.. entity
	private QuestionOneToOneMapping questionOneToOneMapping;
	
	public AnswerOneToOneMapping(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	public void setQuestionOneToOneMapping(QuestionOneToOneMapping questionOneToOneMapping) {
		this.questionOneToOneMapping = questionOneToOneMapping;
	}
	
	
	
	
}
