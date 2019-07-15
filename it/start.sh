echo "Starting Services..."

#Starting service in background
docker-compose up -d

#echo "Starting the temporal container for create the tables"
#docker run mesosphere/aws-cli

DYNAMODB_PORT=$(echo "$(docker port dynamo-db 4569/tcp | cut -d':' -f 2)")

DYNAMODB_URL="http://127.0.0.1:${DYNAMODB_PORT}"

echo "The URL for dynamodb is ${DYNAMODB_URL}"

echo "Creating the tables"
aws dynamodb --endpoint=$DYNAMODB_URL create-table --cli-input-json file://awscli/create-table-pokemon.json

echo "Inserting dummy data inside the data base"
#aws dynamodb put-item --table-name pokemon --item file://awscli/pokemon_list.json --return-consumed-capacity TOTAL --endpoint-url $DYNAMODB_URL
aws dynamodb batch-write-item --request-items file://awscli/pokemon_list.json --endpoint-url $DYNAMODB_URL

echo "Retriving data inserted"
#aws dynamodb get-item --table-name pokemon --key file://get_pokemon_key.json --endpoint-url $DYNAMODB_URL

aws dynamodb scan --table-name pokemon --endpoint-url $DYNAMODB_URL