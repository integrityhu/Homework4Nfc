# Homework4Nfc (for ndef read/write)

Install NFCTools before package!
clone github repo: https://github.com/grundid/nfctools
and install with Maven (mvn install)

# Start application
clone Homework4Nfc github repo and package it with Maven (mvn package)

cd target dir and start java program

java -jar Homework4NDef-1.0-SNAPSHOT.jar

It is tested with ACR122U and Mifare Ultralight C on Windows 10, Oracle JDK 8 (with JavaFX support required)

# Write code to tag
Add NDef(JSON) text below and press "Küldés" button to write to tag.

{"formatted":true,"writeable":true,"empty":false,"ndefRecords":[{"text":"infokristaly.hu","type":"textRecord"},{"text":"nfcshop.hu","type":"textRecord"}]}

Supported by https://nfcshop.hu/
