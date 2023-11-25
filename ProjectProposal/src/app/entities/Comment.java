package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Comment
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Size(max = 6)
	@Column
	private Long commentId;
	
	@NotNull
	@Column
	private String commentingUser;
	
	@NotNull
	@Column
	private String commentText;
	
	@Range(min = 1, max = 5)
	@Column
	private Integer review;
	
//	fk foodStallName
	@ManyToOne
	@JoinColumn(name = "foodStallName")
	private FoodStall name;

	public Comment(@NotNull @Size(max = 6) Long commentId, @NotNull String commentingUser, @NotNull String commentText,
			@Range(min = 1, max = 5) Integer review, FoodStall name) {
		super();
		this.commentId = commentId;
		this.commentingUser = commentingUser;
		this.commentText = commentText;
		this.review = review;
		this.name = name;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommentingUser() {
		return commentingUser;
	}

	public void setCommentingUser(String commentingUser) {
		this.commentingUser = commentingUser;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Integer getReview() {
		return review;
	}

	public void setReview(Integer review) {
		this.review = review;
	}

	public FoodStall getName() {
		return name;
	}

	public void setName(FoodStall name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentingUser=" + commentingUser + ", commentText=" + commentText
				+ ", review=" + review + ", name=" + name + "]";
	}
}
