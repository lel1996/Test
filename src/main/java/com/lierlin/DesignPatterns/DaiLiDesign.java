package com.lierlin.DesignPatterns;

public class DaiLiDesign {
    interface BuyTicket{
        void showticket();
    }
    static class Train implements BuyTicket{

        @Override
        public void showticket() {
            System.out.println("一张火车票");
        }
    }
    static class TicketCenter implements BuyTicket{

        private BuyTicket ticket;
        public TicketCenter(BuyTicket ticket){
            this.ticket=ticket;
        }
        @Override
        public void showticket() {
            ticket.showticket();
        }
        public void buy(){
            System.out.print("通过代理购得：");
            showticket();
        }
    }

    public static void main(String[] args) {
        BuyTicket x = new Train();
        TicketCenter y = new TicketCenter(x);
        y.buy();
    }
}
