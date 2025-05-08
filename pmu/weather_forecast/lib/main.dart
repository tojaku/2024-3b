import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: WeatherPage()
    );
  }
}

class WeatherPage extends StatefulWidget {
  const WeatherPage({super.key});

  @override
  State<WeatherPage> createState() => _WeatherPageState();
}

class _WeatherPageState extends State<WeatherPage> {
  String _city = "Tokyo";
  String _temp = "";
  String _description = "";

  Future<void> _fetchWeather() async {
    const apiKey = "ebd482045ea732a968280ba1f4712695";

    final response = await http.get(Uri.parse(
        'https://api.openweathermap.org/data/2.5/weather?q=$_city&appid=$apiKey&units=metric'));

    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      setState(() {
        _temp = "${data['main']['temp']} °C";
        _description = data['weather'][0]['description'];
      });
    }
  }

  @override
  void initState() {
    super.initState();
    _fetchWeather();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Weather App"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              _temp.isNotEmpty ? _temp : "Loading...",
              style: const TextStyle(fontSize: 40),
            ),
            Text(_description),
            ElevatedButton(
                onPressed: _fetchWeather, child: const Text("Refresh"))
          ],
        ),
      ),
    );
  }
}
