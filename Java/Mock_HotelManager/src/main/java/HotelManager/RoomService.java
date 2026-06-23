package HotelManager;

public class RoomService {
    String itemName;
    double price; 
    boolean isHotMeal; 


    public static void main(String[] args) {

        public RoomService (String itemName, double price, boolean isHotMeal){
            this.itemName = itemName; 
            this.price = price;
            this.isHotMeal = isHotMeal; 
        }

        //getters 

        public String getItemName (){
            return this.itemName;
        }

        public double getPrice(){
            return this.price;
        }

        public boolean getIsHotMeal(){
            return this.isHotMeal;
        }

        //setters

        public void SetItemName (String itemName){
            this.itemName = itemName;
        }

        public void SetPrice (double Price){
            this.price = price; 
        }

        public void setIsHotMeal(boolean isHotMeal){
            this.isHotMeal = isHotMeal;
        }

        public void printOrder() {
            System.out.println(this.itemName + this.price + this.isHotMeal);
        }



        
    }
    
}
