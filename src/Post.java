import java.util.*;

public class Post{
	private String title;
	private String author;
	private String body;
	private List<String> labels;
	private List<Comment> comments;
	private String[] validSearchTypes = {"author", "body"};

	public Post(String title, String author, String body){
		this.title = title;
		this.author = author;
		this.body = body;
		labels = new ArrayList<String>();
		comments = new ArrayList<Comment>();
	}

	// Anonymous author
	public Post(String title, String body){
		this(title, "Anonymous", body);
	}

	// Setters
	public void updateTitle(String title){
		this.title = title;
	}

	public void updateAuthor(String author){
		this.author = author;
	}

	public void updateBody(String body){
		this.body = body;
	}

	public void addLabel(String label){
		labels.add(label);
	}

	public void setLabels(ArrayList<String> labs){
		this.labels = labs;
	}

	// Getters
	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public String getBody(){
		return body;
	}

	public List<String> getLabels(){
		return labels;
	}

	public List<Comment> getComments(){
		return comments;
	}

	// Create, delete comments
	public void addComment(Comment comment){
		comments.add(comment);
	}

	public void deleteComment(Comment comment){
		comments.remove(comment);
	}

	// Search this specific post for comments
	public List<Comment> searchComments(String type, String phrase) throws InvalidSearchTypeException{
		if(!Arrays.asList(validSearchTypes).contains(type)){
			throw new InvalidSearchTypeException("\"" + type + "\" is not a valid search type");
		}

		List<Comment> matches = new ArrayList<Comment>();

		if(type.equals("author")){

			for(Comment c : this.comments){
				if(c.getAuthor().equals(phrase)){ matches.add(c); }
			}
			
		}else if(type.equals("body")){

			for(Comment c : this.comments){
				String searchBody = c.getBody().toLowerCase(); // Ignore case
				if(searchBody.contains(phrase.toLowerCase())){ matches.add(c); } 
			}
			
		}

		return matches;
	}

}