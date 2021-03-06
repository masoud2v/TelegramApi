package org.telegram.api.functions.channels;

import org.telegram.api.input.chat.TLAbsInputChannel;
import org.telegram.api.input.user.TLAbsInputUser;
import org.telegram.api.messages.TLAffectedHistory;
import org.telegram.tl.StreamingUtils;
import org.telegram.tl.TLContext;
import org.telegram.tl.TLMethod;
import org.telegram.tl.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL request channel delete user history
 */
public class TLRequestChannelsDeleteUserHistory extends TLMethod<TLAffectedHistory> {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0xd10dd71b;

    private TLAbsInputChannel channel;
    private TLAbsInputUser userId;

    /**
     * Instantiates a new TL request channel delete user history
     */
    public TLRequestChannelsDeleteUserHistory() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public TLAffectedHistory deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        final TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if ((res instanceof TLAffectedHistory)) {
            return (TLAffectedHistory) res;
        }
        throw new IOException("Incorrect response type. Expected " + TLAffectedHistory.class.getName() +", got: " + res.getClass().getName());
    }

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public void serializeBody(OutputStream stream)
            throws IOException {
        StreamingUtils.writeTLObject(this.channel, stream);
        StreamingUtils.writeTLObject(this.userId, stream);
    }

    public void deserializeBody(InputStream stream, TLContext context)
            throws IOException {
        this.channel = (TLAbsInputChannel) StreamingUtils.readTLObject(stream, context);
        this.userId = (TLAbsInputUser) StreamingUtils.readTLObject(stream, context);
    }

    public String toString() {
        return "functions.channels.TLRequestChannelsDeleteUserHistory#d10dd71b";
    }
}