import java.util.*;

public class Blog{
	private String title;
	private List<Post> posts;
	private String[] validSearchTypes = {"title", "author", "label", "body"};

	public Blog(String title){
		this.title = title;
		posts = new ArrayList<Post>();
	}

	public String getTitle(){
		return title;
	}

	public List<Post> getPosts(){
		return posts;
	}

	// Create, delete post
	public void addPost(Post newPost){
		posts.add(newPost);
	}

	public void deletePost(Post post){
		posts.remove(post);
	}

	// Searches blog for specific posts
	public List<Post> searchPosts(String type, String phrase) throws InvalidSearchTypeException{
		if(!Arrays.asList(validSearchTypes).contains(type)){
			throw new InvalidSearchTypeException("\"" + type + "\" is not a valid search type");
		}

		List<Post> matches = new ArrayList<Post>();

		if(type.equals("title")){

			for(Post p : this.posts){
				if(p.getTitle().equals(phrase)){ matches.add(p); }
			}

		}else if(type.equals("author")){

			for(Post p : this.posts){
				if(p.getAuthor().equals(phrase)){ matches.add(p); }
			}

		}else if(type.equals("label")){

			for(Post p : this.posts){
				if(p.getLabels().contains(phrase)){ matches.add(p); }
			}
			
		}else if(type.equals("body")){

			for(Post p : this.posts){
				String searchBody = p.getBody().toLowerCase(); // Ignore case
				if(searchBody.contains(phrase.toLowerCase())){ matches.add(p); } 
			}
			
		}

		return matches;
	}

	// Searches all posts in the blog for comments
	// Search functionality constrained to single posts is within Post.java
	public List<Comment> searchFullComments(String type, String phrase) throws InvalidSearchTypeException{
		if(!Arrays.asList(validSearchTypes).contains(type)){
			throw new InvalidSearchTypeException("\"" + type + "\" is not a valid search type");
		}

		List<Comment> matches = new ArrayList<Comment>();

		if(type.equals("title")){

			for(Post p : this.posts){
				if(p.getTitle().equals(phrase)){ matches.addAll(p.getComments()); }
			}

		}else if(type.equals("author")){

			for(Post p : this.posts){
				for(Comment c : p.getComments()){
					if(c.getAuthor().equals(phrase)){ matches.add(c); }
				}
			}

		}else if(type.equals("label")){

			for(Post p : this.posts){
				if(p.getLabels().contains(phrase)){ matches.addAll(p.getComments()); }
			}
			
		}else if(type.equals("body")){
			
			for(Post p: this.posts){
				for(Comment c: p.getComments()){
					String searchBody = c.getBody().toLowerCase(); // Ignore case
					if(searchBody.contains(phrase.toLowerCase())){ matches.add(c); } 
				}
			}

		}

		return matches;
	}

}