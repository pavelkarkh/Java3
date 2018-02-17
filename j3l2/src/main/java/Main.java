import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SqlClient.connect();
        System.out.println("Connection established");

        System.out.println("Deleting exist data...");
        SqlClient.deleteTable();
        System.out.println("Done...");

        System.out.println("Try batch insert...");
        ArrayList<Product> store = new ArrayList<>();
        for(int i = 0; i < 10000; i++) {
            store.add(new Product(i + 1, "name" + (i + 1), (int) Math.round(Math.random() * 1000) + i ));
        }
        SqlClient.batchInsert(store);
        System.out.println("Done!");

        System.out.println(SqlClient.getPrice("name44"));
        System.out.println(SqlClient.updatePrice("name44", 521));
        System.out.println(SqlClient.getPrice("name44"));

        System.out.println("Search product by price diapason");
        ArrayList<Product> queryList;
        queryList = SqlClient.getByPriceDiapason(1000, 1150);
        System.out.println("Find " + queryList.size() + " product(s)");
        for (Product product: queryList) {
            product.printInfo();
        }
        System.out.println();
        System.out.println("All operations done...");
        SqlClient.disconnect();
        System.out.println("Close connection");
    }

}
