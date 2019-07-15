FROM java:8

WORKDIR /

ADD ./build/libs/pokedex.jar /pokedex.jar

EXPOSE 8080

CMD java -Dserver.port=8080 -Ddynamodb.endpoint=$DYNAMODB_URL -Daws.accesskey=2 -Daws.secretkey=2 -jar pokedex.jar