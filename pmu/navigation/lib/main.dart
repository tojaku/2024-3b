import 'package:flutter/material.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Primjer navigacije",
      initialRoute: "/",
      routes: {
        "/": (context) => const HomePage(),
        "/second": (context) => const SecondPage()
      },
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Naslovnica"),
      ),
      body: Center(
        child: ElevatedButton(
            onPressed: () {
              Navigator.pushNamed(context, "/second",
                  arguments: Data(a: 1.1, b: 2.2, c: 3.3, d: 4.4));
            },
            child: const Text("Idi na drugu stranicu")),
      ),
    );
  }
}

class SecondPage extends StatelessWidget {
  const SecondPage({super.key});

  @override
  Widget build(BuildContext context) {
    final Data rcvdData =
        ModalRoute.of(context)!.settings.arguments as Data;

    return Scaffold(
      appBar: AppBar(
        title: const Text("Druga stranica"),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pop(context);
          },
          child: Text("${rcvdData.a} ${rcvdData.b} ${rcvdData.c} ${rcvdData.d}"),
        ),
      ),
    );
  }
}

class Data {
  double a;
  double b;
  double c;
  double d;

  Data({
    required this.a,
    required this.b,
    required this.c,
    required this.d
  });
}
