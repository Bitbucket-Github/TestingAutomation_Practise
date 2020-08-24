*** Settings ***
Library    SeleniumLibrary  

*** Variables ***
${url}    http://automationpractice.com/index.php
@{credential}    bitbucket76@gmail.com    Github123
&{LoginData}    username=bitbucket76@gmail.com    password=Github123
${DressJ}    xpath:/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]        
${EveningDressJ}    xpath://*[@id="block_top_menu"]/ul/li[2]/ul/li[2]/a
${message}    product deatails
${Login}    Click Element     class=login    

#RegisterVariables
${logo}    class=logo
&{Signin}    xpa=//*[@id="header"]/div[2]/div/div/nav/div[1]/a
${LOWER}    qwertyuiopasdfghjklzxcvbnm
${UPPER}    QWERTYUIOPASDFGHJKLZXCVBNM
${LETTERS}    ${LOWER}${UPPER}
${NUMBERS}    1234567890
${createaccount}    xpath=//*[@id="SubmitCreate"]/span
${pwd}    happy12
${register}    xpath=//*[@id=\"submitAccount\"]/span
@{credentials}    bitbucket76@gmail.com    Github123
${submit}    xpath=//p[@class='submit']//span[1]
${Dress}    xpath=//*[@id="block_top_menu"]/ul/li[2]/a
${EveningDress}    xpath=/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[2]/a[1]
&{quantity}    quan=3
${MY_color}    pink

*** Keywords ***
LoginKeyword
    Click Element     class=login        
    Input Text        id=email    ${credentials}[0]    
    Input Password    name=passwd    ${LoginData}[password] 
    Sleep    3      
    Click Button      id=SubmitLogin
    
OpenWebsiteKeyword
    Open Browser    ${url}    chrome
    Maximize Browser Window
    Set Browser Implicit Wait    3
     
SearchProductKeyword
    Mouse Over    ${Dress}                       
    Wait Until Element Is Visible    ${EveningDress}   
    Sleep    6     
    Click Element    ${EveningDress}
    Sleep    6    
    #Click on list view
    Click Element    xpath://*[@id="list"]/a/i
    

