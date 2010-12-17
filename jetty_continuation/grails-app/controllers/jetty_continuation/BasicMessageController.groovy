package jetty_continuation

class BasicMessageController {

    def index = {
      //simulate doing something to tie up a thread.
      Thread.sleep(150)
    }
}
