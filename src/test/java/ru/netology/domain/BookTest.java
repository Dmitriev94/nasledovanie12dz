package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book bookOne = new Book(1, "testBookName1", 1111, "testAuthor1");

    @Test
    void bookNameTrue() {
        assertTrue(bookOne.matches("testBookName1"));
    }

    @Test
    void bookNameFalse() {
        assertFalse(bookOne.matches("testBookNameX"));
    }

    @Test
    void bookAuthorTrue() {
        assertTrue(bookOne.matches("testAuthor1"));
    }

    @Test
    void bookAuthorFalse() {
        assertFalse(bookOne.matches("testAuthorX"));
    }
}