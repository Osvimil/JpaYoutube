
package jpayoutube;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author oswaldosaldivar
 */
public class Actualizacion {
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaYoutubePU");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = null;
    
    public static void main(String[] args) {
        
        Person o = new Person();
        o.setId(3);
        o.setName("Martha Leticia");
        
        try{
            
            et = em.getTransaction();
            et.begin();
            em.merge(o);
            System.out.println("Actualizado");
            et.commit();
        
        
        }catch(RuntimeException e){
            if(et.isActive()){
                et.rollback();
                throw e;
            }
        
        }
        
    }
    
}
