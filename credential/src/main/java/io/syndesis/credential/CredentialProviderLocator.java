/**
 * Copyright (C) 2016 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.syndesis.credential;

import org.springframework.social.connect.ConnectionFactory;

public interface CredentialProviderLocator {

    Applicator<?> getApplicator(String providerId);

    /**
     * Lookup a ConnectionFactory by providerId; for example, "facebook". The
     * returned factory can be used to create connections to the provider. Used
     * to support connection creation in a dynamic manner across the set of
     * registered providers.
     *
     * @param providerId the provider ID used to look up the ConnectionFactory.
     * @return the requested ConnectionFactory
     */
    ConnectionFactory<?> getConnectionFactory(String providerId);

    /**
     * Adds or replaces a CredentialProvider in the locator.
     *
     * @param credentialProvider the provider to add
     */
    public <A, T> void addCredentialProvider(final CredentialProvider<A, T> credentialProvider);

}