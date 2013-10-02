package al76.net.jcr.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jcr.Credentials;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import org.apache.jackrabbit.commons.JcrUtils;

/**
 * Hello world!
 *
 */
public class JCRConnect {

	public static void main(String[] args) {
		try {
			Repository repos = JcrUtils.getRepository("http://localhost:4502/crx/server");

			Credentials cd = new SimpleCredentials("admin", "admin".toCharArray());

			Session session = repos.login(cd);

			System.out.println("Hello Session UserID: " + session.getUserID());

		} catch (RepositoryException ex) {
			Logger.getLogger(JCRConnect.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
