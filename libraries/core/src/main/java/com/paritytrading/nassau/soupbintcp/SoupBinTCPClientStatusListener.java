/*
 * Copyright 2014 Nassau authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.paritytrading.nassau.soupbintcp;

import static com.paritytrading.nassau.soupbintcp.SoupBinTCP.*;

import java.io.IOException;

/**
 * The interface for inbound status events on the client side.
 */
public interface SoupBinTCPClientStatusListener {

    /**
     * Receive an indication of a heartbeat timeout.
     *
     * @param session the session
     * @throws IOException if an I/O error occurs
     */
    void heartbeatTimeout(SoupBinTCPClient session) throws IOException;

    /**
     * Receive a Login Accepted packet.
     *
     * @param session the session
     * @param payload the packet payload
     * @throws IOException if an I/O error occurs
     */
    void loginAccepted(SoupBinTCPClient session, LoginAccepted payload) throws IOException;

    /**
     * Receive a Login Rejected packet.
     *
     * @param session the session
     * @param payload the packet payload
     * @throws IOException if an I/O error occurs
     */
    void loginRejected(SoupBinTCPClient session, LoginRejected payload) throws IOException;

    /**
     * Receive an End Of Session packet.
     *
     * @param session the session
     * @throws IOException if an I/O error occurs
     */
    void endOfSession(SoupBinTCPClient session) throws IOException;

}
