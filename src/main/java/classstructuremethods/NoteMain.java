package classstructuremethods;

import java.util.Scanner;

public class NoteMain {
    public static void main(String[] args) {

        String name;
        String topic;
        String text;

        Note note = new Note();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Neve :");
        name = scanner.nextLine();
        note.setName(name);

        System.out.println("Témája :");
        topic = scanner.nextLine();
        note.setTopic(topic);

        System.out.println("A jegyzet szövege :");
        text = scanner.nextLine();
        note.setText(text);

        System.out.println(note.getNoteText());
        
    }
}
