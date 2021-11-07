package org.hegemol.taube.core.marshalling.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.pool.KryoPool;
import org.hegemol.taube.core.marshalling.MessageMarshalling;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoMessageMarshalling implements MessageMarshalling {

    private KryoPool pool = KryoPoolFactory.getKryoPoolInstance();

    @Override
    public byte[] marshalling(final Object object) throws Exception {
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
    public Object unmarshalling(final byte[] data) throws Exception {
        Kryo kryo = pool.borrow();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        Input in = new Input(byteArrayInputStream);
        try {
            Object result = kryo.readObject(in, Object.class);
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
