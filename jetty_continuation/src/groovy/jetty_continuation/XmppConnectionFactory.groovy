package jetty_continuation

import org.jivesoftware.smack.ConnectionConfiguration
import org.jivesoftware.smack.SASLAuthentication
import org.jivesoftware.smack.XMPPConnection

class XmppConnectionFactory {

  static XMPPConnection getConnection() {
    ConnectionConfiguration config = new ConnectionConfiguration("alexandros", 5222, "alexandros");

    XMPPConnection connection = new XMPPConnection(config);

    connection.connect();
    println "CONNECTED= ${connection.connected}"

    // You have to put this code before you login
    SASLAuthentication.supportSASLMechanism("PLAIN", 0);

    connection.login("grails", "password", "res");

    // See if you are authenticated
    System.out.println(connection.isAuthenticated());

    connection.roster.subscriptionMode = org.jivesoftware.smack.Roster.SubscriptionMode.accept_all
    
    return connection
  }
}
