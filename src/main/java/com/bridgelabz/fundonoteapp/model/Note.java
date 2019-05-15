package com.bridgelabz.fundonoteapp.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Note")
public class Note {
	@Id
	private int id;
	private int noteid;
	private String title;
	private String description;
	private Timestamp createdTime;
	private Timestamp updateTime;
	private boolean isArchive;
	private boolean isPinned;
	private boolean inTrash;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoteid() {
		return noteid;
	}

	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isArchive() {
		return isArchive;
	}

	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}

	public boolean isInTrash() {
		return inTrash;
	}

	public void setInTrash(boolean inTrash) {
		this.inTrash = inTrash;
	}

	public Note() {
		super();
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", noteid=" + noteid + ", title=" + title + ", description=" + description + ", createdTime="
				+ createdTime + ", updateTime=" + updateTime+ ", isArchive=" + isArchive + ", isPinned=" + isPinned + ", inTrash=" + inTrash +"]";
	}
}
