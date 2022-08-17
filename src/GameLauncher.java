
import java.io.IOException;
import java.util.Scanner;

public class GameLauncher {

    static GamePlay gameplay;
    static Contestant contestant;
    static Question question;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        gameplay = new GamePlay();

        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("+--------------------Who Wants To Be A Millionaire!----------------------+");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println();

        while (true) {
            System.out.println("Choose one of the option: ");
            System.out.println("[1] Start Game");
            System.out.println("[2] View the rules ");
            System.out.println("[3] Exit");

            System.out.print("Enter the number of selected option: ");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    PlayerName();
                    StartGame();
                    System.exit(0);
                case "2":
                    RulesOfTheGame();
                    break;
                case "3":
                    System.out.println("Exiting the game...");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }

    }

    public static void PlayerName() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();

        contestant = new Contestant(playerName);

        System.out.println("Welcome " + contestant.getName());
        System.out.println("Let's begin the game!");
        System.out.println();
    }

    public static void StartGame() throws IOException {
        Scanner sc = new Scanner(System.in);

        gameplay.startGame(); //load questions

        int questionNum = 1;
        int round = 1;
        String[] prizeList = new String[]{"$100", "$500", "$1,000", "$8,000", "$16,000", "$32,000", "$125,000", "$500,000", "$1,000,000"};

        while (contestant.isPlaying()) {

            String prizeAmount = prizeList[questionNum-1];

            System.out.println("Round " + round + ". Question Number "+ questionNum +" is for " + prizeAmount);

            //Get and Display the question
            question = gameplay.getRandomQuestion();
            System.out.println(question.questionDisplay());

            String answer;
            while (true) {
                System.out.print("Enter your answer: ");
                answer = sc.nextLine();

                switch (answer.toUpperCase()) {
                    case "A":
                    case "B":
                    case "C":
                    case "D":

                        System.out.print("is option " + answer + " your final answer? Y for yes N for no: ");
                        String prompt = sc.nextLine();

                        if (prompt.equalsIgnoreCase("Y")) {
                            break;
                        } else if (prompt.equalsIgnoreCase("N")) {
                            System.out.println("Please change your answer...");
                            continue;
                        } else {
                            System.out.println("Invalid option. Please try again.");
                            continue;
                        }
                    default:
                        System.out.println("Invalid option. Please enter A, B, C, or D only");
                        continue;
                }
                //if player finalizes the answer
                break;
            }

            //validating answer
            if (question.isRightAnswer(answer)) {

                System.out.println("Congratulations! You've won " + prizeAmount);


                questionNum++;

                if (questionNum == 4 || questionNum == 7) {

                    if (walkAway(prizeAmount)) {
                        contestant.stillPlaying(false);
                    } else {
                        System.out.println("let's proceed to the next round!");
                    }
                    //Increment round number
                    round++;
                }

                if (questionNum == 9) {
                    System.out.println("This will be the final question");
                }

                if (questionNum > 9) {
                    System.out.println("Congratulations you won " + prizeAmount);
                    System.out.println("Thank you for playing Who want to be a millionaire!");
                    contestant.stillPlaying(false);
                }

            } else {
                System.out.println("Sorry, you've answered incorrectly");
                System.out.println("The correct answer is " + question.getRightAnswer());
                System.out.println("Thank you for playing Who wants to be a millionaire!");
                contestant.stillPlaying(false);
            }
        }
    }

    public static boolean walkAway(String prize) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to keep playing or walk away with your " + prize + "?");
        while (true) {
            System.out.print("Enter Y  to keep playing or N to walk way now: ");
            String prompt = sc.nextLine();
            if (prompt.equalsIgnoreCase("Y")) {
                return false;
            } else if (prompt.equalsIgnoreCase("N")) {
                System.out.println("Congratulations. You won " + prize);
                System.out.println("Thank you for playing Who wants to be a Millionaire!");
                return true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void RulesOfTheGame() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Rules of the Game");
        System.out.println("This Game consists 3 rounds "
                + "\n"
                + "\t"
                + "Round 1 consists of 3 questions and when answered correct you can win \"$100\", \"$500\", \"$1,000\" respectively"
                + "\n"
                + "\t"
                + "Round 2 consists of 3 questions and when answered correct you can win \"$8,000\", \"$16,000\", \"$32,000\" respectively"
                + "\n"
                + "\t"
                + "Round 3 consists of 3 questions and when answered correct you can win \"$125,000\", \"$500,000\", \"$1,000,000\" respectively"
                + "\n"
                + "\t"
                + "After completing round 1 & 2 you get choose to either continue the game or walkway with the prize money"
                + "\n"
                + "\t"
                + "If you answer any one of the question incorrectly in either rounds, you will be exited from the game");

        System.out.println();

        while (true) {
            System.out.print("Press Y to return to main menu, N to exit the game: ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Y")) break;
            else {
                System.out.println("Exiting the game...");
                System.exit(0);
            }
        }
    }
}

