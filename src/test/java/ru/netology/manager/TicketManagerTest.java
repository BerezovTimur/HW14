package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketOfferRepository repository =new TicketOfferRepository();
    TicketOfferManager item = new TicketOfferManager(repository);

    TicketOffer item1 = new TicketOffer(1, 10000, "LED", "BKK", 980);
    TicketOffer item2 = new TicketOffer(2, 15000, "LED", "HEL", 90);
    TicketOffer item3 = new TicketOffer(3, 7500, "BKK", "LED", 1100);
    TicketOffer item4 = new TicketOffer(4, 18000, "LED", "BKK", 980);


    @Test
    void shouldFindAll() {
        item.addTicket(item1);
        item.addTicket(item2);
        item.addTicket(item3);
        item.addTicket(item4);
        TicketOffer[] expected = new TicketOffer[]{item1, item4};
        TicketOffer[] actual = item.findALl("LED", "BKK");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNoTickets() {
        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = item.findALl("LED", "BKK");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyIfNotFound() {
        item.addTicket(item1);
        item.addTicket(item2);
        item.addTicket(item3);
        item.addTicket(item4);
        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = item.findALl("DME", "BKK");
        assertArrayEquals(expected, actual);
    }



    /*
    @Test
    void shouldSortTicketsIfContains() {
        manager = new OfferManager(repository);
        manager.offerAdd(offer1);
        manager.offerAdd(offer2);
        manager.offerAdd(offer3);
        manager.offerAdd(offer4);
        Offer[] expected = new Offer[]{offer3, offer1};
        Offer[] actual = manager.findAll("LED", "DME");
        assertArrayEquals(expected, actual);
    }*/
}