#include <SPI.h>
#include <MFRC522.h>

#include <Ethernet.h>
#include <RESTClient.h>

#define SS_PIN 7
#define RST_PIN 9

MFRC522 mfrc522(SS_PIN, RST_PIN);

byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };

// Use DNS to find the server IP. Static server IP doesn't reduce sketch size.
// The server name is also used in the HTTP headers.
char server[] = "www.robbie-remote.com";

// Set the static IP address to use if the DHCP fails to assign
IPAddress ip(192, 168, 0, 17);

//IPAddress server(0, 0, 0, 1);
// Initialize the REST Client library
// with the IP address and port of the server
// that you want to connect to (port 80 is default for HTTP):
RESTClient client;

int ID=1;

void setup()
{
   // Inicia a serial
  Serial.begin(9600);
  // Inicia  SPI bus 
  SPI.begin();
  // Inicia MFRC522    
  mfrc522.PCD_Init();
  while (!Serial) {
    ; // wait for serial port to connect. Needed for Leonardo only
  }

  // start the Ethernet connection:
  if (Ethernet.begin(mac) == 0) {
    Serial.println("Failed to configure Ethernet using DHCP");
    // no point in carrying on, so do nothing forevermore:
    // try to congifure using IP address instead of DHCP:
    Ethernet.begin(mac, ip);
  }

  // print the Ethernet board/shield's IP address:
  Serial.print("My IP address: ");
  Serial.println(Ethernet.localIP());

  // give the Ethernet shield a second to initialize:
  delay(1000);
  Serial.println("connecting...");

  // if you get a connection, report back via serial:
  if (client.connect(server, 80)) {
    Serial.println("connected");
    Serial.println("Aproxime o seu cartao/TAG do leitor");
    Serial.println();
    // Make a HTTP request:
    // Send a sensor name (needs URL encoding) and value (integer or float).
    // This name 'My Arduino Sensor' and value '13' are just examples.
    // Put your sensor name and data here.
   // client.send( F("My%20Arduino%20Sensor"), 13 );
  }
  else {
    // kf you didn't get a connection to the server:
    Serial.println("connection failed");
  }
  
}

void loop()
{
   digitalWrite (10, HIGH);

    // Busca novos cartões 
  if ( ! mfrc522.PICC_IsNewCardPresent())
  {
    return;
  }
  // Seleciona um catão a ser lido
  if ( ! mfrc522.PICC_ReadCardSerial())
  {
    return;
  }
  //Mostra ID na serial
    Serial.print("ID da tag:");
    String conteudo = "";
   byte letra;
    for (byte i = 0; i < mfrc522.uid.size; i++)
   {
    Serial.print(mfrc522.uid.uidByte[i], HEX);
    if(i < mfrc522.uid.size-1){
    Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? "%20" : "%20");
    }
    conteudo.concat(String(mfrc522.uid.uidByte[i], HEX));
    if(i < mfrc522.uid.size-1){
      conteudo.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? "%20" : "%20")); //encode
      }
   }
   Serial.println();
  Serial.print("Mensagem : ");
  conteudo.toUpperCase();
  //client.send(F(conteudo.substring(1)),13);
  client.send( F("4C%2072%2054%20D"), 12 ); 

   // if there are incoming bytes available
  // from the server, read them and print them:
  if (client.available()) {
    char c = client.read();
    Serial.print(c);
  }

  // if the server's disconnected, stop the client:
  if (!client.connected()) {
    Serial.println();
    Serial.println("disconnecting.");
    client.stop();

    // do nothing forevermore:
    while (true);
  }


   
}
