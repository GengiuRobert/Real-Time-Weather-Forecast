package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
public class MyFrame extends JFrame implements ActionListener {

    JTextField textField;
    JButton button;
    JPanel panel_sun_info;
    JPanel panel_coord;
    JPanel panel_weather_description;
    JPanel temperature_panel;
    JPanel pressure_panel;
    JPanel umiditate_panel;
    JPanel wind_panel;
    JTextField wind;
    JTextField atmospheric_pressure;
    JTextField umiditate;
    JTextField temperature;
    JTextField feels_like_temperature;
    JTextField longitude;
    JTextField latitude;
    JTextField main_weather;
    JTextField short_description;
    JTextField sunrise;
    JTextField sunset;
    JLabel loading_label;
    JLabel wind_label;
    JLabel temperature_label;
    JLabel athmospheric_label;
    JLabel sun;
    JLabel coordinates;
    JLabel weather;
    JLabel wrong_city;
    JLabel umiditate_label;
    JLabel welcome_label;
    JProgressBar bar;
    Timer timer;
    int contor = 0;
    boolean wrong_input = false;

    MyFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        Color custom_orange = new Color(255, 119, 0);

        //search for a city button
        button = new JButton("Search for a city");
        Font customFont = new Font("Arial Black", Font.PLAIN, 20);
        button.setFont(customFont);
        button.addActionListener(this);
        button.setBounds(420, 0, 220, 40);
        //search for a city button

        //field where you type the city
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 40));
        textField.setVisible(true);
        textField.setFont(customFont);
        textField.setBounds(450, 40, 150, 40);
        //field where you type the city

        //welcome label
        ImageIcon welcome_icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\welcome.png");
        welcome_label = new JLabel();
        welcome_label.setIcon(welcome_icon);
        welcome_label.setVisible(true);
        welcome_label.setBounds(270,75,600,600);
        //welcome label

        ImageIcon location_icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\location (1).png");
        coordinates = new JLabel();
        coordinates.setText("Coordinates of the city");
        coordinates.setFont(new Font("Arial Black", Font.PLAIN, 18));
        coordinates.setIcon(location_icon);
        coordinates.setHorizontalAlignment(JLabel.CENTER);
        coordinates.setVerticalAlignment(JLabel.CENTER);
        coordinates.setVerticalTextPosition(JLabel.TOP);
        coordinates.setHorizontalTextPosition(JLabel.CENTER);

        //panel for the coordinates
        panel_coord = new JPanel();
        panel_coord.setBackground(custom_orange);
        panel_coord.setBounds(0, 115, 250, 230);
        //panel for the coordinates

        //textfield for latitude+longitude
        Font customFont2 = new Font("Arial Black", Font.PLAIN, 15);
        longitude = new JTextField(15);
        longitude.setFont(customFont2);
        longitude.setEditable(false);
        latitude = new JTextField(15);
        latitude.setFont(customFont2);
        latitude.setEditable(false);
        //textfield for latitude+longitude


        panel_coord.add(coordinates);
        panel_coord.add(longitude);
        panel_coord.add(latitude);

        //main weather + short description
        ImageIcon weather_icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\weather (1).png");
        weather = new JLabel("Weather of the city");
        weather.setFont(new Font("Arial Black", Font.PLAIN, 18));
        weather.setIcon(weather_icon);
        weather.setHorizontalAlignment(JLabel.CENTER);
        weather.setVerticalAlignment(JLabel.CENTER);
        weather.setVerticalTextPosition(JLabel.TOP);
        weather.setHorizontalTextPosition(JLabel.CENTER);
        main_weather = new JTextField(15);
        main_weather.setFont(customFont2);
        main_weather.setEditable(false);
        short_description = new JTextField();
        short_description.setFont(customFont2);
        short_description.setEditable(false);
        panel_weather_description = new JPanel();
        panel_weather_description.setBackground(custom_orange);
        panel_weather_description.setBounds(270, 115, 270, 230);
        panel_weather_description.add(weather);
        panel_weather_description.add(main_weather);
        panel_weather_description.add(short_description);
        //main weather + short description

        //infos about the sunrise + sunset
        ImageIcon sun_info = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\sunset (1).png");
        sunset = new JTextField(15);
        sunset.setFont(customFont2);
        sunset.setEditable(false);
        sunrise = new JTextField(15);
        sunrise.setFont(customFont2);
        sunrise.setEditable(false);
        sun = new JLabel("Infos about the sun");
        sun.setFont(new Font("Arial Black", Font.PLAIN, 18));
        sun.setIcon(sun_info);
        sun.setHorizontalAlignment(JLabel.CENTER);
        sun.setVerticalAlignment(JLabel.CENTER);
        sun.setVerticalTextPosition(JLabel.TOP);
        sun.setHorizontalTextPosition(JLabel.CENTER);
        panel_sun_info = new JPanel();
        panel_sun_info.setBounds(550,115,250,230);
        panel_sun_info.setBackground(custom_orange);
        panel_sun_info.add(sun);
        panel_sun_info.add(sunrise);
        panel_sun_info.add(sunset);
        //infos about the sunrise + sunset

        //temperature
        ImageIcon temperature_icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\celsius (1).png");
        temperature = new JTextField(15);
        temperature.setFont(customFont2);
        temperature.setEditable(false);
        feels_like_temperature = new JTextField(15);
        feels_like_temperature.setFont(customFont2);
        feels_like_temperature.setEditable(false);
        temperature_label = new JLabel("Infos about the temperature");
        temperature_label.setFont(new Font("Arial Black", Font.PLAIN, 18));
        temperature_label.setVerticalTextPosition(JLabel.TOP);
        temperature_label.setHorizontalTextPosition(JLabel.CENTER);
        temperature_label.setHorizontalAlignment(JLabel.CENTER);
        temperature_label.setVerticalAlignment(JLabel.CENTER);
        temperature_label.setIcon(temperature_icon);
        temperature_panel = new JPanel();
        temperature_panel.setBackground(custom_orange);
        temperature_panel.setBounds(820,115,280,230);
        temperature_panel.add(temperature_label);
        temperature_panel.add(temperature);
        temperature_panel.add(feels_like_temperature);
        //temperature

        //atmospheric pressure
        ImageIcon pressure_icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\atmospheric (1).png");
        atmospheric_pressure = new JTextField(15);
        atmospheric_pressure.setFont(customFont2);
        atmospheric_pressure.setEditable(false);
        athmospheric_label = new JLabel("Atmospheric pressure infos");
        athmospheric_label.setFont(new Font("Arial Black", Font.PLAIN, 18));
        athmospheric_label.setIcon(pressure_icon);
        athmospheric_label.setVerticalTextPosition(JLabel.TOP);
        athmospheric_label.setHorizontalTextPosition(JLabel.CENTER);
        athmospheric_label.setHorizontalAlignment(JLabel.CENTER);
        athmospheric_label.setVerticalAlignment(JLabel.CENTER);
        pressure_panel = new JPanel();
        pressure_panel.setBackground(custom_orange);
        pressure_panel.setBounds(75,350,300,230);
        pressure_panel.add(athmospheric_label);
        pressure_panel.add(atmospheric_pressure);
        //atmospheric pressure

        //humidity infos
        ImageIcon umiditate_icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\humidity (1).png");
        umiditate = new JTextField(15);
        umiditate.setFont(customFont2);
        umiditate.setEditable(false);
        umiditate_label = new JLabel("Humidity infos");
        umiditate_label.setFont(new Font("Arial Black", Font.PLAIN, 18));
        umiditate_label.setIcon(umiditate_icon);
        umiditate_label.setVerticalTextPosition(JLabel.TOP);
        umiditate_label.setHorizontalTextPosition(JLabel.CENTER);
        umiditate_label.setHorizontalAlignment(JLabel.CENTER);
        umiditate_label.setVerticalAlignment(JLabel.CENTER);
        umiditate_panel = new JPanel();
        umiditate_panel.setBackground(custom_orange);
        umiditate_panel.setBounds(390,350,300,230);
        umiditate_panel.add(umiditate_label);
        umiditate_panel.add(umiditate);
        //humidity infos

        //wind infos
        ImageIcon wind_icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\storm (1).png");
        wind = new JTextField(15);
        wind.setFont(customFont2);
        wind.setEditable(false);
        wind_label = new JLabel("Wind infos");
        wind_label.setFont(new Font("Arial Black", Font.PLAIN, 18));
        wind_label.setIcon(wind_icon);
        wind_label.setVerticalTextPosition(JLabel.TOP);
        wind_label.setHorizontalTextPosition(JLabel.CENTER);
        wind_label.setHorizontalAlignment(JLabel.CENTER);
        wind_label.setVerticalAlignment(JLabel.CENTER);
        wind_panel = new JPanel();
        wind_panel.setBackground(custom_orange);
        wind_panel.setBounds(700,350,300,230);
        wind_panel.add(wind_label);
        wind_panel.add(wind);
        //wind infos

        //loading section
        ImageIcon loading_icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\loading-bar.png");
        loading_label = new JLabel();
        loading_label.setIcon(loading_icon);
        loading_label.setVisible(false);
        loading_label.setBounds(270,75,600,600);
        //loading section

        //progress bar
        bar = new JProgressBar();
        bar.setBounds(420, 80, 220, 30);
        bar.setValue(contor);
        bar.setStringPainted(true);
        bar.setFont(customFont2);
        bar.setForeground(custom_orange);
        //progress bar

        //wrong city input
        ImageIcon wrong_image = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\wrong_image.png");
        wrong_city = new JLabel();
        wrong_city.setLayout(new FlowLayout());
        wrong_city.setText("Your input is wrong");
        wrong_city.setFont(new Font("Arial Black", Font.PLAIN, 30));
        wrong_city.setBounds(230,50,600,600);
        wrong_city.setIcon(wrong_image);
        wrong_city.setHorizontalAlignment(JLabel.CENTER);
        wrong_city.setVerticalAlignment(JLabel.CENTER);
        wrong_city.setVerticalTextPosition(JLabel.TOP);
        wrong_city.setHorizontalTextPosition(JLabel.CENTER);
        //wrong city input

        // we make the progress bar to increase
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loading_label.setVisible(false);
                wind_panel.setVisible(false);
                umiditate_panel.setVisible(false);
                pressure_panel.setVisible(false);
                temperature_panel.setVisible(false);
                panel_sun_info.setVisible(false);
                panel_weather_description.setVisible(false);
                wrong_city.setVisible(false);
                panel_coord.setVisible(false);
                if (contor <= 100) {
                    loading_label.setVisible(true);
                    bar.setValue(contor);
                    contor++;
                } else {

                    timer.stop();
                    if (!wrong_input) {
                        wind_panel.setVisible(true);
                        umiditate_panel.setVisible(true);
                        pressure_panel.setVisible(true);
                        temperature_panel.setVisible(true);
                        panel_sun_info.setVisible(true);
                        panel_weather_description.setVisible(true);
                        panel_coord.setVisible(true);
                    }
                    else {
                        wrong_city.setVisible(true);
                    }
                }

            }
        });
        // we make the progress bar to increase

        this.setTitle("Real Time Weather Forecast");
        this.getContentPane().setBackground(custom_orange);
        ImageIcon icon = new ImageIcon("C:\\Users\\user\\IdeaProjects\\weather_forecast\\src\\main\\image_app.png");
        this.setIconImage(icon.getImage());
        this.setSize(1125, 700);

        wind_panel.setVisible(false);
        umiditate_panel.setVisible(false);
        pressure_panel.setVisible(false);
        temperature_panel.setVisible(false);
        panel_sun_info.setVisible(false);
        panel_weather_description.setVisible(false);
        panel_coord.setVisible(false);
        wrong_city.setVisible(false);

        this.add(wrong_city);
        this.add(bar);
        this.add(wind_panel);
        this.add(umiditate_panel);
        this.add(pressure_panel);
        this.add(temperature_panel);
        this.add(panel_sun_info);
        this.add(panel_weather_description);
        this.add(panel_coord);
        this.add(loading_label);
        this.add(welcome_label);
        this.add(button);
        this.add(textField);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            welcome_label.setVisible(false);
            wrong_input = false;
            contor = 0;
            bar.setValue(0);
            timer.start();

            try {
                String api_key = "19600740f3cab079d9e85ace90d106b6";
                String city = textField.getText();

                URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + api_key);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                StringBuilder response = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    response.append(line);
                }

                bufferedReader.close();

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(response.toString());
                double lon = jsonNode.get("coord").get("lon").asDouble();
                double lat = jsonNode.get("coord").get("lat").asDouble();
                String main_weather1 = jsonNode.get("weather").get(0).get("main").asText();
                String short_main_weather_description1 = jsonNode.get("weather").get(0).get("description").asText();
                double temp = jsonNode.get("main").get("temp").asDouble();
                double temp_feels_like = jsonNode.get("main").get("feels_like").asDouble();
                double presiunea_atmosferica = jsonNode.get("main").get("pressure").asDouble();
                double humidity1 = jsonNode.get("main").get("humidity").asDouble();
                int wind_speed = (int) (jsonNode.get("wind").get("speed").asDouble() * 3.6);
                long sunrise_time = jsonNode.get("sys").get("sunrise").asLong();
                long sunset_time = jsonNode.get("sys").get("sunset").asLong();

                Instant instant_sunrise_time = Instant.ofEpochSecond(sunrise_time);
                LocalTime locatime_surise = instant_sunrise_time.atZone(ZoneId.of("Europe/Bucharest")).toLocalTime();

                Instant instant_sunset_time = Instant.ofEpochSecond(sunset_time);
                LocalTime locatime_sunset = instant_sunset_time.atZone(ZoneId.of("Europe/Bucharest")).toLocalTime();

                //we print the weather info
                longitude.setText("Longitude is -> " + lon+"°");
                latitude.setText("Latitude is -> " + lat+"°");
                main_weather.setText("Main weather -> "+main_weather1);
                short_description.setText("Description -> "+short_main_weather_description1);
                sunrise.setText("Sunrise -> "+locatime_surise.getHour() + ":" + locatime_surise.getMinute() + ":" + locatime_surise.getSecond());
                sunset.setText("Sunset -> "+ locatime_sunset.getHour() + ":" + locatime_sunset.getMinute() + ":" + locatime_sunset.getSecond());
                temperature.setText("Temperature now -> "+temp+"°");
                feels_like_temperature.setText("Feels like -> "+temp_feels_like+"°");
                atmospheric_pressure.setText("Pressure is -> "+presiunea_atmosferica+"hPa");
                umiditate.setText("Humidity is -> "+humidity1+ '%');
                wind.setText("Wind speed is -> "+wind_speed+"km/h");

                connection.disconnect();

            } catch (Exception ex) {
                wrong_input = true;
                System.out.println("Something went wrong");
            }
        }
    }

}

