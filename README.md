Application contains html page, classes, properties file and third party library.

Start application
```
gradle clean; gradle tomcatRun
```

or

```
gradle clean; gradle tomcatRunWar
```

Application routes
---

	/index.html - Wellcome page (html page);
	/api/users - Information about all users in JSON format (Servlet);
	/api/user/{userId} - Information about user with specified Id in JSON format (Servlet).
	/springapi/hello - Hello message (Spring MVC).