package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfferTest {
    TicketOffer item1 = new TicketOffer(1, 10000, "LED", "BKK", 980);
    TicketOffer item2 = new TicketOffer(2, 20000, "LED", "BKK", 980);
    TicketOffer item3 = new TicketOffer(3, 13000, "LED", "BKK", 980);

    @Test
    void shouldSortByPrice(){
        TicketOffer[] expected = new TicketOffer[]{item1, item3, item2};
        TicketOffer[] actual = new TicketOffer[]{item1, item2, item3};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}