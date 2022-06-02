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

/**
 * $Id: ConsumeType.java 1835 2013-05-16 02:00:50Z vintagewang@apache.org $
 */
package org.apache.rocketmq.common.protocol.heartbeat;
/**  消费模式，分为pull和push，pull是由用户主动来拉取消息然后进行消费。push的模式则是由消费端自己根据情况拉取消息，
 * 然后用户只需要注册消费逻辑就行了，拉取到消息后会去回调消费逻辑 。
 * pull的方式使用难度较大，需要自己控制选取消费队列，拉取大小，什么时候拉取消息等，包括处理提交ack等
 */
public enum ConsumeType {
    /** 主动消费模式 */
    CONSUME_ACTIVELY("PULL"),
    /** 被动消费模式*/
    CONSUME_PASSIVELY("PUSH");

    private String typeCN;

    ConsumeType(String typeCN) {
        this.typeCN = typeCN;
    }

    public String getTypeCN() {
        return typeCN;
    }
}
