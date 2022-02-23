package configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebServletConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateUtil.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class arrConfig [] = {SpringConfig.class};
        return arrConfig;
    }

    @Override
    protected String[] getServletMappings() {
        String arr[] = {"/"};
        return arr;
    }
}