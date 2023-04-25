package cart.dao;

public class ProductEntity {
    private Long id;
    private final String name;
    private final Integer price;
    private final String imageUrl;

    public ProductEntity(Long id, String name, Integer price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}