import java.sql.*;
import java.util.ArrayList;

public class SqlClient {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:product.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Product> selectAll()  {
        String requestString = "SELECT * FROM product";
        ArrayList<Product> store = new ArrayList<>();
        try(ResultSet set = statement.executeQuery(requestString)) {
            while(set.next()){
                Product product = new Product(
                        set.getInt("prodid"),
                        set.getString("title"),
                        set.getInt("price"));
                product.setId(set.getInt("id"));
                store.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return store;
    }

    static void insertRow(Product product) {
        String requestString = "INSERT INTO product (prodid, title, price) VALUES(?, ?, ?);";

        try {
            preparedStatement = connection.prepareStatement(requestString);
            preparedStatement.setInt(1, product.getProdid());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static void deleteTable() {

        try {
            statement.executeUpdate("DELETE FROM product");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static int[] batchInsert(ArrayList<Product> store) {
        String requestString = "INSERT INTO product (prodid, title, price) VALUES(?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(requestString);
            preparedStatement.clearBatch();

            for (Product product: store) {
                preparedStatement.setInt(1, product.getProdid());
                preparedStatement.setString(2, product.getTitle());
                preparedStatement.setInt(3, product.getPrice());
                preparedStatement.addBatch();
            }

            return preparedStatement.executeBatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static String getPrice(String title){
        String requestString = "SELECT price FROM product WHERE title=\"" + title +"\"";
        String price = "Product not found";

        try(ResultSet set = statement.executeQuery(requestString)){
            if (set.next()) {
                price = Integer.toString(set.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return price;
    }

    static String updatePrice(String title, int price) {
        String requestString = "UPDATE product SET price = ? WHERE title = ?";
        String result = "Title: " + title + ", not found";
        try {
            preparedStatement = connection.prepareStatement(requestString);
            preparedStatement.setInt(1, price);
            preparedStatement.setString(2, title);
            int response = preparedStatement.executeUpdate();
            if (response == 1) {
                result = "Update successful";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    static ArrayList<Product> getByPriceDiapason(int bPrice, int ePrice) {
        ArrayList<Product> list = new ArrayList<>();
        String requestString = "SELECT * FROM product WHERE price >= ? AND price < ?";

        try {
            preparedStatement = connection.prepareStatement(requestString);
            preparedStatement.setInt(1, bPrice);
            preparedStatement.setInt(2, ePrice);
            ResultSet set = preparedStatement.executeQuery();

            while (set.next()) {
                Product product = new Product(
                        set.getInt("prodid"),
                        set.getString("title"),
                        set.getInt("price")
                );
                product.setId(set.getInt("id"));
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


//    synchronized static String getNick(String login, String password) {
//        String request = "SELECT nickname FROM users WHERE login='" +
//                login + "' AND password='" + password + "'";
//        try (ResultSet set = statement.executeQuery(request)) {
//            if (set.next()) {
//                return set.getString(1);
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
