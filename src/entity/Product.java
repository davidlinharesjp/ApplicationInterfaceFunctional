package entity;

public class Product {

	private Long id;
	private String name;
	private Double price;

	public Product() {

	};

	public Product(Long id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", name=" + name + ", price=" + String.format("%.2f", price ) + "]";
	}
	
	

}
