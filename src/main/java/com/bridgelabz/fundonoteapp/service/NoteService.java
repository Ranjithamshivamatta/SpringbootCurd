package com.bridgelabz.fundonoteapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.fundonoteapp.model.Label;
import com.bridgelabz.fundonoteapp.model.Note;

public interface NoteService {

	public Note updateNote(String header, Note note);

	public Note noteCreate(Note note, HttpServletRequest request);

	boolean delete(String header, Note note);

	public List<Note> fetchNote(String header);
	
	
	
	
	public Label updateLabel(String header, Label label);

	public Label labelCreate(Label label, HttpServletRequest request);

	boolean delete(String header, Label label);

	public List<Label> fetchLabel(String header);
	
	

}







