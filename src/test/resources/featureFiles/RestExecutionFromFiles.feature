Feature: Rest Call from files and compare the outputs
 Scenario Outline: Read the rest api from files and compare the outputs
   Given Two files <fileOne> and <fileTwo>
   When  User call the api from files and compare the out results
   Then  The output results should be displayed in console.
   Examples:
     | fileOne       |   fileTwo  |
     | file1      | file2|




    

 
 