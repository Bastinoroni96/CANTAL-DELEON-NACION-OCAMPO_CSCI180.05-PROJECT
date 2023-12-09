package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.CommentComponent;

@Component
@Path("/comment")
public class CommentController
{
	@Autowired
	private CommentComponent cc;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addCommentReview(CommentDto commentDto)
	{
		return cc.addCommentReview(commentDto);
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCommentReview(CommentDto commentDto)
	{
		return cc.deleteCommentReview(commentDto);
	}
	
	
	
}
