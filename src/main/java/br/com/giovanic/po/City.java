package br.com.giovanic.po;

import javax.persistence.*;

@Entity(name = "city")
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country_code", length = 2, nullable = false)
    private String countryCode;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "population", nullable = false)
    private Integer population;

    public Integer getId() {
        return id;
    }

    public City setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public City setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public City setDistrict(String district) {
        this.district = district;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public City setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
