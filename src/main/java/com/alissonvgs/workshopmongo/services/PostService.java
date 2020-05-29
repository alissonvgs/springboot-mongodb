package com.alissonvgs.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissonvgs.workshopmongo.domain.Post;
import com.alissonvgs.workshopmongo.domain.User;
import com.alissonvgs.workshopmongo.repository.PostRepository;
import com.alissonvgs.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}

	public List<Post> findAll() {
		return repo.findAll();
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		Integer milliseconds = 24 * 60 * 60 * 1000;
		maxDate = new Date(maxDate.getTime() + milliseconds);
		return repo.fullSearch(text, minDate, maxDate);

	}
}

