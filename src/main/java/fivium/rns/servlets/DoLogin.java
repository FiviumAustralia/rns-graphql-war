package fivium.rns.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fivium.rns.graphql.GraphQLController;
import fivium.rns.graphql.RNSGraphQLObjectTypes;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

/**
 * Servlet implementation class DoLogin
 */
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		GraphQLSchema schema = RNSGraphQLObjectTypes.getRNSGraphQLObjectTypes().getRNSGraphQLSchema("User");
		GraphQLController graphQLController = GraphQLController.getInstance();
		
		String query = "{User{Username}}";
		
		Map<String, Object> result = graphQLController.executeOperation(query, schema, null);			
		
		String queryResult = "";
		
		if (result != null && result.get("data") != null) {			
			queryResult = result.get("data").toString();
		} else {
			queryResult = "ERROR: " + result.get("errors").toString();
		}
		
		response.getWriter().append("Query result: \n\n " + queryResult);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
