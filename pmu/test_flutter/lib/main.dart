import 'package:flutter/material.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
        home: Scaffold(
      body: Center(
        child: MojObrazac(),
      ),
    ));
  }
}

class MojGumb extends StatelessWidget {
  const MojGumb({super.key});

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        onPressed: () {
          debugPrint("Gumb je pritisnut!");
        },
        child: const Text("Pritisni me"));
  }
}

class MojObrazac extends StatefulWidget {
  const MojObrazac({super.key});

  @override
  State<MojObrazac> createState() => _MojObrazacState();
}

class _MojObrazacState extends State<MojObrazac> {
  final TextEditingController imeCtrl = TextEditingController();
  final TextEditingController prezimeCtrl = TextEditingController();

  @override
  void dispose() {
    imeCtrl.dispose();
    prezimeCtrl.dispose();
    super.dispose();
  }

  void _sendData() {
    String ime = imeCtrl.text;
    String prezime = prezimeCtrl.text;

    Navigator.push(
        context,
        MaterialPageRoute(
            builder: (context) => PrikazPodataka(ime: ime, prezime: prezime)));

    imeCtrl.text = "";
    prezimeCtrl.text = "";
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Text(
            "Unesite svoje ime i prezime",
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(
            height: 32,
          ),
          TextField(
            controller: imeCtrl,
            decoration: const InputDecoration(
                labelText: "Ime", border: OutlineInputBorder()),
          ),
          const SizedBox(
            height: 16,
          ),
          TextField(
            controller: prezimeCtrl,
            decoration: const InputDecoration(
                labelText: "Prezime", border: OutlineInputBorder()),
            onSubmitted: (value) {
              _sendData();
            },
          ),
          const SizedBox(
            height: 16,
          ),
          ElevatedButton(onPressed: _sendData, child: const Text("Potvrdi"))
        ],
      ),
    );
  }
}

class PrikazPodataka extends StatefulWidget {
  final String ime;
  final String prezime;

  const PrikazPodataka({required this.ime, required this.prezime, super.key});

  @override
  State<PrikazPodataka> createState() => _PrikazPodatakaState();
}

class _PrikazPodatakaState extends State<PrikazPodataka> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Prikaz podataka"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              "Prezime: ${widget.prezime}",
              style: const TextStyle(fontSize: 22),
            ),
            const SizedBox(
              height: 16,
            ),
            Text(
              "Ime: ${widget.ime}",
              style: const TextStyle(fontSize: 22),
            ),
            const SizedBox(
              height: 16,
            ),
            ElevatedButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Text("Nazad"))
          ],
        ),
      ),
    );
  }
}
