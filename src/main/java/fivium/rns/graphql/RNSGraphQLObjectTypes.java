package fivium.rns.graphql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static graphql.Scalars.*;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class RNSGraphQLObjectTypes {

	private static RNSGraphQLObjectTypes instance = null;
	

	private Map<String, GraphQLSchema> rnsGraphQLSchemas = null;
	
	
	private RNSGraphQLObjectTypes() {
		
		rnsGraphQLSchemas = new HashMap<String, GraphQLSchema>();
		
		GraphQLObjectType user = newObject()
			    .name("User")
			    .description("A Clinician user of RNS")
			    .field(newFieldDefinition()
			            .name("Username")
			            .description("The user name the user logs into the system with.")
			            .type(GraphQLString))
			    .field(newFieldDefinition()
			            .name("Password")
			            .description("Password of user.")
			            .type(GraphQLString))
			.build();
		
        GraphQLObjectType queryType = newObject()
                .name("userQuery")
                .field(newFieldDefinition()
                        .type(user)
                        .name("User")
                        .dataFetcher(userDataFetcher))
                .build();
        
        
        GraphQLSchema userSchema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();
		
		
//		GraphQLObjectType queryType = newObject()
//	            .name("QueryType")
//	            .field(newFieldDefinition()
//	                    .name("hero")
//	                    .type(characterInterface)
//	                    .argument(newArgument()
//	                            .name("episode")
//	                            .description("If omitted, returns the hero of the whole saga. If provided, returns the hero of that particular episode.")
//	                            .type(episodeEnum))
//	                    .dataFetcher(new StaticDataFetcher(StarWarsData.getArtoo())))
//	            .field(newFieldDefinition()
//	                    .name("human")
//	                    .type(humanType)
//	                    .argument(newArgument()
//	                            .name("id")
//	                            .description("id of the human")
//	                            .type(nonNull(GraphQLString)))
//	                    .dataFetcher(StarWarsData.getHumanDataFetcher()))
//	            .field(newFieldDefinition()
//	                    .name("droid")
//	                    .type(droidType)
//	                    .argument(newArgument()
//	                            .name("id")
//	                            .description("id of the droid")
//	                            .type(nonNull(GraphQLString)))
//	                    .dataFetcher(StarWarsData.getDroidDataFetcher()))
//	            .build();
		
		
		rnsGraphQLSchemas.put("User", userSchema);
		
	}
	
	
	public static RNSGraphQLObjectTypes getRNSGraphQLObjectTypes() {
		
		if (instance == null) {
			instance = new RNSGraphQLObjectTypes();
		}
		
		return instance;
	}
	
	public GraphQLSchema getRNSGraphQLSchema(String key) {
		return rnsGraphQLSchemas.get(key);
	}
	
    static DataFetcher userDataFetcher = new DataFetcher() {
        @Override
        public Object get(DataFetchingEnvironment environment) {
        	
        	Map<String,String> dummyResult = new HashMap<String, String>();
        	dummyResult.put("Username", "Jimmy");
        	dummyResult.put("Password", "password123");
        	
        	return dummyResult;

        }
    };

	
}
