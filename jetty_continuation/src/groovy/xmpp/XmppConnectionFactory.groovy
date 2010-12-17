package xmpp

import org.jivesoftware.smack.ConnectionConfiguration
import org.jivesoftware.smack.SASLAuthentication
import org.jivesoftware.smack.XMPPConnection

class XmppConnectionFactory {

  static XMPPConnection getConnection() {
    ConnectionConfiguration config = new ConnectionConfiguration("alexandros", 5222, "alexandros");

    XMPPConnection connection = new XMPPConnection(config);

    connection.connect();

    SASLAuthentication.supportSASLMechanism("PLAIN", 0);

    connection.login("jettycontinuation", "password", "res");

    connection.roster.subscriptionMode = org.jivesoftware.smack.Roster.SubscriptionMode.accept_all
    
    return connection
  }
}
