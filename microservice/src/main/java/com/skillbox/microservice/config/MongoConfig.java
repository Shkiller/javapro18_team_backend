package com.skillbox.microservice.config;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {


    @Override
    public String getDatabaseName() {
        return "technical_support_db";
    }
    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.applyConnectionString(new ConnectionString("mongodb://technical_support:aj@Z|0qLY#lZ@localhost:3309"));
    }

}
