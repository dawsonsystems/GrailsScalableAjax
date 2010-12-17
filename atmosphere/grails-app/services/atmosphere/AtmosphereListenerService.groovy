package atmosphere

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.atmosphere.cpr.AtmosphereResource
import org.atmosphere.cpr.AtmosphereResourceEvent

class AtmosphereListenerService {

    def messageService

    static transactional = true

    static atmosphere = [mapping: '/atmosphere/message']

    def onRequest (AtmosphereResource<HttpServletRequest, HttpServletResponse> event) {
      println "Connection from ${event.request.remoteAddr}"
      messageService.addListener(event)
    }

    def onStateChange (AtmosphereResourceEvent<HttpServletRequest, HttpServletResponse> event) {
      println "Sending message ${messageService.lastMessage} to client"
      event.resource.response.writer.print "<div class='message'>${messageService.lastMessage}</div>"
      event.resource.response.writer.flush()
    }
}
