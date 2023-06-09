package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   void addCar(Car car);
   List<User> listUsers();
   User getUserByCar(String carModel, int carSeries);
}
