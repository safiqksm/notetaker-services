package com.aver.notetaker.services.notes;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aver.notetaker.domain.Note;
import com.aver.notetaker.domain.Quote;
import com.aver.notetaker.services.exception.ApplicationException;
import com.aver.notetaker.services.repository.NoteRepository;

@RestController
@RequestMapping("/notes")
public class NoteServiceEndPoint {
    protected final static Logger LOGGER = LoggerFactory
            .getLogger(NoteServiceEndPoint.class);

    @Autowired
    private NoteService noteService;
    
    @Autowired
    private QuoteRetriever quoteRetriever;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public NoteListResponseWrapper all() {
        // get random quote
        Quote quote = quoteRetriever.getRandomQuote();
        LOGGER.info(quote.toString());


        // get all mnotes
        List<Note> notes = noteService.getAllNotes();
        
        // prepare response
        NoteListResponseWrapper response = new NoteListResponseWrapper();
        response.setNotes(notes);
        response.setQuote(quote);
        
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Note find(@PathVariable String id) {
        return noteService.getNoteById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        noteService.delete(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Note add(@RequestBody Note note, BindingResult result) {
        NoteValidator noteValidator = new NoteValidator();
        noteValidator.validate(note, result);

        if (result.hasErrors()) {
            throw new ApplicationException(result);
        } else {
            noteService.addNote(note);
            LOGGER.info("Added new note with id {}", note.getId());
        }
        return note;
    }

}
