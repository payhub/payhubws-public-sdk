// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package webhook.sample.domain;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import webhook.sample.domain.Notifications;

privileged aspect Notifications_Roo_Json {
    
    public String Notifications.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String Notifications.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static Notifications Notifications.fromJsonToNotifications(String json) {
        return new JSONDeserializer<Notifications>()
        .use(null, Notifications.class).deserialize(json);
    }
    
    public static String Notifications.toJsonArray(Collection<Notifications> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String Notifications.toJsonArray(Collection<Notifications> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Notifications> Notifications.fromJsonArrayToNotificationses(String json) {
        return new JSONDeserializer<List<Notifications>>()
        .use("values", Notifications.class).deserialize(json);
    }
    
}
