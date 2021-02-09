package week15d02;

public class Answer {
    private int answer;
    private int point;
    private String question;

    public Answer(String question, int answer, int point) {
        this.answer = answer;
        this.point = point;
    }

    public int getAnswer() {
        return answer;
    }

    public int getPoint() {
        return point;
    }

    public String getQuestion(){
        return this.question;
    }
}
