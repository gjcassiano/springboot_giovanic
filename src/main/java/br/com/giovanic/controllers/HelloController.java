

package br.com.giovanic.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

@Controller
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @ResponseBody()
    public String sayHello() {
        Logger.getAnonymousLogger().info("TESTE");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
//        manager.(pais);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
        return "TESTE";
    }

}
