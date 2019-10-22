package com.duyi.hrb.dao;

import org.apache.ibatis.annotations.Param;

public interface MsgDao {
    void insertMessage(@Param("messages") String messages);
}
