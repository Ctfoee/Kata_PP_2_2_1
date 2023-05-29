package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("porshe", 911);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(car1);
      userService.addCar(car1);
      userService.addUser(user1);

      Car car2 = new Car("porshe2", 912);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(car2);
      userService.addCar(car2);
      userService.addUser(user2);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().toString());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("porshe2", 912));

      context.close();
   }
}
