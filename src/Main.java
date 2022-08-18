import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
Connect connect = new Connect();
Warehouse warehouse = new Warehouse();
warehouse.setAddress("Chui street 123");
warehouse.setName_of_products("Computers");
warehouse.setQuantity(50000);

   connect.insertWarehouse(warehouse);
   connect.deleteWarehouse(warehouse);
   connect.deleteProduct(warehouse);
    }
}
