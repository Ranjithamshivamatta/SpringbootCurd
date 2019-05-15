package com.bridgelabz.fundonoteapp.service;

import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.fundonoteapp.model.Note;

public interface NoteService {

	public Note update(String header, Note note);

	public Note noteCreate(Note note, HttpServletRequest request);

	public boolean delete(String header);

}
