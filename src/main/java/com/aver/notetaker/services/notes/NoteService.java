package com.aver.notetaker.services.notes;

import java.util.List;

import com.aver.notetaker.domain.Note;

public interface NoteService {

    public List<Note> getAllNotes();

    public Note getNoteById(String id);

    public void addNote(Note note);

    public void delete(String id);
}
