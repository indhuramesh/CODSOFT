import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public String getCorrectOption() {
        return options.get(correctOptionIndex);
    }
}

public class Main {
    private List<Question> questions;
    private int score;
    private List<String> results;

    public Main(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.results = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());
            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }
            System.out.print("Select an option (1-" + options.size() + "): ");
            long startTime = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - startTime > 10000) { // 10 seconds timer
                    System.out.println("\nTime's up!");
                    results.add("Question " + (i + 1) + ": Incorrect (Time's up). Correct answer: " + question.getCorrectOption());
                    break;
                }
                if (scanner.hasNextInt()) {
                    int userAnswer = scanner.nextInt() - 1;
                    if (userAnswer == question.getCorrectOptionIndex()) {
                        System.out.println("Correct!");
                        score++;
                        results.add("Question " + (i + 1) + ": Correct");
                    } else {
                        System.out.println("Incorrect. The correct answer is: " + question.getCorrectOption());
                        results.add("Question " + (i + 1) + ": Incorrect. Correct answer: " + question.getCorrectOption());
                    }
                    break;
                }
            }
        }
        scanner.close();
        displayResults();
    }

    private void displayResults() {
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + "/" + questions.size());
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the largest ocean on Earth?", Arrays.asList("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"), 3));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?", Arrays.asList("William Shakespeare", "Charles Dickens", "Mark Twain", "Jane Austen"), 0));
        questions.add(new Question("What is the chemical symbol for water?", Arrays.asList("H2O", "O2", "H2", "CO2"), 0));
        questions.add(new Question("What is the tallest mountain in the world?", Arrays.asList("K2", "Mount Everest", "Kangchenjunga", "Lhotse"), 1));
        questions.add(new Question("In which year did the Titanic sink?", Arrays.asList("1905", "1912", "1918", "1923"), 1));
        Main quiz = new Main(questions);
        quiz.start();
    }
}
