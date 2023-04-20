package toolstask1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class Database {
    @PersistenceContext
    private EntityManager entityManager;

    public Database() {
    }

    public void insert(CalculationForm calculation) {
        entityManager.persist(calculation);
    }

    public List<CalculationForm> selectAll() {
        return entityManager.createQuery("select c from Calculation c", CalculationForm.class).getResultList();
    }
}
