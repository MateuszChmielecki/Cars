package pl.mateusz.Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mateusz.Cars.entity.Brand;
import pl.mateusz.Cars.entity.Car;
import pl.mateusz.Cars.entity.Group;
import pl.mateusz.Cars.enums.SegmentType;
import pl.mateusz.Cars.services.BrandService;
import pl.mateusz.Cars.services.CarService;
import pl.mateusz.Cars.services.GroupService;

@Controller
@RequestMapping(path="/Admin")
public class DataController {
    private final CarService carService;
    private final GroupService groupService;
    private final BrandService brandService;

    public DataController(CarService carService, GroupService groupService, BrandService brandService) {
        this.carService = carService;
        this.groupService = groupService;
        this.brandService = brandService;
    }

    @GetMapping("/data")
    public String data() {
        Group vw = new Group(1L, "Volkswagen AG", "Germany");
        groupService.save(vw);
        Group bmw = new Group(2L, "BMW", "Germany");
        groupService.save(bmw);
        Group toyota = new Group(3L, "Toyota Motor Corporation", "Japan");
        groupService.save(toyota);
        Group stellantis = new Group(4L, "Stellantis N.V.", "French-Italian-American");
        groupService.save(stellantis);


        Brand volkswagen = new Brand(1L ,"Audi", vw, "Germany");
        brandService.save(volkswagen);
        Brand bentley = new Brand(2L,"Bentley", vw, "England");
        brandService.save(bentley);
        Brand bugatti = new Brand(3L, "Bugatti", vw, "France");
        brandService.save(bugatti);
        Brand lamborghini = new Brand(4L,"Lamborghini", vw, "Italy");
        brandService.save(lamborghini);
        Brand porsche = new Brand(5L, "Porsche", vw, "Germany");
        brandService.save(porsche);
        Brand seat = new Brand(6L, "Seat", vw, "Spain");
        brandService.save(seat);

        Car audiA38l = new Car(1L, volkswagen,"A3", "8L", 1996, 2003, SegmentType.C,"zdjecie");
        carService.save(audiA38l);

        return "redirect:/Cars/listCar";
    }

    @GetMapping("/home_reps")
    @ResponseBody
    public String respBody() {
        return "Surowy tekst";
    }
}

