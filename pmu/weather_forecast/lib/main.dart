import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'env.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(home: WeatherPage());
  }
}

class WeatherPage extends StatefulWidget {
  const WeatherPage({super.key});

  @override
  State<WeatherPage> createState() => _WeatherPageState();
}

class _WeatherPageState extends State<WeatherPage> {
  String _city = "Zagreb";
  String _temp = "";
  String _description = "";

  final TextEditingController _controller = TextEditingController();

  Future<void> _fetchWeather() async {
    String apiKey = Env.opmApiKey;

    final response = await http.get(Uri.parse(
        'https://api.openweathermap.org/data/2.5/weather?q=$_city&appid=$apiKey&units=metric'));

    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      setState(() {
        _temp = "${data['main']['temp']} °C";
        _description = data['weather'][0]['description'];
      });
    } else {
      setState(() {
        _temp = "";
        _description = "Weather not found";
      });
    }
  }

  @override
  void initState() {
    super.initState();
    _controller.text = _city;
    _fetchWeather();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Weather App"),
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(24.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextField(
                controller: _controller,
                decoration: const InputDecoration(
                    labelText: "Enter city name", border: OutlineInputBorder()),
                onChanged: (value) {
                  _city = value;
                },
                onSubmitted: (value) {
                  setState(() {
                    _city = value;
                  });
                  _fetchWeather();
                },
              ),
              const SizedBox(
                height: 24.0,
              ),
              Text(
                _temp.isNotEmpty ? _temp : "Loading...",
                style: const TextStyle(fontSize: 40),
              ),
              Text(
                _description,
                style: const TextStyle(fontSize: 18),
              ),
              const SizedBox(
                height: 24.0,
              ),
              ElevatedButton(
                  onPressed: () {
                    setState(() {
                      _city = _controller.text.trim();
                    });
                    _fetchWeather();
                  },
                  child: const Text("Show Weather"))
            ],
          ),
        ),
      ),
    );
  }
}
