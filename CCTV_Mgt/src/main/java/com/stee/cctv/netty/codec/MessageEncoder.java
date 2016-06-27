package com.stee.cctv.netty.codec;

import com.stee.cctv.utils.ByteUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

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
public class MessageEncoder extends MessageToByteEncoder<String> {

	@Override
	protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
		if (null == msg || msg.equals(""))
			return;
		byte[] startByte = new byte[] { 0x01 };
		byte[] contentByte = msg.getBytes();
		byte[] lengthByte = new byte[4];
		lengthByte = ByteUtil.intToBytes(contentByte.length);
		lengthByte = ByteUtil.littleEndian(lengthByte);
		byte[] endByte = new byte[] { 0x00 };
		byte[] temp = new byte[] {};
		temp = ByteUtil.byteMerger(temp, startByte);
		temp = ByteUtil.byteMerger(temp, lengthByte);
		temp = ByteUtil.byteMerger(temp, contentByte);
		temp = ByteUtil.byteMerger(temp, endByte);
		out.writeBytes(temp);
	}

}
