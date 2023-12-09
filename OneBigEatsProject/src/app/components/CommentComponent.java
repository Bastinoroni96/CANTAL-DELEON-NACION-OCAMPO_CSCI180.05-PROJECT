package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Comment;
import app.entities.FoodStall;
import app.entities.User;
import app.repositories.CommentRepository;
import app.repositories.FoodStallRepository;
import app.repositories.UserRepository;
import app.rest.controllers.CommentDto;

@Component
public class CommentComponent {
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
    private FoodStallRepository foodStallRepo;
	
	public String addCommentReview(CommentDto commentDto)
	{
		// Retrieve details from CommentDto
		String username = commentDto.getUsername();
		String commentText = commentDto.getCommentText();
		int rating = commentDto.getRating();
		String foodStallName = commentDto.getFoodStallName();
		
		User user = userRepo.findByUsername(username);
        FoodStall foodStall = foodStallRepo.findByName(foodStallName);
		
		if (user == null) {
            return "User not found.";
        }

        if (foodStall == null) {
            return "Food stall not found.";
        }
        
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setCommentText(commentText);
        comment.setRating(rating);
        comment.setFoodStall(foodStall);
        
        comment = commentRepo.save(comment);
        
        return "Commment has been posted for: " + foodStall.getName();
	}
	
	public String deleteCommentReview(CommentDto commentDto)
	{
		int commentId = commentDto.getCommentId();
		
		Comment comment = commentRepo.findByCommentId(commentId);
		if (comment != null)
		{
			commentRepo.delete(comment);
			return "Comment deleted.";
		}
		else
		{
			return "No comment deleted because comment was not found.";
		}
	}
	
}
