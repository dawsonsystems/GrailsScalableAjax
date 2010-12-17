package xmpp

import org.jivesoftware.smack.packet.Presence


class StringToPresence {

  Presence transform(String content) {
    Presence p = new Presence(Presence.Type.available)
    p.status = content
    return p
  }

}
