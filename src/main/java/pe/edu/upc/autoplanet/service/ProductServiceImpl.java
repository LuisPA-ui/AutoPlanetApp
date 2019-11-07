package pe.edu.upc.autoplanet.service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.autoplanet.model.Product;
import pe.edu.upc.autoplanet.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository; 
	
	@Override
	@Transactional
	public int createProduct(Product product) {
		int result = productRepository.countByName(product.getName());
		if(result == 0) {
			product.setEnteredAt(new Date());
			productRepository.save(product);
		}
		return result;
	}

	@Override
	public int updateProduct(Long id, Product product) {
		int result = 0;
		Optional<Product> originalProduct = productRepository.findById(id);
		if(originalProduct.isPresent()) {
			Product updatedProduct = originalProduct.get();
			updatedProduct.setName(product.getName());
			updatedProduct.setPrice(product.getPrice());
			updatedProduct.setBrand(product.getBrand());
			updatedProduct.setEnteredAt(product.getEnteredAt());
			productRepository.save(updatedProduct);
		}
		return result;
	}

	@Override
	public int deleteProduct(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(!product.isPresent()) {return -1; }
		productRepository.delete(product.get());
		return 0;
	}

	@Override
	public Collection<Product> getProducts() {
		return productRepository.findAllByOrderByNameDesc();
	}

}
