/**
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
package org.apache.camel.component.websocket;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.spi.ExceptionHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class WebsocketConsumerTest {

    private static final String CONNECTION_KEY = "random-connection-key";
    private static final String MESSAGE = "message";

    @Mock
    private Endpoint endpoint;

    @Mock
    private ExceptionHandler exceptionHandler;

    @Mock
    private Processor processor;

    @Mock
    private Exchange exchange;

    @Mock
    private Message outMessage;

    private Exception exception = new Exception("BAD NEWS EVERYONE!");

    private WebsocketConsumer websocketConsumer;

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        websocketConsumer = new WebsocketConsumer(endpoint, processor);
        websocketConsumer.setExceptionHandler(exceptionHandler);
    }

    /**
     * Test method for {@link org.apache.camel.component.websocket.WebsocketConsumer#sendExchange(String, String)} .
     */
    @Test
    public void testSendExchange() throws Exception {
        when(endpoint.createExchange()).thenReturn(exchange);
        when(exchange.getIn()).thenReturn(outMessage);

        websocketConsumer.sendExchange(CONNECTION_KEY, MESSAGE);

        InOrder inOrder = inOrder(endpoint, exceptionHandler, processor, exchange, outMessage);
        inOrder.verify(endpoint, times(1)).createExchange();
        inOrder.verify(exchange, times(1)).getIn();
        inOrder.verify(outMessage, times(1)).setHeader(WebsocketConstants.CONNECTION_KEY, CONNECTION_KEY);
        inOrder.verify(exchange, times(1)).getIn();
        inOrder.verify(outMessage, times(1)).setBody(MESSAGE);
        inOrder.verify(processor, times(1)).process(exchange);
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Test method for {@link org.apache.camel.component.websocket.WebsocketConsumer#sendExchange(String, String)} .
     */
    @Test
    public void testSendExchangeWithException() throws Exception {
        when(endpoint.createExchange()).thenReturn(exchange);
        when(exchange.getIn()).thenReturn(outMessage);
        doThrow(exception).when(processor).process(exchange);
        when(exchange.getException()).thenReturn(exception);

        websocketConsumer.sendExchange(CONNECTION_KEY, MESSAGE);

        InOrder inOrder = inOrder(endpoint, exceptionHandler, processor, exchange, outMessage);
        inOrder.verify(endpoint, times(1)).createExchange();
        inOrder.verify(exchange, times(1)).getIn();
        inOrder.verify(outMessage, times(1)).setHeader(WebsocketConstants.CONNECTION_KEY, CONNECTION_KEY);
        inOrder.verify(exchange, times(1)).getIn();
        inOrder.verify(outMessage, times(1)).setBody(MESSAGE);
        inOrder.verify(processor, times(1)).process(exchange);
        inOrder.verify(exchange, times(2)).getException();
        inOrder.verify(exceptionHandler, times(1)).handleException(any(String.class), eq(exchange), eq(exception));
        inOrder.verifyNoMoreInteractions();
    }

    /**
     * Test method for {@link org.apache.camel.component.websocket.WebsocketConsumer#sendExchange(String, String)} .
     */
    @Test
    public void testSendExchangeWithExchangeExceptionIsNull() throws Exception {
        when(endpoint.createExchange()).thenReturn(exchange);
        when(exchange.getIn()).thenReturn(outMessage);
        doThrow(exception).when(processor).process(exchange);
        when(exchange.getException()).thenReturn(null);

        websocketConsumer.sendExchange(CONNECTION_KEY, MESSAGE);

        InOrder inOrder = inOrder(endpoint, exceptionHandler, processor, exchange, outMessage);
        inOrder.verify(endpoint, times(1)).createExchange();
        inOrder.verify(exchange, times(1)).getIn();
        inOrder.verify(outMessage, times(1)).setHeader(WebsocketConstants.CONNECTION_KEY, CONNECTION_KEY);
        inOrder.verify(exchange, times(1)).getIn();
        inOrder.verify(outMessage, times(1)).setBody(MESSAGE);
        inOrder.verify(processor, times(1)).process(exchange);
        inOrder.verify(exchange, times(1)).getException();
        inOrder.verifyNoMoreInteractions();
    }
}
