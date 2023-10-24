# Real-Time-Weather-Forecast
![Java](https://img.shields.io/badge/Language-Java-orange)
!!   HELLO EVERYONE   !!
For this project I wanted to keep it very simple! This is based on the OpenWeatherMap API (https://openweathermap.org/api) to retrive the data in JSON format.
To establish the connection to the API , I used the HttpURLConnection java class.
After that I mapped the data in a JSON object ( to do that I used some dependencies that you can find in the pom.xml file).
With all the data stored as a String in a JSON object , I stripped the String and collect all the important infos for my ideea.
Btw, to obtain these datas, I used a specific API call (Call current weather data), which you can find on the API's website.
All the action on the application is based on a button which activates all the process each time when you search a city.
For every info table, I used the same tamplate -> the data that is displayed is "stored" in JTextFields, the picture and the name of the table are "stored" in a JLabel and all of these are included in a JPanel, that is added to the main frame.
Also, I created interfaces for -> "Welcome"/"Loading"/"Wrong input".
For any question, do not hesitate to contact me.
!!  THX FOR THE ATTENTION   !!
