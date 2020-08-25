*** Settings ***
Library    SeleniumLibrary
Resource    ../ MyStoreResource.robot

*** Test Cases ***
Searching a Product throgh search bar
       open Browser         ${url}   chrome
       Maximize Browser Window
       Input Text            xpath://input[@id='search_query_top']                T-Shirts
       Press Keys            xpath://input[@id='search_query_top']  ENTER    
      Sleep    5      
       Close Browser 
       Log                        succesfully searched a product  
          
 Searching a product through navigation
       Log                       Searching a product through navigation    
      open Browser     ${url}   chrome
      Maximize Browser Window
      Set Browser Implicit Wait    5
      searchproduct
      Click Element    xpath://*[@id="layered_id_attribute_group_2"]    
      Click Element    xpath://*[@id="layered_id_attribute_group_24"]
      Close Browser
                
 
Send to a friend
     open Browser     ${url}        chrome
     Set Browser Implicit Wait    5
     searchproduct
     Click Image    xpath://*[@id="center_column"]/ul/li/div/div[1]/div/a[1]/img    
     Click Element    xpath://*[@id="send_friend_button"] 
     Maximize Browser Window 
     Input Text  xpath://*[@id="friend_name"]   Lasya
     Input Text    xpath://*[@id="friend_email"]       lasya@123@gmail.com
     Click Element    xpath://*[@id="sendEmail"]/span    
     Sleep    4           
     # Click Button    xpath://button[@id='sendEmail']//span[contains(text(),'Send')]
      # Click Element    classname=button      
      # Click Button    name=close   
      Close Browser
      
 

NewsLetter 
       open Browser     ${url}        chrome
       Set Browser Implicit Wait    5
       Maximize Browser Window
       Sleep    5    
      Input Text    id=newsletter-input     bitbucket7676@gmail.com    
      Click Button   name= submitNewsletter      
       