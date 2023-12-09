package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Comment
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;
	
//	fk purchaseUser
	@NotNull
	@ManyToOne
    @JoinColumn(name = "username")
    private User user;
	
//	fk foodStallName
	@NotNull
	@ManyToOne
    @JoinColumn(name = "foodStallID", referencedColumnName = "name")
    private FoodStall foodStall;
	
	@NotNull
	@Column
	private String commentText;
	
	@Column
	private int rating;
	
	public Comment() {
		
	}

	public Comment(Long commentId, @NotNull User user, @NotNull FoodStall foodStall, @NotNull String commentText,
			int rating) {
		super();
		this.commentId = commentId;
		this.user = user;
		this.foodStall = foodStall;
		this.commentText = commentText;
		this.rating = rating;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FoodStall getFoodStall() {
		return foodStall;
	}

	public void setFoodStall(FoodStall foodStall) {
		this.foodStall = foodStall;
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

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", user=" + user + ", foodStall=" + foodStall + ", commentText="
				+ commentText + ", rating=" + rating + "]";
	}
		

}
