package swe.model;

public class QuestionMCQ {

	String questionhead;
	String choice1, choice2, choice3, choice4;
	String correctAnswer;
	
	public QuestionMCQ() {
		this.questionhead = "";
		this.correctAnswer = "";
		this.choice1 = "";
		this.choice2 = "";
		this.choice3 = "";
		this.choice4 = "";
	}

	public QuestionMCQ(String questionhead, String choice1, String choice2, String choice3, String choice4,
			String correctAnswer) {
		super();
		this.questionhead = questionhead;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.correctAnswer = correctAnswer;
	}

	public String getQuestionhead() {
		return questionhead;
	}

	public void setQuestionhead(String questionhead) {
		this.questionhead = questionhead;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
}
