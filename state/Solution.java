
// Client class
public class Solution {

    public static void main(String[] args) {

        BlogPost post = new BlogPost();
        post.setContent("This is a sample blog post for iamnishantrao.com");
        System.out.println();

        post.publish();

        post.submitForReview();

        post.publish();

        post.submitForReview();

        post.publish();
        
        post.archive();

        post.submitForReview();

        post.archive();

        post.publish();

        post.draft();

        post.submitForReview();

        post.delete();
    }
}

// Context
class BlogPost {

    private BlogPostState draftState;
    private BlogPostState underReviewState;
    private BlogPostState publishedState;
    private BlogPostState archivedState;
    private BlogPostState currentState;

    private String content;

    public BlogPost() {

        draftState = new DraftState();
        underReviewState = new UnderReviewState();
        publishedState = new PublishedState();
        archivedState = new ArchivedState();
        currentState = draftState;
    }

    public void setContent(String content) {

        this.content = content;
        System.out.println("Created new blog post with content: (" + content + ")");
    }

    public void draft() {

        System.out.println("Trying to set the blog post as draft...");
        currentState.draft(this);
    }

    public void submitForReview() {

        System.out.println("Trying to submit the blog post for review...");
        currentState.submitForReview(this);
    }

    public void publish() {

        System.out.println("Trying to publish the blog post...");
        currentState.publish(this);
    }

    public void archive() {

        System.out.println("Trying to archieve the blog post...");
        currentState.archive(this);
    }

    public void delete() {

        System.out.println("Trying to delete the blog post...");
        currentState.delete(this);
    }

    public void setState(BlogPostState state) {

        this.currentState = state;
    }

    public BlogPostState getDraftState() {

        return draftState;
    }

    public BlogPostState getUnderReviewState() {

        return underReviewState;
    }

    public BlogPostState getPublishedState() {

        return publishedState;
    }

    public BlogPostState getArchivedState() {

        return archivedState;
    }
}

// State interface
interface BlogPostState {

    void draft(BlogPost post);
    void submitForReview(BlogPost post);
    void publish(BlogPost post);
    void archive(BlogPost post);
    void delete(BlogPost post);
}

// Concrete States
class DraftState implements BlogPostState {

    public void draft(BlogPost post) {

        System.out.println("Post is already in draft state!\n");
    }

    public void submitForReview(BlogPost post) {

        System.out.println("Submitting post for review!\n");
        post.setState(post.getUnderReviewState());
    }

    public void publish(BlogPost post) {

        System.out.println("Cannot publish directly from draft. Please submit for review first!\n");
    }

    public void archive(BlogPost post) {

        System.out.println("Archiving draft post!\n");
        post.setState(post.getArchivedState());
    }

    public void delete(BlogPost post) {

        System.out.println("Deleting draft post!\n");
        post.setState(null);
    }
}

class UnderReviewState implements BlogPostState {

    public void draft(BlogPost post) {

        System.out.println("Moving post back to draft!\n");
        post.setState(post.getDraftState());
    }

    public void submitForReview(BlogPost post) {

        System.out.println("Post is already under review!\n");
    }

    public void publish(BlogPost post) {

        System.out.println("Publishing reviewed post!\n");
        post.setState(post.getPublishedState());
    }

    public void archive(BlogPost post) {

        System.out.println("Cannot archive a post under review!\n");
    }

    public void delete(BlogPost post) {

        System.out.println("Deleting post under review!\n");
        post.setState(null);
    }
}

class PublishedState implements BlogPostState {

    public void draft(BlogPost post) {

        System.out.println("Moving published post back to draft!\n");
        post.setState(post.getDraftState());
    }

    public void submitForReview(BlogPost post) {

        System.out.println("Cannot submit a published post for review!\n");
    }

    public void publish(BlogPost post) {

        System.out.println("Post is already published!\n");
    }

    public void archive(BlogPost post) {

        System.out.println("Archiving published post!\n");
        post.setState(post.getArchivedState());
    }

    public void delete(BlogPost post) {

        System.out.println("Deleting published post!\n");
        post.setState(null);
    }
}

class ArchivedState implements BlogPostState {

    public void draft(BlogPost post) {

        System.out.println("Moving archived post back to draft!\n");
        post.setState(post.getDraftState());
    }

    public void submitForReview(BlogPost post) {

        System.out.println("Cannot submit an archived post for review!\n");
    }

    public void publish(BlogPost post) {

        System.out.println("Publishing archived post!\n");
        post.setState(post.getPublishedState());
    }

    public void archive(BlogPost post) {

        System.out.println("Post is already archived!\n");
    }

    public void delete(BlogPost post) {

        System.out.println("Deleting archived post!\n");
        post.setState(null);
    }
}
