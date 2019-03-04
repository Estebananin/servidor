
import model.Manager.EMF;
import model.vo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 * @author pc
 */
public class test {
    
    public static void main(String[] args){
        
        EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("Tiempo");
        EntityManager em = emfInstance.createEntityManager();
        
        
        try {


            em.getTransaction().begin();

            TypedQuery<Usuario> query = (TypedQuery<Usuario>) em.createQuery(

                    "SELECT e FROM Usuario e", Usuario.class);

            em.getTransaction().commit();

            // em.close();

            System.out.println(query.getResultList().size());

        } catch (Exception e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

//            return new ArrayList<Usuario>();

        } finally {

            if (em != null && em.isOpen()) {

                // em.getTransaction().commit();

                em.close();

            }

        }
        
        
    }
    
    
    
}
