package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
	public Comment findByCommentId (Long commentId);
}