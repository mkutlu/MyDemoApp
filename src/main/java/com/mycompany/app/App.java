package com.mycompany.app;
import java.lang.Math;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
public class App 
{
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
	System.out.println("hello");
        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
       
            int value1 = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            int value2 = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            int value3 = Integer.parseInt(sc1.next().replaceAll("\\s",""));




          int result = App.greatestCommonDivisor(value1,value2,value3);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
	System.out.println("herro");
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
	public static int greatestCommonDivisor(int a, int b, int c)
	{
            int limit;
 	    limit = Math.min(a, b);
    	    limit = Math.min(limit, c);
    	    for(int n = limit; n >= 2; n--)
    	    {
       		 if ( (a % n == 0) && (b % n == 0) && (c % n == 0) ) {
           	    return n;
       	    	 }
            }
	    return 1;
	}
}
