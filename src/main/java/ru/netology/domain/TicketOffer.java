package ru.netology.domain;

public class TicketOffer{
    public int id;
    public int price;
    public String from;
    public String to;
    public int time;

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
