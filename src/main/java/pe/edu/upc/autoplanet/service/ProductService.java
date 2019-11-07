package pe.edu.upc.autoplanet.service;

import java.util.Collection;

import pe.edu.upc.autoplanet.model.Product;

public interface ProductService {
	public abstract int createProduct(Product product);
	public abstract int updateProduct(Long id, Product product);
	public abstract int deleteProduct(Long id);
	public abstract Collection<Product> getProducts();

}
