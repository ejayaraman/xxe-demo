#!/usr/bin/env bash
#Runs the test NO_OF_TIMES before triggering active scan
NO_OF_TIMES=$1

for i in $(seq 1 ${NO_OF_TIMES:=1}); do
curl -H "Content-Type: application/xml" -X POST http://localhost:12345/$i -d $'<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n<foo>hello</foo>' --proxy localhost:11000

curl -H "Content-Type: application/xml" -X PUT http://localhost:12345/$i -d $'<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n<foo>hello</foo>' --proxy localhost:11000
done

curl "http://localhost:11000/JSON/ascan/action/scan/?url=http%3A%2F%2Flocalhost%3A12345&scanPolicyName=xml_external_entity_attack"


