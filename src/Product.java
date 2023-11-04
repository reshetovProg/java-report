public class Product {
    //item_name,is_expense,quantity,sum_of_one
    private String item_name;
    private int quantity;
    private int sum_of_one;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSum_of_one() {
        return sum_of_one;
    }

    public void setSum_of_one(int sum_of_one) {
        this.sum_of_one = sum_of_one;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Product(String item_name, int quantity, int sum_of_one) {
        this.item_name = item_name;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }

    @Override
    public String toString() {
        return "Product{" +
                "item_name='" + item_name + '\'' +
                ", quantity=" + quantity +
                ", sum_of_one=" + sum_of_one +
                '}';
    }
}
