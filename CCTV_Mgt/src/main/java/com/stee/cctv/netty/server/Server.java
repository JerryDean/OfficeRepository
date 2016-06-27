package com.stee.cctv.netty.server;

import java.util.concurrent.TimeUnit;

import com.stee.cctv.netty.codec.MessageDecoder;
import com.stee.cctv.netty.codec.MessageEncoder;
import com.stee.cctv.netty.handler.ServerHandler;
import com.stee.cctv.utils.Util;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

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
public class Server {

	private volatile EventLoopGroup bossGroup;

	private volatile EventLoopGroup workerGroup;

	private volatile ServerBootstrap serverBootstrap;

	private volatile boolean isClose;

	public void close() {
		if (null == bossGroup || null == workerGroup) {
			return;
		}
		isClose = false;
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
		Util.logger.info("Stoped server at port:" + Util.port);
	}

	public void run() throws Exception {
		isClose = false;
		bossGroup = new NioEventLoopGroup();
		workerGroup = new NioEventLoopGroup();
		try {
			serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new MessageEncoder());
							ch.pipeline().addLast(new MessageDecoder());
							ch.pipeline().addLast(new ServerHandler());
						}
					}).option(ChannelOption.SO_BACKLOG, 1024).childOption(ChannelOption.SO_KEEPALIVE, true);
			doBind();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	protected void doBind() throws InterruptedException {
		if (isClose) {
			return;
		}
		ChannelFuture channelFuture = serverBootstrap.bind(Util.port).addListener(new ChannelFutureListener() {

			@Override
			public void operationComplete(ChannelFuture f) throws Exception {
				if (f.isSuccess()) {
					Util.logger.info("Start server at port " + Util.port + " success!");
				} else {
					Util.logger.info("Start server failed.Try bind again..");
					f.channel().eventLoop().schedule(new Runnable() {
						public void run() {
							try {
								doBind();
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
		try {
			new Server().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
