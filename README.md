# Real-Time-Weather-Forecast
![Java](https://img.shields.io/badge/Language-Java-orange)
----------------------------------------------------------------------------------------------------------------------------------------------------

!!   HELLO EVERYONE   !!
For this project I wanted to keep it very simple! This is based on the OpenWeatherMap API (https://openweathermap.org/api) to retrive the data in JSON format.
To establish the connection to the API , I used the HttpURLConnection java class.
After that I mapped the data in a JSON object ( to do that I used some dependencies that you can find in the pom.xml file).
With all the data stored as a String in a JSON object , I stripped the String and collect all the important infos for my ideea.
Btw, to obtain these datas, I used a specific API call (Call current weather data), which you can find on the API's website.
All the action on the application is based on a button which activates all the process each time when you search a city.
For every info table, I used the same tamplate -> the data that is displayed is "stored" in JTextFields, the picture and the name of the table are "stored" in a JLabel and all of these are included in a JPanel, that is added to the main frame.
Also, I created interfaces for -> "Welcome"/"Loading"/"Wrong input".

----------------------------------------------------------------------------------------------------------------------------------------------------

P.S: KEEP IN MIND THAT THE DATA THAT IS COLLECTED IS BASED ON THE REAL TIME WEATHER FORECAST, BASICALLY THE WEATHER FORECAST IN THE MOMENT OF THE SEARCH
For any question, do not hesitate to contact me.

----------------------------------------------------------------------------------------------------------------------------------------------------

P.S: KEEP IN MIND TO CHANGE THE PATH OF THE IMAGES BASED ON THE DIRECTORY WHERE YOU SAVED THE PROJECT
IF YOU USE INTELLIJ, RIGHT CLICK ON IMAGE -> COPY PATH, AND AFTER THAT YOU CAN PASTE AT THE IMAGE ICON OBJECTS
IF YOU DO NOT USE INTELLIJ , COPY THE PATH MANUALLY, AND AFTER THAT YOU CAN PASTE AT THE IMAGE ICON OBJECTS
!!  THX FOR THE ATTENTION   !!

----------------------------------------------------------------------------------------------------------------------------------------------------


--   WELCOME INTERFACE   --
![welcome](https://github.com/GengiuRobert/Real-Time-Weather-Forecast/assets/127054806/51d24937-4fc1-4f7b-a208-a4a4bd2efff4)
--   WELCOME INTERFACE   --

--   LOADING INTERFACE   --
![loading](https://github.com/GengiuRobert/Real-Time-Weather-Forecast/assets/127054806/66a87815-e2cb-4463-996a-5ffdd12b5c45)
--   LOADING INTERFACE   --

--   WRONG INPUT INTERFACE   --
![wrong](https://github.com/GengiuRobert/Real-Time-Weather-Forecast/assets/127054806/63ec09ab-498c-42d5-a3e6-c4cd70687e7b)
--   WRONG INPUT INTERFACE   --

--   MAIN INTERFACE   --
![reveal](https://github.com/GengiuRobert/Real-Time-Weather-Forecast/assets/127054806/0155fcc8-1eb5-41bc-b6b0-4234ccc984eb)
--   MAIN INTERFACE   --




