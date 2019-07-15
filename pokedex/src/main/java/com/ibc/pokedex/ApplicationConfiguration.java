package com.ibc.pokedex;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.ibc.pokedex.repositories")
public class ApplicationConfiguration {
    @Value("${dynamodb.endpoint}")
    private String dynamoDBEndpoint;

    @Value("${aws.accesskey}")
    private String awsAccessKey;

    @Value("${aws.secretkey}")
    private String awsSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        System.out.println("****************************Creating the DynamoDbClient");

        AmazonDynamoDB amazonDynamoDB
                = new AmazonDynamoDBClient(amazonAWSCredentials());

        if (!StringUtils.isEmpty(dynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(dynamoDBEndpoint);
        }

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        System.out.println("Credentials");
        System.out.println("aws key:" + awsAccessKey);
        System.out.println("secret key: " + awsSecretKey);
        System.out.println("end point: " + dynamoDBEndpoint);

        return new BasicAWSCredentials(
                awsAccessKey, awsSecretKey);
    }
}
