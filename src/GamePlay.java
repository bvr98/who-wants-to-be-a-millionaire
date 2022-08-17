import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePlay {

    private List<Question> questionList = new ArrayList<>();

    private List<String> askedQuestions = new ArrayList<>();

    //Generate a random question
    public Question getRandomQuestion() {


        Random random = new Random();

        while (true) {

            //Generate a random number to get a random index in the questions
            int randomNumber = random.nextInt(questionList.size());

            Question randomQuestion = questionList.get(randomNumber);

            //Identify the question via using the question code
            String code = randomQuestion.getCode();

            if (!askedQuestions.contains(code)) {
                askedQuestions.add(code);
                return randomQuestion;
            }
        }

    }

    public void startGame() throws IOException {

        String questions = "Questions.txt";
        FileReader fr = new FileReader(questions);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {

            String question = br.readLine();
            String choiceA = br.readLine();
            String choiceB = br.readLine();
            String choiceC = br.readLine();
            String choiceD = br.readLine();
            String correctAnswer = br.readLine();

            //Create the question and then add it to the question list
            questionList.add(new Question(line, question, choiceA, choiceB, choiceC, choiceD, correctAnswer));
        }
    }

}
