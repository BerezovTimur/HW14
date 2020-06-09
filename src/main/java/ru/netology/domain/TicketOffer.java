package ru.netology.domain;

public class TicketOffer implements Comparable<TicketOffer>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    @Override
    public int compareTo(TicketOffer o) {
        return price - o.price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTime() {
        return time;
    }

    public TicketOffer(int id, int price, String from, String to, int time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;
    }
}
