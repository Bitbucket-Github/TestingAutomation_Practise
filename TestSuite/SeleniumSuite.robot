*** Settings ***
Library    SeleniumLibrary
Suite Setup    Log    I am inside test suite setup
Suite Teardown    Log    I am inside test suite teardown    
Test Setup    Log    I am inside test setup    
Test Teardown    Log    I am inside test teardown    

Default Tags    Sanity    

*** Test Cases ***
OpenBrowserTest   
    [Tags]    OpenChrome
    Open Browser    https://google.com    chrome
    Maximize Browser Window
    Set Browser Implicit Wait    3
    Input Text    name=q    Automation Step By Step 
    Press Keys    name=q    ENTER
    Sleep    2      
    Close Browser
    
SimpleLoginTest
    [Tags]    LoginTest
    [Documentation]    This is a simple login test
    Open Browser       ${url}   chrome
    Set Browser Implicit Wait    3
    LoginKeyword 
    Click Element     xpath://a[@class='logout']
    Log    Logged out successfully 
    #Log    This test was executed by %{username} on %{os}                 
    Close Browser
  
*** Variables ***
${url}    http://automationpractice.com/index.php
@{credentials}    bitbucket76@gmail.com    gitbucket123@gmail.com 
&{LoginData}    username=bitbucket76@gmail.com    password=Github123  

*** Keywords ***
LoginKeyword 
    Click Element     class=login        
    Input Text        id=email    ${credentials}[0]    
    Input Password    name=passwd    ${LoginData}[password]   
    Click Button      id=SubmitLogin