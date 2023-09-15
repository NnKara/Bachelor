# Σύστημα παρακολούθησης αποφοίτων

Πτυχιακή εργασία του Ν. Καραμήτου -- 2023.

## Απαιτήσεις συστήματος

 - Java (>= 11)
 - Maven
 - Docker

## Εκκίνηση

 - `git clone https://github.com/NnKara/Bachelor.git`
 - `cd Bachelor`
 - `mvn clean package`
 - `docker compose up`

Αν παρουσιάζονται σφάλματα κατά την εκκίνηση, ξεκινήστε χωριστά τη βάση και τον server:

 - `docker compose up mysqldb`
 - `docker compose up server`

Η εφαρμογή μπορεί να προσπελαστεί στο\
http://localhost:8080/
