package com.bridgelabz.fundonoteapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundonoteapp.model.Note;
import com.bridgelabz.fundonoteapp.repository.NoteRepository;
import com.bridgelabz.fundonoteapp.service.NoteService;
import com.bridgelabz.fundonoteapp.util.JsonToken;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	public NoteRepository noteRep;

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private JsonToken token;

	@Override
	public Note noteCreate(Note note, HttpServletRequest request) {
		String JsonToken = request.getHeader("token");
		int id = token.tokenVerification(JsonToken);
		note.setUserId(id);
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
//		public List getAllNote() {
//			return (List) noteRep.findAll();
//		}
		List<Note> notes = (List<Note>) noteRep.findByUserId(varifiedUserId);
	
		return notes;
}
	
	
	
	
	
	
	
	


	
	}

