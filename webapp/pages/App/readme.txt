//Apache web server origin-access-allow-control is disabled
//Goto folder conf under apache and  open web.xml
//Add the following filter under filter section
     <filter>
       <filter-name>CorsFilter</filter-name>
       <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
     </filter>
     <filter-mapping>
       <filter-name>CorsFilter</filter-name>
       <url-pattern>/*</url-pattern>
     </filter-mapping>
//Something here
