package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {
    private List<Post> posts = new ArrayList<>();

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPostsFor(String user){
        List<Post> posts = new ArrayList<>();

        for(Post post : posts){
            if(post.getOwner().equals(user) &&
                    post.getPublishedAt().isBefore(LocalDate.now()) &&
                    !post.getTitle().isEmpty() &&
                    !post.getContent().isEmpty()){
                posts.add(post);
            }
        }
        return new ArrayList<>(posts);
    }
}
