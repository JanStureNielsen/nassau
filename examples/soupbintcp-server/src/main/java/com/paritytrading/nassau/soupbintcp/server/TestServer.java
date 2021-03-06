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
package com.paritytrading.nassau.soupbintcp.server;

import static org.jvirtanen.util.Applications.*;

import java.io.IOException;
import java.net.InetSocketAddress;

class TestServer {

    private static final String USAGE = "nassau-soupbintcp-server <port>";

    public static void main(String[] args) throws IOException {
        if (args.length != 1)
            usage(USAGE);

        try {
            main(Integer.parseInt(args[0]));
        } catch (NumberFormatException e) {
            usage(USAGE);
        }
    }

    private static void main(int port) throws IOException {
        final Server server = Server.open(new InetSocketAddress(port));

        Server.Session session = server.accept();

        server.close();

        while (session.receive() != -1);

        session.close();
    }

}
