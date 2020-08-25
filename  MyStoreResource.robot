*** Settings ***
Library    SeleniumLibrary    
*** Variables ***
${url}         http://automationpractice.com/index.php

*** Keywords ***
searchproduct
     Click Element    xpath://*[@id="block_top_menu"]/ul/li[2]/a
     Sleep    3    
     Click Element    xpath://*[@id="categories_block_left"]/div/ul/li[2]/a 
condition1
        Page Should Contain   "T-SHIRTS"       