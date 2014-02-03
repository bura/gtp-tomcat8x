Application contains classes, properties file and third party library.

Start application
---

	gradle clean; gradle tomcatRunWar

Application routes
---

	/users - Information about all users in JSON format
	/user/{userId} - Information about user with specified Id in JSON format