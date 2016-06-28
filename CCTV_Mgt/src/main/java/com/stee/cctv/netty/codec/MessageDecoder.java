package com.stee.cctv.netty.codec;

import java.util.List;

import com.stee.cctv.utils.ByteUtil;
import com.stee.cctv.utils.Util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

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
public class MessageDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> in) throws Exception {
		if (buf.readableBytes() < 6) {
			return;
		}
		while (buf.isReadable()) {
			byte[] nByte = new byte[buf.readableBytes()];
			buf.readBytes(nByte);
			if (nByte[0] == 0x01) {
				byte[] tByte = ByteUtil.subBytes(nByte, 5, nByte.length - 5);
				in.add(new String(tByte));
			}
			if (nByte[nByte.length - 1] == 0x00) {
				byte[] tByte = ByteUtil.subBytes(nByte, 0, nByte.length - 1);
				in.add(new String(tByte));
			}
			if (nByte[0] != 0x01 && nByte[nByte.length - 1] != 0x00) {
				in.add(new String(nByte));
			}
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		Util.logger.error(cause.getMessage());
		ctx.close();
	}

}
