package ru.netology.domain;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<TicketOffer> {
    @Override
    public int compare(TicketOffer o1, TicketOffer o2) {
        return o1.getTime() - o2.getTime();
    }

    /*public int compare(TicketOffer o1, TicketOffer o2) {
        return o1.getPrice() - o2.getPrice();
    }*/
}
