# ANTexpert-netbeans
Ant Expert is utility software to save time and improve package and org management for salesforce deployment and retreival using Ant.
The basic tasks performed using this are 
    creating and managing packages
    managing orgs 
    performing Ant actions

The execuatable Jar can be found at https://drive.google.com/drive/folders/1WEhFMDXY0UTzfiPeuj-ND0n777WG6iok?usp=sharing.

This software is primarily aimed to help the Ant Salesforce practictioners save time and increase efficiency. Individual should have a 
working understanding of Ant deployment practices. Also the prerequisities to this are Ant CLI, ant-salesforce Jar files and 
Java 7+(preferrable).

Breif of some functionalities:

1. BACKUP - Once a single or more packages are created and SAVED, using this function will move all those packages into a backup folder
            with the moments timestamp. This functions helps in keeping a track of previously successfull package.

2. UPDATE - After a package has been created and saved, if updation is required in the package, swictch to update mode and click the file
            name from the right most list to begin editting. 

3. SAVE - Once a metadata and its components are added to a package, this function will save the package created to the respective
          xml file and new package can be created thereafter.
