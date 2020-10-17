# xxe-demo

Prerequisite:
Install SBT: https://www.scala-sbt.org/1.x/docs/Setup.html

To run the service locally:

```
sbt run
```

Supported Requests:
```
GET     /         
POST    /:id    with XML Body   Retunrs 200 (No other code)
PUT     /:id    with XML Body   Returns 400 (No other code)
```      

Script to send request proxied through zap:

Assumes ZAP is running in port 11000.

```
./test.sh
```

The script generates 1 POST request and 1 PUT request using Curl. 
Proxies the request through port 11000 where ZAP should be running
Loads [xml_external_entity_attack.policy](xml_external_entity_attack.policy) set in Insane Mode.
Trigger Active Scan with the above policy. 

The script accepts a parameter to repeat the requests. Below script will inject 2 requests for POST and PUT.  

```
./test.sh 2 
```