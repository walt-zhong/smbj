/*
 * Copyright (C)2016 - SMBJ Contributors
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
package com.hierynomus.smbj.testing;

import java.util.function.Consumer;

import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.connection.Connection;

public class TestingUtils {
    public static void withConnectedClient(SmbConfig config, ConsumerWithError<Connection> f) throws Exception {
        try (SMBClient client = new SMBClient(config)) {
            try (Connection connection = client.connect("127.0.0.1")) {
                f.accept(connection);
            }
        }
    }

    public interface ConsumerWithError<T> {
        void accept(T val) throws Exception;
    }
}
