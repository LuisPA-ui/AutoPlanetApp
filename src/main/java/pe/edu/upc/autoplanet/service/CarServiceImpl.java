package pe.edu.upc.autoplanet.service;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.autoplanet.model.Car;
import pe.edu.upc.autoplanet.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepository;
	
	@Override
	@Transactional
	public int createCar(Car car) {
		int result = carRepository.countByPlaca(car.getPlaca());
		if(result == 0) {
			carRepository.save(car);
		}
		return result;
	}

	@Override
	public int updateCar(Long id, Car car) {
		int result = 0;
		Optional<Car> originalCar = carRepository.findById(id);
		if(originalCar.isPresent()) {
			Car updatedCar = originalCar.get();
			updatedCar.setBrand(car.getBrand());
			updatedCar.setColor(car.getColor());
			updatedCar.setModel(car.getModel());
			updatedCar.setPlaca(car.getPlaca());
			updatedCar.setYear(car.getYear());
			carRepository.save(updatedCar);
		}
		return result;
	}

	@Override
	public int deleteCar(Long id) {
		Optional<Car> car = carRepository.findById(id);
		if(!car.isPresent()) {return -1; }
		carRepository.delete(car.get());
		return 0;
	}

	@Override
	public Collection<Car> getCars() {
		return carRepository.findAllByOrderByPlacaDesc();
	}
	
}
