package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductManager manager;
    Smartphone smartphoneOne = new Smartphone(1, "testPhoneName1", 1111, "testManufacturer1");
    Smartphone smartphoneTwo = new Smartphone(2, "testPhoneName2", 2222, "testManufacturer2");
    Smartphone smartphoneThree = new Smartphone(3, "testPhoneName3", 3333, "testManufacturer3");
    Book bookOne = new Book(1, "testBookName1", 1111, "testAuthor1");
    Book bookTwo = new Book(2, "testBookName2", 2222, "testAuthor2");
    Book bookThree = new Book(3, "testBookName3", 3333, "testAuthor3");


    @Test
    void shouldFindByNameSmartphone() {
        String smartphoneName = "testPhoneName1";
        Product[] returned = new Product[]{smartphoneOne,smartphoneTwo, smartphoneThree};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{smartphoneOne};
        Product[] actual = manager.searchBy(smartphoneName);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByNameBook() {
        String bookName = "testBookName1";
        Product[] returned = new Product[]{bookOne,bookTwo,bookThree};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{bookOne};
        Product[] actual = manager.searchBy(bookName);
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindByAuthor() {
        String author = "testAuthor2";
        Product[] returned = new Product[]{bookOne,bookTwo,bookThree};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{bookTwo};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByManufactured() {
        String manufactured = "testManufacturer3";
        Product[] returned = new Product[]{smartphoneOne,smartphoneTwo, smartphoneThree};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{smartphoneThree};
        Product[] actual = manager.searchBy(manufactured);
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldBookNameNotFound() {
        String bookName = "testBookNameX";
        Product[] returned = new Product[]{bookOne,bookTwo,bookThree};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(bookName);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldBookAuthorNotFound() {
        String author = "testAuthorX";
        Product[] returned = new Product[]{bookOne,bookTwo,bookThree};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSmartphoneNameNotFound() {
        String smartphoneName = "testPhoneNameX";
        Product[] returned = new Product[]{smartphoneOne,smartphoneTwo, smartphoneThree};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(smartphoneName);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSmartphoneManufacturerNotFound() {
        String smartphoneManufacturer = "testManufacturerX";
        Product[] returned = new Product[]{smartphoneOne,smartphoneTwo, smartphoneThree};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(smartphoneManufacturer);
        assertArrayEquals(expected, actual);
    }

}