# Test automation for web application navigator.ba
This is an automated Smoke test project for web application https://www.navigator.ba/ which covers core functions of web application (eg.find street, create new object, change to satelite view, switch to english language, zoom the map...).

###Prerequisities

#######Browser
Firefox must be installed; follow the directions at http://getfirefox.com to install it. On Unix, ensure that Firefox is on your path.

#######Java
The Java SE Development Kit must be installed; follow the directions at http://www.oracle.com/technetwork/java/javase/downloads/index.html to install it.

#######Selenium
Selenium is an project encapsulating a variety of tools and libraries enabling web browser automation. Selenium specifically provides infrastructure for the W3C WebDriver specification — a platform and language-neutral coding interface compatible with all major web browsers; follow the directions at http://www.seleniumhq.org/ to install Selenium and Selenium IDE.

#######TestNG
TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use.
TestNG must be installed; follow the directions at http://beust.com/testng/ to install it. Ensure that it is on your path.
              
#######Maven
Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
Maven must be installed; follow the directions at http://maven.apache.org/install.html
Add Surefire plug-in. This is the aggregator POM in Apache Maven Surefire project.

###Installing
######Clone the source repository from Github.    
*Install Java 8         
*Install Maven, using their instructions.  

*On the command line, enter:   
`git clone https://github.com/domorocki/NavigatorSmokeTest.git`

Open a terminal/console/command prompt, change to the directory where you cloned NavigatorSmokeTest, and type:       

`mvn test`
           
           
######Building with Eclipse

Open Eclipse, select File → Import... Expand the “Git” folder, select “Projects from Git”, and hit the Next button.

On the “Select Repository Source” screen, choose “URI” and enter `https://github.com/domorocki/NavigatorSmokeTest.git` And then click Next.

Select “Import existing projects” on the “Wizard for project import” page. Hit Next.

Select all the projects shown and finish the wizard.

Use Run as Application to start /src/test/java/com.navigator.tests/CreatePlace.java

###Running the tests
* Repo https://github.com/domorocki/NavigatorSmokeTest.git contains Java file which is actually automation of smoke test for web application https://www.navigator.ba/

Running CreatePlace.java you will be able to automate successfully creating a new place with Name, City, Zip, Adress, House number, Description and Category. searching for a street, choosing it from shown results, zooming the map, switching to satelite view and switching to english language and searching for created object.

Report of testing Java file is generated as html file in NavigatorSmokeTest/test-output/.


 
####Author
Nedim Kaknjasevic
