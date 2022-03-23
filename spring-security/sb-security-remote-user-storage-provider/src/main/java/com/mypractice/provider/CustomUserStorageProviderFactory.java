package com.mypractice.provider;

import com.mypractice.api.RemoteUserService;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

public class CustomUserStorageProviderFactory implements UserStorageProviderFactory<RemoteUserStorageProvider> {
    @Override
    public RemoteUserStorageProvider create(KeycloakSession keycloakSession, ComponentModel componentModel) {
        return new RemoteUserStorageProvider(keycloakSession, componentModel, buildHttpClient("http://localhost:8999"));
    }

    @Override
    public String getId() {
        return "custom-user-remote-provider";

    }

    private RemoteUserService buildHttpClient(String uri) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(uri);
        return target.proxyBuilder(RemoteUserService.class)
                .classloader(RemoteUserService.class.getClassLoader()).build();
    }
}
