*** Settings ***
Library        SeleniumLibrary    

*** Test Cases ***
MyFirstTestCase
        Log  HelloWorld......
        
FirstSeleniumTest
        open Browser      http://automationpractice.com/index.php   chrome
       Input Text            xpath://input[@id='search_query_top']                T-Shirts  
       Click Button    //button[@name='submit_search']    
       Sleep    5      
        Close Browser 
        