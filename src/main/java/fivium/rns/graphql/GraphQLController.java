package fivium.rns.graphql;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class GraphQLController {

	private static GraphQLController instance = null;
	
	private static final Logger log = LoggerFactory.getLogger(GraphQLController.class);

	private GraphQLController() {
		
	}
	
	
	public Map<String, Object> executeOperation(String query, GraphQLSchema schema, Map<String, Object> variables) {
	  
	    ExecutionResult executionResult = null;
	    
	    if (variables != null) {
	    	executionResult = new GraphQL(schema).execute(query, (Object) null, variables);
	    } else {
	    	executionResult = new GraphQL(schema).execute(query);
	    }
	        
	    Map<String, Object> result = new LinkedHashMap<String,Object>();
	    
	    if (executionResult.getErrors().size() > 0) {
	        result.put("errors", executionResult.getErrors());
	        log.error("Errors: {}", executionResult.getErrors());
	    }
	    
	    result.put("data", executionResult.getData());
	    return result;
	}
	
	public static GraphQLController getInstance() {
		
		if (instance == null) {
			instance = new GraphQLController();
		}
		
		return instance;
	}
	
}

