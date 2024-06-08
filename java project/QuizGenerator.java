import java.util.*;

public class QuizGenerator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter quiz title: ");
    String title = sc.nextLine();
    

    System.out.print("Enter number of questions :: ");
    int numQue = sc.nextInt();
    sc.nextLine(); 

    Question[] questions = new Question[numQue];
    for (int i = 0; i < numQue; i++) {
      System.out.print("Enter question " + (i + 1) + ": ");
      String questionText = sc.nextLine();

      System.out.print("Enter number of options: ");
      int numOpt = sc.nextInt();
      sc.nextLine(); 

      String[] options = new String[numOpt];
      for (int j = 0; j < numOpt; j++) {
        System.out.print("Enter option " + (j + 1) + ": ");
        options[j] = sc.nextLine();
      }

      System.out.print("Enter correct answer (1-" + numOpt + "): ");
      int correctAnswerIndex = sc.nextInt() ;
      sc.nextLine(); 

      questions[i] = new Question(questionText, options, correctAnswerIndex);
    }
        System.out.println("\n\nLets start the Quiz !!\n");
    int score = 0;
    for (Question question : questions) {
      System.out.println(question.getText());
      for (int i = 0; i < question.getOptions().length; i++) {
        System.out.println((i + 1) + ". " + question.getOptions()[i]);
      }

      System.out.print("Your answer: ");
      int userAnswerIndex = sc.nextInt() ;

      if (userAnswerIndex == question.getCorrectAnswerIndex()) {
        score++;
        System.out.println("Correct!");
      } else {
        System.out.println("Incorrect. The correct answer was: " + question.getOptions()[question.getCorrectAnswerIndex()]);
      }
    }

    System.out.println("You scored " + score + " out of " + numQue + "!");
  }
}

class Question {
  private String text;
  private String[] options;
  private int correctAnswerIndex;

  public Question(String text, String[] options, int correctAnswerIndex) {
    this.text = text;
    this.options = options;
    this.correctAnswerIndex = correctAnswerIndex;
  }

  public String getText() {
    return text;
  }

  public String[] getOptions() {
    return options;
  }

  public int getCorrectAnswerIndex() {
    return correctAnswerIndex;
  }
}