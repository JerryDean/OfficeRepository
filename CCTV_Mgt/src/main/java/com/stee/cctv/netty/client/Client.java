package com.stee.cctv.netty.client;

import java.util.concurrent.TimeUnit;

import com.stee.cctv.netty.codec.MessageDecoder;
import com.stee.cctv.netty.handler.ClientHandler;
import com.stee.cctv.utils.Util;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Copyright @ 2007, ST Electronics Info-comm Systems PTE. LTD All rights
 * reserved.
 *
 * This software is confidential and proprietary property of ST Electronics
 * Info-comm Systems PTE. LTD. The user shall not disclose the contents of this
 * software and shall only use it in accordance with the terms and conditions
 * stated in the contract or licence agreement with ST Electronics Info-comm
 * Systems PTE. LTD.
 *
 * @author Jerry
 * @version 1.0
 *
 */
public class Client {
	private volatile EventLoopGroup workerGroup;

	private volatile Bootstrap bootstrap;

	private volatile boolean isClose;

	public void close() {
		if (null == workerGroup) {
			return;
		}
		isClose = true;
		workerGroup.shutdownGracefully();
		Util.logger.info("Stoped client...");
	}

	public void run() {
		isClose = false;
		workerGroup = new NioEventLoopGroup();
		bootstrap = new Bootstrap();
		try {
			bootstrap.group(workerGroup);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
			bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					// ch.pipeline().addLast(new
					// LengthFieldBasedFrameDecoder(1024 * 1024 * 1024, 1, 4, 0,
					// 5));
					// ch.pipeline().addLast(new StringDecoder());
					// ByteBuf buf = Unpooled.buffer();
					// buf.writeBytes(new byte[] { 0x00 });
					// ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024
					// * 1024 * 1024, buf));
					ch.pipeline().addLast(new MessageDecoder());
					ch.pipeline().addLast(new ClientHandler());
				}
			});

			doConect();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
		}
	}

	public void doConect() throws InterruptedException {
		if (isClose) {
			return;
		}
		ChannelFuture channelFuture = bootstrap.connect(Util.ip, Util.port).addListener(new ChannelFutureListener() {

			@Override
			public void operationComplete(ChannelFuture f) throws Exception {
				if (f.isSuccess()) {
					Util.logger.info("Start client success(" + Util.ip + ":" + Util.port + ")");
				} else {
					Util.logger.info("Start client failed,try connect again...");
					f.channel().eventLoop().schedule(new Runnable() {
						public void run() {
							try {
								doConect();
							} catch (Exception e) {
								Util.logger.error(e.getMessage());
							}
						}
					}, 1L, TimeUnit.SECONDS);
				}
			}
		}).sync();
		channelFuture.channel().closeFuture().sync();
	}

	public static void main(String[] args) {
		new Client().run();
	}

}
