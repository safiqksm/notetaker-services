package com.aver.notetaker.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aver.notetaker.domain.Note;

/**
 * Created by mathew on 10/29/15.
 */
public interface NoteRepository extends MongoRepository<Note, String> {
}
