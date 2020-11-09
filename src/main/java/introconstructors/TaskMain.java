package introconstructors;

public class TaskMain {

    public static void main(String[] args) {
        Task task = new Task("Videó megnézése", "Lepörgetni még egyet...");

        System.out.println("Cím: " + task.getTitle());
        System.out.println("Leírás: " + task.getDescription());

        task.start();
        task.setDuration(100);

        System.out.println("Elkezdődött "
                + task.getStartDateTime()
                + " és tartott "
                + task.getDuration()
                + " percig.");
    }
}
