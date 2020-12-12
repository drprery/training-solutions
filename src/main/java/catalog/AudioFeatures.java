package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private final List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }

        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException();
        }

        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException();
        }

        this.length = length;
        this.performers = new ArrayList<>(performers);
        this.title = title;
        this.composer = null;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }

        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException();
        }

        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException();
        }

        this.composer = new ArrayList<>(composer);
        this.length = length;
        this.performers = new ArrayList<>(performers);
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        if (composer == null) {
            return performers;
        } else {
            List<String> tempList = new ArrayList<>();
            tempList.addAll(composer);
            tempList.addAll(performers);
            return tempList;
        }
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
