Application contains html page, classes, properties file and third party library.

Start application
---

	gradle clean; gradle tomcatRunWar

Application routes
---

	/index.html - Simple html page (webapp);
	/api/users - Information about all users in JSON format (servlet);
	/api/user/{userId} - Information about user with specified Id in JSON format (servlet).