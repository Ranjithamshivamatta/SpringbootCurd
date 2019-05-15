package com.bridgelabz.fundonoteapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundonoteapp.model.Label;

import com.bridgelabz.fundonoteapp.service.NoteService;

@RestController
public class LabelController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/createLabel", method = RequestMethod.POST)
	public Label createLabel(@RequestBody Label label, HttpServletRequest request) {
		return noteService.labelCreate(label, request);
	}

	@RequestMapping(value = "/fetchLabel", method = RequestMethod.GET)
	public List<Label> fetchNote(HttpServletRequest request) {
		System.out.println("I am token at get method :" + request.getHeader("label"));
		return noteService.fetchLabel(request.getHeader("token"));

	}

	@RequestMapping(value = "/deleteLabel", method = RequestMethod.DELETE)
	public void deleteLabel(@RequestBody Label label, HttpServletRequest request) {

		System.out.println("I am  token at delete method :" + request.getHeader("token"));
		boolean b = noteService.delete(request.getHeader("token"), label);
		System.out.println("-->" + b);
	}

	@RequestMapping(value = "/updateLabel", method = RequestMethod.PUT)
	public Label updateLabel(@RequestBody Label label, HttpServletRequest request) {

		return noteService.updateLabel(request.getHeader("token"), label);
	}
}
