package Controller;

import Model.Costumer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @RequestMapping("/costumer")
    @Cacheable(value = "customer")
    public ResponseEntity<List<Costumer>> customer(){
        System.out.println("Informacion del cache");

        return new ResponseEntity<List<Costumer>>(costumerList(), HttpStatus.OK);
    }


    public List<Costumer> costumerList() {
        System.out.println("No cache");
       List<Costumer> listCostumer = Arrays.asList(
               new Costumer(1,"Juan"),
               new Costumer(2,"Perdro"),
               new Costumer(3,"Raul")
       );
       return listCostumer;
    }
}
