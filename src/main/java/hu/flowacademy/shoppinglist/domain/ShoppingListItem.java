package hu.flowacademy.shoppinglist.domain;

import javax.persistence.*;

@Entity
@Table(name = "shoppinglist_item")
public class ShoppingListItem {

    @Id
    @Column(name = "id")
    private String id;

    @Column()
    private String product;

    @Column(name = "product_cathegory")
    private String productCathegory;

    @Column()
    private int quantity;

    @Column()
    private int price;

    @Column()
    private String comment;

    @OneToOne
    @JoinColumn(name = "user_name", foreignKey = @ForeignKey(name = "fk_shoppinglistitem_user"))
    private Users user;

    public ShoppingListItem() {
    }


    public ShoppingListItem(String id, String product, String productCathegory, int quantity, int price, String comment, Users user) {
        this.id = id;
        this.product = product;
        this.productCathegory = productCathegory;
        this.quantity = quantity;
        this.price = price;
        this.comment = comment;
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

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
