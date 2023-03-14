package prog2.exercise4.flight.booking.system;


import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FlightBooking {
    
    public String getRandomString(int length) {
        String range = "abcdefgABCDEFG0123456789";
        Random random = new Random();
        StringBuffer str = new StringBuffer();
        
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(24);
            str.append(range.charAt(number));
        }
        return str.toString();
    }


    private static final String flightCompany = "Flights-of-Fancy";
    private String flightID = getRandomString(9);
    private String passengerFullName;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private double departingTicketPrice = 100;
    private double returnTicketPrice = 100;
    private double totalTicketPrice;
    private String ticketNumber = getRandomString(4);
    private BookingClass bookingClass;
    private TripType typeOfTrip;
    private TripSource sourceOfTrip;
    private TripDestination destinationOfTrip;
    private SourceAirport airportOfSource;
    private DestinationAirport airportOfDestination;


    public enum BookingClass {
        FIRST, BUSINESS, ECONOMY;
    }

    public enum TripType {
        ONE_WAY, RETURN;
    }

    public enum TripSource {
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS;
    }

    public enum TripDestination {
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS;;
    }

    public enum SourceAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport;
    }

    public enum DestinationAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport;
    }



    private int a;

    public FlightBooking(String passengerFullName, LocalDate departureDate, LocalDate returnDate, int childPassengers, int adultPassengers) {
        this.passengerFullName = passengerFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
    }


    public String getFlightCompany() {
        return flightCompany;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getPassengerFullName() {
        return passengerFullName;
    }


    public int getChildrenPassengers() {
        return childPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }

    public LocalDate getDepartingDate() {
        return departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public TripSource getTripSource() {
        return sourceOfTrip;
    }
  
    public double getTotalTicketPrice() {
        return this.totalTicketPrice;
    }


    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        long dayDifference = ChronoUnit.DAYS.between(departureDate, returnDate);
        if (dayDifference == 1) {
            this.returnDate = departureDate.plusDays(2);
            this.a = 1;
        } 
        else if (dayDifference == 0) {
            this.returnDate = departureDate.plusDays(2);
            this.a = 2;
        } 
        else {
            this.returnDate = returnDate;
            this.a = 0;
        }

    }

    public void setBookingClass(String classType) {
        int choice = Integer.parseInt(classType);
        switch (choice) {
            case 1:
                bookingClass = BookingClass.FIRST;
                break;
            case 2:
                bookingClass = BookingClass.BUSINESS;
                break;
            case 3:
                bookingClass = BookingClass.ECONOMY;
                break;
        }
    }

    public void setTripType(String type) {
        int choice = Integer.parseInt(type);
        switch (choice) {
            case 1:
                typeOfTrip = TripType.ONE_WAY;
                break;
            case 2:
                typeOfTrip = TripType.RETURN;
                break;
        }
    }

    public void setTripSource(String tripSource) {  
        int choice = Integer.parseInt(tripSource);
        switch (choice) {
            case 1:
                sourceOfTrip = TripSource.NANJING;
                break;
            case 2:
                sourceOfTrip = TripSource.BEIJING;
                break;
            case 3:
                sourceOfTrip = TripSource.SHANGHAI;
                break;
            case 4:
                sourceOfTrip = TripSource.OULU;
                break;
            case 5:
                sourceOfTrip = TripSource.HELSINKI;
                break;
            case 6:
                sourceOfTrip = TripSource.PARIS;
                break;
        }
    }

    public void setTripDestination(String tripSource, String tripDestination) {
        int srcChoice = Integer.parseInt(tripSource);
        int desChoice = Integer.parseInt(tripDestination);
        if (srcChoice != desChoice) {
            switch (desChoice) {
                case 1:
                    destinationOfTrip = TripDestination.NANJING;
                    break;
                case 2:
                    destinationOfTrip = TripDestination.BEIJING;
                    break;
                case 3:
                    destinationOfTrip = TripDestination.SHANGHAI;
                    break;
                case 4:
                    destinationOfTrip = TripDestination.OULU;
                    break;
                case 5:
                    destinationOfTrip = TripDestination.HELSINKI;
                    break;
                case 6:
                    destinationOfTrip = TripDestination.PARIS;
                    break;
                
            }
        }
         else {
            System.out.println("The trip source and the trip destination should not be the same!");
        }

    }

    public String getTicketNumber() {
        String ticketNum;
        if (typeOfTrip == TripType.ONE_WAY) {
            ticketNum = "11";
            if (bookingClass == BookingClass.FIRST) {
                ticketNum = ticketNum + "F" + ticketNumber;
                if (sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";

                } 
                else if ((sourceOfTrip == TripSource.OULU && destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI && destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";

                } 
                else if ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";

                } 
                else {
                    ticketNum = ticketNum + "INT";

                }
            } else if (bookingClass == BookingClass.BUSINESS) {
                ticketNum = ticketNum + "B" + ticketNumber;
                if (sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";

                } 
                else if ((sourceOfTrip == TripSource.OULU && destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI && destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";

                } 
                else if ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";

                } 
                else {
                    ticketNum = ticketNum + "INT";

                }
            } else if (bookingClass == BookingClass.ECONOMY) {
                ticketNum = ticketNum + "E" + ticketNumber;
                if (sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";

                } 
                else if ((sourceOfTrip == TripSource.OULU && destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI && destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";

                } 
                else if ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";

                } 
                else {
                    ticketNum = ticketNum + "INT";

                }
            }
        } else {
            ticketNum = "22";
            if (bookingClass == BookingClass.FIRST) {
                ticketNum = ticketNum + "F" + ticketNumber;
                if (sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";
                } 
                else if ((sourceOfTrip == TripSource.OULU && destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI && destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                } 
                else if ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                } 
                else {
                    ticketNum = ticketNum + "INT";
                }
            } 
            else if (bookingClass == BookingClass.BUSINESS) {
                ticketNum = ticketNum + "B" + ticketNumber;
                if (sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";
                } 
                else if ((sourceOfTrip == TripSource.OULU && destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI && destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                } 
                else if ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                } 
                else {
                    ticketNum = ticketNum + "INT";
                }
            } else if (bookingClass == BookingClass.ECONOMY) {
                ticketNum = ticketNum + "E" + ticketNumber;
                if (sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";
                } 
                 else if ((sourceOfTrip == TripSource.OULU && destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI && destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                }
                 else if ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                }
                 else {
                    ticketNum = ticketNum + "INT";
                }
            }
        }

        return ticketNum;
    }

    public void setDepartingTicketPrice(int childPassengers, int adultPassengers) {
        double departingTicketPrice = 0.0;
        if ((sourceOfTrip == TripSource.OULU && destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI && destinationOfTrip == TripDestination.OULU) || ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI))) {
            departingTicketPrice = (300 + 0.1 * 300) + 0.05 * 300;
        }
         else {
            departingTicketPrice = 300 * (1 + 0.15 + 0.1);
        }
        if (bookingClass == BookingClass.FIRST) {
            this.departingTicketPrice = departingTicketPrice * childPassengers + departingTicketPrice * adultPassengers + 250;
        } 
        else if (bookingClass == BookingClass.BUSINESS) {
            this.departingTicketPrice = departingTicketPrice * childPassengers + departingTicketPrice * adultPassengers + 150;
        } 
        else if (bookingClass == BookingClass.ECONOMY) {
            this.departingTicketPrice = departingTicketPrice * childPassengers + departingTicketPrice * adultPassengers + 50;
        }
    }

    public void setReturnTicketPrice() {
        if (typeOfTrip == TripType.ONE_WAY) {
            this.returnTicketPrice = 0;
        } 
        else {
            this.returnTicketPrice = this.departingTicketPrice;
        }
    }

    public void setTotalTicketPrice() {
        this.totalTicketPrice = this.departingTicketPrice + this.returnTicketPrice;
    }

   


}
