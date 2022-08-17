public class Question {

    private String code;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correctAnswer;

    public Question(String code, String question, String choiceA, String choiceB, String choiceC, String choiceD, String correctAnswer) {
        this.code = code;
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.correctAnswer = correctAnswer;
    }

    public String getCode() {

        return code;
    }

    public String questionDisplay() {
        return "Question: " + this.question
                + "\n" + "A. " + this.choiceA
                + "\n" + "B. " + this.choiceB
                + "\n" + "C. " + this.choiceC
                + "\n" + "D. " + this.choiceD;
    }

    public boolean isRightAnswer(String letterOfAnswer) {

        switch (letterOfAnswer.toUpperCase()) {
            case "A":
                if(choiceA.equalsIgnoreCase(correctAnswer)) {
                    return true;
                }
            case "B":
                if(choiceB.equalsIgnoreCase(correctAnswer)) {
                    return true;
                }
            case "C":
                if(choiceC.equalsIgnoreCase(correctAnswer)) {
                    return true;
                }
            case "D":
                if(choiceD.equalsIgnoreCase(correctAnswer)) {
                    return true;
                }
            default:
                return false;
        }
    }

    public String getRightAnswer() {
        return correctAnswer;
    }

}
