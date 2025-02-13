package com.shoppingcartsystem;

import java.util.*;

// Represents a Shopping Cart where products are added, their prices are stored,
class ShoppingCart {
	// HashMap to store product prices (Product Name -> Price)
	private Map<String, Double> productPrices = new HashMap<>();

	// LinkedHashMap to store products maintaining the order they were added (Product Name -> Quantity)
	private Map<String, Integer> cartItems = new LinkedHashMap<>();

	// TreeMap to store products sorted by their prices (Price -> Product Name)
	private Map<Double, String> productsSortedByPrice = new TreeMap<>();

	//Adds a product to the cart.
	public void addProduct(String productName, double price) {
		// Add product price to the HashMap
		productPrices.put(productName, price);

		// Add or update product quantity in the cart
		cartItems.put(productName, cartItems.getOrDefault(productName, 0) + 1);

		// Add or update the product in the TreeMap (sorted by price)
		productsSortedByPrice.put(price, productName);
	}

	// Displays all products in the order they were added to the cart using LinkedHashMap.
	public void displayProductsInOrder() {
		System.out.println("\nProducts in Order (LinkedHashMap):");
		for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
			System.out.println("Product: " + entry.getKey() + ", Quantity: " + entry.getValue());
		}
	}
	// Displays products sorted by price using TreeMap.
	public void displayProductsSortedByPrice() {
		System.out.println("\nProducts Sorted by Price (TreeMap):");
		for (Map.Entry<Double, String> entry : productsSortedByPrice.entrySet()) {
			System.out.println("Product: " + entry.getValue() + ", Price: " + entry.getKey());
		}
	}

	// Displays the total price of all products in the cart.
	public void displayTotalPrice() {
		double totalPrice = 0.0;
		for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
			totalPrice += productPrices.get(entry.getKey()) * entry.getValue();
		}
		System.out.println("\nTotal Price of Products in Cart: " + totalPrice);
	}
}
