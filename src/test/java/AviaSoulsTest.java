import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();

    Ticket ticket1 = new Ticket("Moscow", "SPb", 5900, 9, 10);
    Ticket ticket2 = new Ticket("Moscow", "Kazan", 4800, 8, 9);
    Ticket ticket3 = new Ticket("Moscow", "Omsk", 12400, 10, 13);
    Ticket ticket4 = new Ticket("Moscow", "Novosibirsk", 16500, 14, 18);
    Ticket ticket5 = new Ticket("Moscow", "Kaliningrad", 15000, 12, 13);
    Ticket ticket6 = new Ticket("Moscow", "SPb", 8580, 12, 13);
    Ticket ticket7 = new Ticket("Moscow", "SPb", 7900, 10, 11);
    Ticket ticket8 = new Ticket("Moscow", "Khabarovsk", 19700, 11, 19);
    Ticket ticket9 = new Ticket("Moscow", "Ekaterinburg", 14900, 14, 16);
    Ticket ticket10 = new Ticket("Moscow", "Khabarovsk", 17400, 20, 6);
    Ticket ticket11 = new Ticket("Moscow", "Khabarovsk", 20000, 15, 0);
    Ticket ticket12 = new Ticket("Moscow", "Khabarovsk", 18200, 22, 6);


    @Test
    public void shouldSortTicketsByPrice() {

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};

        Arrays.sort(tickets);

    }

    @Test
    public void shouldNotFindTickets() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        aviaSouls.search("Moscow", "Sotchi");

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Moscow", "Sotchi");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindOneTicket() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        aviaSouls.search("Moscow", "Omsk");

        Ticket[] expected = {ticket3};
        Ticket[] actual = aviaSouls.search("Moscow", "Omsk");

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldSortTicketsByFlightTime() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket3, ticket4, ticket8, ticket9, ticket10, ticket11};

        Arrays.sort(tickets, timeComparator);

    }

    @Test
    public void shouldNotFindTicketsWhenSortingByFlightTime() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);
        aviaSouls.add(ticket11);
        aviaSouls.add(ticket12);

        aviaSouls.searchAndSortBy("Moscow", "Sotchi", timeComparator);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Sotchi", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicketWhenSortingByFlightTime() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);
        aviaSouls.add(ticket11);
        aviaSouls.add(ticket12);

        aviaSouls.searchAndSortBy("Moscow", "Ekaterinburg", timeComparator);

        Ticket[] expected = {ticket9};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Ekaterinburg", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}


