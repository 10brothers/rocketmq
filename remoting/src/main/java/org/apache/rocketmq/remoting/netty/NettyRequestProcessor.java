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
package org.apache.rocketmq.remoting.netty;

import io.netty.channel.ChannelHandlerContext;
import org.apache.rocketmq.remoting.protocol.RemotingCommand;

/**
 * Common remoting command processor
 * 通用请求处理器。每种请求都会有自己的请求处理器，处理器和请求类型绑定到一起。处理器实现类不在remoting模块，在各自模块实现。
 * 对与使用remoting模块的模块来说，通过这个NettyRequestProcessor接口和 RemotingCommand，屏蔽了部分直接对netty的操作，
 * 其实这里最好能再对ChannelHandlerContext做一层包装，在非remoting模块完全屏蔽netty
 *
 */
public interface NettyRequestProcessor {
    RemotingCommand processRequest(ChannelHandlerContext ctx, RemotingCommand request)
        throws Exception;

    boolean rejectRequest();

}
