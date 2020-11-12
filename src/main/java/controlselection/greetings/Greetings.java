package controlselection.greetings;

public class Greetings {

    public String greet(int hour, int minutes) {
        int totalMinutes = hour * 60 + minutes;

        if (totalMinutes <= 5  * 60 || totalMinutes > 20 * 60) {
            return "Jó éjt!";
        }
        else if (totalMinutes > 5 * 60 && totalMinutes <= 9 * 60) {
            return "Jó reggelt!";
        }
        else if (totalMinutes > 9 * 60 && totalMinutes <= 18 * 60 + 30) {
            return "Jó napot!";
        }
        else {
            return "Jó estét!";
        }
    }
}
