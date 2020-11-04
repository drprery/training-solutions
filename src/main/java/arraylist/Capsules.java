package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List<String> capsuleColors = new ArrayList<>();

    public void addLast(String capsule) {
        capsuleColors.add(capsule);
    }

    public void addFirst(String capsule) {
        capsuleColors.add(0, capsule);
    }

    public void removeFirst() {
        capsuleColors.remove(0);
    }

    public void removeLast() {
        capsuleColors.remove(capsuleColors.size() - 1);
    }

    public List<String> getColors() {
        return capsuleColors;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();

        capsules.addFirst("Red");
        capsules.addFirst("Green");
        capsules.addFirst("Blue");
        capsules.addFirst("Yellow");

        System.out.println(capsules.getColors().toString());

        capsules.addLast("Brown");
        System.out.println(capsules.getColors().toString());

        capsules.removeFirst();
        System.out.println(capsules.getColors().toString());

        capsules.removeLast();
        System.out.println(capsules.getColors().toString());
    }
}
