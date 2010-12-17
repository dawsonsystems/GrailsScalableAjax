package tomcat_advancedio

import org.apache.catalina.CometEvent

class MessageService {

  static transactional = true

  def events = []

  def onMessage(def message) {
    println "Message ${message}"
    synchronized (events) {
      events.each { CometEvent event ->
        event.httpServletResponse.writer.println("<div class='message'>${message}</div>")
        event.httpServletResponse.writer.flush()
        event.httpServletResponse.writer.close()
        event.close()
      }
      events.clear()
    }
  }

  def addEvent(def event) {
    synchronized (events) {
      events << event
    }
  }
}
