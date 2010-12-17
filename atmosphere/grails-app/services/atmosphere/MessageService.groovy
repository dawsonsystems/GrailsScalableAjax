package atmosphere

import org.atmosphere.cpr.DefaultBroadcaster

class MessageService {

  def presenceGateway

  def broadcaster = new DefaultBroadcaster()
  def lastMessage

  def addListener(def atmosphereEvent) {
    println "Adding Atmosphere Resource to Broadcaster"
    broadcaster.addAtmosphereResource(atmosphereEvent)
    atmosphereEvent.suspend()
  }

  def onMessage(def message) {
    lastMessage = message
    presenceGateway.publishPresence("Last MSG:${lastMessage}")
    broadcaster.resumeAll()
  }

  def getLastMessage() {
    return lastMessage
  }
}

