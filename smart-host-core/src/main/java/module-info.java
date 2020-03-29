module com.smarthost.core {
    requires java.logging;
    exports com.smarthost.core;
    exports com.smarthost.core.domain;
    opens com.smarthost.core;
}