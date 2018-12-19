package com.data.manipulation;

import com.data.configurations.MyBatisConnectionFactory;
import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.data.configurations.StaticData.*;

public class DataAcces {

    private final Logger logger = LoggerFactory.getLogger(DataAcces.class);
    private boolean Status = false;
    private SqlSession session;
    private int status;

    public DataAcces() {

        session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

    }

    public synchronized int insert(Object entidad, String tablaConsultar) {

        try {

            session.insert(tablaConsultar+".insert", entidad);
            session.commit();
            status = OPERACION_EXITOSA;

        } catch (Exception e) {

            if (e.getCause().toString().contains("CONSTRAINT")) {
                status = REGISTRO_EXISTE;
            } else {
                status = ERROR_GENERAL;
            }

            session.rollback();
            System.out.println("Causa:" + e);

        } finally {
            session.close();
        }

        return status;
    }

    public synchronized int update(Object entidad,String tablaConsulta) {

        try {
            session.update(tablaConsulta+".update", entidad);
            session.commit();
            status = OPERACION_EXITOSA;

        } catch (Exception e) {

            if (e.getCause().toString().contains("CONSTRAINT")) {
                status = REGISTRO_EXISTE;
            } else {
                status = ERROR_GENERAL;
            }

            session.rollback();
            System.out.println("Causa:" + e);

        } finally {
            session.close();
        }

        return status;
    }

    public int delete(Object entidad, String tablaConsultar) {

        try {
            session.delete(tablaConsultar+".deleteById", entidad);
            session.commit();
            status = OPERACION_EXITOSA;

        } catch (Exception e) {

            status = ERROR_GENERAL;
            session.rollback();
            System.out.println("Causa:" + e);

        } finally {
            session.close();
        }

        return status;
    }

    public ArrayList<Object> read(String like,String tablaConsultar) {

        ArrayList<Object> list = new ArrayList();

        try {
            list = (ArrayList) session.selectList( tablaConsultar+".getAll",like );
        } catch (Exception e) {
           System.out.println(e.toString());
        } finally {
            session.close();
        }
        return list;
    }

    public Object readOne(String id) {

        Object entidad = null;

        try {
            entidad = (Object) session.selectOne("TbTrabajador.getById", id);
        } catch (Exception e) {
            logger.error(e.toString());
        } finally {
            session.close();
        }
        return entidad;
    }
}
