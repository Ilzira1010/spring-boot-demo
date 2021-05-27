//package ru.itis.springbootdemo.config;
//
//
//import org.springframework.boot.web.server.ErrorPage;
//import org.springframework.boot.web.server.ErrorPageRegistrar;
//import org.springframework.boot.web.server.ErrorPageRegistry;
//
//public class ErrorPageConfig implements ErrorPageRegistrar {
//    @Override
//    public void registerErrorPages(ErrorPageRegistry registry) {
//        ErrorPage error500IllegalArgument = new ErrorPage(IllegalArgumentException.class, "/error/500/iae");
//        ErrorPage error500IllegalState = new ErrorPage(IllegalStateException.class, "/error/500/ise");
//
//        registry.addErrorPages(error500IllegalArgument, error500IllegalState);
//    }
//
//}
