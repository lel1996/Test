package com.lierlin.DesignPatterns;

public class DaiLiDesign {
    interface BuyTicket{
        void showticket();
    }
    static class Train implements BuyTicket{

        @Override
        public void showticket() {
            System.out.println("һ�Ż�Ʊ");
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
            System.out.print("ͨ�������ã�");
            showticket();
        }
    }

    public static void main(String[] args) {
        BuyTicket x = new Train();
        TicketCenter y = new TicketCenter(x);
        y.buy();
    }
}
