module com.smarthost.web {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;
    requires spring.core;
    requires com.fasterxml.classmate;
    requires com.fasterxml.jackson.databind;
    opens com.smarthost.web;
}