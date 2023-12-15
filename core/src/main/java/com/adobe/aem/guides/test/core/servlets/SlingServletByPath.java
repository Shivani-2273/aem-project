package com.adobe.aem.guides.test.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service={Servlet.class},
        property={
                "sling.servlet.methods=GET",
                "sling.servlet.paths=/bin/practice",
                "sling.servlet.selectors={one, two}",
                "sling.servlet.extensions=txt"
})
public class SlingServletByPath extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String[] selectors = request.getRequestPathInfo().getSelectors();

        if (selectors != null && selectors.length > 0) {
            String responseText = "Selectors size = " + selectors.length + ", Selectors values = " + String.join(", ", selectors);
            response.getWriter().write(responseText);
        } else {
            response.getWriter().write("No selectors");
        }


    }
}
