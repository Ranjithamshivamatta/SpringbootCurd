package com.bridgelabz.fundonoteapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundonoteapp.model.Label;
import com.bridgelabz.fundonoteapp.model.Note;
import com.bridgelabz.fundonoteapp.repository.LabelRepository;
import com.bridgelabz.fundonoteapp.repository.NoteRepository;
import com.bridgelabz.fundonoteapp.service.NoteService;
import com.bridgelabz.fundonoteapp.util.JsonToken;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	public NoteRepository noteRep;
	
	@Autowired
	public LabelRepository labelRep;

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private JsonToken token;

	@Override
	public Note noteCreate(Note note, HttpServletRequest request) {
		String JsonToken = request.getHeader("token");
		int varifiedUserId = token.tokenVerification(JsonToken);
		note.setUserId(varifiedUserId);
		return noteRep.save(note);
	}

	

	@Override
	public boolean delete(String header,Note note) {

		int varifiedUserId = token.tokenVerification(header);
		noteRep.deleteByUserIdAndNoteId(varifiedUserId, note.getNoteId());
		return false;

	}
	
	@Override
	public Note updateNote(String header, Note note) {
		int varifiedUserId = token.tokenVerification(header);
		System.out.println("varifiedUserId :" + varifiedUserId);
		Optional<Note> maybeNote = noteRep.findByUserIdAndNoteId(varifiedUserId, note.getNoteId());
		System.out.println("maybeNote :" + maybeNote);
		Note presentNote = maybeNote.map(existingNote -> {
			System.out.println("noteee here");
			existingNote.setDescription(
					note.getDescription() != null ? note.getDescription() : maybeNote.get().getDescription());
			existingNote.setTitle(note.getTitle() != null ? note.getTitle() : maybeNote.get().getTitle());
			return existingNote;
		}).orElseThrow(() -> new RuntimeException("Note Not Found"));

		return noteRep.save(presentNote);
}
	@Override
	public List<Note> fetchNote(String header) {
		int varifiedUserId = token.tokenVerification(header);
		System.out.println("i m in fetch :"+varifiedUserId);

		List<Note> notes = (List<Note>) noteRep.findByUserId(varifiedUserId);
	
		return notes;
}



	@Override
	public Label updateLabel(String header, Label label) {
		int varifiedUserId = token.tokenVerification(header);
		System.out.println("varifiedUserId :" + varifiedUserId);
		Optional<Label> maybeLabel = labelRep.findByUserIdAndLabelId(varifiedUserId, label.getLabelId());
		System.out.println("maybeLabel :" + maybeLabel);
		Label presentLabel = maybeLabel.map(existingLabel -> {
			System.out.println("Lable is here");
			existingLabel.setLabelName(
					label.getLabelName() != null ? label.getLabelName() : maybeLabel.get().getLabelName());
			
			return existingLabel;
		}).orElseThrow(() -> new RuntimeException("Label Not Found"));

		return labelRep.save(presentLabel);
	}



	@Override
	public Label labelCreate(Label label, HttpServletRequest request) {
		String JsonToken = request.getHeader("token");
		int varifiedUserId = token.tokenVerification(JsonToken);
		label.setUserId(varifiedUserId);
		return labelRep.save(label);
	}



	@Override
	public boolean delete(String header, Label label) {
		int varifiedUserId = token.tokenVerification(header);
		labelRep.deleteByUserIdAndLabelId(varifiedUserId, label.getLabelId());
		return false;
	}



	@Override
	public List<Label> fetchLabel(String header) {
		int varifiedUserId = token.tokenVerification(header);
		System.out.println("i m in fetch :"+varifiedUserId);
		
		List<Label> labels = (List<Label>) labelRep.findByUserId(varifiedUserId);
	
		return labels;
	}
	
	
	
	
	
	
	
	


	
	}

