package app.rest.controllers;

public class CommentDto
{
	private int commentId;
	private String username;
	private String commentText;
	private int rating;
	private String foodStallName;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFoodStallName() {
		return foodStallName;
	}
	public void setFoodStallName(String foodStallName) {
		this.foodStallName = foodStallName;
	}
	@Override
	public String toString() {
		return "CommentDto [commentId=" + commentId + ", username=" + username + ", commentText=" + commentText
				+ ", rating=" + rating + ", foodStallName=" + foodStallName + "]";
	}
	
	
}
