package com.hibernate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionOneToManyMapping {
	@Id
	private int questionId;
	private String question;
	
	//below cascade means all the related entitites or refrenced will get automatic operation execution when operation is performed on questiononetomanymapping, cascade all means cascading will be applicable for all type of operations such as update, delete etc.
	@OneToMany(mappedBy = "questionOneToManyMapping" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL) //estabilishing onetomany relationship i.e one question many answers, mappedby ensures that no separate table is created for storing relationship data and FK field(questionOneToManyMapping) of AnswerOnetoMany entity is used for storing such data
	private List<AnswerOneToManyMapping> answerOneToManyMapping;
	
	public QuestionOneToManyMapping(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public void setAnswerOneToManyMapping(List<AnswerOneToManyMapping> answerOneToManyMapping) {
		this.answerOneToManyMapping = answerOneToManyMapping;
	}

	@Override
	public String toString() {
		return "QuestionOneToManyMapping [questionId=" + questionId + ", question=" + question
				+ ", answerOneToManyMapping=" + answerOneToManyMapping + "]";
	}

	public QuestionOneToManyMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<AnswerOneToManyMapping> getAnswerOneToManyMapping() {
		return answerOneToManyMapping;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	

}
