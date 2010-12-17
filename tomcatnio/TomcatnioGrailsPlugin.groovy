class TomcatnioGrailsPlugin {
    // the plugin version
    def version = "1.3.4"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
	    "grails-app/domain/*.groovy",
	    "grails-app/controllers/*.groovy"		
    ]
    // don't package in war
    def scopes = [excludes:'war']
	
    //Derived from the standard Grails tomcat plugin. Modified, so if there are problems with the mods talk to me (David Dawson)
    def author = "David Dawson"
    def authorEmail = "david.dawson@dawsonsystems.com"
    def title = "Apache Tomcat (NIO) plugin for Grails"
    def description = '''\\
Replaces Jetty with Tomcat as the default development time server for Grails
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/tomcatnio"
}
