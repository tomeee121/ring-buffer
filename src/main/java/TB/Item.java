package TB;

public class Item {
    private int price;
    private String brand;

    public Item(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
