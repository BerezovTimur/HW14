package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.TicketOfferManager;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfferRepositoryTest {
    TicketOfferRepository repository = new TicketOfferRepository();
    TicketOfferManager item = new TicketOfferManager(repository);

    TicketOffer item1 = new TicketOffer(1, 10000, "LED", "BKK", 980);
    TicketOffer item2 = new TicketOffer(2, 15000, "LED", "HEL", 90);
    TicketOffer item3 = new TicketOffer(3, 7500, "BKK", "LED", 1100);
    TicketOffer item4 = new TicketOffer(4, 18000, "LED", "BKK", 980);
    TicketOffer item5 = new TicketOffer(5, 8000, "LED", "BKK", 980);
    TicketOffer item6 = new TicketOffer(6, 8500, "DME", "HEL", 980);

    @Test
    void save() {
        repository.save(item2);
        TicketOffer[] expected = new TicketOffer[]{item2};
        TicketOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        TicketOffer[] expected = new TicketOffer[]{item1, item2, item3, item4, item5};
        TicketOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        int findById = 3;
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        TicketOffer expected = item3;
        TicketOffer actual = repository.findById(findById);
        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        int removeById = 3;
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.removeById(removeById);
        TicketOffer[] expected = new TicketOffer[]{item1, item2, item4, item5};
        TicketOffer[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfNotExists() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        int findById = 4;
        repository.findById(findById);
        TicketOffer expected = null;
        TicketOffer actual = repository.findById(findById);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveIfNotExists() {
        int removeById = 3;
        repository.save(item1);
        repository.save(item2);
        assertThrows(NotFoundException.class, () -> repository.removeById(removeById));
    }
}