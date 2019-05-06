package hu.flowacademy.shoppinglist.domain;

public class ShoppingListItem {

    private String id;
    private String product;
    private String productCathegory;
    private int quantity;
    private int price;
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductCathegory() {
        return productCathegory;
    }

    public void setProductCathegory(String productCathegory) {
        this.productCathegory = productCathegory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ShoppingListItem{" +
                "id='" + id + '\'' +
                ", product='" + product;
    }
}
