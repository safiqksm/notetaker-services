package com.aver.notetaker.services.notes;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aver.notetaker.domain.Note;

public class NoteValidator implements Validator {
    public boolean supports(Class clazz) {
        return Note.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        Note p = (Note) obj;
        if (StringUtils.isEmpty(p.getMessage())) {
            e.rejectValue("message", "note.invalid.message");
        }
    }
}