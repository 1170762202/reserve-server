package com.zlx.reverce.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author 1170762202@qq.com
 * @2019-10-14 17:37
 * 说明：通道初始化
 */
public class BootNettyChannelInitializer<SocketChannel> extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        // ChannelOutboundHandler，依照逆序执行
        ch.pipeline().addLast("encoder", new StringEncoder());

        // 属于ChannelInboundHandler，依照顺序执行
        ch.pipeline().addLast("decoder", new StringDecoder());
        /**
         * 自定义ChannelInboundHandlerAdapter
         */
        ch.pipeline().addLast(new BootNettyChannelInboundHandlerAdapter());

    }

}