package com.adobe.aem.guides.test.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Enumeration;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.methods=POST",
                "sling.servlet.paths=/geeks/page"
        })
public class FormSubmissionServlet extends SlingAllMethodsServlet {

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {


        // Get form parameters
        Enumeration<String> parameterNames = request.getParameterNames();
        response.getWriter().write("Form Submission Results: \n");
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            response.getWriter().write(paramName + ": " + paramValue +  "\n");
        }

    }
}
