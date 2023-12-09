package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
	Comment findByCommentId(int commentId);
	Comment findByFoodStall(String foodStall);
}
