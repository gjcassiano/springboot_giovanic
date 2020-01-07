package br.com.giovanic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.giovanic.po.City;
import br.com.giovanic.repository.CityRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<City> findAll() {
        Iterable<City> it = cityRepository.findAll();
        ArrayList<City> cities = new ArrayList<City>();
        it.forEach(cities::add);

        return cities;
    }

    public List<City> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        Iterable<City> it = cityRepository.findAll(pageable);

        ArrayList<City> cities = new ArrayList<City>();
        it.forEach(cities::add);

        return cities;
    }

    public City getById(Integer id) {
        return cityRepository.findById(id).orElse(null);
    }

    public Long count() {
        return cityRepository.count();
    }

    public void create(City city) {
        cityRepository.save(city);
    }
    public void create(List<City> city) {
        cityRepository.saveAll(city);
    }

    public void deleteById(Integer userId) {
        cityRepository.deleteById(userId);
    }

    public List<City> findCitiesByCountryCode(String countriesCode) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<City> query = cb.createQuery(City.class);
        Root<City> cityRoot = query.from(City.class);

        Path<String> coutryPath = cityRoot.get("countryCode");

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.like(coutryPath, countriesCode));

        query.select(cityRoot)
                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                .getResultList();
    }
}