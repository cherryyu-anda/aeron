/*
 *  Copyright 2017 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.aeron.cluster.client;

import io.aeron.cluster.codecs.EventCode;
import io.aeron.logbuffer.Header;
import org.agrona.DirectBuffer;

public interface EgressListener
{
    void sessionEvent(long correlationId, long clusterSessionId, EventCode code, String detail);

    void newLeader(
        long correlationId,
        long clusterSessionId,
        long lastMessageTimestamp,
        long clusterTermTimestamp,
        long clusterMessageIndex,
        long clusterTermId,
        String leader);

    void onMessage(
        long correlationId,
        long clusterSessionId,
        long timestamp,
        DirectBuffer buffer,
        int offset,
        int length,
        Header header);
}
