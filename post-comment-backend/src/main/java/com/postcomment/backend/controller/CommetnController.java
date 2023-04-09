package com.postcomment.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postcomment.backend.entity.Comment;
import com.postcomment.backend.service.CommentService;

@RestController
public class CommetnController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/getAllComments")
	public List<Comment> getAllCommnets() {
		return commentService.getComments();
	}
	
	@GetMapping("/getComments/{postID}")
	public List<Comment> getCommnets(@PathVariable int postID) {
		return commentService.getComments(postID);
	}
	
	@PostMapping("/addComment")
	public String addComment(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}
	
	@PostMapping("/editComment")
	public String editComment(@RequestBody Comment comment) {
		return commentService.updateComment(comment);
	}
	
	@PostMapping("/deleteComment")
	public String deleteComment(@RequestBody Comment comment) {
		return commentService.deleteComment(comment);
	}

}
