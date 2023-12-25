package com.example.springsecurityofficial.entity.product;

import jakarta.persistence.*;

@Entity
@Table(name = "основная_информация")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Монитор_id")
	private int id;
	@Column(name = "Цена")
	private int price;
	@Column(name = "Страна_производитель")
	private String countryManufacturer;
	@Column(name = "Изображение")
	private String imageSource;
	@Column(name = "Описание")
	private String description;
	@Column(name = "Модель")
	private String model;
	@Column(name = "Бренд")
	private String brand;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Монитор_id")
	private AudioInfo audioInfo;

	public Product() {
	}

	public Product(int price, String countryManufacturer, String imageSource, String description, String model, String brand) {
		this.price = price;
		this.countryManufacturer = countryManufacturer;
		this.imageSource = imageSource;
		this.description = description;
		this.model = model;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", price=" + price +
				", countryManufacturer='" + countryManufacturer + '\'' +
				", imageSource='" + imageSource + '\'' +
				", description='" + description + '\'' +
				", model='" + model + '\'' +
				", brand='" + brand + '\'' +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCountryManufacturer() {
		return countryManufacturer;
	}

	public void setCountryManufacturer(String countryManufacturer) {
		this.countryManufacturer = countryManufacturer;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
