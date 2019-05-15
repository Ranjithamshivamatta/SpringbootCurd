package com.bridgelabz.fundonoteapp.serviceimpl;


import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundonoteapp.model.Note;
import com.bridgelabz.fundonoteapp.repository.NoteRepository;
import com.bridgelabz.fundonoteapp.service.NoteService;
import com.bridgelabz.fundonoteapp.util.Token1;


@Service
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	public NoteRepository noteRep;

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Token1 token;
	
	@Override
	public Note noteCreate(Note note, HttpServletRequest request) {
		String token1 = request.getHeader("token");
		int id = token.tokenVerification(token1);
		note.setId(id);
		return noteRep.save(note);
	}
	
	@Override
	public Note update(String header, Note note) {
		return note;
		
	}
//	@Override
//	public boolean delete(String header) {
//		
//			int varifiedUserId = tokenVerification(token1);
//			Optional<Token> maybeUser = noteRep.findById(varifiedUserId);
//			return maybeUser.map(existingToken -> {
//				noteRep.delete(existingToken);
//				return true;
//			}).orElseGet(() -> false);
//		}
	
//		

	@Override
	public boolean delete(String header) {
		// TODO Auto-generated method stub
		return false;
	}
	}

	
	


