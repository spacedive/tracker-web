**tracker-web**
----

	Application which tracks domain referrals and displays the top three domain referrals.

* **How to run**
1. Run 'tracker-web.war' on Tomcat
2. Launch in browser: 'http://localhost:8080/tracker-web/

**REST APIs**

* **API 1**
	Saves a domain referral

	* **URL**
	  /domains

	* **Method:**
	  `GET`

	*  **URL Params**
		{domain}

	* **Success Response:**
	  * **Code:** 200 <br />

	* **Sample Call:**
		/domains/some.domain.com

* **API 2**
	Gets top domain referrals by count in descending order

	* **URL**
  	/domains

	* **Method:**
	  `GET`

	* **Optional:**

	   `limit=[numeric]`
		 (default is 3)

	* **Success Response:**
	  * **Code:** 200 <br />
	    **Content:** `{"domain1":4,"domain2":2,"domain3":2}`

	* **Sample Call:**
		/domains?limit=5
