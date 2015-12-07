package com.aver.notetaker.services.notes;

import java.util.List;

import com.aver.notetaker.domain.Note;
import com.aver.notetaker.domain.Quote;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteListResponseWrapper {
    private List<Note> notes;
    private Quote quote;

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}
