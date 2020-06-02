package ru.netology.manager;

import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;

public class TicketOfferManager {
    private TicketOfferRepository repository;

    public TicketOfferManager(TicketOfferRepository repository) {
        this.repository = repository;
    }

    public void addTicket(TicketOffer item) {
        repository.save(item);
    }

    public TicketOffer[] findALl(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer item : repository.findAll()) {
            if (item.getFrom().equalsIgnoreCase(from) && item.getTo().equalsIgnoreCase(to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
