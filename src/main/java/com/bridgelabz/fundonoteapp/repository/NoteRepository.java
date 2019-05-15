package com.bridgelabz.fundonoteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundonoteapp.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

	// void delete(Token existingToken);

}
