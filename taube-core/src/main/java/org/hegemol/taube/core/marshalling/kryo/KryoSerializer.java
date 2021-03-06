package org.hegemol.taube.core.marshalling.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoPool;
import org.hegemol.taube.common.model.MessageModel;
import org.hegemol.taube.core.marshalling.Serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoSerializer implements Serializer {

    private KryoPool pool = KryoPoolFactory.getKryoPoolInstance();

    @Override
    public byte[] serialize(final Object object) throws Exception {
        Kryo kryo = pool.borrow();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output out = new Output(byteArrayOutputStream);
        try {
            kryo.writeObject(out, object);
            out.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            pool.release(kryo);
        }
    }

    @Override
    public MessageModel deserialize(final byte[] data) throws Exception {
        Kryo kryo = pool.borrow();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        Input in = new Input(byteArrayInputStream);
        try {
            MessageModel result = kryo.readObject(in, MessageModel.class);
            in.close();
            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            pool.release(kryo);
        }
    }

}
