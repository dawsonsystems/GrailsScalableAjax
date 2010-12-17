package tomcat_advancedio

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import org.apache.catalina.CometEvent
import org.apache.catalina.CometProcessor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.support.WebApplicationContextUtils

class CometServlet extends HttpServlet implements CometProcessor {

  Logger log = LoggerFactory.getLogger(CometServlet)

  def connections = []


  def getMessageService() {
    WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    return ctx.getBean("messageService")
  }

  void event(CometEvent event) throws IOException, ServletException {

    def messageService = getMessageService()

    if(event.getEventType() == org.apache.catalina.CometEvent.EventType.BEGIN) {
      log.info "Connection Started from ${event.httpServletRequest.remoteAddr}"
      synchronized (connections) {
        messageService.addEvent(event)
      }
    }
  }
}
