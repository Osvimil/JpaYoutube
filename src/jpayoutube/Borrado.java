
package jpayoutube;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author oswaldosaldivar
 */
public class Borrado {
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaYoutubePU");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = null;
    
    public static void main(String[] args) {
        
        try{
                et = em.getTransaction();
                et.begin();
        
                Person q = em.find(Person.class, 2);
                em.remove(q);
                et.commit();
        
        }catch(RuntimeException e){
            if(et.isActive()){
                et.rollback();
            
                throw e;
            }
        
        }
        
      
        
        
    }
    
}
