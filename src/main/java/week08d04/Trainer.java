package week08d04;

public class Trainer {
    CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public int giveMark() {
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer trainerInGoodMood = new Trainer(new GoodMood());
        Trainer trainerInBadMood = new Trainer(new BadMood());

        System.out.println("Trainer in good mood: " + trainerInGoodMood.giveMark());
        System.out.println("Trainer in bad mood: " + trainerInBadMood.giveMark());
    }
}
