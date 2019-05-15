package com.bridgelabz.fundonoteapp.controller;

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
		/*
		 * @RequestMapping(value = "/updatenote",method = RequestMethod.POST) public
		 * Note updateNote(@RequestBody Note note,HttpServletRequest request) { return
		 * noteService.delete(header); }
		 */
	}

}
