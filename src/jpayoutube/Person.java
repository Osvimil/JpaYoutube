
package jpayoutube;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author oswaldosaldivar
 */

@Entity
@Table(name="PERSON")
public class Person {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PERSON_ID")
    private int personId;
    
    @Column(name="PERSON_NAME")
    private String personName;
    
    public Person(){
    
    }
    
    public int getId(){
        return personId;
    }
    public void setId(int personId){
        this.personId=personId;
    }
    
    public String getName(){
        return personName;
    }
    
    public void setName(String personName){
        this.personName=personName;
    
    }
    
}
