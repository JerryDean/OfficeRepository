package com.stee.cctv.netty.handler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.stee.cctv.netty.client.Client;
import com.stee.cctv.utils.Util;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ClientHandler extends ChannelHandlerAdapter {
	ScheduledExecutorService excutorService = Executors.newScheduledThreadPool(2);

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		ctx.channel().eventLoop().schedule(new Runnable() {
			public void run() {
				try {
					new Client().doConect();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 1L, TimeUnit.SECONDS);
	}

	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		// excutorService.scheduleAtFixedRate(new Runnable() {
		// public void run() {
		// ctx.writeAndFlush(TestEntity.message());
		// }
		// }, 0, 30, TimeUnit.SECONDS);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Util.logger.info(String.valueOf(msg));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		Util.logger.info(cause.getMessage());
		ctx.close();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		// if (evt instanceof IdleStateEvent) {
		// IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
		// switch (idleStateEvent.state()) {
		// case WRITER_IDLE:
		// ctx.writeAndFlush(HeartBeat.getHeartBeatXml());
		// break;
		// default:
		// break;
		// }
		// }
	}

}