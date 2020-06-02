package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOffer implements Comparable<TicketOffer>{
    public int id;
    public int price;
    public String from;
    public String to;
    public int time;


    @Override
    public int compareTo(TicketOffer o) {
        return price - o.price;
    }
}
