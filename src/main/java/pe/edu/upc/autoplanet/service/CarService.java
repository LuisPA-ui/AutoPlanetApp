package pe.edu.upc.autoplanet.service;

import java.util.Collection;

import pe.edu.upc.autoplanet.model.Car;

public interface CarService {
	
	public abstract int createCar(Car car);
	public abstract int updateCar(Long id, Car car);
	public abstract int deleteCar(Long id);
	public abstract Collection<Car> getCars();

}
