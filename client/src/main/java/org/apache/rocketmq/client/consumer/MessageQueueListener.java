/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.client.consumer;

import java.util.Set;
import org.apache.rocketmq.common.message.MessageQueue;

/**
 * A MessageQueueListener is implemented by the application and may be specified when a message queue changed
 *
 * 当消费者消费的队列变化时，用于响应这种变化。不过这个类主要是给应用程序实现的，调用处为RebalancePullImpl和RebalanceLitePullImpl
 * 的messageQueueChanged方法。目前的实现分别为DefaultLitePullConsumerImpl和MQPullConsumerScheduledService，用于在消费队列有变更时做出不同的处理
 *
 */
public interface MessageQueueListener {
    /**
     * @param topic message topic
     * @param mqAll all queues in this message topic
     * @param mqDivided collection of queues,assigned to the current consumer
     */
    void messageQueueChanged(final String topic, final Set<MessageQueue> mqAll,
        final Set<MessageQueue> mqDivided);
}
