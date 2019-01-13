
package jpayoutube;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author oswaldosaldivar
 */
public class Agregando {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaYoutubePU");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = null;
    public static void main(String[] args) {
        
        Person persona1 = new Person();
        Person persona2 = new Person();
        Person persona3 = new Person();
        Person persona4 = new Person();
        Person persona5 = new Person();
        Person persona6 = new Person();
        
        persona1.setName("Carolina");
        persona2.setName("Maria");
        persona3.setName("Daniela");
        persona4.setName("Martha");
        persona5.setName("Nora");
        persona6.setName("Celina");
        
        
        
        try{
            
            et = em.getTransaction();
            et.begin();
            em.persist(persona1);
            em.persist(persona2);
            em.persist(persona3);
            em.persist(persona4);
            em.persist(persona5);
            em.persist(persona6);
            et.commit();
        
        }catch(RuntimeException e){
            if(et.isActive()){
                et.rollback();
            
                throw e;
            }        
        }        
    }
    
}
