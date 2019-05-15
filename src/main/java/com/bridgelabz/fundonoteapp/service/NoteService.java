package com.bridgelabz.fundonoteapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.fundonoteapp.model.Note;

public interface NoteService {

	public Note updateNote(String header, Note note);

	public Note noteCreate(Note note, HttpServletRequest request);

	boolean delete(String header, Note note);

	public List<Note> fetchNote(String header);

}







