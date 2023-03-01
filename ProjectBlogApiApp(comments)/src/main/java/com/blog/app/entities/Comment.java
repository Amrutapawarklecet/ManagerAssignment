package com.blog.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comments")
@Setter
@Getter
@NoArgsConstructor
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer commentId;
	
	private  String content;
	
	//post has many comments
	@ManyToOne
	private  Post post; //add only primary key in comment table
	
	//user has many comment
	@ManyToOne
	private User user;

}
