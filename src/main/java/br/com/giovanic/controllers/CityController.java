package br.com.giovanic.controllers;

import br.com.giovanic.po.City;
import br.com.giovanic.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/cities")
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("create")
    public void createCity(@RequestBody City city) {
        Logger.getAnonymousLogger().info(city.toString());
        cityService.create(city);
    }

    @GetMapping
    public List<City> allCitys(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "100") Integer pageSize) {

        return cityService.findAll(pageNo, pageSize);
    }

    @GetMapping("{key}/search")
    public List<City> searchCitys(@PathVariable String key) {
        return cityService.findCitiesByCountryCode(key);
    }

    @GetMapping("{id}")
    public City getById(@PathVariable Integer id) {
        return cityService.getById(id);
    }

    @GetMapping("count")
    public Long count() {

//        Faker faker = new Faker();
//        List<City> cities = new ArrayList<>();
//
//        for (int i = 0; i < 5000; i++) {
//
//            cities.add(new City()
//                    .setCountryCode(faker.zipCode())
//                    .setPopulation(new Random().nextInt(100000000))
//                    .setDistrict(faker.secondaryAddress())
//                    .setName(faker.cityPrefix()));
//        }
//
//        cityService.create(cities);

        return cityService.count();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        cityService.deleteById(id);
    }
}