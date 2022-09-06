1.Build the project by maven 
2.All the dependencies are resolved in pom file ,include diffrents broswer drivers
3.FrameWork contains both UI and API 
4.To execute the UI frame work folowing command need to "run mvn install -Dbrowser=chrome -DtestType=UI"
5.For API following comand need to run mvn install -DtestType=rest
6.Both the task are implemented using Cucucmer and testng 
7.TestGN listners have been provied but jira (Create cycle ,add test-cases ,update the result still need to implemnet )
8.Logs are created by Selenium listner and Testng lisnters 
9.project relateded utils like mail ,excel reader ,csv reder db Connection .has been created ,but need to call the as reqried .
10.Cucumber Hooks are left free for future use
