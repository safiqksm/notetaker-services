package com.aver.notetaker.services.notes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aver.notetaker.domain.Note;
import com.aver.notetaker.services.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
    protected final static Logger LOGGER = LoggerFactory
            .getLogger(NoteServiceImpl.class);

    @Autowired
    private NoteRepository noteRepository;

    // @Secured("hasRole('USER')")
    public List<Note> getAllNotes() {
        List<Note> notelist = new ArrayList<Note>();
        noteRepository.findAll().forEach(note -> notelist.add(note));
        return notelist;
    }

    // @Secured("hasRole('USER')")
    public Note getNoteById(String id) {
        return noteRepository.findOne(id);
    }

    // @Secured("hasRole('USER')")
    public void addNote(Note note) {
        note.setCreatedOnDate(new Date());
        noteRepository.save(note);
    }

    // @Secured("hasRole('ADMIN')")
    public void delete(String id) {
        noteRepository.delete(id);
    }
}
