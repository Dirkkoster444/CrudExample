package nl.delpninity.gameshop.interceptor;
import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import nl.delpninity.gameshop.persistence.factories.DAOFactories;
import nl.delpninity.gameshop.persistence.factories.DAOFactory;
import nl.delpninity.gameshop.persistence.util.HibernateSessionManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class HibernateInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(HibernateInterceptor.class);
    @Override
    public void init() {
        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        // HibernateSessionManager.getSessionFactory();
    }
    @Override
    public void destroy() {
        DAOFactory.setFactory(null);
    }
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            Map<String, Object> sessionMap = invocation.getInvocationContext().getSession();
            return invocation.invoke();
        } catch (Exception e) {
            logger.error("Error saving game", e);
            return "error";
        }
    }
}