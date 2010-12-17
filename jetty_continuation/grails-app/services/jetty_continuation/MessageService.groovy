package jetty_continuation

class MessageService {

  def listeners = []
  def lastMessage

  def addListener(def continuation) {
    synchronized (listeners) {
      listeners << continuation
      continuation.suspend(60000);
    }
  }

  def onMessage(def message) {
    synchronized (listeners) {
      int count = listeners.size()
      long then = System.currentTimeMillis()

      lastMessage = message
      listeners*.resume()
      listeners.clear()

      long now = System.currentTimeMillis()
      log.info "Resumed ${count} listeners in ${then - now} millis"
    }
  }
  
  def getLastMessage() {
    return lastMessage
  }
}

