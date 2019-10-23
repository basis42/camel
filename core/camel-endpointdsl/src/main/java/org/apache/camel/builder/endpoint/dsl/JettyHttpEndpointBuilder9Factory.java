/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.builder.endpoint.dsl;

import javax.annotation.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;
import org.apache.camel.spi.HeaderFilterStrategy;

/**
 * The jetty component provides HTTP-based endpoints for consuming and producing
 * HTTP requests.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface JettyHttpEndpointBuilder9Factory {


    /**
     * Builder for endpoint for the Jetty component.
     */
    public interface JettyHttpEndpointBuilder9
            extends
                EndpointConsumerBuilder {
        default AdvancedJettyHttpEndpointBuilder9 advanced() {
            return (AdvancedJettyHttpEndpointBuilder9) this;
        }
        /**
         * Determines whether or not the raw input stream from Servlet is cached
         * or not (Camel will read the stream into a in memory/overflow to file,
         * Stream caching) cache. By default Camel will cache the Servlet input
         * stream to support reading it multiple times to ensure it Camel can
         * retrieve all data from the stream. However you can set this option to
         * true when you for example need to access the raw stream, such as
         * streaming it directly to a file or other persistent store.
         * DefaultHttpBinding will copy the request input stream into a stream
         * cache and put it into message body if this option is false to support
         * reading the stream multiple times. If you use Servlet to bridge/proxy
         * an endpoint then consider enabling this option to improve
         * performance, in case you do not need to read the message payload
         * multiple times. The http producer will by default cache the response
         * body stream. If setting this option to true, then the producers will
         * not cache the response body stream but use the response stream as-is
         * as the message body.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: common
         */
        default JettyHttpEndpointBuilder9 disableStreamCache(
                boolean disableStreamCache) {
            doSetProperty("disableStreamCache", disableStreamCache);
            return this;
        }
        /**
         * Determines whether or not the raw input stream from Servlet is cached
         * or not (Camel will read the stream into a in memory/overflow to file,
         * Stream caching) cache. By default Camel will cache the Servlet input
         * stream to support reading it multiple times to ensure it Camel can
         * retrieve all data from the stream. However you can set this option to
         * true when you for example need to access the raw stream, such as
         * streaming it directly to a file or other persistent store.
         * DefaultHttpBinding will copy the request input stream into a stream
         * cache and put it into message body if this option is false to support
         * reading the stream multiple times. If you use Servlet to bridge/proxy
         * an endpoint then consider enabling this option to improve
         * performance, in case you do not need to read the message payload
         * multiple times. The http producer will by default cache the response
         * body stream. If setting this option to true, then the producers will
         * not cache the response body stream but use the response stream as-is
         * as the message body.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: common
         */
        default JettyHttpEndpointBuilder9 disableStreamCache(
                String disableStreamCache) {
            doSetProperty("disableStreamCache", disableStreamCache);
            return this;
        }
        /**
         * To use a custom HeaderFilterStrategy to filter header to and from
         * Camel message.
         * 
         * The option is a:
         * <code>org.apache.camel.spi.HeaderFilterStrategy</code> type.
         * 
         * Group: common
         */
        default JettyHttpEndpointBuilder9 headerFilterStrategy(
                HeaderFilterStrategy headerFilterStrategy) {
            doSetProperty("headerFilterStrategy", headerFilterStrategy);
            return this;
        }
        /**
         * To use a custom HeaderFilterStrategy to filter header to and from
         * Camel message.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.spi.HeaderFilterStrategy</code> type.
         * 
         * Group: common
         */
        default JettyHttpEndpointBuilder9 headerFilterStrategy(
                String headerFilterStrategy) {
            doSetProperty("headerFilterStrategy", headerFilterStrategy);
            return this;
        }
        /**
         * If this option is false the Servlet will disable the HTTP streaming
         * and set the content-length header on the response.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: consumer
         */
        default JettyHttpEndpointBuilder9 chunked(boolean chunked) {
            doSetProperty("chunked", chunked);
            return this;
        }
        /**
         * If this option is false the Servlet will disable the HTTP streaming
         * and set the content-length header on the response.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: consumer
         */
        default JettyHttpEndpointBuilder9 chunked(String chunked) {
            doSetProperty("chunked", chunked);
            return this;
        }
        /**
         * Whether org.apache.camel.component.jetty.MultiPartFilter is enabled
         * or not. You should set this value to false when bridging endpoints,
         * to ensure multipart requests is proxied/bridged as well.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: consumer
         */
        default JettyHttpEndpointBuilder9 enableMultipartFilter(
                boolean enableMultipartFilter) {
            doSetProperty("enableMultipartFilter", enableMultipartFilter);
            return this;
        }
        /**
         * Whether org.apache.camel.component.jetty.MultiPartFilter is enabled
         * or not. You should set this value to false when bridging endpoints,
         * to ensure multipart requests is proxied/bridged as well.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: consumer
         */
        default JettyHttpEndpointBuilder9 enableMultipartFilter(
                String enableMultipartFilter) {
            doSetProperty("enableMultipartFilter", enableMultipartFilter);
            return this;
        }
        /**
         * If enabled and an Exchange failed processing on the consumer side,
         * and if the caused Exception was send back serialized in the response
         * as a application/x-java-serialized-object content type. On the
         * producer side the exception will be deserialized and thrown as is,
         * instead of the HttpOperationFailedException. The caused exception is
         * required to be serialized. This is by default turned off. If you
         * enable this then be aware that Java will deserialize the incoming
         * data from the request to Java and that can be a potential security
         * risk.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: consumer
         */
        default JettyHttpEndpointBuilder9 transferException(
                boolean transferException) {
            doSetProperty("transferException", transferException);
            return this;
        }
        /**
         * If enabled and an Exchange failed processing on the consumer side,
         * and if the caused Exception was send back serialized in the response
         * as a application/x-java-serialized-object content type. On the
         * producer side the exception will be deserialized and thrown as is,
         * instead of the HttpOperationFailedException. The caused exception is
         * required to be serialized. This is by default turned off. If you
         * enable this then be aware that Java will deserialize the incoming
         * data from the request to Java and that can be a potential security
         * risk.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: consumer
         */
        default JettyHttpEndpointBuilder9 transferException(
                String transferException) {
            doSetProperty("transferException", transferException);
            return this;
        }
        /**
         * To configure security using SSLContextParameters.
         * 
         * The option is a:
         * <code>org.apache.camel.support.jsse.SSLContextParameters</code> type.
         * 
         * Group: security
         */
        default JettyHttpEndpointBuilder9 sslContextParameters(
                Object sslContextParameters) {
            doSetProperty("sslContextParameters", sslContextParameters);
            return this;
        }
        /**
         * To configure security using SSLContextParameters.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.support.jsse.SSLContextParameters</code> type.
         * 
         * Group: security
         */
        default JettyHttpEndpointBuilder9 sslContextParameters(
                String sslContextParameters) {
            doSetProperty("sslContextParameters", sslContextParameters);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Jetty component.
     */
    public interface AdvancedJettyHttpEndpointBuilder9
            extends
                EndpointConsumerBuilder {
        default JettyHttpEndpointBuilder9 basic() {
            return (JettyHttpEndpointBuilder9) this;
        }
        /**
         * To use a custom HttpBinding to control the mapping between Camel
         * message and HttpClient.
         * 
         * The option is a:
         * <code>org.apache.camel.http.common.HttpBinding</code> type.
         * 
         * Group: common (advanced)
         */
        default AdvancedJettyHttpEndpointBuilder9 httpBinding(Object httpBinding) {
            doSetProperty("httpBinding", httpBinding);
            return this;
        }
        /**
         * To use a custom HttpBinding to control the mapping between Camel
         * message and HttpClient.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.http.common.HttpBinding</code> type.
         * 
         * Group: common (advanced)
         */
        default AdvancedJettyHttpEndpointBuilder9 httpBinding(String httpBinding) {
            doSetProperty("httpBinding", httpBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 basicPropertyBinding(
                String basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * If this option is true then IN exchange Body of the exchange will be
         * mapped to HTTP body. Setting this to false will avoid the HTTP
         * mapping.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 mapHttpMessageBody(
                boolean mapHttpMessageBody) {
            doSetProperty("mapHttpMessageBody", mapHttpMessageBody);
            return this;
        }
        /**
         * If this option is true then IN exchange Body of the exchange will be
         * mapped to HTTP body. Setting this to false will avoid the HTTP
         * mapping.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 mapHttpMessageBody(
                String mapHttpMessageBody) {
            doSetProperty("mapHttpMessageBody", mapHttpMessageBody);
            return this;
        }
        /**
         * If this option is true then IN exchange Form Encoded body of the
         * exchange will be mapped to HTTP. Setting this to false will avoid the
         * HTTP Form Encoded body mapping.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 mapHttpMessageFormUrlEncodedBody(
                boolean mapHttpMessageFormUrlEncodedBody) {
            doSetProperty("mapHttpMessageFormUrlEncodedBody", mapHttpMessageFormUrlEncodedBody);
            return this;
        }
        /**
         * If this option is true then IN exchange Form Encoded body of the
         * exchange will be mapped to HTTP. Setting this to false will avoid the
         * HTTP Form Encoded body mapping.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 mapHttpMessageFormUrlEncodedBody(
                String mapHttpMessageFormUrlEncodedBody) {
            doSetProperty("mapHttpMessageFormUrlEncodedBody", mapHttpMessageFormUrlEncodedBody);
            return this;
        }
        /**
         * If this option is true then IN exchange Headers of the exchange will
         * be mapped to HTTP headers. Setting this to false will avoid the HTTP
         * Headers mapping.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 mapHttpMessageHeaders(
                boolean mapHttpMessageHeaders) {
            doSetProperty("mapHttpMessageHeaders", mapHttpMessageHeaders);
            return this;
        }
        /**
         * If this option is true then IN exchange Headers of the exchange will
         * be mapped to HTTP headers. Setting this to false will avoid the HTTP
         * Headers mapping.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 mapHttpMessageHeaders(
                String mapHttpMessageHeaders) {
            doSetProperty("mapHttpMessageHeaders", mapHttpMessageHeaders);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 synchronous(
                boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedJettyHttpEndpointBuilder9 synchronous(String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }
    /**
     * Jetty (camel-jetty)
     * The jetty component provides HTTP-based endpoints for consuming and
     * producing HTTP requests.
     * 
     * Category: http
     * Available as of version: 1.2
     * Maven coordinates: org.apache.camel:camel-jetty
     * 
     * Syntax: <code>jetty:httpUri</code>
     * 
     * Path parameter: httpUri (required)
     * The url of the HTTP endpoint to call.
     */
    default JettyHttpEndpointBuilder9 jetty(String path) {
        class JettyHttpEndpointBuilder9Impl extends AbstractEndpointBuilder implements JettyHttpEndpointBuilder9, AdvancedJettyHttpEndpointBuilder9 {
            public JettyHttpEndpointBuilder9Impl(String path) {
                super("jetty", path);
            }
        }
        return new JettyHttpEndpointBuilder9Impl(path);
    }
}