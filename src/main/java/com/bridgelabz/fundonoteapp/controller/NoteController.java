package com.bridgelabz.fundonoteapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundonoteapp.model.Note;

import com.bridgelabz.fundonoteapp.service.NoteService;

@RestController
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/createnote", method = RequestMethod.POST)
	public Note createNote(@RequestBody Note note, HttpServletRequest request) {
		return noteService.noteCreate(note, request);
	}

	@RequestMapping(value = "/fetchNote", method = RequestMethod.GET)
	public List<Note> fetchNote(HttpServletRequest request) {
		System.out.println("I am token at get method :" + request.getHeader("token"));
		return noteService.fetchNote(request.getHeader("token"));
// System.out.println("-->" + b);
	}

	@RequestMapping(value = "/deleteNote", method = RequestMethod.DELETE)
	public void deleteNote(@RequestBody Note note, HttpServletRequest request) {

		System.out.println("I am  token at delete method :" + request.getHeader("token"));
		boolean b = noteService.delete(request.getHeader("token"), note);
		System.out.println("-->" + b);
	}
	@RequestMapping(value = "/updateNote", method = RequestMethod.PUT)
	public Note updateNote(@RequestBody Note note, HttpServletRequest request) {

		return noteService.updateNote(request.getHeader("token"), note);
}
}
