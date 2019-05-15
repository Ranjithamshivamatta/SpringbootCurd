package com.bridgelabz.fundonoteapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundonoteapp.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer>{

	
	public List<Label> findByUserId(int varifiedUserId);

	public Optional<Label> findByUserIdAndLabelId(int varifiedUserId, int labelid);

	// public List<Note> findAll(Optional<Note> findByUserId);

	// public List<Note> findOne(Optional<Note> findByUserId);

	public List<Label> findAll();

	void deleteByUserIdAndLabelId(int varifiedUserId, int labelId);


}
