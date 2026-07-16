public class Booking {

    private String userEmail;
    private int roomNumber;

    public Booking (String userEmail, int roomNumber){
        this.roomNumber = roomNumber;
        this.userEmail = userEmail;
    }

    public String getEmail (){
        return this.email;    
    }

    public int getRoomNumber (){
        return roomNumber;
    }

    public void setEmail (String userEmail){
        this.userEmail = userEmail;
    }

    public void setFloorNumber (int roomNumber) { 
        this.roomNumber = roomNumber;
    }

    System.out.println("The users email address is" + this.userEmail );
    System.out.println("The floor number is: " + this.roomNumber );

    //RodKev - Feat do not recognize this new file 






    
}
