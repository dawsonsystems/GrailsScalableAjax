<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta name="layout" content="main" />
    <title>Ajax Demo - Tomcat Advanced IO</title>

    <g:javascript library="prototype" />

     <style>
      .message {
        margin:4px;
        border-bottom:1px solid #ccc;
        
      }
    h2 {
      margin-left:8px;
      font-size:2.0em;
      margin-bottom:10px;
    }
     </style>
     <script>
      function listen()
      {
          new Ajax.Updater(
              { success: 'last_message'},
              '/tomcat_advancedio/comet',
              {
                  method:     'get',
                  insertion: 'bottom',              
                  onComplete:  function(transport)
                  {
                      listen();
                  }
          });
      }

      Event.observe(window, 'load', function() {
        listen();    
      });
    </script>
  </head>
  <body>
    <h2>Ajax Messaging Demo - Tomcat Advanced IO</h2>

    <hr/>
    <div id="last_message">


    </div>
  </body>
</html>