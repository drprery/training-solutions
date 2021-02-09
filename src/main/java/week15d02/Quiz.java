package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz {
    private Map<String, List<Answer>> answersList = new HashMap<>();

    public Quiz() {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(Quiz.class.getResourceAsStream("kerdesek.txt")))){
            processFiles(bf);
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found!");
        }
    }

    private void processFiles(BufferedReader bf) throws IOException{
        String question;
        String answer;

        while((question=bf.readLine())!=null && (answer=bf.readLine())!=null){
            String[] answerLine = answer.split(" ");
            String subject = answerLine[2];
            int answerPoint = Integer.parseInt(answerLine[1]);
            int answerData = Integer.parseInt(answerLine[0]);

            if(!answersList.containsKey(subject)){
                answersList.put(subject, new ArrayList<>());
            }
            answersList.get(subject).add(new Answer(question, answerData, answerPoint));
        }
    }

    public List<String> questionsOfSubject(String subject){
        List<Answer> answers;
        List<String> questionsOnThatSubject = new ArrayList<>();

        answers = answersList.get(subject);
        for(Answer answer : answers){
            questionsOnThatSubject.add(answer.getQuestion());
        }

        return new ArrayList<>(questionsOnThatSubject);
    }

    public Answer randomQuestion(){
        Answer[] ans = new Answer[answersList.size()];
        answersList.values().toArray(ans);
        Answer selected =  ans[new Random().nextInt(ans.length)];
        return selected;
    }

    public Map<String, List<String>> answersBySubject(){
        Map<String, List<String>> abs = new HashMap<>();

        Iterator it = answersList.keySet().iterator();
        while(it.hasNext()){
            String key = (String) it.next();
            List<Answer> answers = answersList.get(it.next());
            for(Answer answer : answers){
                if(!abs.containsKey(key)){
                    abs.put(key, new ArrayList<>());
                }
                abs.get(key).add(answer.getQuestion());
            }
        }
        return abs;
    }

    public String mostValuedQuestion(){
        int questionMax=0;
        int tempPoint=0;
        String question="";

        for(String key : answersList.keySet()) {
            question=key;
            for (Answer answer : answersList.get(key)) {
                tempPoint += answer.getPoint();
            }
            if(tempPoint>questionMax){
                questionMax=tempPoint;
                question=key;
            }
        }
        return question;
    }
}
