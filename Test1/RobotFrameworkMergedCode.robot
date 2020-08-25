*** Settings ***
Library    String
Library    SeleniumLibrary    
Resource    ../RobotFramework.resource    
Force Tags    EndToEnd

*** Test Cases ***
RegisterTest
    [Tags]    Register
    [Documentation]    User able to create new account 
    OpenWebsiteKeyword
    Click Element    class=login    
    #enter random variable
    ${random_string}=    Generate Random String    8    ${LETTERS}${NUMBERS}  
    Input Text    id=email_create     ${random_string}@gmail.com    
    Click Element    ${createaccount}
    Click Element    xpath=//*[@id="id_gender1"]    
    Input Text    xpath=//*[@id="customer_firstname"]   cat
    Input Text    xpath=//*[@id="customer_lastname"]    house
    Input Text    xpath=//*[@id=\"passwd\"]    ${pwd}   
    Input Text    id=firstname    git   
    Input Text    id=lastname    new   
    Input Text    xpath=//*[@id="address1"]    new1,waycolony
    Input Text    id=city    newup
    Click Element    id=id_state   
    Select From List By Value    xpath=//*[@id="id_state"]    1  
    Input Text    id=postcode    00000  
    Click Element    id=id_country  
    Select From List By Value    xpath=//*[@id="id_country"]    21   
    Input Text    id=phone_mobile    09909034343
    Input Text    id=alias    nonsense
    Click Element    ${register}
    Log To Console    Registed successfully..  
    Close Browser  
    

SearchingByNavigationTest
    [Tags]    ByNavigation
    [Documentation]    User able to search a product through navigation
    #Searching a product through navigation
    OpenWebsiteKeyword
    SearchProductKeyword
    Log To Console    Succesfully searched a product through navigation..
    Close Browser
 

SearchingBySearchBarTest
    [Tags]    BySearchBar
    [Documentation]    User able to search a product through search bar
    #Searching a product through search bar
    OpenWebsiteKeyword
    Input Text            xpath://input[@id='search_query_top']                T-Shirts
    Sleep    2
    Press Keys            xpath://input[@id='search_query_top']  ENTER
    # Click Button    //button[@name='submit_search']
    Sleep    3
    Close Browser
    Log To Console   Succesfully searched a product through search bar..
    Close Browser


LoginTest
    [Tags]    Login
    [Documentation]    User logged into the application
    Open Browser    https://google.com    chrome
    Maximize Browser Window
    Set Browser Implicit Wait    3
    Input Text    name=q    automation practice 
    Press Keys    name=q    ENTER
    Sleep    2
    #User able to navigate application on clicking desired element
    Click Element    xpath://*[@id="rso"]/div[1]/div/div/div[1]/a/h3 
    LoginKeyword
    Log To Console    Logged in successfully..    


WishlistTest
    [Tags]    Wishlist
    [Documentation]    User able to add the product into wishlist
    #OpenWebsiteKeyword
    #LoginKeyword
    SearchProductKeyword 
    #Click on add to wishlist button
    Click Element    xpath://*[@id="center_column"]/ul/li/div/div/div[3]/div/div[3]/div[1]/a
    Sleep    3       
    Click Element    xpath://a[@class='fancybox-item fancybox-close'] 
    Sleep    3      
    Log To Console    Successfully added into wishlist..    
    

AddToCartTest
    [Tags]    AddToCart
    [Documentation]    User search and add the product into the cart
    #OpenWebsiteKeyword
    #LoginKeyword
    #SearchProductKeyword
    #Click on more button
    Click Element    xpath://span[contains(text(),'More')] 
    #Clear text and enter value of your choice
    Clear Element Text    id=quantity_wanted
    Input Text    id=quantity_wanted    2
    #Select the dropdown for size 
    Mouse over    xpath://label[contains(text(),'Size')]
    Page Should Contain Element    id=group_1     5s
    Select From List By Label    id=group_1      M 
    Sleep    2
    #Click on add to cart button 
    Click Element    //span[contains(text(),'Add to cart')]  
    Log To Console    Product successfully added into cart..   
    

ShippingMethodTest
    [Tags]    ShippingMethod 
    [Documentation]    User select the shipping mode option
    Click Element    xpath://span[contains(text(),'Proceed to checkout')]  
    #Click on proceed to checkout button for address   
    Click Element    css:#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span
    #Click on proceed to checkout button for shipping method  
    Click Element    xpath://*[@id="center_column"]/form/p/button/span 
    #Select the checkbox to agree terms and services
    Select Checkbox    id=cgv    
    Sleep    2   
    #Click on proceed to checkout button for payment option
    Click Element    xpath://*[@id="form"]/p/button/span         


PaymentMethodTest
    [Tags]    PaymentMethod
    [Documentation]   User select the Payment option and confirm the order
    #Click on payment method
    Click Element    xpath://a[@class='cheque']  
    #Click on confirm order
    Click Element    xpath://span[contains(text(),'I confirm my order')]
    Sleep    2    
    Log To Console    Order completed successfully..    
           
    
OrderHistoryTest
    [Tags]    OrderHistory                   
    [Documentation]    User able to see the product in order history
    #Click on my orders
    Click Element    css:#footer > div > section:nth-child(7) > div > ul > li:nth-child(1) > a    
    Log    Order placed successfully in the order history
    Click Element     xpath://a[@class='logout']
    Log To Console    Logged out successfully..
    Close Browser  
    

ContactUsTest
    [Tags]    ContactUs
    [Documentation]    User able to contact for any queries
    OpenWebsiteKeyword
    Click Element    link=Contact us 
    #Select the dropdown for subject heading   
    Mouse over    xpath://label[contains(text(),'Subject Heading')]
    Page Should Contain Element    xpath=//select[@id='id_contact']     5s
    Select From List By Label    xpath://select[@id='id_contact']      Customer service 
    Sleep    2
    #Enter email address
    Input Text    xpath://input[@id='email']    ${credentials}[0] 
    #Enter message
    Input Text    xpath://textarea[@id='message']       ${message}
    #Click on send button 
    Click Element    xpath://span[contains(text(),'Send')]
    Log To Console    Message sent successfully..  
    Close Browser 
    

SocialMediaTest
    [Tags]    SocialMedia
    [Documentation]    User able to navigate media page on clicking media icon
    OpenWebsiteKeyword  
    Click Element    class=twitter
    Sleep    5    
    @{list1}    Get Window Handles    
    FOR    ${win}    IN      @{list1}
        Select Window    ${win}
        ${getUrl}    Get Location
        Log    ${getUrl}       
    END 
    Log To Console    Successfully navigated media page..
    Close Browser    
              

NewsLetterTest
    [Tags]    NewsLetter
    [Documentation]    User able to subscribe on newsletter
    OpenWebsiteKeyword
    Input Text    id=newsletter-input     bitbuckets0908@gmail.com
    Click Button   name= submitNewsletter
    Log To Console    Successfully  subscribed to NewsLetter..
    Close Browser 


SendToFriendTest
    [Tags]    SendToFriend
    [Documentation]    User able to send mail to a friend
    OpenWebsiteKeyword
    SearchProductKeyword 
    #Click on more option
    Click Element    xpath://span[contains(text(),'More')]
    Sleep    3      
    #Click on send to friend button    
    Click Element    xpath://*[@id="send_friend_button"]
    #Enter name and email address of friend
    Input Text  xpath://*[@id="friend_name"]   Lasya
    Input Text    xpath://*[@id="friend_email"]       lasya@123@gmail.com
    #Click on send button     Sleep    3    
    Click Element    xpath://*[@id="sendEmail"]/span
    Sleep    3    
    Log To Console    Email sent succesfully to a friend..       
    Close Browser
     



         

      
     




