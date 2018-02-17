public class Product {

    private int id;
    private int prodid;
    private String title;
    private int price;

    public Product(int prodid, String title, int price) {
        this.prodid = prodid;
        this.title = title;
        this.price = price;
    }

    public void printInfo() {
        System.out.println();
        System.out.print("[ id: " + id);
        System.out.print(", prodid: " + prodid);
        System.out.print(", title: " + title);
        System.out.print(", price: " + price + " ]");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
