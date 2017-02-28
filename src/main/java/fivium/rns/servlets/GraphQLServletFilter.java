package fivium.rns.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import fivium.rns.graphql.RNSGraphQLObjectTypes;
import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Servlet Filter implementation class GraphQLServletFilter
 */
public class GraphQLServletFilter implements Filter {


	
    /**
     * Default constructor. 
     */
    public GraphQLServletFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		
		
//		GraphQLObjectType queryType = newObject().name("helloWorldQuery")
//				.field(newFieldDefinition().type(GraphQLString).name("hello").staticValue("world")).build();

		response.getWriter().write("Filter says: COWS GO MOO \n\n");
	

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	
		
		
		// TODO Auto-generated method stub
	}

}
