module com.smarthost.web {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;
    requires spring.core;
    requires com.fasterxml.classmate;
    requires com.fasterxml.jackson.databind;
    requires com.smarthost.core;
    requires spring.beans;
    requires spring.test;
    opens com.smarthost.web;
}