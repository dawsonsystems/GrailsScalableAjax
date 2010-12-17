package xmpp

import org.jivesoftware.smack.ConnectionConfiguration
import org.jivesoftware.smack.SASLAuthentication
import org.jivesoftware.smack.XMPPConnection

class XmppConnectionFactory {

  static org.jivesoftware.smack.XMPPConnection getConnection() {
    org.jivesoftware.smack.ConnectionConfiguration config = new org.jivesoftware.smack.ConnectionConfiguration("alexandros", 5222, "alexandros");

    org.jivesoftware.smack.XMPPConnection connection = new org.jivesoftware.smack.XMPPConnection(config);

    connection.connect();

    org.jivesoftware.smack.SASLAuthentication.supportSASLMechanism("PLAIN", 0);

    connection.login("tomcatnio", "password", "res");

    connection.roster.subscriptionMode = org.jivesoftware.smack.Roster.SubscriptionMode.accept_all
    
    return connection
  }
}
