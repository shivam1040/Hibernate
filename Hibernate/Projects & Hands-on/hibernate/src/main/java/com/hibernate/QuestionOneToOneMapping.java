package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class QuestionOneToOneMapping {
	@Id
	private int questionId;
	private String question;
	@OneToOne //one que can have only one answer type of relation
	@JoinColumn(name="aid") //this tag changes the name of column created by fk constraint
	private AnswerOneToOneMapping answerOneToOneMapping;
	
	public QuestionOneToOneMapping(int questionId, String question, AnswerOneToOneMapping answerOneToOneMapping) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answerOneToOneMapping = answerOneToOneMapping;
	}
	
	
}
