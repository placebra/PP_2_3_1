package web.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //Классы конфигурации(БД и тд)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {DataBaseConfig.class};
    }

    //Класс конфигурации Web (web.xml)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    //Все запросы на сервер обрабатываются сервлетом
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //Фильтр для корректного UTF-8
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[] { encodingFilter };
    }
}
