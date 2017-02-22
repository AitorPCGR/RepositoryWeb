

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioyFin
 *
 */
@WebListener
public class EscuchaInicioyFin implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EscuchaInicioyFin() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("PROGRAMA FINALIZADO");
    	System.out.println("PROGRAMA FINALIZADO");
    	System.out.println("PROGRAMA FINALIZADO");
    	System.out.println("PROGRAMA FINALIZADO");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("PROGRAMA INICIADO");
    	System.out.println("PROGRAMA INICIADO");
    	System.out.println("PROGRAMA INICIADO");
    	System.out.println("PROGRAMA INICIADO");
    }
	
}
