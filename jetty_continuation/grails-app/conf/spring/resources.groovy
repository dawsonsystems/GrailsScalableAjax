// Place your Spring DSL code here
beans = {

  //This adds support to augment the Spring exception handling and pass RetryRequest up to the top level.
  exceptionHandler(jetty_continuation.RetryRequestExceptionResolver)

}
