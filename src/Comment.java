public class Comment{
	private String author;
	private String body;

	public Comment(String author, String body){
		this.author = author;
		this.body = body;
	}

	// Anonymous author
	public Comment(String body){
		this("Anonymous", body);
	}

	// Setters
	public void updateAuthor(String author){
		this.author = author;
	}

	public void updateBody(String body){
		this.body = body;
	}

	// Getters
	public String getAuthor(){
		return author;
	}

	public String getBody(){
		return body;
	}
}