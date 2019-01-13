
package jpayoutube;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author oswaldosaldivar
 */
public class Leyendo {
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaYoutubePU");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = null;
    
    
    public static void main(String[] args) {
        /*Person pp1 = new Person();
        Person pp2 = new Person();
        
        pp1.setName("Carolina");
        pp2.setName("Maria");*/
        
        
        try{
            
            et = em.getTransaction();
            et.begin();
            
            Person pp1 = em.find(Person.class,1);
            System.out.println("La persona es: "+pp1.getName());
            et.commit();
        
        }catch(RuntimeException e){
            if(et.isActive()){
                et.rollback();
            
                throw e;
            }
        
        
        }
        
    }
    
}
