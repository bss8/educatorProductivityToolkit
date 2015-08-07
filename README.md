# Educator Productivity Toolkit
Can you see this? 2569
A productivity tool for instructors.     
Users will have the ability to:
 - read/write data for a class;
 - perform analytics on class and individual student performance;
 - email reports, gradebook, and other materials

### Class Diagram:    
http://i.imgur.com/nZi23I4.png
### Downloadable JAR:    
https://drive.google.com/file/d/0BzUtXxcCG9ZvbW10RHZEX3o5OUU/view?usp=sharing
### Online Data (Spreadsheet):     
https://docs.google.com/spreadsheets/d/1uJVvxDvBN-pvjwuSWcTjdmX9DePW0a3y1JByMMIzpIM/edit?usp=sharing
### StackOverflow on creating generic array:        
https://stackoverflow.com/questions/31486242/java-instantiating-array-object-of-type-t-using-a-factory/31486323?noredirect=1#comment50937886_31486323

# 1. Setup Instructions

To build the updated project, add the following dependencies (JAR files) in a directory. For example:
 - Create a folder called "projectDependencies"
 - In this folder, include mail.jar: 
   http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-eeplat-419426.html#javamail-1.4.5-oth-JPR

# 2. Installing Git: 
- Go to the site and download: https://git-scm.com/download/win
- During configuration, select both Git Bash and Git GUI
- Select "Use with Windows Command Prompt"

# 3. Installing IntelliJ:
- Go to the site, make an account using your Texas State email, and download:
https://confluence.jetbrains.com/display/IntelliJIDEA/Basics+and+Installation
- Take most default options but look through some of the settings and remove components that are not commonly used to speed up load times. Web servers like Glassfish, Tomcat; version control plugins: we will be using Git and GitHub;
- From the main menu, click on "View" and check all four options (Toolbar, Tool Buttons, Status Bar, Navigation Bar)
- Ctrl+Shift+A for looking up commands; Ctrl+Shift+F for global searches
- Navigate to: File > Project Structure > Modules > Dependencies
- Click the green + icon and select "JARs or directories..."
- Navigate to and select your directory "projectDependencies"
- Click "Apply" then "OK"
- The libraries should now be included in the project. See my previous emails for details on how to build a project JAR or     compile to run. 

# 4. Working with GitHub:
- Make an account: https://github.com/
- Send me your user name so I can add you to the project
- Download the code as a zip and extract it somewhere

# 5. Configuring the project to compile and run:
Note that there is some duplication with #1 above as both steps reference including mail.jar

- Select a project SDK (usually located in Program Files > Java > jdk###). IntelliJ I believe comes with one but if you don't find it, you can download a jdk from Oracle. I recommend version 1.6 something. 
- Download the latest mail.jar from Oracle: 
http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-eeplat-419426.html#javamail-1.4.5-oth-JPR
- Extract just mail.jar from the zip to some location
- In IntelliJ, select "Open Project," then "from existing sources" (just follow the prompts until you can select the folder)
- When you are prompted with selecting the project source, navigate to the workflowProcess-master folder. Select it
- Finish opening the project, go to File > Project Structure > Modules > Dependencies
- Click the + icon, then select 1. Jar or directories
- find mail.jar and add is as a dependency to the project
- Go back to File > Project Structure; then select Artifacts
- Click the + icon, hover over JAR, then "From modules with dependencies"
- To build the project JAR, on the main menu, select Build > Build Artifacts; a little popup will open, select "Build"
- You should now have an "out" directory with two sub-folders - artifacts and production. 
- Finally, to compile and run the application for the first time, select the "Main" class
- Right click, Run Main (or Ctrl + Shift + F10)

# 6. Marking directories in IntelliJ
- When you build a JAR for the project, the "out" directory should be automatically set to ignore
- right click on ".idea" directory, select "Mark directory as," then select "Excluded"
- the "src" directory should be automatically marked as source when you create the project
- the "test" directory should be marked as test: right click > mark directory as > test
- the file "educatorProductivityToolkit-master.iml" should be automatically ignored
- the file "MANIFEST.MF" should be ignored; it is used for packaging the app as a JAR
- Colors in IntelliJ (https://www.jetbrains.com/idea/help/file-status-highlights.html):
    - red: ignored by Git
    - blue: the file has been modified from it's current version / a change has been made
    - green: a new file is added
    - brown: file exists locally, but is not in the repository, and is not scheduled for adding. 

As the project directory structure changes and we add things like packages, other dependencies, we may need to go through this process a few times.
If we are mostly working remote, we can look into meeting tools like Cisco WebEx or Skype so we can share the desktop and get on a call together.

# Using the applications - Basic Instructions
The application is user friendly and in most cases provides a detailed popup message in case anything goes wrong or if the user skips an important step. Below is a general outline for interacting with the application's main features:

 - One must be connected to the internet to use this application. If behind a proxy server and/or a firewall, some functionality may not work. This app should work on the Texas State network. 
 - Whenever sending an email is an option, the "To" field is required. The remaining fields may be skipped by typing a dash (-) character in the text box. The "To" field may accept multiple emails - they must be separated by a semicolon and there must not be any blank spaces in between. The "CC" field only accepts one email. 
 - To view analytics, authenticate using an instructor account; student accounts do not have sufficient permission to run analytics. The "Import" button must be clicked on the main page prior to running analytics. 
 - To view "Current User Info" the "Import" button must be clicked to read in data. 
 - Some menu items on the "File" menu do nothing, they are placeholders for a future release (I plan to continue adding to and improving this application). 
 - Students should see a bronze logo when logging in; instructors should see a metalic blue logo.  
 - Mnemonics and accelerators are used where appropriate, for example, when the "Help" menu is open, one may press Ctrl+A to open the "About" page. Ctrl+W will exit the application.
 - The application does not contain manu scrollbars and GUI elements are best viewed on a 1920x1080 resolution. The main applicaiton window (the one with the links and import button) should be kept full screen at all times. Should the window size change, it will collapse in a small box. Expanding it slightly and invoking: **right-click > maximize** should return the window to normal. 
