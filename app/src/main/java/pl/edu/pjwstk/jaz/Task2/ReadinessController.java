package pl.edu.pjwstk.jaz.Task1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwstk.jaz.Examples.Test1Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@RestController
public class ReadinessController {
    @PersistenceContext
    private final EntityManager em;

    public ReadinessController(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @GetMapping("auth0/is-ready")
    public void readinessTest() {
        var entity = new Test1Entity();
        entity.setName("sdavsda");


        em.persist(entity);
    }

}
