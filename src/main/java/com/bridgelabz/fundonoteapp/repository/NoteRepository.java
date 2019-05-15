package com.bridgelabz.fundonoteapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundonoteapp.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

	public List<Note> findByUserId(int varifiedUserId);

	public Optional<Note> findByUserIdAndNoteId(int varifiedUserId, int noteid);

	// public List<Note> findAll(Optional<Note> findByUserId);

	// public List<Note> findOne(Optional<Note> findByUserId);

	public List<Note> findAll();

	void deleteByUserIdAndNoteId(int varifiedUserId, int noteId);

}
