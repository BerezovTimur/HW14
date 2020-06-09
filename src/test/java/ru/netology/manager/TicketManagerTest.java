package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketOfferRepository repository = new TicketOfferRepository();
    TicketOfferManager item = new TicketOfferManager(repository);

    TicketOffer item1 = new TicketOffer(1, 10000, "LED", "BKK", 980);
    TicketOffer item2 = new TicketOffer(2, 15000, "LED", "HEL", 90);
    TicketOffer item3 = new TicketOffer(3, 7500, "BKK", "LED", 1100);
    TicketOffer item4 = new TicketOffer(4, 18000, "LED", "BKK", 1080);
    TicketOffer item5 = new TicketOffer(5, 8000, "LED", "BKK", 1000);
    TicketOffer item6 = new TicketOffer(6, 8500, "DME", "HEL", 120);

    @BeforeEach
    void setUp() {
        item = new TicketOfferManager(repository);
        item.addTicket(item1);
        item.addTicket(item2);
        item.addTicket(item3);
        item.addTicket(item4);
        item.addTicket(item5);
    }

    @Test
    void shouldFindAllAndSortByPrice() {
        TicketOffer[] expected = new TicketOffer[]{item5, item1, item4};
        TicketOffer[] actual = item.findALl("LED", "BKK");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllAndSortByTime() {
        Comparator<TicketOffer> comparator = new TicketByPriceAscComparator();
        TicketOffer[] expected = new TicketOffer[]{item1, item5, item4};
        TicketOffer[] actual = item.findAndSortByTime("LED", "BKK", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNoTickets() {
        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = item.findALl("DME", "HEL");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNotFound() {
        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = item.findALl("DME", "BKK");
        assertArrayEquals(expected, actual);
    }
}
