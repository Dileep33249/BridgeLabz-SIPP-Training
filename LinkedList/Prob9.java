public class TicketReservationSystem {
    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
        }
    }

    Ticket head = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicketById(int ticketId) {
        if (head == null) return;

        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            return;
        }

        Ticket curr = head, prev = null;

        do {
            if (curr.ticketId == ticketId) {
                if (curr == head) {
                    Ticket temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No matching ticket found.");
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total booked tickets: 0");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total booked tickets: " + count);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1001, "Alice", "Interstellar", "A1", "10:00 AM");
        system.addTicket(1002, "Bob", "Inception", "B2", "1:00 PM");
        system.addTicket(1003, "Charlie", "Interstellar", "A2", "10:00 AM");

        System.out.println("--- All Tickets ---");
        system.displayTickets();

        System.out.println("\n--- Search for 'Interstellar' ---");
        system.searchTicket("Interstellar");

        System.out.println("\n--- Remove Ticket ID 1002 ---");
        system.removeTicketById(1002);
        system.displayTickets();

        System.out.println("\n--- Count Tickets ---");
        system.countTickets();
    }
}
