package jetty_continuation

import org.mortbay.util.ajax.Continuation
import org.mortbay.util.ajax.ContinuationSupport

class MessageController {

  def messageService

  def index = {}

  def listen = {
    Continuation cont = ContinuationSupport.getContinuation(
            request, this);

    if (!cont.isResumed()) {
      log.info "Adding a new Listener - ${request.remoteAddr}"
      messageService.addListener(cont)
    }

    render "<div class='message'>${messageService.lastMessage}</div>"
  }
}
