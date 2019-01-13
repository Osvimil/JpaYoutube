
package jpayoutube;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaYoutube {

    
    public static void main(String[] args) {
        
        Person p1 = new Person();
        p1.setName("Oswaldo");
        
        Person p2 = new Person();
        p2.setName("Alfonso");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaYoutubePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;
        
        try{
            et = em.getTransaction();
            et.begin();
            em.persist(p1);
            em.persist(p2);
            et.commit();
        
        }catch(RuntimeException e){
            if(et.isActive()){
                et.rollback();
                throw e;
            
            }
        
        }
        
        
    }
    
}
