package com.example.ems.other

import org.hibernate.HibernateException
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator

public class EmployeeIdGenerator implements IdentifierGenerator {

//    @Override
//    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        Random random = new Random();
//        return "emp-"+random.nextInt(99);
//    }
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "emp-";
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        return prefix + uuid;
    }
}